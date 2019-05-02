package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginDDT {
	
	@Test(dataProvider="getData")
	public void loginTest(String name, String email, String password) {
		//System.out.println("NEW RECORD: " + name + " " + email + " " + password);
		
	}
	
	@DataProvider
	public String[][] getData(){
		return utilities.Excel.get("C:\\Users\\shaswata\\Downloads\\New folder\\Data_Driven Framework_1\\UserLogin.xls");
	}

}
