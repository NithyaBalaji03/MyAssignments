package week3.day2;

import java.util.Arrays;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		
		String strText = new String("We learn java basics as part of java sessions in java week1");
		String strDup = "";
		int count = 0;
		String[] strArray = strText.split(" ");
		Arrays.sort(strArray);
		for (int i = 0; i < strArray.length-1; i++) {
			if(strArray[i].equals(strArray[i+1]))
			{
				count++;
				strDup = strArray[i];
			}
			
			if (count > 1) {
				System.out.println("Original String is - " + strText);
				strText = strText.replace(strDup, " ");
				System.out.println("Replaced String is - " + strText);
				break;
			}
		}		
	}
}
