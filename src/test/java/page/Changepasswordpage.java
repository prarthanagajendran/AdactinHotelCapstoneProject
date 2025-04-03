package page;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethod;


public class Changepasswordpage extends ProjectSpecificationMethod {
	
	@FindBy(id = "current_pass")
	WebElement currentpassword;
	
	@FindBy(id = "new_password")
	WebElement newpassword;
	
	@FindBy(id = "re_password")
	WebElement confirmnewpassword;
	
	@FindBy(id = "Submit")
	WebElement submitpassword;
	
	@FindBy(xpath = "//span[text()='Your Password is successfully updated!!!']")
	WebElement passwordchangedsuccess;
	
	
	@FindBy(xpath = "//span[@id='re_pass_span']")
	WebElement passwordnotchanged;


	public Changepasswordpage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver,this );
	}
	
	public Changepasswordpage currentpassword(String Currentpass) {
		currentpassword.sendKeys(Currentpass);
		return this;
	}
	
	public Changepasswordpage  newpassword(String newpass) {
		newpassword.sendKeys(newpass);
		return this;
	}
	
	public Changepasswordpage confrmnewpassword(String confirmpass) {
		confirmnewpassword.sendKeys(confirmpass);
		return this;
		
	}
	
	public Changepasswordpage passchangeVerify() {
		System.out.println(passwordchangedsuccess.getText());
		return this;
	}
public Changepasswordpage passchangeverifyforerror() {
	System.out.println(passwordnotchanged.getText());
		return this;
	}
	
	
	public Changepasswordpage SubmitPassword() {
		submitpassword.click();
		return this;
	}
	
	
//span[@id='re_pass_span']

}