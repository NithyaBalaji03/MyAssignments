package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class EditFields {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/Edit.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.id("email")).sendKeys("nithyaraj.balaji@gmail.com");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys("adding");
		String defaultText = driver.findElement(By.xpath("//input[@name='username']")).getAttribute("value");
		System.out.println("Default Text " + defaultText);

		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();

		boolean disableChk = driver.findElement(By.xpath("//input[@disabled='true']")).isEnabled();
		if (!disableChk) {
			System.out.println("The Edit field is disabled");
		} else {
			System.out.println("The Edit field is enabled");
		}

		driver.close();
	}
}
