package page;
 
 import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.PageFactory;
 import org.testng.Assert;
 
import base.ProjectSpecificationMethod;
 
 public class Bookitinerarypage extends ProjectSpecificationMethod {
 	
 	@FindBy(id = "logout")
 	WebElement logout;
 	
 	@FindBy(id = "order_id_text")
 	WebElement searchorder;
 	
 	@FindBy(id ="search_hotel_id")
 	WebElement Gobutton;
 	
 	@FindBy(xpath = "//input[@class='reg_button']")
 	WebElement cancelselected;
 	
 	@FindBy(id = "search_hotel")
 	WebElement SearchHotelbutton;
 	
 	@FindBy(id = "order_id_1321676")
    WebElement id1;
 	
 	@FindBy(xpath = "//input[@value='RXFN5N3DF7'] ")
 	WebElement id2;
 	
 
 	@FindBy(id = "order_id_1316806")
 	WebElement textorderid1;
 	
 	@FindBy(id = "search_result_error")
 	WebElement verifyorder;
 	
 	public Bookitinerarypage(WebDriver driver) {
 		this.driver = driver;
 		PageFactory.initElements(driver,this );
 	}
 	
 	public Logoutpage logout() {
 		logout.click();
 		return new Logoutpage(driver);
 	}
 	
 	public Bookitinerarypage searchorder() {
 		searchorder.sendKeys("V020JDMHMY");
 		Gobutton.click();
 		return this;
 	}
 	 public Bookitinerarypage Deleteorder() {
 		 id1.click();
 		 cancelselected.click();
 		 Alert alert = driver.switchTo().alert();
 		 alert.accept();
 		 return this;
 	}
 	public Bookitinerarypage VerifySearchOrder() {
 		Assert.assertTrue(verifyorder.isDisplayed(), "the search result is not displayed");
 		return this;
 		
 	}
 
 }