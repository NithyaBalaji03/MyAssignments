package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Amazon {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Go to https://www.amazon.in/
		driver.get("https://www.amazon.in/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//search as oneplus 9 pro 
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//Get the price of the first product
		String strPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
		System.out.println(strPrice);
		strPrice = strPrice.replaceAll("\\D", "");
		System.out.println("Price of first product is " + strPrice);
		
		//Print the number of customer ratings for the first displayed product
		String strCustRating = driver.findElement(By.xpath("(//span[@class='a-size-base'])[1]")).getText();
		System.out.println("Customer Rating is " + strCustRating);
		
		//Mouse Hover on the stars
		//Get the percentage of ratings for the 5 star.
		driver.findElement(By.xpath("//a[@href='javascript:void(0)']/i")).click();
		Thread.sleep(2000);
		System.out.println("Percentage of ratings for the 5 star is " + driver.findElement(By.xpath("//td[@class='a-text-right a-nowrap']/span/a")).getText());
		
		//Click the first text link of the first image
		driver.findElement(By.xpath("//a[@class='a-link-normal s-underline-text s-underline-link-text s-link-style a-text-normal']")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));	
		
		//Take a screen shot of the product displayed
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/amazon.png");
		FileUtils.copyFile(source, dest);
		
		//Click 'Add to Cart' button
		driver.findElement(By.xpath("//input[@id='add-to-cart-button']")).click();
		Thread.sleep(2000);
		
		//Get the cart subtotal and verify if it is correct.
		WebElement temp = driver.findElement(By.xpath("//span[@id='attach-accessory-cart-subtotal']"));
		Thread.sleep(2000);
		String strCartPrice = temp.getText();
		strCartPrice = strCartPrice.replace(".00", "");
		strCartPrice = strCartPrice.replaceAll("\\D", "");
		System.out.println("Cart Price is " +strCartPrice);
		
		if (Integer.parseInt(strCartPrice) == Integer.parseInt(strPrice)) {
			System.out.println("Cart Subtotal is correct");
		}
		
		driver.quit();
	}
}
