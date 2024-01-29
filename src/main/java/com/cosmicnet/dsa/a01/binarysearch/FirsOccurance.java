package com.cosmicnet.dsa.a01.binarysearch;

public class FirsOccurance {
	public static int binarySearch(int[] a, int start, int end, int target) {
		int result = -1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if(a[mid] == target) {
				result = mid;
				//break;
				//end = mid - 1;
				start = mid+1;
			}
			else if(a[mid] < target)
				start = mid + 1;
			else 
				end = mid - 1;
		}
		return result;
	}
	public static void main(String args[]) {
		int[] a = {2, 6, 8, 9, 10, 10, 10, 10, 10, 10, 36, 47, 63, 81, 97};
		int start = 0;
		int end = a.length-1;
		int target = 10;
		long startTime = System.nanoTime();
		int ind = binarySearch(a, start, end, target);
		long durationTimeInMillis = (System.nanoTime()- startTime);
		System.out.println("FirsOccurance binarySearch : Target found at "+ind+", in "+durationTimeInMillis);
		
	}

}
