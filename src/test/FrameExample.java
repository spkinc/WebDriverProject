package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/frames");

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		driver.switchTo().frame("frame1");
		WebElement header = driver.findElement(By.id("sampleHeading"));
		System.out.println("Frame1 header is: " + header.getText());

		driver.switchTo().defaultContent();
		
		driver.switchTo().frame("frame2");
		header = driver.findElement(By.id("sampleHeading"));
		System.out.println("Frame2 header is: " + header.getText());
		

		driver.quit();
	}

}
