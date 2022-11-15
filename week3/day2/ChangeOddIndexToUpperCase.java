package week3.day2;

public class ChangeOddIndexToUpperCase {

	public static void main(String[] args) {


		String strText = "changeme";
		System.out.println("Original String " + strText);
		char[] chrText = strText.toCharArray();

		for (int i = 0; i < chrText.length; i++) {
			if (!(i%2 == 0)) {
				chrText[i] = Character.toUpperCase(chrText[i]);
			}
		}
		System.out.print(chrText);
	}
}
