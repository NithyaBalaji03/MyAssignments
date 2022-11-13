package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ListBoxes {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/Dropdown.html");
		
		//Select using index
		WebElement selectTrainingProgram1 = driver.findElement(By.id("dropdown1")); 
		Select drop1 = new Select(selectTrainingProgram1);
		drop1.selectByIndex(2);
		
		//Select using Text
		WebElement selectTrainingProgram2 = driver.findElement(By.name("dropdown2")); 
		Select drop2 = new Select(selectTrainingProgram2);
		drop2.selectByVisibleText("Loadrunner");
		
		//Select using Value
		WebElement selectTrainingProgram3 = driver.findElement(By.name("dropdown3")); 
		Select drop3 = new Select(selectTrainingProgram3);
		drop3.selectByValue("3");
		
		//Get all options size		
		WebElement selectTrainingProgram4 = driver.findElement(By.className("dropdown")); 
		Select drop4 = new Select(selectTrainingProgram4);
		int size = drop4.getOptions().size();
		System.out.println("Number of available options " + size);
		
		//Select using sendKeys
		driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[5]/select[1]")).sendKeys("Selenium"); 		
		
		//Select multiple options
		WebElement selectTrainingProgram5 = driver.findElement(By.xpath("//div[@id='contentblock']/section[1]/div[6]/select[1]")); 
		Select drop5 = new Select(selectTrainingProgram5);
		drop5.selectByValue("2");
		drop5.selectByValue("4");			
		
		driver.close();
	}
}
