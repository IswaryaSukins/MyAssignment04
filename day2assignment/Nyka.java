package week4.day2assignment;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class Nyka {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.nykaa.com/");
		Thread.sleep(1000);
		
		WebElement brand = driver.findElement(By.xpath("(//a[@class='css-1mavm7h'])[2]"));
		
		Actions bnd=new Actions(driver);
		bnd.moveToElement(brand).perform();
		
		Thread.sleep(1000);
		driver.findElement(By.id("brandSearchBox")).sendKeys("L'Oreal Paris",Keys.ENTER);
		
		driver.findElement(By.linkText("L'Oreal Paris")).click();
		
        String data="L'Oreal Paris: Buy L'Oreal Paris Products Online at Best Price in India";
		
		String title=driver.getTitle();
		
		System.out.println(title);
		
		if(title.equals(data)) {
			System.out.println("Title Matched");
		}else {
			System.out.println("Title not Matched");
		}
		
		driver.findElement(By.className("sort-name")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//span[text()='Hair Care'])[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Concern']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();
		Thread.sleep(1000);
		
		String shampoo="L'Oreal Paris Colour Protect Shampoo With UVA & UVB For Colo...";
				
		
		String fltr = driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).getText();
		System.out.println(fltr);
		
		if(fltr.equals(shampoo)) {
			System.out.println("Filter Applied");
		}else {
			System.out.println("Filter not Applied");
		}
		driver.findElement(By.xpath("//div[@class='css-xrzmfa']")).click();
		Thread.sleep(1000);
		
		Set<String> windowHandles2 = driver.getWindowHandles();
		System.out.println(windowHandles2);
		
		List<String> window= new ArrayList<String>(windowHandles2);
		
		driver.switchTo().window(window.get(1));
		
		driver.findElement(By.xpath("//span[text()='180ml']")).click();
		String price = driver.findElement(By.className("css-1jczs19")).getText();
		System.out.println("product price: "+price);
		
		driver.findElement(By.xpath("//span[@class='btn-text']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.className("cart-count")).click();
		driver.switchTo().frame(0);
		
		String totalPrice = driver.findElement(By.xpath("(//p[contains(@class,'css-6nd5ki')])[2]")).getText();
		System.out.println("Grand total: "+totalPrice);
		
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("//button[text()='Continue as guest']")).click();
		Thread.sleep(1000);
		
		driver.findElement(By.xpath("(//img[@alt='Image'])[7]")).click();
		
		
		String totalAmount = driver.findElement(By.xpath("//p[contains(@class,'css-1e59vjt')]")).getText();
		
		if(totalAmount.equals(totalPrice)) {
			 System.out.println("Grand total matched");
		 }else {
			 System.out.println("Grand total not matched");
		 }
		 
		 
		 driver.quit();
	}
}
		
	
	