package week4.day2assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Count {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://html.com/tags/table/");
        
        List<WebElement> row = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
        int size = row.size();
        System.out.println("Row size: "+size);
        
        List<WebElement> column = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr[1]/td"));
        int clmnSize = column.size();
        System.out.println("Column size: "+clmnSize);
        
	}

}
