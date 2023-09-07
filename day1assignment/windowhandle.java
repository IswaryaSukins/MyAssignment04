package week4.day1assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;

public class windowhandle {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		driver.get("https://leafground.com/window.xhtml;jsessionid=node0ohpw87cjok1dz9p1fgudvj6l12019.node0");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		
		
		Thread.sleep(2000);
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("multiple windows: "+windowHandles);
		
		String parent = driver.getTitle();
		System.out.println("parent window is: "+parent);
		
		List<String> allLinks=new ArrayList<String>(windowHandles);
		driver.switchTo().window(allLinks.get(0));
		
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		driver.findElement(By.xpath("//i[@class='pi pi-ellipsis-v']")).click();
		
        Thread.sleep(2000);
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println(windowHandles2);
		
		List<String> allLinks1=new ArrayList<String>(windowHandles);
		Thread.sleep(2000);
		driver.switchTo().window(allLinks1.get(0));
		
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Thread.sleep(2000);
		
		Set<String> windowHandles3 = driver.getWindowHandles();
		System.out.println(windowHandles3);
		
		driver.switchTo().window(allLinks.get(0));
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		
		Set<String> windowHandles4 = driver.getWindowHandles();
		System.out.println(windowHandles4);
		Thread.sleep(2000);
		
		driver.quit();
			
		}
	}

