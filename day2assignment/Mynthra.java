package week4.day2assignment;

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
import org.openqa.selenium.interactions.Actions;

public class Mynthra {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.myntra.com/");
		Thread.sleep(2000);
		
		WebElement men = driver.findElement(By.className("desktop-main"));
		Actions msovr=new Actions(driver);
		msovr.moveToElement(men).perform();
		
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[text()='Jackets']")).click();
		
		WebElement totalCount = driver.findElement(By.className("title-count"));
		String totalText = totalCount.getText();
		String total = totalText.replaceAll("[^0-9]", "");
		System.out.println("Total number of jackets: "+total);
		int totalNum = Integer.parseInt(total);
		
		
		WebElement jackets = driver.findElement(By.xpath("//span[@class='categories-num']"));
		String text1= jackets.getText();
		String jacketsCount = text1.replaceAll("[^0-9]", "");
		System.out.println(jacketsCount);
		int totalJackets = Integer.parseInt(jacketsCount);
		
		
		WebElement rainJackets = driver.findElement(By.xpath("(//span[@class='categories-num'])[2]"));
		String text2= rainJackets.getText();
		String rainJacketsCount = text2.replaceAll("[^0-9]", "");
		System.out.println(rainJacketsCount);
		int totalRainJackets = Integer.parseInt(rainJacketsCount);
		
        int totalItem=totalJackets+totalRainJackets;
		
		if(totalNum==totalItem) {
			System.out.println("matched");
		}else {
			System.out.println("not matched");
		}
			
		driver.findElement(By.xpath("//div[@class='brand-more']")).click();
		
		WebElement element = driver.findElement(By.xpath("//input[@class='FilterDirectory-searchInput']"));
		element.sendKeys("Duke",Keys.ENTER);
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//label[@class=' common-customCheckbox']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[contains(@class,'FilterDirectory-close')]")).click();
		
		List<WebElement> jacket = driver.findElements(By.xpath("//h1[@class='title-title']"));
		
		for (WebElement Element : jacket) {
		String text = Element.findElement(By.xpath("//div[text()='Duke']")).getText();
		System.out.println(text);
		
		if(text.equals("Duke")) {
			System.out.println("All brands are Duke");
		}else {
			System.out.println("Not Duke");
		}
		WebElement srt = driver.findElement(By.xpath("//span[contains(@class,'sprites-downArrow')]"));
		Actions srt1=new Actions(driver);
		srt1.moveToElement(srt).perform();
		
		driver.findElement(By.xpath("(//label[@class='sort-label '])[4]")).click();
		Thread.sleep(1000);
		
		String price = driver.findElement(By.xpath("//span[@class='product-discountedPrice']")).getText();
		System.out.println(price);
		
		Thread.sleep(1000);
		driver.findElement(By.className("img-responsive")).click();
		
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println("Multiple windows: "+windowHandles);
		
		for (String window : windowHandles) {
			System.out.println(window);
			
		}
		
		List<String> links=new ArrayList<String>(windowHandles);
		driver.switchTo().window(links.get(1));
		
		
		File src=driver.getScreenshotAs(OutputType.FILE);
		File dest=new File("./screensht/img.png");
		FileUtils.copyFile(src, dest);
		
		driver.findElement(By.xpath("//span[contains(@class,'myntraweb-sprite pdp-notWishlistedIcon')]")).click();
		
		
		driver.quit();
		
		}
		
	}

}



