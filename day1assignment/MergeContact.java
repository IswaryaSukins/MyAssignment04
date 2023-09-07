package week4.day1assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeContact {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("Demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.linkText("Contacts")).click();
		Thread.sleep(1000);
		driver.findElement(By.linkText("Merge Contacts")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> window=new ArrayList<String>(windowHandles);
		driver.switchTo().window(window.get(1));
		
		Thread.sleep(1000);
		WebElement firstResultId = driver.findElement(By.xpath("(//a[@class='linktext'])[1]"));
		String firstId = firstResultId.getText();
		System.out.println("First resulting Id is: "+firstId);
		Thread.sleep(1000);
		firstResultId.click();
		
		driver.switchTo().window(window.get(0));
		Thread.sleep(1000);
	    
	    driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
	    
	    Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> window2=new ArrayList<String>(windowHandles2);
		driver.switchTo().window(window2.get(1));
	   
		Thread.sleep(1000);
	    WebElement secondResultId = driver.findElement(By.xpath("(//a[@class='linktext'])[6]"));
		String secondId = secondResultId.getText();
		System.out.println("Second resulting Id is: "+secondId);
		Thread.sleep(1000);
		secondResultId.click();
		
		driver.switchTo().window(window.get(0));
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//a[@class='buttonDangerous']")).click();
		
		Thread.sleep(1000);
		Alert alert = driver.switchTo().alert();
		alert.accept();
		
		String title = driver.getTitle();
		System.out.println(title);
		
		String titleName="View Contact | opentaps CRM";
		
		if(titleName.equals(title)) {
			System.out.println("Title verified");
		}else {
			System.out.println("Title not verified");
		}
		
		
		
		

}
}
