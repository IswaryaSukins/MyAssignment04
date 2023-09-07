package week4.day2assignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrintValuesInTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://html.com/tags/table/");
        
        List<WebElement> row = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr"));
        int rowSize = row.size();
        System.out.println("Row size: "+rowSize);
        
        
        List<WebElement> column = driver.findElements(By.xpath("//div[@class='render']/table/tbody/tr[1]/td"));
        int clmnSize = column.size();
        System.out.println("Column size: "+clmnSize);
        
        
        for (int i = 1; i <=rowSize; i++) {
        	
        	for (int j = 1; j <=clmnSize; j++) {
        		String text = driver.findElement(By.xpath("//div[@class='render']/table/tbody/tr["+i+"]/td["+j+"]")).getText();
        		System.out.println(text);
        	}
        
	}

}
}
