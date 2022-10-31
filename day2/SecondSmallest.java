package week1.day2;

import java.util.Arrays;

public class SecondSmallest {

	public static void main(String[] args) {
		
		int[] arr = {234,298,8881,99,888};
		Arrays.sort(arr);
		
		System.out.println("The second smallest in the array is " + arr[1]);
	}
}
