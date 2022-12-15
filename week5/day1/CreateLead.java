package week5.day1;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class CreateLead extends BaseClass {
	@Test

	public  void runCreateLead() throws InterruptedException {

		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Test Leaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Nithya");
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Raj G S");
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Nithya B");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Testing");
		driver.findElement(By.id("createLeadForm_description")).sendKeys("vnj fjdssjf hjdkfhsdjh bkdsjdfkdshfk kjhhfjkdhfj");	
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("nithyaraj.balaji@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("7397429005");
		driver.findElement(By.name("submitButton")).click();

	}
}