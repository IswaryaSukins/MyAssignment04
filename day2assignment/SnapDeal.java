package week4.day2assignment;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;


public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub
		ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--disable-notifications");
        ChromeDriver driver=new ChromeDriver(opt);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://www.snapdeal.com/");
		Thread.sleep(1000);
		
		  WebElement men = driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
			
			
		    Actions mensFashion=new Actions(driver);
			mensFashion.moveToElement(men).perform();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]")).click();
			
			String shoeCount = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
			System.out.println("Total count of sports shoes: "+shoeCount);
			
			driver.findElement(By.xpath("(//div[@class='child-cat-name '])[2]")).click();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//i[@class='sd-icon sd-icon-expand-arrow sort-arrow']")).click();
			driver.findElement(By.xpath("(//li[@class='search-li'])[1]")).click();
			
			Thread.sleep(1000);
			List<WebElement> priceList = driver.findElements(By.xpath("(//span[contains(@class,'product-price')])[1]"));
			boolean sorted=true;
			int price=0;
			
	        Thread.sleep(1000);
			for (int i = 0; i < priceList.size(); i++) {
			    WebElement priceElement = priceList.get(i);
			    int price3 = Integer.parseInt(priceElement.getText().replaceAll("[^\\d]", ""));
			    Thread.sleep(1000);

			 if(price>price3) {
					sorted=false;
					break;
				}
				price=price3;
			}
			if(sorted) {
				System.out.println("sorted");
			}else {
				System.out.println("non sorted");
			}
			
			WebElement minPrice = driver.findElement(By.xpath("(//input[@class='input-filter'])[1]"));
			minPrice.clear();
			Thread.sleep(1000);
			minPrice.sendKeys("Rs.600");
			
			WebElement maxPrice = driver.findElement(By.xpath("(//input[@class='input-filter'])[2]"));
			maxPrice.clear();
			Thread.sleep(1000);
			maxPrice.sendKeys("Rs.999");
			
			
			driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow')]")).click();
			
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[contains(@class,'Navy')]/parent::label")).click();
			
			List<WebElement> filteredProduct = driver.findElements(By.xpath("(//div[@class='filters'])[1]"));
			
			boolean filterApplied = true;
			int minimumPrice = 600;
			int maximumPrice = 999; 
			String desiredColor = "navy";

			for (WebElement item : filteredProduct) {
			    String priceString = item.findElement(By.xpath("(//a[@class='clear-filter-pill'])[1]")).getText().replaceAll("[^0-9]", "");
			    int totalPrice = Integer.parseInt(priceString);

			    String color = item.findElement(By.xpath("(//a[@class='filter-name'])[5]")).getText().toLowerCase();

			    if (totalPrice >= minimumPrice) {
			        if (totalPrice <= maximumPrice) {
			            if (color.contains(desiredColor)) {
			                
			            } else {
			                filterApplied = false;
			                break;
			            }
			        } 
			}
			}

			if (filterApplied) {
			    System.out.println("All filters have been successfully applied.");
			} else {
			    System.out.println("Not all filters have been applied correctly.");
			}
			WebElement filteredShoe = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
			Actions msovr=new Actions(driver);
			msovr.moveToElement(filteredShoe).perform();
			Thread.sleep(1000);
			
			driver.findElement(By.xpath("//div[@class='clearfix row-disc']/div")).click();
			
			Thread.sleep(1000);
			String text = driver.findElement(By.xpath("//div[@class='product-price pdp-e-i-PAY-l clearfix']")).getText();
			System.out.println("The cost and discount percentages: "+text);

			File src=driver.getScreenshotAs(OutputType.FILE);
			File dest=new File("./snapdealt/img.png");
			FileUtils.copyFile(src, dest);
			
			driver.close();
			}
			
			
		
	}


