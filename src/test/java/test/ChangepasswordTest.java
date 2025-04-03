package test;
 
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;
 
 import page.Changepasswordpage;
 import page.Loginpage;
 import page.Searchhotelpage;
import base.ProjectSpecificationMethod;
 
 public class ChangepasswordTest extends ProjectSpecificationMethod{
 	
 	@BeforeTest
 	public void setup() {
 		    sheetname="Passwordchange";
 		   testName="Changepassword Test";
			testDescription="Testing the change password functionality with positive and negative cases";
			testAuthor="prarthana";
			testCategory="Smoke Testing";
 	}
 	
 	@Test(priority = 1,dataProvider = "excelRead")
 	public void changepasswordvalid(String pass1 , String pass2 , String pass3 , String pass4 , String Username , String Password) throws Exception {
 		
 		Loginpage loginpage = new Loginpage(driver); 		

 		loginpage.Username(Username)
 		.Password(Password)
 		.Login();
 		Searchhotelpage objSearchhotelpage = new Searchhotelpage(driver);
 		objSearchhotelpage.changepassword();
 		Changepasswordpage objChangepasswordpage = new Changepasswordpage(driver);
 		objChangepasswordpage.currentpassword(Password)
 		.newpassword(pass1)
 		.confrmnewpassword(pass2)
 		.SubmitPassword();
 		Changepasswordpage objChangepassword = new Changepasswordpage(driver);
 		objChangepassword.passchangeVerify();
 		} 
 	
 	@Test(priority = 2,dataProvider = "excelRead")
 	public void changepasswordinvalid(String pass1 , String pass2 , String pass3 , String pass4 , String Username , String Password) throws Exception{
 		Loginpage objloginpage1 = new Loginpage(driver);
 		objloginpage1.Username(Username)
 		.Password(pass2)
 		.Login();
 		Searchhotelpage objSearchhotelpage = new Searchhotelpage(driver);
 		objSearchhotelpage.changepassword();
 		Changepasswordpage objChangepasswordpage = new Changepasswordpage(driver);
 		objChangepasswordpage.currentpassword(pass2)
 		.newpassword(pass3)
 		.confrmnewpassword(pass4)
 		.SubmitPassword();
 		Changepasswordpage objChangepassword= new Changepasswordpage(driver);
 		objChangepassword.passchangeverifyforerror();
 	}
 
 }