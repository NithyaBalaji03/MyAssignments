package week1.day2;

public class PrimeNumber {
	
	public static void main(String[] args) {
		int number = 5;
		boolean flag = false;
		
		for (int i = 2; i <= number/2; i++) {
			if (number % i == 0) {
				flag = true;
			}
		}
		if (flag == false)
		{
			System.out.println("The nunmber is prime");
		}
		else {
			System.out.println("The number is not prime");
		}
	}

}
