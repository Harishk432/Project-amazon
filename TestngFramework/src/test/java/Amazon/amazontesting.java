package Amazon;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class amazontesting extends baseclass{
WebElement amazon;

   
 @Test(priority=1)
	public void searchproduct() throws IOException {
		
     
    	WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));     //explicit
		
    		
	
		amazon=driver.findElement(By.xpath("(//input[@class=\"nav-input nav-progressive-attribute\"])[1]"));
		amazon.sendKeys("Mobile phones under 30000");
		
		Screenshots("searchproduct"); //TO TAKE SCREENSHOT
		
		amazon=driver.findElement(By.xpath("(//input[@class=\"nav-input nav-progressive-attribute\"])[2]"));
		wait.until(ExpectedConditions.visibilityOf(amazon));
		amazon.click();
		//HI
			}

    @Test(priority=2)
	public void printsearchresults() throws IOException {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5)); 
		amazon=driver.findElement(By.xpath("(//div[@class=\"sg-col-inner\"])[1]"));
		
		String str=amazon.getText();
		wait.until(ExpectedConditions.visibilityOf(amazon));
		System.out.println(str);
		
		Screenshots("PrintSearch");//TO TAKE SCREENSHOT
		//HI
	}
    
    @Test(priority=3)
	public void sortbyprint() throws IOException {
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5)); 
		
		amazon = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//select)[2]")));
		String st = amazon.getText();
		System.out.println(st);
			    
	    Select select = new Select(amazon);
	    select.selectByVisibleText("Newest Arrivals");
	    amazon.submit();
	   
	   Screenshots("Sortby");//TO TAKE SCREENSHOT
	}	
    @Test(priority=4)
	public void printfirstfivemobiles() throws IOException {
		
		List<WebElement>product=driver.findElements(By.xpath("//div[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));
		for(int i=0;i<=5;i++) {
			
			System.out.println(product.get(i).getText());
			

		}

	}
}
