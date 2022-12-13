package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Myntra {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		//Open https://www.myntra.com/
		driver.get("https://www.myntra.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//Mouse hover on MeN 
		WebElement menHover = driver.findElement(By.xpath("//a[@href='/shop/men']"));
		Actions hover = new Actions(driver);
		hover.moveToElement(menHover).perform();
		
		//Click Jackets 
		driver.findElement(By.xpath("//a[@href='/men-jackets']")).click();
		
		//Find the total count of item 
		String strTotal = driver.findElement(By.xpath("//span[@class='title-count']")).getText();
		strTotal = strTotal.replaceAll("\\D", "");
		int intTotalItems = Integer.parseInt(strTotal);
		
		//Validate the sum of categories count matches
		String strCatTotal = "";
		int intCatTotal = 0;
		List<WebElement> categoriesEls = driver.findElements(By.xpath("//span[@class='categories-num']"));
		for (int i = 0; i <= categoriesEls.size()-1; i++) {
			strCatTotal = categoriesEls.get(i).getText();
			strCatTotal = strCatTotal.replaceAll("\\D", "");
			intCatTotal = intCatTotal + Integer.parseInt(strCatTotal);
		}
		
		if  (intCatTotal == intTotalItems) {
			System.out.println("Total count of items match with the total under categories section");
		} else {
			System.out.println("Count doesn't match");
		}
		
		//6) Check jackets	
		Thread.sleep(2000);
		WebElement l = driver.findElement(By.xpath("//input[@value='Jackets']"));
	    //JavascriptExecutor to click element
	    JavascriptExecutor j = (JavascriptExecutor) driver;
	    j.executeScript("arguments[0].click();", l);
				
		//7) Click + More option under BRAND
	    driver.findElement(By.xpath("//div[@class='brand-more']")).click();
	    
		//Type Duke and click checkbox
		driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']")).sendKeys("Duke");
		l = driver.findElement(By.xpath("//input[@value='Duke']"));
	    //JavascriptExecutor to click element
	    j = (JavascriptExecutor) driver;
	    j.executeScript("arguments[0].click();", l);
		
	    //Close the pop-up x
	    driver.findElement(By.xpath("//div[@class='FilterDirectory-panel FilterDirectory-expanded']/div/span")).click();
	    Thread.sleep(2000);
	    
		//10) Confirm all the Coats are of brand Duke
	    String brand = "";
	    List<String>lstBrand = new ArrayList<String>();
	    List<WebElement> searhList = driver.findElements(By.xpath("//h3[@class='product-brand']"));
	    for(int i = 0; i <= searhList.size()-1; i++) {
	    	brand = searhList.get(i).getText();
	    	if (brand.equalsIgnoreCase("duke")) {
	    		lstBrand.add(brand);
	    	}
	    }
	    if (searhList.size() == lstBrand.size()) {
	    	System.out.println("All Brands are duke");
	    } else {
	    	System.out.println("All brands are non duke");
	    }
		
		//Sort by Better Discount
	    WebElement sortHover = driver.findElement(By.xpath("//span[@class='myntraweb-sprite sort-downArrow sprites-downArrow']"));
		hover = new Actions(driver);
		hover.moveToElement(sortHover).perform();
		
		l = driver.findElement(By.xpath("//input[@value='discount']"));
	    //JavascriptExecutor to click element
	    j = (JavascriptExecutor) driver;
	    j.executeScript("arguments[0].click();", l);
	    Thread.sleep(2000);
	   
		//12) Find the price of first displayed item
	    System.out.println("Price of the first displayed item is " + driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText());
		//Click on the first product
	    driver.findElement(By.xpath("//li[@class='product-base']")).click();
	    Thread.sleep(2000);
	    
		//Take a screen shot
	    Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));	
		File source = driver.getScreenshotAs(OutputType.FILE);
		File dest = new File("./snap/myntra.png");
		FileUtils.copyFile(source, dest);
		
		//Click on WishList Now
		driver.findElement(By.xpath("//div[contains(@class, 'pdp-add-to-wishlist pdp-button pdp-add-to-wishlist pdp-button pdp-flex pdp-center')]")).click();
		
		//Close Browser
		driver.quit();
	}

}
