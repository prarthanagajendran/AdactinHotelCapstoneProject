package page;
 
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.PageFactory;
 import org.testng.Assert;

import base.ProjectSpecificationMethod;
 
 
 
 public class BookHotelpage extends ProjectSpecificationMethod {
 	
 	@FindBy(id = "radiobutton_0")
 	WebElement checkbox1;
 	
 	@FindBy(id ="continue")
 	WebElement ContinuetoHotel2page;
 
 	public BookHotelpage(WebDriver driver) {
 		this.driver = driver;
 		PageFactory.initElements(driver,this );
 	}
 	
 	public BookHotelpage CheckBox01() {
 		Assert.assertTrue(checkbox1.isEnabled(), "The radiobutton is not clickable");
 		checkbox1.click();
 		return this;
 	}
 	
 	public PaymentHotelpage Continue() {
 		ContinuetoHotel2page.click();
 		return new PaymentHotelpage(driver);
 	}
 	
 
 }