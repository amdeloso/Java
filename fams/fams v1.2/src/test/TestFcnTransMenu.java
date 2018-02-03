package test;

import static org.junit.Assert.assertEquals;

//import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import functions.FcnDbConnect;


public class TestFcnTransMenu {
	FcnDbConnect mng1;
	
	@Before
	public void setUp() throws Exception {
		
		mng1 = new FcnDbConnect();
		//mng1.deleteTmpData("transfer");
		
	}
		
	//GET
	@Test
	public void testGetMaxIDIfNull()
	{
		//TRANSFER
		mng1.deleteTmpData("transfer");
		System.out.println(mng1.getMaxId(0, "transfer"));
		assertEquals(0, mng1.getCount("transfer"));
		
		//MAINTENANCE
		mng1.deleteTmpData("maintenance");
		System.out.println(mng1.getMaxId(0, "maintenance"));
		assertEquals(0, mng1.getCount("maintenance"));
	}
	
	@Test
	public void testGetTransNoIfNull()
	{
		//TRANSFER
		mng1.deleteTmpData("transfer");
		System.out.println(mng1.getTransNo("transfer", "", ""));
		assertEquals(0, mng1.getCount("transfer"));
		
		//MAINTENANCE
		mng1.deleteTmpData("maintenance");
		System.out.println(mng1.getTransNo("maintenance", "", ""));
		assertEquals(0, mng1.getCount("maintenance"));
	}
	
	@Test
	public void testGetCboId()
	{
		System.out.println( "idDept = " + mng1.getCboId("department", "CIT"));
		//assertEquals(1, 1);
		
		System.out.println( "idEmp = " + mng1.getCboId("employee", "Deloso, Annie"));
		//assertEquals(1, 1);
	}
	
//FIXED ASSET
	@Test
	public void testAddAssetInfoToDb(){
		mng1.deleteTmpData("fixedasset");	
		mng1.manageFixedAsset("fixedasset_tmp", 1, "add", "FA-1", mng1.getDateNow(), "Laptop", 1, 1, "Any", "ABC1234", "A1000", "0122345", "0987654", 3500, "intel core i7, 16gb", 1, 1, mng1.getDateNow(), "", 3, 1000, "2017-01-07", "2018-01-07", 1);
		
		assertEquals(1, mng1.getCount("fixedasset"));
	}
	
	@Test
	public void testEditExistAssetInfoToDb(){
		mng1.manageFixedAsset("fixedasset_tmp", 1, "edit", "FA-1", mng1.getDateNow(), "Server Local", 1, 1, "Any", "ABC1234", "A1000", "0122345", "0987654", 35000, "server specs", 1, 1, mng1.getDateNow(), "", 3, 10000, "2017-01-07", "2018-01-07", 1);
				
		
		assertEquals(1, mng1.getCount("fixedasset"));
	}
	
	@Test
	public void testDeleteExistAssetInfoToDb(){
		mng1.manageFixedAsset("fixedasset_tmp", 1, "delete", "FA-1", mng1.getDateNow(), "Server Local", 1, 1, "Any", "ABC1234", "A1000", "0122345", "0987654", 35000, "server specs", 1, 1, mng1.getDateNow(), "", 3, 10000, "2017-01-07", "2018-01-07", 1);
				
		
		assertEquals(0, mng1.getCount("fixedasset"));
	}
	
//RECEIVING
	@Test 
	public void testAddRcvngInfotoEmptyTbl(){
		mng1.deleteTmpData("receiving");
		mng1.manageTransactions("receiving", 1, "RCV-1", 1, "", "", "", "", 0, 0, 0, "");
		
		assertEquals(1, mng1.getCount("receiving"));
	}
	
