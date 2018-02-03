package test;

//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.*;
import org.junit.Before;
//import org.junit.Test;
import functions.FcnDbConnect;
import functions.FcnManageMenu;


public class TestFcnManageMenu {
	FcnDbConnect mng1;
	FcnManageMenu mng2;
	int result = 0;
	
	@Before
	public void connectDb(){
		
		mng1 = new FcnDbConnect();
		mng2 = new FcnManageMenu();
		
	}
	

}
