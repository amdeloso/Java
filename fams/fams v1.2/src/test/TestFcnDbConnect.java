package test;

import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import functions.FcnDbConnect;

public class TestFcnDbConnect {
	FcnDbConnect mng1;
	int result = 0;
	
	@Before
	public void connectDb(){
		
		mng1 = new FcnDbConnect();
		mng1.getDateNow();
		mng1.getHostInfo();
		System.out.println("Connected");
	}

	@Test
	public void loginTest() {
		
		mng1.loginUser("amd", "passamd");
		//assertEquals
	}
		
	@Test
	public void addLogInfoTest(){
		
		//mng1.addTransLogInfo(mng1.idEmp, mng1.ipAdd, mng1.pcName, "LOGIN", 0, "INSERT","NEW","Login");
		
	}
	
	@Test
	public void getIDs() 
	{
		/*mng1.getMaxId(0, "department");
		result =mng1.maxID;
		assertEquals(result, 0);*/
	}
	
	@Test
	public void AddMngData()
	{
		/*mng1.manageData(mng1.getMaxId(0, "employee"), "", "employee", "add", "s", "s", "s", "s", "s", "s", 1, 1);
		assertEquals(1, mng1.getCount("employee"));*/
	}
	
	@Test
	public void AddSupplier()
	{
		/*mng1.manageData(mng1.getMaxId(0, "supplier"), "XYZ", "supplier", "add", "", "", "", "xyz@gmail.com", "025200", "Auckland", 0, 0);
		assertEquals(2, mng1.getCount("supplier"));*/
	}
	
	@Test
	public void EditSupplier()
	{
		/*mng1.manageData(3, "Fujitsu", "supplier", "edit", "", "", "", "fujitso@gmail.com", "025200", "Auckland", 0, 0);
		assertEquals(3, mng1.getCount("supplier"));*/
	}
	
	@Test
	public void getRcvNo(){
		mng1.getTransNo("receiving", "0", "");
		mng1.getTransNo("assetCode", "0", "");
		assertEquals(1, 1);
	}


	
}
