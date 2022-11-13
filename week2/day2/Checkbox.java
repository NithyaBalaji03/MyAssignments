package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/checkbox.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
		driver.findElement(By.xpath("(//input[@type='checkbox']/following-sibling::input)[3]")).click();
		
		WebElement selChecked = driver.findElement(By.xpath("//label[text()='Confirm Selenium is checked']/following::input"));
		if (selChecked.isSelected())
		{
			System.out.println("Selenium is selected - Confirmed");
		}
		
		WebElement notSelected = driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[3]/input[1]"));
		if (notSelected.isSelected()) {
			driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[3]/input[1]")).click();
		}
		WebElement selected = driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[3]/input[2]"));
		if (selected.isSelected()) {
			driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[3]/input[2]")).click();
		}
		
		List <WebElement> allCheckBoxes = driver.findElements(By.xpath("//label[text()='Select all below checkboxes ']/following::input"));
		int size = allCheckBoxes.size();
		for(int i = 0; i<size; i++) {
			     
			allCheckBoxes.get(i).click();
		        
		}
	}

}
