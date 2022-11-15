package week3.day1;

public class ReverseString {
	
	public static void main (String[] args) {
		
		String name = new String(" Welcome to Testleaf ");
		//Convert to Array
		char[] charArray = name.toCharArray();
		
		//Iterate in reverse
		for (int i = charArray.length; i > 0; i--) {
			
			System.out.print(charArray[i-1]);
		}
	}

}
