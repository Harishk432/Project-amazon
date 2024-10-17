package Amazon;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.google.common.io.Files;

public class baseclass {

WebDriver driver;	
	@BeforeTest
	public void openchrome() throws IOException {
		driver = new ChromeDriver();  
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//implicit
		Screenshots("Openchrome");
		//HI
		
	}     
	
	 
	  public void Screenshots(String Filename) throws IOException {
		 
	  File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(file, new File("C:\\Users\\elcot\\eclipse-workspace\\MiniProject\\Screenshots"+Filename+".jpg"));
	  }
			
	


	@AfterTest
	public void navigatemainmenu() throws InterruptedException{
		driver.navigate().to("https://www.amazon.in/");
		Thread.sleep(2000);
		driver.quit();
		}
	
	
}


