package basics;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;





public class Day1 {
	public static void main(String[] args) throws InterruptedException, IOException{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\SeleniumJan24\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.manage().window().maximize();
	    Thread.sleep(1000);
	    String title = driver.getTitle();
	    String currentUrl = driver.getCurrentUrl();
	    System.out.println("Title: " + title);
	    System.out.println("Current_Url: " + currentUrl);
	    
	    //Screenshot-1
	    TakesScreenshot ts = (TakesScreenshot)driver;
	    File src = ts.getScreenshotAs(OutputType.FILE);
	    File dest = new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJan24\\Screenshot\\Snap1.png");
	    FileHandler.copy(src, dest);
	    
	    Thread.sleep(1000);
//	    driver.navigate().to("https://www.facebook.com");
//	    String title_1 = driver.getTitle();
//	    String currentUrl_1 = driver.getCurrentUrl();
//	    System.out.println("Title: " + title_1);
//	    System.out.println("Current_Url: " + currentUrl_1);
	    ////a[text()='Images']
	    
	    WebElement imgElement = driver.findElement(By.xpath("//a[text()='Images']"));
	    Thread.sleep(1000);
	    imgElement.click();
//	    driver.findElement(By.xpath("//a[text()='Images']")).click();
	    
	    WebElement searchTextBox = driver.findElement(By.xpath("//textarea[@title='Search']"));
	    Thread.sleep(1000);
	    searchTextBox.sendKeys("Republic day Images 2024");
	    driver.findElement(By.xpath("//button[@type='submit']")).click();
	    Thread.sleep(1000);
	    //Screenshot-2
	    TakesScreenshot ts2 = (TakesScreenshot)driver;
	    File src2 = ts2.getScreenshotAs(OutputType.FILE);
	    File dest2 = new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJan24\\Screenshot\\Snap2.png");
	    FileHandler.copy(src2, dest2);
	    
	    WebElement imgSearhTxtBox = driver.findElement(By.xpath("//input[@title='Search']"));
	    imgSearhTxtBox.clear();
	    imgSearhTxtBox.sendKeys("Republic day vidoes");
	    String text = driver.findElement(By.xpath("(//div[@role='button'])[5]")).getText();
//	    String attribute = driver.findElement(By.xpath("//a[@aria-label='Sign in']")).getAttribute("aria-label");
	    String attribute = driver.findElement(By.xpath("(//div[@role='button'])[5]")).getAttribute("role");
	    System.out.println("Get Text from current browser: " + text + " and Attribute: " + attribute);
	    
	    //Screenshot-3 syntax
	    TakesScreenshot ts3 = (TakesScreenshot)driver;
	    File source = ts3.getScreenshotAs(OutputType.FILE);
	    File destination = new File("C:\\Users\\Admin\\eclipse-workspace\\SeleniumJan24\\Screenshot\\Snap3.png");
	    FileHandler.copy(source, destination);
//	    FileUtils.copyFile(source, destination);
	    
//	    driver.close();
	    driver.quit();
	    
}

}

