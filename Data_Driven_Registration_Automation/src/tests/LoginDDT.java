package tests;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	WebDriver driver;
	
	@Test(dataProvider="getData")
	public void loginTest(String name, String email, String password) {
		//System.out.println("NEW RECORD: " + name + " " + email + " " + password);
		//Interact with login elements
		driver.findElement(By.name("ctl00$MainContent$txtUserName")).sendKeys(email); 
		driver.findElement(By.name("ctl00$MainContent$txtPassword")).sendKeys(password); 
	    driver.findElement(By.name("ctl00$MainContent$btnLogin")).click();
	    
	  //Get Confirmation
		
		 String conf = driver.findElement(By.id("conf_message")).getText();
		 System.out.println("CONFIRMATION :" +conf);

		
	}
	
	@Before
    public void setUp() {
    	driver = utilities.DriverFactory.open("Firefox");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");	
    }
    
    @After
    public void tearDown() {
    	driver.quit();
    }
	
	@DataProvider
	public String[][] getData(){
		return utilities.Excel.get("C:\\Users\\shaswata\\Downloads\\New folder\\Data_Driven Framework_1\\UserLogin.xls");
	}

}
