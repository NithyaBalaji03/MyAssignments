package week4.day2;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HTMLTablePrintValues {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://html.com/tags/table/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		List<WebElement> rowValues = driver.findElements(By.xpath("(//table)[1]//tr"));

		for (int i = 1; i < rowValues.size()-1; i++) {
			String library = driver.findElement(By.xpath("(//table)[1]//tr[" +i+ "]//td")).getText();

			if (library.equals("Absolute Usage")){
				System.out.println(rowValues.get(i).getText());
			}
		}	
	}
}
