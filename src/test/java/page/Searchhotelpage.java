package page;
 
 import org.openqa.selenium.By;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.WebElement;
 import org.openqa.selenium.support.ui.Select;
 import org.openqa.selenium.support.FindBy;
 import org.openqa.selenium.support.PageFactory;
 import org.testng.Assert;
 
import base.ProjectSpecificationMethod;
 
 public class Searchhotelpage extends ProjectSpecificationMethod  {
 	
 	@FindBy(id = "hotels")
 	WebElement Hotel;
 	@FindBy(id = "room_type")
 	WebElement Roomtype;
 	@FindBy(id = "room_nos")
 	WebElement RoomNo;
 	@FindBy(id = "adult_room")
 	WebElement AdultRoom;
 	@FindBy(id = "datepick_in")
 	WebElement Checkin;
 	@FindBy(id = "datepick_out")
 	WebElement Checkout;
    @FindBy(id = "Submit")
 	WebElement Search;
 	@FindBy(id = "child_room")
 	WebElement ChildRoom;
 	@FindBy(xpath = "//td[@class='welcome_menu']")
 	WebElement username;
 	@FindBy(xpath = "//a[text()='Logout']")
 	WebElement logout;
 	@FindBy(xpath = "//a[text()='Booked Itinerary']")
 	WebElement bookeditinerary;
 	@FindBy(xpath =" //a[normalize-space()='Change Password']")
 	WebElement changepassword;
 	@FindBy(id = "location")
 	WebElement Location;

 	public Searchhotelpage(WebDriver driver) {
 		this.driver = driver;
 		PageFactory.initElements(driver,this );
 	}
 	 
	 public Searchhotelpage searchLocation() {
		 Location.click();
		 Select location = new Select(Location);
		 location.selectByIndex(4);
		 return this;
	}
	 
	public Searchhotelpage searchHotel() {
		Hotel.click();
		Select search = new Select(Hotel);
		search.selectByValue("Hotel Creek");
		return this;
	}
	
	public Searchhotelpage Roomtype() {
		Roomtype.click();
		Select roomtype = new Select(Roomtype);
		roomtype.selectByIndex(1);
		return this;
	}
	
	public Searchhotelpage NoOfrooms() {
		RoomNo.click();
		Select room = new Select(RoomNo);
		room .selectByIndex(1);
		return this;
	}
	
	public Searchhotelpage adultperRoom() {
		AdultRoom.click();
		Select adultroom = new Select(AdultRoom);
		adultroom.selectByIndex(1);
		return this;
	}
	
	public Searchhotelpage childperRoom() {
		ChildRoom.click();
		Select childroom = new Select(ChildRoom);
		childroom.selectByIndex(1);
		return this;
	}
	
	public Searchhotelpage checkinDate() {
		Checkin.clear();
		Checkin.sendKeys("27/03/2025");
		return this;
	}
	
	public Searchhotelpage checkoutDate() {
		Checkout.clear();
		Checkout.sendKeys("30/03/2025");
		return this;
	}
	
	public BookHotelpage Searchsubmit() {
		Search.click();
		return new BookHotelpage(driver);
	}

 	public Bookitinerarypage bookiti() {
 		bookeditinerary.click();
 		return new Bookitinerarypage(driver);
 	}
 	
 	public Searchhotelpage verifyuser() {
 		WebElement welcomemessage = driver.findElement(By.xpath("//td[@class='welcome_menu']"));
 		Assert.assertTrue(welcomemessage.isDisplayed(),"The username is not displayed");
 		System.out.println("The Login is successfull");
 		return this;
 	}
 	public Changepasswordpage changepassword() {
 		 changepassword.click();
 		 return new Changepasswordpage(driver);
 	 }

 	public Logoutpage  Logout() {
 		logout.click();
 		return new Logoutpage(driver);
 	}
 	
 	
 }