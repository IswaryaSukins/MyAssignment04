package week4.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Resizeabl {
public static void main(String[] args) {
	ChromeOptions opt = new ChromeOptions();
    opt.addArguments("--disable-notifications");
    ChromeDriver driver=new ChromeDriver(opt);
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    driver.get("https://jqueryui.com/resizable");
   
    driver.switchTo().frame(0);
    
    WebElement size = driver.findElement(By.xpath("//div[contains(@class,'ui-resizable-handle')]"));
    
    Actions size1=new Actions(driver);
    size1.moveToElement(size, 90, 90).perform();
}
}
