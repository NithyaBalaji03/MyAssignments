package week1.day2;

public class NegativeToPositive {
	public static void main(String[] args) {
		int number = 2;
		int posNumber;
		
		if (number < 0) {
			posNumber = Math.abs(number);
			System.out.println("The number " + number + " is converted to " + posNumber); 
		}
		else {
			System.out.println("The number is a positive number");
		}
	}

}
