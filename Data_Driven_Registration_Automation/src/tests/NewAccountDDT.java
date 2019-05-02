package tests;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value=Parameterized.class)
public class NewAccountDDT {
	String name;
	String email;
	String phone;
	
	
	@Test
	public void newAccounTest() {
		
	}
	
	@Parameters
	public static List<String[]> getData(){
		return utilities.CSV.get("C:\\Users\\shaswata\\Downloads\\New folder\\Data_Driven Framework_1\\UserAccounts.csv");
		
	}
	
	//Constructor that passes parameters to the test method
	public NewAccountDDT(String name , String email, String phone, String gender, String password, String country, String WeeklyEmail, String monthlyEmail, String occasionalEmail) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

}
