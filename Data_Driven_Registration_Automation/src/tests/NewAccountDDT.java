package tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.junit.Assert;

@RunWith(value=Parameterized.class)
public class NewAccountDDT {
	String name;
	String email;
	String phone;
	String gender;
	String password;
	String country;
	boolean weeklyEmail;
	boolean monthlyEmail;
	boolean occasionalEmail;
	
	//This is the test method
	@Test
	public void newAccounTest() {
		System.out.println("NEW RECORD: " + name + " " + email + " " + phone + " " + gender + " " + password + " " + country + " " + weeklyEmail + " " + monthlyEmail + " " + occasionalEmail);
		if (phone.equals ("agggggss")) {
			Assert.fail();
		}
		// 1. Create WebDriver
		WebDriver driver = utilities.DriverFactory.open("chrome");
		driver.get("http://sdettraining.com/trguitransactions/AccountManagement.aspx");
		driver.findElement(By.xpath("html/body/form/div[3]/div[2]/div/div[2]/a")).click();		
				
						

						
		// Define Web Elements
		
		WebElement nameElement = driver.findElement(By.id("MainContent_txtFirstName")); 
		WebElement emailElement = driver.findElement(By.id("MainContent_txtEmail")); 
		WebElement phoneElement = driver.findElement(By.id("MainContent_txtHomePhone")); 
		WebElement passwordElement = driver.findElement(By.id("MainContent_txtPassword")); 
		WebElement verifyPasswordElement = driver.findElement(By.id("MainContent_txtVerifyPassword")); 
		WebElement countryElement = driver.findElement(By.id("MainContent_menuCountry")); 
		WebElement maleRadio = driver.findElement(By.id("MainContent_Male")); 
		WebElement femaleRadio = driver.findElement(By.id("MainContent_Female")); 
		WebElement weeklyCheckbox = driver.findElement(By.id("MainContent_checkWeeklyEmail")); 	 
		WebElement submitButton = driver.findElement(By.id("MainContent_btnSubmit")); 
	 
						
						
		//3. Fill out the form
		nameElement.sendKeys(name);
		emailElement.sendKeys(email);
		phoneElement.sendKeys(phone);
		passwordElement.sendKeys(password);
		verifyPasswordElement.sendKeys(password);
		new Select(countryElement).selectByVisibleText(country);
		
		//Gender Radio Button Algorithm
		if (gender.equalsIgnoreCase("Male")) {maleRadio.click();}
		else {femaleRadio.click();}
		
	    //checkbox algorithm
	    if (weeklyEmail) {
	    	if (!weeklyCheckbox.isSelected()) {weeklyCheckbox.click();}
	    }
	    else {
	    	if (weeklyCheckbox.isSelected()) {weeklyCheckbox.click();}
	    }
	   // if (monthlyEmail) {
	   // 	if (!monthlyCheckbox.isSelected()) {monthlyCheckbox.click()}
	   // }
	   //else {
	   //	if (monthyCheckbox.isSelected()) {monthlyCheckbox.click()}
	   // }
	   // if (occasionalEmail) {
	   // 	if (!occasionalCheckbox.isSelected()) {occasionalCheckbox.click()}
	   // }
	   //else {
	   //  	if (occasionalCheckbox.isSelected()) {occasionalCheckbox.click()}
	   // }
		
		driver.findElement(By.name("ctl00$MainContent$checkWeeklyEmail")).click();
						
	    //submit
	    submitButton.click();


						


						
	   //4. Get Confirmation
						
	   String conf = driver.findElement(By.id("MainContent_lblTransactionResult")).getText();
	   System.out.println("CONFIRMATION :" +conf);
						
	   //5. Close the browser
	   driver.close();	
		
		
	}
	//This annotated method is designed to pass parameters into the class via constructor 
	@Parameters
	public static List<String[]> getData(){
		return utilities.CSV.get("C:\\Users\\shaswata\\Downloads\\New folder\\Data_Driven Framework_1\\UserAccounts.csv");
		
	}
	
	//Constructor that passes parameters to the test method
	public NewAccountDDT(String name , String email, String phone, String gender, String password, String country, String weeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.password = password;
		this.country = country;
		if (weeklyEmail.equals("TRUE")){
			this.weeklyEmail = true;
		}
		else { 
			this.weeklyEmail = false;
				}
		if (monthlyEmail.equals("TRUE")){
			this.monthlyEmail = true;
		}
		else { 
			this.monthlyEmail = false;
				}
		if (occasionalEmail.equals("TRUE")){
			this.occasionalEmail = true;
		}
		else { 
			this.occasionalEmail = false;
				}
	}

}
