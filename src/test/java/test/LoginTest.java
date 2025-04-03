package test;
 
 import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;
 

import base.ProjectSpecificationMethod;
import page.Loginpage;
import page.Searchhotelpage;
 
 public class LoginTest extends ProjectSpecificationMethod {
 	
 	@BeforeTest
 	public void setup() {
 		    sheetname="LoginData";
 		   testName="Login Test";
 			testDescription="Testing the login functionality with positive and negative cases";
 			testAuthor="prarthana";
 			testCategory="Smoke Testing";
 	}
 	
 	@Test(priority = 1,dataProvider = "excelRead")
 	public void Logintest(String Username , String Password ,String Invalidusername,String Invalidpassword) throws Exception {
 		Loginpage loginpage = new Loginpage(driver);
 		loginpage.Username(Username)
 		.Password(Password)
 		.Login();
 		Searchhotelpage objSearchhotelpage = new Searchhotelpage(driver);
 		objSearchhotelpage.verifyuser();
 	}
 	
 	@Test(priority = 2,dataProvider = "excelRead")
 	public void InvalidLoginTest(String Username , String Password ,String Invalidusername,String Invalidpassword) throws Exception {
 		Loginpage loginpage = new Loginpage(driver);
 	    loginpage.Username(Invalidusername)
 		.Password(Invalidpassword)
 		.Login();
 		Loginpage loginpage1 = new Loginpage(driver);
 		loginpage1.verifycredentials();
        //Assert.assertTrue(driver.getCurrentUrl().contains("https://adactinhotelapp.com/HotelAppBuild2/index.php"));
 		 
 	
 	}
 	
 
 }