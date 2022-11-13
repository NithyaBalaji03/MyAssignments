package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class RadioButtons {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new  ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/radio.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Select radio button
		driver.findElement(By.id("yes")).click();
		
		//Finding the default selected radio button
		WebElement unchecked = driver.findElement(By.xpath("//input[@name='news']"));
		WebElement checked = driver.findElement(By.xpath("(//input[@name='news'])[2]"));
		if (unchecked.isSelected()) {
			System.out.println("Unchecked Radio button is selected by default");
		} else if (checked.isSelected()) {
			System.out.println("Checked Radio button is selected by default");
		}
		
		//Selecting age if not selected by default
		WebElement ageGroup = driver.findElement(By.xpath("(//input[@name='age'])[3]"));
		if (!ageGroup.isSelected()) {
			driver.findElement(By.xpath("(//input[@name='age'])[3]")).click();
		}
		
		driver.close();
		
	}

}
