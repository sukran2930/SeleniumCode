package basics;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Day4WindowHandle {

	public static void main(String[] args) throws InterruptedException, Throwable {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Admin\\eclipse-workspace\\SeleniumJan24\\Drivers\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://omayo.blogspot.com/"); //main window
		driver.manage().window().maximize();
		
		driver.findElement(By.linkText("Open a popup window")).click(); //1st child window
		
		driver.findElement(By.linkText("Blogger")).click(); //2nd child window
		
		Set<String> windowIds = driver.getWindowHandles(); //3 windows will store in random order
		Iterator<String> itr = windowIds.iterator(); //to iterate the windows
		
		String ChildWindowText = null;
		while(itr.hasNext()) {
			String windowId = itr.next();
			driver.switchTo().window(windowId);
			if(driver.getTitle().equals("New Window")) {
				ChildWindowText = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();
			}
//			if(driver.getTitle().equals("Blogger.com - Create a unique and beautiful blog easily.")) {
//				ChildWindowText = driver.findElement(By.xpath("//span[text()='Sign in']")).getText();
//			}
		}
		System.out.println(ChildWindowText);
		driver.quit();
		/*
		//----------------
		String mainWindowId = itr.next();
		String childWindowId = itr.next();
		
		//Switch to Child window
		driver.switchTo().window(childWindowId);
		String firstChildWindowText = driver.findElement(By.xpath("//h3[text()='New Window']")).getText();		
		System.out.println(firstChildWindowText);
		Thread.sleep(2000);
		//Switch to mainWindow
		driver.switchTo().window(mainWindowId);
		//--------------------------
		*/
//		driver.close();
		
	}

}
