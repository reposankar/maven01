package com.cosmicnet.effectivej.item34;
/**
 * 
 * @author Sanakr M
 * @apiNote Enum strategy pattern to limit the code repetition.
 *
 */
public enum PayrollDay {
	
	MONDAY,
	TUESDAY,
	WEDNESDAY,
	THURSDAY,
	FRIDAY,
	SATURDAY (PayType.WEEKEND),
	SUNDAY (PayType.WEEKEND);
	
	PayrollDay(PayType payType) {
		this.payType = payType;
	}
	
	PayrollDay() {
		this.payType = payType.WEEKDAY;
	}
	
	private PayType payType;

	
	public double pay(double hoursWorked, double payRate) {
		return payType.pay(hoursWorked, payRate);
	}
	
	private enum PayType {
		WEEKDAY {
			@Override
			double overtimePay(double hoursWorked, double payRate) {
				//return 2.3;
				return hoursWorked <= MAX_WORKING_HOURS_PER_DAY ? 0 
						: (hoursWorked - MAX_WORKING_HOURS_PER_DAY) * payRate / 2;
			}
		},
		WEEKEND {
			@Override
			double overtimePay(double hoursWorked, double payRate) {
				//return 2.3;
				return hoursWorked <= 0 ? 0 
						: hoursWorked * payRate / 2;
			}
		};
		
		private static final int MAX_WORKING_HOURS_PER_DAY = 8;
		
		abstract double overtimePay(double hoursWorked, double payRate);
		
		double pay(double hoursWorked, double payRate) {
			return (hoursWorked * payRate) + overtimePay(hoursWorked, payRate);
		}
		
	}
	

}
