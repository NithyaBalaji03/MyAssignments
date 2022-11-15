package week3.day2;

public class ReverseCharacter {

	public static void main(String[] args) {
		String strInput = "ay12ht35777777iN";
		String strReverse = "";
		String strFinalOutput = "";

		for (int i = strInput.length()-1; i >= 0; i--) {

			strReverse = strReverse + strInput.charAt(i);
		}

		char[] charArray = strReverse.toCharArray();

		for (int j = 0; j < charArray.length; j++) {
			if (Character.isLetter(charArray[j])){
				strFinalOutput = strFinalOutput + charArray[j];
			}
		}

		System.out.println(strFinalOutput );
	}
}
