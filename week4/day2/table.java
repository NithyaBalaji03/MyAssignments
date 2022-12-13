
package week4.day2;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class table {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://leafground.com/table.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Get the column count
		List<WebElement> column = driver.findElements(By.xpath("(//table[@role='grid'])[1]//th"));
		
		System.out.println("Number of columns in this page are " + column.size());
		System.out.println("-------------------------------------");
		System.out.println();
		System.out.println("The column headers are: ");
		
		for (int i = 0; i < column.size(); i++) {			
			System.out.println(column.get(i).getText());			
		}	
		//Blank line
		System.out.println();
		
		//row count
		List<WebElement> row = driver.findElements(By.xpath("(//table[@role='grid'])[2]//tr"));
		
		System.out.println("Number of rows in this page are " + row.size());
		System.out.println("----------------------------------");
		System.out.println();
		System.out.println("The datas in the rows are: ");
		
		for (int i = 1; i < row.size(); i++) {
			List<WebElement> rowData = driver.findElements(By.xpath("(//table[@role='grid'])[2]//tr["+i+"]//td"));
			for (int k = 0; k < rowData.size(); k++) {
				System.out.println(rowData.get(k).getText());
			}		
		}	
		
		//Blank line
		System.out.println();
		
		//Just getting the country field values
		List<WebElement> country = driver.findElements(By.xpath("(//table[@role='grid'])[2]//tr//td[2]"));
		System.out.println("The values in Country column are:");
		for (int i = 0; i < country.size(); i++) {
			System.out.println(country.get(i).getText());
		}
	}
}
