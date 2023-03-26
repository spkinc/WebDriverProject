package test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DragAndDropExample {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		String parentWin = driver.getWindowHandle();
		String childWin="";

		WebElement newTab = driver.findElement(By.id("tabButton"));
		newTab.click();
		
		Set<String> allWin = driver.getWindowHandles();

		for (String win: allWin) {
			if(!win.equals(parentWin)) {
				childWin = win;
			}
		}

		System.out.println("Parent win is " + parentWin);
		System.out.println("Child win is " + childWin);
		
		driver.switchTo().window(childWin);
		
		WebElement childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in child win is " + childHeader.getText());
		
		driver.close();
		Thread.sleep(2000);

// Second script		
		driver.switchTo().window(parentWin);

		newTab = driver.findElement(By.id("windowButton"));		
		newTab.click();

		allWin = driver.getWindowHandles();

		for (String win: allWin) {
			if(!win.equals(parentWin)) {
				childWin = win;
			}
		}
		System.out.println("Child win is " + childWin);
		
		driver.switchTo().window(childWin);
		
		childHeader = driver.findElement(By.id("sampleHeading"));
		System.out.println("Header in child win is " + childHeader.getText());

		driver.close();
		Thread.sleep(2000);
	
		driver.quit();
	}

}
