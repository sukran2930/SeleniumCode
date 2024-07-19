package basics;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Day1WebDriver {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\SeleniumJan24\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://omayo.blogspot.com/"); //Mainwindow
		driver.manage().window().maximize();
	    String title = driver.getTitle();
	    String currentUrl = driver.getCurrentUrl();
	    System.out.println("Title: " + title);
	    System.out.println("Current_Url: " + currentUrl);
	    //Text area field - > sendkeys
	   driver.findElement(By.id("ta1")).sendKeys("Selenium Training");
	   driver.findElement(By.linkText("Open a popup window")).click(); //childwindow-1
	   driver.findElement(By.linkText("Blogger")).click();
	   
	   
	   //window handling
	   Set<String> windowIds = driver.getWindowHandles(); //Main and Child window
	   Iterator<String> iterator = windowIds.iterator();
	   //next()-->String , hasNext()-> boolean
	   String windowId = null;
	   while(iterator.hasNext()) {
		   //next() and switchTo()
		   windowId = iterator.next();
		   driver.switchTo().window(windowId);
		   if(driver.getTitle().equals("New Window")) {
			   String WindowText = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
			   System.out.println("childWindowText: " + WindowText); 
		   }else if(driver.getTitle().equals("Blogger.com - Create a unique and beautiful blog easily.")) {
			   String WindowText1 = driver.findElement(By.xpath("//p[text() = 'Create a unique and beautiful blog easily.']")).getText();
			   System.out.println("childWindowText: " + WindowText1); 
		   }
		}
	   
//	   String mainWindowId = iterator.next();
//	   String childWIndowId = iterator.next();
//	   System.out.println("mainWindowId: " + mainWindowId);
//	   System.out.println("childWIndowId: " + childWIndowId);
	   
	   
//	   String childPopWindowText = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
//	   System.out.println(childPopWindowText);
//	   driver.findElement(By.linkText("Blogger")).click();
	   
	   
//	    driver.close();
	    driver.quit();

	}

}
