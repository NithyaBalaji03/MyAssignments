package week3.day2;

public class SumOfDigitsFromString {

	public static void main(String[] args) {

		String strText = "Tes22Le79af65";
		int sum = 0;
		for (int i = 0; i < strText.length(); i++) {
			if (Character.isDigit(strText.charAt(i))){
				sum = sum + Character.getNumericValue(strText.charAt(i));
			}
		}
		System.out.println(sum);
	}
}
