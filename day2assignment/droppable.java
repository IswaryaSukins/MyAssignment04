package week4.day2assignment;



import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class droppable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/droppable");
        
        driver.switchTo().frame(0);
        
        WebElement src = driver.findElement(By.id("draggable"));
        
        WebElement trg = driver.findElement(By.id("droppable"));
        
        Actions op=new Actions(driver);
        op.dragAndDrop(src, trg).perform();
        
      
	}

}
