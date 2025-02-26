import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Login {



	public static WebDriver main(String[] args) throws Throwable{
	WebDriver driver;
	driver = new FirefoxDriver();
//	driver.manage().window().maximize();
	driver.get("http://192.168.1.100:8086/VyoogErp3/");
	
	driver.findElement(By.id("loginDatasource")).click();
	driver.findElement(By.id("loginDatasource")).click();
	{
		WebElement element = driver.findElement(By.id("loginDatasource"));
		Actions builder = new Actions(driver);
		builder.doubleClick(element).perform();
	}

	driver.findElement(By.id("loginDatasource")).click();
	driver.findElement(By.id("loginDatasource")).clear();
	driver.findElement(By.id("loginDatasource")).sendKeys("makwin");
	driver.findElement(By.id("loginDatasource")).sendKeys(Keys.DOWN);
	driver.findElement(By.id("loginDatasource")).sendKeys(Keys.TAB);
	driver.findElement(By.id("userName")).clear();
	driver.findElement(By.id("userName")).sendKeys("makwinadmin");  
	driver.findElement(By.id("password")).clear();
	driver.findElement(By.id("password")).sendKeys("vyg06");
	driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
	TimeUnit.SECONDS.sleep(1);
return driver;
}
}