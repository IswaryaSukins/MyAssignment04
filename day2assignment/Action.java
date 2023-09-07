package week4.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Action {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
        ChromeDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/draggable");
        
        driver.switchTo().frame(0);
        
        WebElement drg = driver.findElement(By.xpath("//p[text()='Drag me around']"));
        
        Actions drg1=new Actions(driver);
        drg1.dragAndDropBy(drg, 120, 120).perform();
        
     
        
	}

}
