package test;
 
 import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;
 
 import page.Bookitinerarypage;
 import page.Loginpage;
 import page.Searchhotelpage;
import base.ProjectSpecificationMethod;
 
 public class BookitineraryTest extends ProjectSpecificationMethod {
 	@BeforeTest
 	public void setup() {
 		   sheetname="LoginData";
 		   testName="Bookitinerary Test";
			testDescription="Testing the Bookitinerary functionality with positive and negative cases";
			testAuthor="prarthana";
			testCategory="Smoke Testing";
 	}
 	
 	@Test(priority = 1, dataProvider = "excelRead")
 	
 	public void Bookeditenerary(String Username, String Password ,String Invalidusername,String Invalidpassword) throws Exception {
 		Loginpage objloginpage = new Loginpage(driver);
 		objloginpage.Username(Username)
 		.Password(Password)
 		.Login();
 		Searchhotelpage objSearchhotelpage = new Searchhotelpage(driver);
 		objSearchhotelpage.bookiti();
 		Bookitinerarypage objBookeditenerarypage = new Bookitinerarypage(driver);
 		objBookeditenerarypage.searchorder()
 		.VerifySearchOrder();
 	}
 	@Test(priority = 2, dataProvider = "excelRead")
 	public void Bookeditenerary1(String Username, String Password ,String Invalidusername,String Invalidpassword) throws Exception {
 		Loginpage objloginpage = new Loginpage(driver);
 		objloginpage.Username(Username)
 		.Password(Password)
 		.Login();
 		Searchhotelpage objSearchhotelpage = new Searchhotelpage(driver);
 		objSearchhotelpage.bookiti();
 		Bookitinerarypage objBookeditenerarypage = new Bookitinerarypage(driver);
 		objBookeditenerarypage.Deleteorder()
 		.VerifySearchOrder();
 	}
 
 }