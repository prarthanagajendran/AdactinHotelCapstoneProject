package page;
 
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethod;
 
 
 public class Logoutpage extends ProjectSpecificationMethod {
 	
 	
 	@FindBy(xpath = "//a[text()='Click here to login again']")
 	WebElement logout;
 
 	public Logoutpage(WebDriver driver) {
 		this.driver = driver;
 		PageFactory.initElements(driver,this );
 	}
 	

 	public Loginpage logout() {
 		logout.click();
        Assert.assertTrue(driver.getCurrentUrl().contains("https://adactinhotelapp.com/HotelAppBuild2/Logout.php"));
 		return new Loginpage(driver);
 	}
 
 }	
 
