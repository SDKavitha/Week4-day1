package week4.day1;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LearnAlert {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/alert.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
		
		//1.Find the element of simple alert
		 driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[1]")).click();
		 //handle alert
		 Alert sa = driver.switchTo().alert();
		 //print information from box
		 String text = sa.getText();
		 System.out.println("Simple alert:"+text);
		// Thread.sleep(2000);
		  sa.accept();//have only one option
		  String ver = driver.findElement(By.xpath("//span[@id='simple_result']")).getText();
		  System.out.println(ver);
		 
		//2.Find the element of confirm alert
		 driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[2]")).click();
		 //handle alert
		 Alert ca = driver.switchTo().alert();
		 String msg = sa.getText();
		 System.out.println("confirm alert:"+msg);
		 Thread.sleep(2000);
		 //ca.accept();
		 ca.dismiss();
		  String verify = driver.findElement(By.xpath("//span[@id='result']")).getText();
		 System.out.println(verify);
		 
		 //3.Sweet Alert (Simple Dialog)
		 driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[3]")).click();
		 driver.findElement(By.xpath("//span[text()='Dismiss']")).click();
		 String text3 = driver.findElement(By.xpath("//div[@class='ui-dialog-content ui-widget-content']//p")).getText();
		 System.out.println("Sweet alert (simple):"+text3);
		 
		 //4.Sweet Modal Dialog
		 driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[5]")).click();
		 driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		 String text4 = driver.findElement(By.xpath("//p[@class='m-0']")).getText();
		 System.out.println("Sweet Modal Dialog :"+text4);
		 
		 
		 // 5.Prompt dialog
		 driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]")).click();
		 Alert pa = driver.switchTo().alert();
		 Thread.sleep(3000);
		 pa.sendKeys("Testleaf");
		 String text2 = pa.getText();
		 System.out.println("Prompt msg:"+text2);
		 Thread.sleep(1000);
		 pa.accept();
		 String verify2 = driver.findElement(By.xpath("//span[@id='confirm_result']")).getText();
		 System.out.println(verify2);
		 
		 driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[2]")).click();
		 
		 Thread.sleep(1000);
		 //6.Sweet alert(confirmation)
		 driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[7]")).click();
		 driver.findElement(By.xpath("//span[text()='Yes']")).click();
		 
		 //7.Minimize and Maximize
		 driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[8]")).click();
		 driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-minus']")).click();
		 String text5 = driver.findElement(By.xpath("(//p[@class='m-0'])[2]")).getText();
		 System.out.println("Minimize and Maximize :"+text5);
		 Thread.sleep(1000);
		 driver.findElement(By.xpath("(//span[@class='ui-icon ui-icon-closethick'])[3]")).click();
	}

}
