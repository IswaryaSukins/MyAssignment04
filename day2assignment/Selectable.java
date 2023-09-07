package week4.day2assignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Selectable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(opt);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://jqueryui.com/selectable");
        
        driver.switchTo().frame(0);
        
        WebElement index1 = driver.findElement(By.xpath("//li[text()='Item 2']"));
        
        WebElement index2 = driver.findElement(By.xpath("//li[text()='Item 4']"));
        
        WebElement index3 = driver.findElement(By.xpath("//li[text()='Item 6']"));
        
        Actions select=new Actions(driver);
        select.keyDown(Keys.CONTROL).click(index1).click(index2).click(index3).keyUp(Keys.CONTROL).perform();
	}

}
