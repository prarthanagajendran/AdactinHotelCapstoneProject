package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.ProjectSpecificationMethod;

public class PaymentHotelpage extends ProjectSpecificationMethod {

	@FindBy(id = "first_name")
	WebElement Firstname1;
	@FindBy(id = "last_name")
	WebElement Lastname1;
	@FindBy(id = "address")
	WebElement Address1;
	@FindBy(id = "cc_num")
	WebElement creditcard;
	@FindBy(id = "cc_type")
	WebElement creditcardtype;
	@FindBy(id = "cc_exp_month")
	WebElement ExpireMonth;
	@FindBy(id = "cc_exp_year")
	WebElement Expireyear;
	@FindBy(id = "cc_cvv")
	WebElement cvv;
	@FindBy(id = "book_now")
	WebElement Booknow;

	public PaymentHotelpage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public PaymentHotelpage firstname(String Firstname) {
		Firstname1.sendKeys(Firstname);
		return this;
	}

	public PaymentHotelpage lastname(String Lastname) {
		Lastname1.sendKeys(Lastname);
		return this;
	}

	public PaymentHotelpage Address(String Address) {
		Address1.sendKeys(Address);
		return this;
	}

	public PaymentHotelpage creditcardnumber() {
		creditcard.sendKeys("1234123412341234");
		return this;
	}

	public PaymentHotelpage invalidcreditcardnumber() {
		creditcard.sendKeys("123412341234");
		return this;
	}

	public PaymentHotelpage CVVnumber() {
		cvv.sendKeys("1234");
		return this;
	}

	public PaymentHotelpage cardtype() {
		creditcardtype.click();
		Select ctype = new Select(creditcardtype);
		ctype.selectByIndex(2);
		return this;
	}

	public PaymentHotelpage monthexpire() {
		ExpireMonth.click();
		Select cardmonth = new Select(ExpireMonth);
		cardmonth.selectByIndex(2);
		return this;
	}

	public PaymentHotelpage yearexpire() {
		Expireyear.click();
		Select cardyear = new Select(Expireyear);
		cardyear.selectByValue("2027");
		return this;
	}

	public Bookingconfirmation detailsubmit() {
		Booknow.click();
		return new Bookingconfirmation(driver);
	}

}