package page;
 
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.PageFactory;
 
import base.ProjectSpecificationMethod;
 
 public class Loginpage extends ProjectSpecificationMethod{
 	
 	@FindBy(id ="username")
 	WebElement Username;
 	@FindBy(id = "password")
 	WebElement Password;
 	@FindBy(id="login")
 	WebElement Login;
 	@FindBy(xpath = "//a[text()='New User Register Here']")
 	WebElement Newuser;
 	
 	
 	
 	public Loginpage(WebDriver driver) {
 		this.driver = driver;
 		PageFactory.initElements(driver,this );
 	}
 	public Loginpage Username(String username) {
 		Username.sendKeys(username);
 		return this;
 	}
 	public Loginpage Password(String password) {
 		Password.sendKeys(password);
 		System.out.println("Password used for login: " + password);

 		return this;
 	}
 	public Searchhotelpage Login() throws Exception {
 		Login.click();
 	    return new Searchhotelpage(driver);
 	}

 	public Loginpage verifycredentials() {
 		WebElement verifycreds = driver.findElement(By.xpath("//div[@class='auth_error']"));
 		

 		if(verifycreds.isDisplayed()) {
 			System.out.println("The login is failed");
 		}else {
 			System.out.println("The login is success");
 		}
 		return this;
 	}
 
 	public Loginpage verifyloginpage() {
 		WebElement verifylogintitle = driver.findElement(By.id("username_show"));
 		if(verifylogintitle.isDisplayed()) {
 			System.out.println("The logut is passed");
 		}else {
 			System.out.println("The logut is failed");
 		}
 		return this;
 		}
 
 }