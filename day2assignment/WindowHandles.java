package week4.day2assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WindowHandles {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com/");
		driver.findElement(By.id("username")).sendKeys("hari.radhakrishnan@qeagle.com");
		driver.findElement(By.id("password")).sendKeys("Leaf$1234");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		
		String parentWindow = driver.getWindowHandle();
		
		Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> links=new ArrayList<String>(windowHandles);
		driver.switchTo().window(links.get(1));
		
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		Thread.sleep(1000);
		
		String title = driver.getTitle();
		System.out.println("Title of the page is: "+title);
		
		driver.close();
		
		driver.switchTo().window(parentWindow);
		Thread.sleep(1000);
		
		driver.quit();
		
		
		
	}

}