	@Test
	public void testAddFullRcvngInfoToDb(){
		mng1.deleteTmpData("receiving");
		mng1.manageTransactions("receiving", 1, "RCV-1", 1, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("receiving", 2, "RCV-2", 2, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("receiving", 3, "RCV-3", 3, "", "", "", "", 0, 0, 0, "");
		
		assertEquals(3, mng1.getCount("receiving"));
	}
	
	@Test
	public void testRestrictAddExistRcvngInfoToDb(){
		mng1.deleteTmpData("receiving");
		mng1.manageTransactions("receiving", 1, "RCV-1", 1, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("receiving", 2, "RCV-2", 2, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("receiving", 3, "RCV-3", 3, "", "", "", "", 0, 0, 0, "");
		mng1.restrictDuplicateInfo("receiving", 3, "RCV-3", 3,"", "", "", "", 0, 0, 0, "");
		
		assertEquals(3, mng1.getCount("receiving"));
	}
	
	@Test
	public void testCancelRcvTrans()
	{
		mng1.manageFixedAsset("fixedasset_tmp", 0, "cancel", "", "", "", 0, 0, "", "", "", "", "", 0, "", 0, 0, "", "", 0, 0, "", "", 1);
		mng1.cancelTransactions("receiving", 1, "");
		mng1.cancelTransactions("transaction", 0, "RCV-1");
		
		assertEquals(0, mng1.getCount("receiving"));
		assertEquals(0, mng1.getCount("transaction"));
	}
	
	
	//TRANSFER
	@Test 
	public void testAddTransferInfotoEmptyTbl(){
		mng1.deleteTmpData("transfer");
		mng1.manageTransactions("transfer",1, "TX-1", 1, "", "", "", "", 0, 0, 0, "");
		
		assertEquals(1, mng1.getCount("transfer"));
	}
	
	@Test
	public void testAddLastTransferInfoToDb(){
		mng1.deleteTmpData("transfer");
		mng1.manageTransactions("transfer", 1, "TX-1", 1, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 2, "TX-2", 2, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 3, "TX-3", 3, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 4, "TX-4", 4, "", "", "", "", 0, 0, 0, "");
		
		assertEquals(4, mng1.getCount("transfer"));
	}
	
	
	@Test
	public void testAddFullTranferInfoToDb(){
		mng1.deleteTmpData("transfer");
		
		mng1.manageTransactions("transfer", 1, "TX-1", 1, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 2, "TX-2", 2, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 3, "TX-3", 3, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 4, "TX-4", 4, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 5, "TX-5", 5, "", "", "", "", 0, 0, 0, "");
		
		assertEquals(5, mng1.getCount("transfer"));
	}
	
	@Test
	public void testRestrictAddFullTransferInfoToDb(){
		mng1.deleteTmpData("transfer");
		mng1.manageTransactions("transfer", 1, "TX-1", 1, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 2, "TX-2", 2, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 3, "TX-3", 3, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 4, "TX-4", 4, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 5, "TX-5", 5, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 6, "TX-6", 6, "", "", "", "", 0, 0, 0, "");
		
		assertEquals(5, mng1.getCount("transfer"));
	}
	
	@Test
	public void testRestrictAddExistTransferInfoToDb(){
		mng1.deleteTmpData("transfer");
		mng1.manageTransactions("transfer", 1, "TX-1", 1, "", "", "", "", 0, 0, 0, "");
		mng1.manageTransactions("transfer", 2, "TX-2", 2, "", "", "", "", 0, 0, 0, "");	
		mng1.restrictDuplicateInfo("transfer", 2, "TX-2", 2,"", "", "", "", 0, 0, 0, "");
		
		assertEquals(2, mng1.getCount("transfer"));
	}
	
	@Test
	public void testCancelTransferTrans()
	{
		mng1.cancelTransactions("transfer", 2, "TX-2");
		mng1.cancelTransactions("transaction", 2, "TX-2");
		
		assertEquals(0, mng1.getCount("transfer"));
		assertEquals(0, mng1.getCount("transaction"));
	}
	
	//MAINTENANCE
	@Test 
	public void testAddMntnInfotoEmptyTbl(){
		mng1.deleteTmpData("maintenance");
		mng1.manageTransactions("maintenance", 1, "MX-1", 1, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		
		assertEquals(1, mng1.getCount("maintenance"));
	}

	@Test
	public void testAddLastMntnInfoToDb(){
		mng1.deleteTmpData("maintenance");
		mng1.manageTransactions("maintenance", 1, "MX-1", 1, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		mng1.manageTransactions("maintenance", 2, "MX-2", 2, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		
		assertEquals(2, mng1.getCount("maintenance"));
	}
	
	@Test
	public void testAddFullMntnInfoToDb(){
		mng1.deleteTmpData("maintenance");
		
		mng1.manageTransactions("maintenance", 1, "MX-1", 1, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		mng1.manageTransactions("maintenance", 2, "MX-2", 2, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		mng1.manageTransactions("maintenance", 3, "MX-3", 3, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		
		assertEquals(3, mng1.getCount("maintenance"));
	}
	
	@Test
	public void testRestrictAddFullMntnInfoToDb(){
		mng1.deleteTmpData("maintenance");
		mng1.manageTransactions("maintenance", 1, "MX-1", 1, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		mng1.manageTransactions("maintenance", 2, "MX-2", 2, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		mng1.manageTransactions("maintenance", 3, "MX-3", 3, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		
		assertEquals(2, mng1.getCount("maintenance"));
	}
	
	@Test
	public void testRestrictAddExistMntnInfoToDb(){
		mng1.deleteTmpData("maintenance");
		mng1.manageTransactions("maintenance", 1, "MX-1", 1, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		mng1.manageTransactions("maintenance", 2, "MX-2", 2, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		mng1.restrictDuplicateInfo("maintenance", 2, "MX-2", 2, "2017-01-01", "2017-01-10", "fix product", "on-progress", 1, 2, 1, "on-going");
		
		assertEquals(2, mng1.getCount("maintenance"));
	}
	
	public void testCancelMntnTrans()
	{
		mng1.cancelTransactions("maintenance", 1, "MX-2");
		mng1.cancelTransactions("transaction", 2, "MX-2");
		
		assertEquals(0, mng1.getCount("maitenance"));
		assertEquals(0, mng1.getCount("transaction"));
	}
	
	//PULLOUT
	@Test 
	public void testAddPoInfotoEmptyTbl(){
		mng1.deleteTmpData("pullout");
		mng1.manageTransactions("pullout", 1, "PO-1", 1, "", "", "", "disposed", 0, 0, 0, "disposed");
		
		assertEquals(1, mng1.getCount("pullout"));
	}
	
	@Test
	public void testAddLastPoInfoToDb(){
		mng1.deleteTmpData("pullout");
		mng1.manageTransactions("pullout", 1, "PO-1", 1, "", "", "", "disposed", 0, 0, 0, "disposed");
		mng1.manageTransactions("pullout", 2, "PO-2", 2, "", "", "", "disposed", 0, 0, 0, "disposed");
		mng1.manageTransactions("pullout", 3, "PO-3", 3, "", "", "", "disposed", 0, 0, 0, "disposed");
			
		assertEquals(3, mng1.getCount("pullout"));
	}
	
	@Test
	public void testAddFullPoInfoToDb(){
		mng1.deleteTmpData("pullout");
		mng1.manageTransactions("pullout", 1, "PO-1", 1, "", "", "", "disposed", 0, 0, 0, "disposed");
		mng1.manageTransactions("pullout", 2, "PO-2", 2, "", "", "", "sold", 0, 0, 0, "disposed");
		
		assertEquals(2, mng1.getCount("pullout"));
	}
	
	@Test
	public void testRestrictAddFullPoInfoToDb(){
		mng1.deleteTmpData("pullout");
		mng1.manageTransactions("pullout", 1, "PO-1", 1, "", "", "", "disposed", 0, 0, 0, "disposed fixed asset");
		mng1.manageTransactions("pullout", 2, "PO-2", 2, "", "", "", "sold", 0, 0, 0, "sold fixed asset");
		mng1.manageTransactions("pullout", 3, "PO-3", 3, "", "", "", "sold", 0, 0, 0, "sold fixed asset");
		
		assertEquals(2, mng1.getCount("pullout"));
	}
	
	@Test
	public void testRestrictAddExistPoInfoToDb(){
		mng1.deleteTmpData("pullout");
		mng1.manageTransactions("pullout", 1, "PO-1", 1, "", "", "", "disposed", 0, 0, 0, "disposed fixed asset");
		mng1.manageTransactions("pullout", 2, "PO-2", 2, "", "", "", "sold", 0, 0, 0, "sold fixed asset");
		mng1.restrictDuplicateInfo("pullout", 2, "PO-2", 2, "", "", "", "sold", 0, 0, 0, "sold fixed asset");

		assertEquals(2, mng1.getCount("pullout"));
	}
	
	@Test
	public void testCancelPoTrans()
	{
		mng1.cancelTransactions("pullout", 1, "PO-1");
		mng1.cancelTransactions("transaction", 1, "PO-1");
		
		assertEquals(0, mng1.getCount("pullout"));
		assertEquals(0, mng1.getCount("transaction"));
	}

}
