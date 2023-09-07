package week4.day2assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Frame {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		   ChromeDriver driver=new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	        driver.get("https://leafground.com/frame.xhtml;jsessionid=node05us3gij8ed091h38fieurov685953.node0");
	       
	        driver.switchTo().frame(0);
	        Thread.sleep(2000);
	        WebElement frm1 = driver.findElement(By.id("Click"));
	        frm1.click();
	        System.out.println(frm1.getText());
	        
	        driver.switchTo().defaultContent();
	        Thread.sleep(2000);
	        
	        driver.switchTo().frame(2);
	        driver.switchTo().frame("frame2");
	        
	        WebElement frm2 = driver.findElement(By.id("Click"));
	        frm2.click();
	        System.out.println(frm2.getText());
	        
	        driver.switchTo().defaultContent();
	        
	        List<WebElement> elements = driver.findElements(By.tagName("iframe"));
	        System.out.println("Frames count:" +elements.size());
	        
	      
	        
	        
	      
	}

}
