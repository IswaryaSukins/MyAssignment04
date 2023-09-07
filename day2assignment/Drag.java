package week4.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Drag {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://leafground.com/drag.xhtml");
        
        WebElement src = driver.findElement(By.xpath("//p[text()='Drag to target']"));
        
        WebElement trg = driver.findElement(By.xpath("//span[text()='Droppable Target']"));
        
        Actions drg=new Actions(driver);
        drg.dragAndDrop(src, trg).perform();
        Thread.sleep(3000);
        
        WebElement src1 = driver.findElement(By.xpath("//span[text()='Drag and Drop']"));
        
        drg.dragAndDropBy(src1, 90, 0).perform();
        
	}

}
