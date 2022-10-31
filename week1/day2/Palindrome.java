package week1.day2;

public class Palindrome {
	
	public static void main(String[] args) {
		
		int number = 8989898;		
		int revNumber = 0;
		int remainder = 0;
		int originalNumber = 0;

		originalNumber = number;

		if (number == 0) {
			System.out.println("Invalid Number");
		}
		else {

			while (number != 0) {
				remainder = number%10;
				revNumber = revNumber * 10 + remainder;
				number = number / 10;
			}

			if (originalNumber == revNumber)
			{
				System.out.println("The number "+ originalNumber + " is a palindrome");
			}
			else
			{ 
				System.out.println("The number " + originalNumber + " is not a palindrome");
			}

		}
	}	
}
