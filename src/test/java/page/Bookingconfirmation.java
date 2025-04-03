package page;
 
 import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethod;
 

 
 public class Bookingconfirmation extends ProjectSpecificationMethod{
 	
 	@FindBy(id ="my_itinerary")
 	WebElement Myitinerary;

 	//@FindBy(xpath ="//label[@id='cc_num_span']")
 //	WebElement CCnum;
 
 
 	public Bookingconfirmation(WebDriver driver) {
 		this.driver = driver;
 		PageFactory.initElements(driver,this );
 	}
 	
 	public Bookitinerarypage itinerarybutton() {
 		Myitinerary.click();
 		return new Bookitinerarypage(driver);
 	}
 	public Bookingconfirmation invalidcreditdetails() {
 		WebElement verifycredit = driver.findElement(By.xpath("//label[@id='cc_num_span']"));
 		if(verifycredit.isDisplayed()) {
 			System.out.println("Please Enter your 16 Digit Credit Card Number");
 		}
 		return this;
 	}
 
 }