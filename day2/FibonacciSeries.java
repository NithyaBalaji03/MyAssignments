package week1.day2;

public class FibonacciSeries {
	public static void main(String[] args) {
		
		int range = 9;
		int firstNum = 0;
		int secondNum = 1;
		int sum;
		
		System.out.println(firstNum);
		System.out.println(secondNum);
		for (int i=1; i<range-1; i++) {
			sum = firstNum + secondNum;
			System.out.println(sum);
			firstNum = secondNum;
			secondNum = sum;
			
		}
	}

}
