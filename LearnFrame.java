package week4.day1;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnFrame {

	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/frame.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
		
		//handle frame
		driver.switchTo().frame(0);
		WebElement ele = driver.findElement(By.xpath("//button[@id='Click']"));
		 ele.click();
		 String text = ele.getText();
		 System.out.println(text);
		 //get out of frame
		 driver.switchTo().defaultContent();
		 //driver.switchTo().parentFrame();
		 
		 //Nested frame
		 //using id
		 driver.switchTo().frame(2);
		 //using web element
		// WebElement frame = driver.findElement(By.xpath("//iframe[@src=\"default.xhtml\"]"));
		// driver.switchTo().frame(frame);
		 //using text
		 driver.switchTo().frame("frame2");
		 WebElement ele1 = driver.findElement(By.xpath("//button[text()='Click Me']"));
		 ele1.click();
		 String text2 = ele1.getText();
		 System.out.println(text2);
		 driver.switchTo().defaultContent();
		 
		 
		 //How many frames in this page?
		 driver.switchTo().frame(1);
		 WebElement ele2 = driver.findElement(By.xpath("//button[text()='Count Frames']"));
		 ele2.click();
		 String text3 = ele2.getText();
		 System.out.println(text3);
		 
		 
		 //Thread.sleep(1000);
		 //How to take snap shot
		 //step1: take a snap
		// File source = driver.getScreenshotAs(OutputType.FILE);
		 //step 2 : to save the file in local dir
		 
		 //File dest=new File("./snap/frame.png");//to create folder automatically
		 //step3: join source and dest
		// FileUtils.copyFile(source, dest);
		
	}

}
