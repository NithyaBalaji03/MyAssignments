package week1.day2;

import java.util.Arrays;

public class FindIntersection {
	
	public static void main(String[] args) {
		
		int[] arr1 = {1,5,9,6,99,21,4};
		int[] arr2 = {99,3,5,21,9};
		
		int arr1Length = arr1.length;
		int arr2Length = arr2.length;
				
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		for (int i = 0; i < arr1Length; i++) {
			for (int k = 0; k < arr2Length; k++) {
				if (arr1[i] == arr2[k]) {
					System.out.println(arr1[i]);
				}
			}
		}
		
	}

}
