package week2.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public final class Facebook {
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://en-gb.facebook.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.linkText("Create New Account")).click();
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Nithya");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Balaji");
		driver.findElement(By.xpath("(//input[@type='text'])[4]")).sendKeys("nithyaraj.balaji@gmail.com");
		driver.findElement(By.xpath("(//input[@type='password'])[2]")).sendKeys("sample@123");
		//select day
		WebElement selectDay = driver.findElement(By.xpath("//select[@id='day']"));
		Select dropDay = new Select(selectDay);
		dropDay.selectByValue("26");
		//select month
		WebElement selectMonth = driver.findElement(By.xpath("//select[@id='month']"));
		Select dropMonth = new Select(selectMonth);
		dropMonth.selectByValue("7");
		//select year
		WebElement selectYear = driver.findElement(By.xpath("//select[@id='year']"));
		Select dropYear = new Select(selectYear);
		dropYear.selectByValue("1983");
		driver.findElement(By.xpath("(//input[@type='radio'])[1]")).click();
		driver.close();
	}
}
