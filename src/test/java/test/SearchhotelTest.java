package test;
 
 import java.time.Duration;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
 import org.testng.annotations.Test;
 

 import page.BookHotelpage;
 import page.Bookingconfirmation;
 import page.Loginpage;
import page.PaymentHotelpage;
import page.Searchhotelpage;
import base.ProjectSpecificationMethod;
 
 public class SearchhotelTest extends ProjectSpecificationMethod {
 	
 	@BeforeTest
 	public void setup() {
 		    sheetname="HotelBookingData";
 		   testName="search hotel Test";
			testDescription="Testing the search hotel functionality and booking hotel with positive and negative cases";
			testAuthor="prarthana";
			testCategory="Smoke Testing";
 		    
 	}
 	
 	@Test(priority=1,dataProvider = "excelRead")
 	 public void searchHoteltest(String Username , String Password ,String Firstname,String Lastname,String Address) throws Exception {
 		Loginpage loginpage = new Loginpage(driver); 		

 		loginpage.Username(Username)
 		.Password(Password)
 		.Login();
 		Searchhotelpage Searchhotelpage = new Searchhotelpage(driver);
 		// Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

 		Searchhotelpage.searchLocation()
 		.searchHotel()

 		.Roomtype()
 		.NoOfrooms()
        .checkinDate()
 		.checkoutDate()
 		.adultperRoom()
 		.childperRoom()
        .Searchsubmit();

 		BookHotelpage BookHotelpage = new BookHotelpage(driver);
 		BookHotelpage.CheckBox01()
 		.Continue();
 		PaymentHotelpage objBookHotel2page = new PaymentHotelpage(driver);
 		objBookHotel2page.firstname(Firstname)
 		.lastname(Lastname)
 		.Address(Address)
 		.creditcardnumber()
 		.CVVnumber()
 		.cardtype()
 		.monthexpire()
 		.yearexpire()
 		.detailsubmit();
 		Bookingconfirmation objBookingconfirmationpage = new Bookingconfirmation(driver);
 		objBookingconfirmationpage.itinerarybutton();
 		}
 	@Test(priority=1,dataProvider = "excelRead")
	 public void searchHoteltestwithinvalid(String Username , String Password ,String Firstname,String Lastname,String Address) throws Exception {
		Loginpage loginpage = new Loginpage(driver); 		

		loginpage.Username(Username)
		.Password(Password)
		.Login();
		Searchhotelpage Searchhotelpage = new Searchhotelpage(driver);
		// Thread.sleep(5000);
       WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));

		Searchhotelpage.searchLocation()
		.searchHotel()

		.Roomtype()
		.NoOfrooms()
       .checkinDate()
		.checkoutDate()
		.adultperRoom()
		.childperRoom()
       .Searchsubmit();

		BookHotelpage BookHotelpage = new BookHotelpage(driver);
		BookHotelpage.CheckBox01()
		.Continue();
		PaymentHotelpage objBookHotel2page = new PaymentHotelpage(driver);
		objBookHotel2page.firstname(Firstname)
		.lastname(Lastname)
		.Address(Address)
		.invalidcreditcardnumber()
		.CVVnumber()
		.cardtype()
		.monthexpire()
		.yearexpire()
		.detailsubmit()
		.invalidcreditdetails();
	
		
		}

 
 }