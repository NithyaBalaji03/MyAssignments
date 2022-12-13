package week4.day2;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Nykaa {
	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Go to https://www.nykaa.com/
		driver.get("https://www.nykaa.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Mouseover on Brands and Search L'Oreal Paris
		WebElement brandHover = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions hover = new Actions(driver);
		hover.moveToElement(brandHover).perform();
		
		/*Click L'Oreal Paris
		Check the title contains L'Oreal Paris(Hint-GetTitle)*/
		driver.findElement(By.xpath("//img[@src='https://adn-static2.nykaa.com/media/wysiwyg/2019/lorealparis.png']")).click();		
		System.out.println("Page Title" + driver.getTitle());
		
		//Click sort By and select customer top rated		
		driver.findElement(By.xpath("//span[text()='Sort By : popularity']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		
		//Click Category and click Hair->Click haircare->Shampoo
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		
		//Click->Concern->Color Protection
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		
		//Check whether the Filter is applied with Shampoo
		List<WebElement> filters = driver.findElements(By.xpath("//span[@class='filter-value']"));
		for (int i = 0; i < filters.size(); i++) {
			String strFilter = filters.get(i).getText();
			if (strFilter.equalsIgnoreCase("Shampoo")) {
				System.out.println("Shampoo Filter applied");
			}
		}
		
		//Click on L'Oreal Paris Colour Protect Shampoo
		driver.findElement(By.className("css-11gn9r6")).click();
	
		//GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));	
		
		WebElement selectSize = driver.findElement(By.xpath("//select[@title='SIZE']")); 
		Select drop1 = new Select(selectSize);
		drop1.selectByValue("0");
		
		//Print the MRP of the product
		System.out.println("MRP of the product is " + driver.findElement(By.xpath("//span[contains(text(),'MRP')]/following::span")).getText());
		
		//Click on ADD to BAG
		driver.findElement(By.xpath("//span[contains(text(),'Add to Bag')]")).click();
		
		//Go to Shopping Bag 
		driver.findElement(By.className("cart-count")).click();
		
		//Print the Grand Total amount
		driver.switchTo().frame(0);
		String grandTotal1 = driver.findElement(By.xpath("//span[contains(text(),'Grand')]/../preceding-sibling::div/span")).getText();
		grandTotal1 = grandTotal1.replaceAll("\\D", "");
		System.out.println("Grand Total is " + grandTotal1);
		
		//Click Proceed
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(text(),'Proceed')]")).click();		
		Thread.sleep(2000);
		
		//Click on Continue as Guest
		driver.findElement(By.xpath("//button[contains(text(),'Continue as guest')]")).click();
		
		//Check if this grand total is the same in step 14
		String grandTotal2 = driver.findElement(By.xpath("//p[contains(text(),'Price Details')]/ancestor::div[2]/p")).getText();
		grandTotal2 = grandTotal2.replaceAll("\\D", "");
		System.out.println("Grand Total is " + grandTotal2);
		
		if (Integer.parseInt(grandTotal2) == Integer.parseInt(grandTotal2)) {
			System.out.println("Both the Grand totals are same");
		}
			
		//Close all windows
		driver.quit();
	}
}
