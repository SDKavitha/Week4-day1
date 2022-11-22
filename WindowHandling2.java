package week4.day1;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowHandling2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leafground.com/window.xhtml");
		driver.manage().timeouts().implicitlyWait(Duration.ofMinutes(30));
		
		//print active window
		String windowHandle = driver.getWindowHandle();
		System.out.println(windowHandle);
		System.out.println(driver.getTitle());
		
		//click and confirm new window open
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		System.out.println(driver.getWindowHandle());
		System.out.println(driver.getTitle());
		
		//Find the number of opened tabs
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Number of opened tabs :"+windowHandles.size());
		
		//convert set into list
				//List<String> lstname=new ArrayList<String>(windowHandles);
		
			
				
			//Close all windows except primary
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
	
				for(String str : driver.getWindowHandles()) {
			        if (!str.equals(windowHandle)) {
			            driver.switchTo().window(str);
			            driver.close();
			        }
			    }

			    driver.switchTo().window(windowHandle);
				
		//Wait for 2 new tabs to open
				driver.findElement(By.xpath("//span[text()='Open with delay']")).click();	
		
		
	}

}
