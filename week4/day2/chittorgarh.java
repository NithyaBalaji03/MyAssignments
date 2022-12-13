package week4.day2;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class chittorgarh {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.chittorgarh.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		driver.findElement(By.linkText("STOCK MARKET")).click();
		driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();

		//List to store Security Names
		List<String> securityNameList = new ArrayList<String>();
		//Get the table
		WebElement table = driver.findElement(By.xpath("//div//table[@class='table table-bordered table-condensed table-striped']"));
		//Get the rows count
		List<WebElement> rowValues = table.findElements(By.xpath("//tr"));

		//loop through to find header
		for (int i = 1; i <= rowValues.size()-1; i++) {
			WebElement findHeader = rowValues.get(i).findElement(By.xpath("//th[" + i + " ]" ));
			//condition check to see if header is Security Name
			if (findHeader.getText().equals("Security Name")) {
				//Loop to get values under Security Name tab
				for (int j = 1; j < rowValues.size()-2; j++) {
					String SecurityNameVal = table.findElement(By.xpath("//tr["+j+"]//td["+i+"]")).getText();
					securityNameList.add(SecurityNameVal);
				}
				Set<String> targetSet = new TreeSet<String>(securityNameList);
				if (targetSet.size() < securityNameList.size()) {
					System.out.println("Yes, the list contains duplicates");
				}

				break;
			}
		}
	}
}
