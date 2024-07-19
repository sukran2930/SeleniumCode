package basics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Day5WaitMechanism {
	
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\SeleniumJan24\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://omayo.blogspot.com/"); //main window
		driver.manage().window().maximize();
		
		//Selenium implicit wait - global wait - if element find, immediate action happen
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//0 sec -> immediate click
		driver.findElement(By.className("dropbtn")).click();
		//3 sec -> only wait till 3 sec
//		driver.findElement(By.linkText("Facebook")).click();
		
		//if next element is appeared in 30sec, then????
		//Using Explicit wait -> Individual wait
		WebDriverWait wait = new WebDriverWait(driver,30);
		WebElement facebookElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Facebook")));
		facebookElement.click();
		driver.quit();
	}
	
	//FluentWait is learning purpose, generally we dont use

/*
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\SeleniumJan24\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://omayo.blogspot.com/"); //main window
		driver.manage().window().maximize();
		
		driver.findElement(By.className("dropbtn")).click();
		Thread.sleep(1000); //thread from java -> 3sec
		driver.findElement(By.linkText("Facebook")).click();
		
		driver.quit();
	}
*/
}
