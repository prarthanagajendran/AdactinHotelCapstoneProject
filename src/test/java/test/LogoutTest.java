package test;
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;
 
 import page.Bookitinerarypage;
 import page.Loginpage;
 import page.Logoutpage;
 
 import page.Searchhotelpage;
import base.ProjectSpecificationMethod;
 
 public class LogoutTest extends ProjectSpecificationMethod{
 	
 	@BeforeTest
 	public void setup() {
 		    sheetname="LoginData";
 		   testName="Logout Test";
			testDescription="Testing the logout functionality with positive and negative cases";
			testAuthor="prarthana";
			testCategory="Smoke Testing";
 	}
 	
 	@Test(dataProvider = "excelRead")
 	public void Logout01(String Username , String Password ,String Invalidusername,String Invalidpassword) throws Exception {
 		Loginpage objloginpage = new Loginpage(driver);
 		objloginpage.Username(Username)
 		.Password(Password)
 		.Login();
 		Thread.sleep(4000);
 		Searchhotelpage objSearchhotelpage = new Searchhotelpage(driver);
 		objSearchhotelpage.Logout();
 		//Logoutpage objLogoutSuccesspage = new Logoutpage(driver);
 		//objLogoutSuccesspage.logout();
 		//objloginpage.verifyloginpage();
 		
 	}
 
 
 }