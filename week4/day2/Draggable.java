package week4.day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Draggable {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		Actions actDrive = new Actions(driver);
		
		//Drag and Drop By
		WebElement draggable = driver.findElement(By.xpath("//div[@id='form:conpnl']"));
		Thread.sleep(2000);		
		actDrive.dragAndDropBy(draggable, 50, 80).perform();	
		
		//Drag and Drop 
		WebElement source = driver.findElement(By.xpath("//div[@id='form:drag_content']"));
		WebElement destination = driver.findElement(By.xpath("//div[@id='form:drop_content']"));
		actDrive.dragAndDrop(source, destination).perform();
		 
		System.out.println("After dropping : " + driver.findElement(By.xpath("//div[@id='form:drop_content']")).getText());
		
		//Column Draggable
		source = driver.findElement(By.xpath("//span[@class='ui-column-title']"));
		destination = driver.findElement(By.xpath("(//span[@class='ui-column-title'])[3]"));
		actDrive.dragAndDrop(source, destination).perform();
		
		//Row Draggable
		source = driver.findElement(By.xpath("(//tr[@role='row'])[18]"));
		destination = driver.findElement(By.xpath("(//tr[@role='row'])[13]"));
		actDrive.dragAndDrop(source, destination).perform();		
		
		WebElement resize = driver.findElement(By.xpath("//div[@class='ui-resizable-handle ui-resizable-e']"));
		actDrive.clickAndHold(resize).moveByOffset(10, 10).perform(); 
	}

}
