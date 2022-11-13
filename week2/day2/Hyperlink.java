package week2.day2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Hyperlink {
	
	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testleaf.herokuapp.com/pages/Link.html");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.findElement(By.linkText("Go to Home Page")).click();
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following-sibling::img")).click();
		
		String element = driver.findElement(By.linkText("Find where am supposed to go without clicking me?")).getAttribute("href");
		System.out.println(element);
		
		driver.findElement(By.linkText("Verify am I broken?")).click();
		String title = driver.getTitle();
		System.out.println(title);
		if (title.equals("404 Not Found")) {
			System.out.println("Link is broken");
		}else {
			System.out.println("Link is not broken");
		}

		driver.navigate().back();
		String homePageLink1 = driver.findElement(By.xpath("//a[text()='Go to Home Page']")).getAttribute("href");
		String homePageLink2 = driver.findElement(By.xpath("(//a[text()='Go to Home Page'])[2]")).getAttribute("href");
		
		if (homePageLink1.equals(homePageLink2)) {
			driver.navigate().to(homePageLink1);
			System.out.println("Both links are same and clicking on 1st link");
		}else {
			System.out.println("Both links are not same");
		}
		
		driver.findElement(By.xpath("//h5[text()='HyperLink']/following-sibling::img")).click();
		
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		int linkCount = linkElements.size();
		System.out.println("The number of links in this page " + linkCount);
		
	}

}
