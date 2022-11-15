package week3.day1;

public class Desktop extends Computer{

	public void desktopSize() {

		System.out.println("Method in this class called");
	}

	public static void main(String[] args) {
		Desktop objDesk = new Desktop();
		objDesk.computerModel();
		objDesk.desktopSize();		
	}
}
