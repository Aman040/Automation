package TestNG;

import org.testng.annotations.Test;

public class DataProvider {
	@Test(dataProvider = "data-provider")
	public void test(int a,int b) {
		int result=a+b;
		System.out.println(result);
	}
	@org.testng.annotations.DataProvider(name="data-provider")
	public Object[][] dpMethod(){
		return new Object[][] {{2,3},{4,5}};
	}
}
