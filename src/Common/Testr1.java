package Common;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Testr1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.gecko.driver", "/home/vyoog/Downloads/Cucumber/geckodriver");
		WebDriver driver=new FirefoxDriver();
		driver.get("http://localhost:8085/VyoogErp3/");
		
		driver.findElement(By.id("loginDatasource")).click();
		driver.findElement(By.id("loginDatasource")).click();
		{
			WebElement element = driver.findElement(By.id("loginDatasource"));
			Actions builder = new Actions(driver);
			builder.doubleClick(element).perform();
		}

		driver.findElement(By.id("loginDatasource")).click();
		driver.findElement(By.id("loginDatasource")).clear();
		driver.findElement(By.id("loginDatasource")).sendKeys("unicon");
		driver.findElement(By.id("loginDatasource")).sendKeys(Keys.DOWN);
		driver.findElement(By.id("loginDatasource")).sendKeys(Keys.TAB);
		driver.findElement(By.id("userName")).clear();
		driver.findElement(By.id("userName")).sendKeys("uniconadmin");
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys("evygadm123");
		driver.findElement(By.id("password")).sendKeys(Keys.ENTER);
		
		driver.get("http://localhost:8085/VyoogErp3/dashboard/common");
	    
	    driver.findElement(By.cssSelector(".nav-item:nth-child(10) p")).click();

	}

}
