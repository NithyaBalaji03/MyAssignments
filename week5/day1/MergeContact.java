package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class MergeContact extends BaseClass {
	@Test

	public void runMergeContact() {

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.linkText("Merge Contacts")).click();

		driver.findElement(By.xpath("//img[@alt='Lookup']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String>lstwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));		
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();

		driver.switchTo().window(lstwindow.get(0));	

		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		windowHandles = driver.getWindowHandles();
		lstwindow = new ArrayList<String>(windowHandles);
		driver.switchTo().window(lstwindow.get(1));
		driver.findElement(By.xpath("//table[@class='x-grid3-row-table']/following::table/tbody[1]/tr[1]/td[1]/div[1]/a[1]")).click();

		driver.switchTo().window(lstwindow.get(0));	
		driver.findElement(By.linkText("Merge")).click();

		Alert smpAlert = driver.switchTo().alert();
		smpAlert.accept();
		System.out.println(driver.getTitle());
	}

}