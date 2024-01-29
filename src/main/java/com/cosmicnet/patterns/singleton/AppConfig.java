package com.cosmicnet.patterns.singleton;

import java.io.*;

/**
 * This is a singleton class.
 * @author Sankar M
 *
 */

public final class AppConfig implements Serializable, Cloneable {

	/**
	 * Singleton class to get an application configuration object.
	 * Author : Sankar M
	 */
	
	public enum AppRAMType {INTEL, AMD, VEDANTA}
	
	private static final long serialVersionUID = -5075838354868831413L;
	private static AppConfig self;
	private int appRAM;
	private AppRAMType appRAMType;
	
	public void setAppRAM(int ram) {
		this.appRAM = ram;
	}
	public void setAppRAMType(AppRAMType ramType) {
		this.appRAMType = ramType;
	}
	
	public int getAppRAM() {
		return appRAM;
	}
	
	public AppRAMType getAppRAMType() {
		return appRAMType;
	}
	
	AppConfig() throws AssertionError{
		if(self != null)
			throw new AssertionError("Singleton class error.  Can not instanciate more than once!");
			
	}
	
	/*
	public static AppConfig getInstance() {
		if(self == null) {
			synchronized(AppConfig.class) {
				if(self == null)
					self = new AppConfig();
				return self;
			}
		}
		return self;
	}
	*/
	public static AppConfig getInstance() {
		AppConfig result = self;
		if (result == null) {
			synchronized(AppConfig.class) {
				if (self == null)
					self = result = new AppConfig();
			}
		}
		return result;
	}
	
	Object readResolve() {
		return self;
	}
	
	@Override
	protected Object clone() {
		return self;
	}
	

}
