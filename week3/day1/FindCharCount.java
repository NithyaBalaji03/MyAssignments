package week3.day1;

public class FindCharCount {
	
public static void main (String[] args) {
		
		String name = "Welcome to Testleaf";
		int count = 0;
		//Convert to Array
		char[] charArray = name.toCharArray();
		
		//Iterate in reverse
		for (int i = 0; i < charArray.length; i++) {
			
			if (charArray[i] == 'e') {
				count++;
			}
		}
		System.out.println("Number of e's in the sentence " + count);
	}

}
