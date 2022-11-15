package week3.day2;

public class MyCalculator extends Calculator {

	public static void main(String[] args) {
		
		MyCalculator objCal = new MyCalculator();
		
		System.out.println("Addition of numbers by calling add method in Superclass - " + objCal.add(23, 43, 21));
		
		System.out.println("Subtraction of numbers by calling sub method in Superclass - " + objCal.sub(65,40));
		
		System.out.println("Multiplication of numbers by calling mul method in Superclass - " + objCal.mul(345, 444));
		
		System.out.println("Division of numbers by calling div method in Superclass - " + objCal.divide(7654, 43));
	}

}
