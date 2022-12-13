package week4.day2;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tableRowsAndColumnsCount {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//find the number of tables in the page
		int tableCount = driver.findElements(By.xpath("//table")).size();
		System.out.println("Number of Tables in this page " + tableCount);
		System.out.println("--------------------------------");
		
		//loop through the tables to find number of ros and columns
		for(int i = 1; i <= tableCount; i++) {
			int intRowCount = driver.findElements(By.xpath("(//table)[" +i+ "]//tr")).size();
			int intColumnCount = driver.findElements(By.xpath("(//table)[" +i+ "]//th")).size();
			System.out.println("Number of Columns in Table " + i + " is " + intColumnCount);
			System.out.println("Number of Rows in Table " + i + " is " + intRowCount);
		}		
	}
}
