package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		//driver setup
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\SeleniumJan24\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/");
		driver.manage().window().maximize();
		
		//locator - id
		driver.findElement(By.id("ta1")).sendKeys("Ranjith Kumar");
		Thread.sleep(1000);
		//locator - name
		driver.findElement(By.name("q")).sendKeys("Ranjith");
		Thread.sleep(1000);
		
		//locator - className 
		driver.findElement(By.className("dropbtn")).click();
		Thread.sleep(1000);
 
		//locator - linkText
		driver.findElement(By.linkText("onlytestingblog")).click();
	}

}
