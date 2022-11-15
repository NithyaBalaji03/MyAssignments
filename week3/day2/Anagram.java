package week3.day2;

import java.util.Arrays;

public class Anagram {

	public static void main(String[] args) {
		String str1 = "stops";
		String str2 = "potss";

		char[] arr1 = str1.toCharArray();
		char[] arr2 = str2.toCharArray();

		if (str1.length() == str2.length()) {

			Arrays.sort(arr1);
			Arrays.sort(arr2);

			if (Arrays.equals(arr1, arr2)) {
				System.out.println("Anagram");
			}else {
				System.out.println("Not Anagram");
			}
		}
		else
			System.out.println("Not Anagram");
	}

}
