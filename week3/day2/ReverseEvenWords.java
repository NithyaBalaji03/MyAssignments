package week3.day2;

public class ReverseEvenWords {

	public static void main(String[] args) {
		String strTest = "I am a software tester"; 
		String[] strArray = strTest.split(" ");

		System.out.print(strArray[0] + " ");

		for (int i = 1; i < strArray.length; i++) {
			if (!(i%2 == 0)) {
				char[] charArray = strArray[i].toCharArray();
				for (int j = charArray.length; j > 0; j--) {
					System.out.print(charArray[j-1]);
				}
			}
			else {
				System.out.print(" " + strArray[i] + " ");
			}
		}
	}
}
