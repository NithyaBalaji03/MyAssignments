package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/alert.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//handling alert
		//Simple Dialog
		driver.findElement(By.xpath("//span[contains(@class,'ui-button-icon-left ui-icon')]")).click();
		Alert smpAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		String strText1 = smpAlert.getText();
		System.out.println(strText1);
		smpAlert.accept();

		//Confirm Dialog
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		Alert cnfAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		String strText2 = cnfAlert.getText();
		System.out.println(strText2);
		cnfAlert.accept();

		//Prompt  Dialog
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
		Alert pmtAlert = driver.switchTo().alert();
		Thread.sleep(2000);
		String strText3 = pmtAlert.getText();
		System.out.println(strText3);
		pmtAlert.sendKeys("Nithya");
		pmtAlert.accept();

		//Sweet Alert
		driver.findElement(By.xpath("(//span[@class='ui-button-icon-left ui-icon ui-c pi pi-external-link'])[3]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[4]")).click();

		//Sweet Modal Dialog
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();

		//Sweet Alert Confirmation
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[9]")).click();

		//Minimize and Maximize
		driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();	
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-plus']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-extlink']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-newwin']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
	}
}
