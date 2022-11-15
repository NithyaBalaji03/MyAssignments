package week3.day2;

public class FindIntersection {

	public static void main(String[] args) {
		int[] intArr1 = {3,2,11,4,6,7};
		int[] intArr2 = {1,2,8,4,9,7};

		for (int i = 0; i < intArr1.length; i++) {
			for (int j = 0; j < intArr2.length; j++) {
				if (intArr1[i] == intArr2[j]) {
					System.out.println(intArr1[i]);
				}
			}
		}

	}
}
