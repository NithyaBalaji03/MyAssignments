package week2.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Image {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/Image.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.xpath("//img[@src='../images/home.png']")).click();
		driver.navigate().back();
		
		//Broken Image
		WebElement imgSrc = driver.findElement(By.xpath("//label[text()='Am I Broken Image?']/following-sibling::img"));
			
		//Click on image using mouse or keyboard
		WebElement keyboard = driver.findElement(By.xpath("//img[@src='../images/keyboard.png']"));
		Actions builder = new Actions(driver);
		builder.click(keyboard).perform();
		
	}

}
