package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnWindow {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Click and Confirm new Window Opens
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow = new ArrayList<String>(windowHandles);
		
		if(lstwindow.size() > 1) {
			System.out.println("New Window Opened");
		}
		
		driver.switchTo().window(lstwindow.get(0));	
		
		//Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		
		windowHandles = driver.getWindowHandles();
		lstwindow = new ArrayList<String>(windowHandles);
		System.out.println("Total number of windows opened " + lstwindow.size());
		
		//Close all windows except Primary
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		windowHandles = driver.getWindowHandles();
		lstwindow = new ArrayList<String>(windowHandles);
		System.out.println("Total number of windows opened now " + lstwindow.size());
		
		for (int i = 1; i <= lstwindow.size()-1; i++) {
			driver.switchTo().window(lstwindow.get(i));	
		    driver.close(); 
		}
		
		driver.switchTo().window(lstwindow.get(0));	
		
		//Wait for 2 new tabs to open
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Thread.sleep(2000);
		windowHandles = driver.getWindowHandles();
		System.out.println("Total number of windows opened now " + windowHandles.size());
		
		driver.quit();
	}
}
