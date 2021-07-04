package Practice.Appiumramework;

import org.testng.annotations.DataProvider;

public class TestData {
	
	
	@DataProvider(name="InputData")
	public void getData() {
		Object[][] obj=new Object[][]
				{
			{"Hello"},{"!@#$%^&*"}
				};
				
		
				
				
	}

}
