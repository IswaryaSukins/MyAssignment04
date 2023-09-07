package week4.day1assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Amazon {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(opt);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("oneplus 9 pro",Keys.ENTER);
        
        String frstPrdctPrice = driver.findElement(By.xpath("(//span[@class='a-price-whole'])[1]")).getText();
        System.out.println("First product price: "+frstPrdctPrice);
        
        WebElement ratings = driver.findElement(By.xpath("(//i[contains(@class,'a-icon-star-small')])[1]"));
        String frstPrdctRating = ratings.getAttribute("textContent");
        System.out.println("Ratings of first product: "+frstPrdctRating);
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("(//img[@class='s-image'])[1]")).click();
        
        Set<String> windowHandles = driver.getWindowHandles();
		
		List<String> links=new ArrayList<String>(windowHandles);
		driver.switchTo().window(links.get(1));
		
		
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./snap1/img.png");
		FileUtils.copyFile(src, dest);
		
		Thread.sleep(1000);
		driver.findElement(By.id("add-to-cart-button")).click();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[@id='attach-sidesheet-view-cart-button-announce']/preceding-sibling::input")).click();
		 
		Thread.sleep(1000);
		String cartSubtotal = driver.findElement(By.xpath("(//span[contains(@class,'sc-white-space-nowrap')])[1]")).getText();
		System.out.println("Cart subtotal: "+cartSubtotal);
		
		
		
		String subTotal = cartSubtotal.replaceAll("[^\\d]", "");
		String firstPrdct = frstPrdctPrice.replaceAll("[^\\d]", "");
		System.out.println(subTotal);
		
		int totalAmount = Integer.parseInt(subTotal);
		System.out.println(totalAmount);
		
		int formattedAmount=totalAmount/100;
		System.out.println(formattedAmount);
		
		int frstProduct = Integer.parseInt(firstPrdct);
		System.out.println(frstProduct);
		
		
		    
		            if (formattedAmount==frstProduct) {
		                System.out.println("Cart amount matches the product price.");
		            } else {
		                System.out.println("Cart amount does not match the product price.");
		            }
		           
		            driver.quit();
		
		}

		
		
		
		
		
		
        
        	}


