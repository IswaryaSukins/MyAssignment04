package week4.day2assignment;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chittorgarh {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://www.chittorgarh.com/");
        driver.findElement(By.id("navbtn_stockmarket")).click();
        driver.findElement(By.xpath("//a[text()='NSE Bulk Deals']")).click();
        List<WebElement> securityName = driver.findElements(By.xpath("//table[contains(@class,'table-hover w-auto')]/tbody/tr/td[1]"));
        Set<String> uniqueName = new TreeSet<String>();
        for (WebElement webElement : securityName) {
            String text = webElement.getText();
            uniqueName.add(text);
        }
        if (securityName.size()==uniqueName.size()) {
                System.out.println("There is no duplicate");
        }else {
            System.out.println("There is a duplicate");
        }
    }

	}


