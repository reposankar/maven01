package com.cosmicnet.dsa.a01.binarysearch;

public class BinarySerach {
	
	public static int binarySearchRecursive(int[] a, int start, int end, int target) {
		
		if (start <= end ) {
			//int mid = start+(end-start)/2;
			int mid = (start+ end)/2;
			if (a[mid] == target)
				return mid;
			else if(a[mid] < target )
				return binarySearchRecursive(a, mid+1, end, target);
			else
				return binarySearchRecursive(a, start, mid-1, target); 
		}
			return -1;
	}
	
	public static int binarySearch(int[] a, int start, int end, int target) {
		while (start <= end) {
			int mid = (start + end) / 2;
			if(a[mid] == target)
				return mid;
			else if(a[mid] < target)
				start = mid + 1;
			else 
				end = mid - 1;
		}
		return -1;
	}
	public static void main(String args[]) {
		int[] a = {2, 6, 13, 21, 36, 47, 63, 81, 97};
		int start = 0;
		int end = a.length-1;
		int target = 20;
		long startTime = System.nanoTime();
		int ind = binarySearchRecursive(a, start, end, target);
		long durationTimeInMillis = (System.nanoTime()- startTime);
		System.out.println("binarySearchRecursive : Target found at "+ind+", in "+durationTimeInMillis);
		
		startTime = System.nanoTime();
		ind = binarySearch(a, start, end, target);
		durationTimeInMillis = (System.nanoTime()- startTime);
		System.out.println("binarySearch : Target found at "+ind+", in "+durationTimeInMillis);
		
	}

}
