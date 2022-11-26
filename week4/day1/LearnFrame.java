package week4.day1;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/frame.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		//Inside Frame
		driver.switchTo().frame(0);
		WebElement click1 = driver.findElement(By.xpath("//button[text()='Click Me']"));		
		click1.click();
		System.out.println(click1.getText());
		driver.switchTo().defaultContent();

		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/frame1.png");
		FileUtils.copyFile(source, dest);
		
		//nested frame
		driver.switchTo().frame(2);
		driver.switchTo().frame("frame2");
		WebElement click2 = driver.findElement(By.xpath("//button[text()='Click Me']"));		
		click2.click();
		System.out.println(click2.getText());
		driver.switchTo().defaultContent();	
		
		List<WebElement> f = driver.findElements(By.xpath("//iframe"));
	    System.out.println("Total number of frames " + f.size());
	}

}
