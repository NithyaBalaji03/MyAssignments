package week3.day2;

public class Palindrome {

	public static void main(String[] args) {

		String str1 = "malayalam";
		String revStr = "";

		char[] charArray = str1.toCharArray();

		for (int i = charArray.length; i > 0 ; i--) {
			revStr = revStr.concat(String.valueOf(charArray[i-1]));		
		}

		System.out.println("The given word is " + str1);
		System.out.println("The reversed word is " + revStr);

		if (str1.equalsIgnoreCase(revStr)) {
			System.out.println("The word is a palindrome");
		} else {
			System.out.println("The word is not a palindrome");
		}
	}

}
