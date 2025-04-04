package utils;
 
 import java.io.File;
import java.io.FileReader;
import java.io.IOException;
 import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.TakesScreenshot;

 import org.apache.commons.io.FileUtils;
 import org.apache.poi.xssf.usermodel.XSSFCell;
 import org.apache.poi.xssf.usermodel.XSSFRow;
 import org.apache.poi.xssf.usermodel.XSSFSheet;
 import org.apache.poi.xssf.usermodel.XSSFWorkbook;
 import org.openqa.selenium.OutputType;
 import org.openqa.selenium.WebDriver;
 import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
 
 public class Utility {
 	
 	public static WebDriver driver;
	public static Properties prop;
    public String sheetname;
    public static ExtentReports extent;
 	public static ExtentTest test;
 	public String testName, testDescription, testCategory, testAuthor;
	public String filepath;

 	
	
	public void launchingBrowser(String browser , String url) {
 		//driver = new ChromeDriver();
		if (browser.equalsIgnoreCase("Chrome")) {
	        driver = new ChromeDriver();
	    } else if (browser.equalsIgnoreCase("Firefox")) {
	        driver = new FirefoxDriver();
	    }
 		driver.get(url);
 		driver.manage().window().maximize();
 		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
 		}
 	public void closingbrowser() {
 		driver.close();
 	}
 public static String[][] DatafrmExcel(String sheetname) throws Exception {
 		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\Pradeep\\eclipse-workspace\\AdactinHotel\\src\\test\\resources\\AdactinTestData.xlsx");
 		XSSFSheet sheet = book.getSheet(sheetname);
 		int rowCount = sheet.getLastRowNum();
		System.out.println("Row count: "+rowCount);
 		int columnCount = sheet.getRow(0).getLastCellNum();
		System.out.println("Column count: "+columnCount);
 		String[][] data = new String[rowCount][columnCount];
 		for(int i =1 ; i <= rowCount; i++) {
 			XSSFRow row = sheet.getRow(i);
 			for(int j =0 ; j<columnCount; j++) {
 				XSSFCell cell = row.getCell(j);
 				data[i-1][j] = cell.getStringCellValue();
 			}
 		}
         book.close();
 		return data;
 	}
 
public static void readFromPropFile(String filepath) throws IOException {
		
		FileReader file = new FileReader(filepath);
		prop = new Properties();
		prop.load(file);
	}
	
 
 
 
 public static String screenshot(String name) throws IOException {
        String path = "C:\\Users\\Pradeep\\eclipse-workspace\\AdactinHotel\\screenshots\\" + name + ".png";
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File(path);
		FileUtils.copyFile(src, dest);
		return path;
	}
}
 	
 
 