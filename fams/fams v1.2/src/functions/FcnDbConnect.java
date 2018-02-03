package functions;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.*;
import java.text.DecimalFormat;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import frames.Department;
import frames.MainFrame;
import frames.MainMenu;

public class FcnDbConnect {
	
	public Connection con;
	public Statement st;
	public PreparedStatement pst;
	public ResultSetMetaData rsmt;
	public ResultSet rs; 
	public String sql;
	
	//Forms
	JFrame frmLogin;
	MainFrame frmMainFrame;
	MainMenu frameMainMenu;
	Department frmDept;
	
	//Login
	public Date dateNow, dateTime, yearNow;
	public String dateString;
	public String ipAdd=null;
	public String pcName=null;
	public int code, usrCnt, transNo, idEmpLog, idEmp;
	public String result;
	public DecimalFormat df = new DecimalFormat("0.00##");
	
	//Frames
	public int maxID, i, id, idfa, idClass, idSupplier, idDept, idBrand, idPosn, idCbo, assetLife;
	public String trans, assetStatus, item, fName, midInit, lName, gender, email, contact, address;
	public String status, asset, faCode, product, model, brand, classification, manufacturer, license, serialNo, barcode, description, supplier, location, datePurchase, dateWarranty;
	public double cost, salvageVal, depVal;
	public FcnDbConnect() {
		super();
				
		//start connect to database
		//Initialize
		
		String hostName = "jdbc:mysql://localhost:3306/dbfams";
		String hostUser = "root";
		String hostPass="";
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(hostName,hostUser,hostPass);
			st = con.createStatement();
			System.out.println("Connected to dbfams.");
		}catch(Exception e){
			
			e.printStackTrace();
		}finally
		{
			try {
				st.close();
			} catch (Exception e) {
				System.out.println("Final catch FcnDbConnect() " + e);
			}
			
		}
		
	}//end DbManager()
	  
	
	public void loginUser(String username, String password){
		frmMainFrame = new MainFrame();
		
		//start try
		  try {
			st = con.createStatement();
			rs = st.executeQuery("SELECT * FROM user WHERE username='" + username +"' AND password='"+ password +"'" );
		
			//improve this code
			usrCnt = 0;
			while(rs.next()){										
				usrCnt = usrCnt + 1;
				
				//successful login 
				if(username.equals(rs.getString("username")) && password.equals(rs.getString("password"))) {	
					  idEmpLog = rs.getInt("idEmp");
					  System.out.println("ID: " + idEmpLog);
					  JOptionPane.showMessageDialog(null, "Succcess in login. ");
					  
					  //go to main window
					  //MainFrame window = new MainFrame();
					  MainMenu window = new MainMenu();
			          window.frameMainMenu.setVisible(true);
			          window.txtIdEmp.setText(Integer.toString(idEmpLog));
				}
				
							
			}//end while
			
			//unsuccessful login
			if(usrCnt == 0) {
				JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again. ");
			}
			
			System.out.println(usrCnt);
			
		 }catch (Exception e) {
			
			e.printStackTrace();
			
		 }finally
		  {
				try {
					st.close();
				} catch (Exception e) {
					System.out.println("Final catch loginUser() " + e);
				}
				
		  }//end try catch
		
	}//end loginUser
	
	public String getDateNow(){
		
		 try 
		 {
			st = con.createStatement(); 
			rs = st.executeQuery("SELECT DATE_FORMAT(NOW(),'%Y-%m-%d') As dateNow, NOW() As dateTime");	
			while(rs.next()){										
				dateNow =rs.getDate("dateNow");	
				dateTime =rs.getDate("dateTime");	
				//yearNow = rs.getDate(columnLabel)
				
				
			}//end while
			
			//convert Types: Date to String
			dateString = (dateNow).toString();
			//yearInt = Integer.parseInt((yearNow).toString());
			
			System.out.println("Date Now: " + dateString + "");
		 }catch (Exception e) {
			e.printStackTrace();
		 }finally
		  {
				try {
					st.close();
				} catch (SQLException e) {
					System.out.println("Final catch getDateNow() " + e);
				}
				
		  }//end try catch
		  
		 return dateNow.toString(); 
		  
	}//end getDateNow
		
		
	public void getHostInfo(){
		
		try {
			ipAdd = InetAddress.getLocalHost().getHostAddress();
			pcName = InetAddress.getLocalHost().getHostName();
			System.out.println(ipAdd + " " + pcName);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}//end getHostInfo

		
	public void addTransLogInfo(int idUser, String ipAdd, String pcName, String trans, int transNo, String transFcn, String status, String function){
		try 
		{
			if(function == "Login")
			{
				sql = "INSERT INTO `dbfams`.`logs` (`idUser`, `dateLog`, `ipAdd`, `pcName`, `trans`, `transFcn`, `status`) " 
						+ "VALUES ('"+ idUser +"',  '"+ getDateNow() +"', '"+ ipAdd +"', '"+ pcName +"', '"+ trans +"',"
						+ " '"+ transFcn +"', '"+ status +"')";
			}else
			{
				sql = "INSERT INTO `dbfams`.`logs` (`idUser`, `dateLog`, `ipAdd`, `pcName`, `trans`, `transNo`, `transFcn`, `status`) " 
						+ "VALUES ('"+ idUser +"',  '"+ getDateNow() +"', '"+ ipAdd +"', '"+ pcName +"', '"+ trans +"',"
						+ " '"+ transNo +"', '"+ transFcn +"', '"+ status +"')";
			}	
			
				try {
					st = con.createStatement();
					st.executeUpdate(sql);
				} catch (SQLException e) {
					e.printStackTrace();
				}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}finally
		  {
			try 
			{
				st.close();
			} catch (SQLException e) {
				System.out.println("Final catch addTransLogInfo()  + e");
			}
				
		  }//end final try catch
		
	}// end addLogInfo
	
	public int getCount(String transaction){
		int count = 0;
		
		try{
			st = con.createStatement();
			if(transaction == "employee")
			{
				rs = st.executeQuery("SELECT * FROM employee");
			}
			else if(transaction == "supplier")
			{
				rs = st.executeQuery("SELECT * FROM supplier");
			}
			else if(transaction == "fixedasset")
			{
				rs = st.executeQuery("SELECT * FROM fixedasset_tmp");
			}
			else if(transaction == "receiving")
			{
				rs = st.executeQuery("SELECT * FROM receiving");
			}
			else if(transaction == "transfer")
			{
				rs = st.executeQuery("SELECT * FROM transfer");
			}
			else if(transaction == "maintenance")
			{
				rs = st.executeQuery("SELECT * FROM maintenance");
			}
			else if(transaction == "pullout")
			{
				rs = st.executeQuery("SELECT * FROM pullout");
			}
			else
			{
				System.out.println("No transaction.");
			}
			while (rs.next()) {
			    ++count;
			    // Get data from the current row and use it
			    System.out.println("Count: " + count);
			}
			
			
		}catch(Exception e){
			
			e.printStackTrace();
		}
		
		
		return count;
		
	}//end getCount()
	
	public int getMaxId(int maxIds, String transaction){
		try{
			
			st = con.createStatement();
			if(transaction == "department")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idDept),0) + 1 As maxId FROM department");
			}
			else if(transaction == "brand")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idBrand),0) + 1 As maxId FROM brand");
			}
			else if(transaction == "position")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idPosn),0) + 1 As maxId FROM position");
			}
			else if(transaction == "employee")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idEmp),0) + 1 As maxId FROM employee");
			}
			else if(transaction == "supplier")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idSupplier),0) + 1 As maxId FROM supplier");
			}
			else if(transaction == "fixedAsset")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idfa),0) + 1 As maxId FROM fixedasset_tmp");
			}
			else if(transaction == "receiving")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idRcv),0) + 1 As maxId FROM receiving");
			}
			else if(transaction == "transaction")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idTrnsctn),0) + 1 As maxId FROM transaction");
			}
			else if(transaction == "transfer")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idTrans),0) + 1 As maxId FROM transfer");
			}
			else if(transaction == "maintenance")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idMntn),0) + 1 As maxId FROM maintenance");
			}
			else if(transaction == "pullout")
			{
				rs = st.executeQuery("SELECT IFNULL(MAX(idPo),0) + 1 As maxId FROM pullout");
			}
			else
			{
				System.out.println("getMaxId(): No queries found for " + transaction);
			}
			while (rs.next()) {
				maxIds = rs.getInt("maxId");
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally
		{
			try
			{
				st.close();
			}catch(Exception error)
			{
				System.out.println("Error final try catch getMaxId(): " + error);
			}
		}
		
		return maxIds;
	}//end getMaxID
	
	public String getTransNo(String transaction, String transNum, String Code){
		try{
			
			st = con.createStatement();
			if(transaction == "receiving")
			{
				rs = st.executeQuery("SELECT rcvNo, IFNULL(MAX(CONVERT(SUBSTRING_INDEX(rcvNo,'-',-1),UNSIGNED INTEGER)),0) + 1 AS transNum FROM receiving"); 
				Code = "RCV-";
			}
			else if(transaction == "fixedasset")
			{
				rs = st.executeQuery("SELECT faCode, IFNULL(MAX(CONVERT(SUBSTRING_INDEX(faCode,'-',-1),UNSIGNED INTEGER)),0) + 1 AS transNum FROM fixedasset_tmp");
				Code = "FA-";
			}
			else if(transaction == "transfer")
			{
				rs = st.executeQuery("SELECT transNo, IFNULL(MAX(CONVERT(SUBSTRING_INDEX(transNo,'-',-1),UNSIGNED INTEGER)),0) + 1 AS transNum FROM transfer");
				Code = "TX-";
			}
			else if(transaction == "maintenance")
			{
				rs = st.executeQuery("SELECT mntnNo, IFNULL(MAX(CONVERT(SUBSTRING_INDEX(mntnNo,'-',-1),UNSIGNED INTEGER)),0) + 1 AS transNum FROM maintenance");
				Code = "MX-";
			}
			else if(transaction == "pullout")
			{
				rs = st.executeQuery("SELECT poNo, IFNULL(MAX(CONVERT(SUBSTRING_INDEX(poNo,'-',-1),UNSIGNED INTEGER)),0) + 1 AS transNum FROM pullout");
				Code = "PO-";
			}
			else 
			{
				System.out.println("getTransNo(): No queries found for " + transaction);
			}
			while (rs.next()) {
				
				
					transNum = Code + rs.getString("transNum");
				   System.out.println(transaction + " transNo: "+ transNum);
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally
		{
			try
			{
				st.close();
			}catch(Exception error)
			{
				System.out.println("Error final try catch getRcvNo(): " + error);
			}
		}
		
		return transNum;
	}//end getMaxID
	
	public void  manageMenuInfo(int id, String name, String transaction, String function, String fName, String lName, String gender, String email, String contactNo, String address, int id_Dept, int id_Posn){
	
		if(transaction == "department" && function == "add")
		{
			sql = "INSERT INTO department (idDept, department) VALUES ('"+ id +"' ,'"+ name +"')";
		}else if(transaction == "department" && function == "edit")
		{
			sql = "UPDATE `department` SET `department`='"+ name +"' WHERE `idDept`='"+ id +"'";
		}
		else if(transaction == "brand" && function == "add")
		{
			sql = "INSERT INTO brand (idBrand, brand) VALUES ('"+ id +"' ,'"+ name +"')";
		}
		else if(transaction == "brand" && function == "edit")
		{
			sql = "UPDATE `brand` SET `brand`='"+ name +"' WHERE `idBrand`='"+ id +"'";
		}
		else if(transaction == "position" && function == "add")
		{
			sql = "INSERT INTO position (idPosn, position) VALUES ('"+ id +"' ,'"+ name +"')";
		}
		else if(transaction == "position" && function == "edit")
		{
			sql = "UPDATE `position` SET `position`='"+ name +"' WHERE `idPosn`='"+ id +"'";
		}
		else if(transaction == "employee" && function == "add")
		{
			sql = "INSERT INTO employee (idEmp, fName, lName, gender, email, contactNo, address, idDept, idPosn)"
				+  " VALUES ('"+ id +"' ,'"+ fName +"','"+ lName +"','"+ gender +"', '"+ email +"','"+ contactNo +"','"+ address +"','"+ id_Dept +"', '"+ id_Posn +"')";
		}
		else if(transaction == "employee" && function == "edit")
		{
			sql = "UPDATE `employee` SET `fName`='"+ fName +"', `lName`='"+ lName +"', `gender`='"+ gender +"',"
				+ "	`email`='"+ email +"', `contactNo`='"+ contactNo +"', `address`='"+ address +"'," 
				+ " `idDept`='"+ id_Dept +"', `idPosn`='"+ id_Posn +"'"
				+ " WHERE `idEmp`='"+ id +"'";
		}
		else if(transaction == "supplier" && function == "add")
		{
			sql = "INSERT INTO supplier (idSupplier, supplier, address, contactNo, email)"
				+  " VALUES ('"+ id +"' ,'"+ name +"','"+ address +"','"+ contactNo +"', '"+ email +"')";
		}
		else if(transaction == "supplier" && function == "edit")
		{
			sql = "UPDATE `supplier` SET `supplier`='"+ name +"', `address`='"+ address +"',"
				+ "	`contactNo`='"+ contactNo +"', `email`='"+ email +"'"
				+ " WHERE `idSupplier`='"+ id +"'";
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Transaction unsuccessful.");
		}	
		
		try 
		{
			st = con.createStatement();
			st.executeUpdate(sql);
			
			if(function == "add")
			{
				JOptionPane.showMessageDialog(null, "Successfully added " +  transaction + " " + name + ".");
			}
			else if(function == "edit")
			{
				JOptionPane.showMessageDialog(null, "Successfully updated " +  transaction + " " + name + ".");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Unsuccessful transaction " +  transaction + ".");
			}
		}catch (Exception e) 
		{
			
			e.printStackTrace();
		}

	}//end mngData
	
	
	public void  manageFixedAsset(String transaction, int id,  String function, String faCode, String dateAdded, String product, int id_Class, int id_Brand, String manufacturer, String license, String model, String serialNo, String barcode, double cost, String desc, int id_Supplier, int currLoc, String dateUpdated, String rcptInfo, int assetLife, double salvageVal, String datePurchase, String dateWarranty, int idRcv){
		
		if(function == "add")
		{
			sql = "INSERT INTO fixedasset_tmp (idfa, faCode, dateAdded, product,"
					+ "	idClass, idBrand, manufacturer, license, model,"
				    + " serialNo, barcode, cost, description,"
					+ " idSupplier, currLoc, dateUpdated, rcptInfo,"
				    + " assetLife, salvageVal, datePurchase, dateWarranty, idRcv)"
				    + " VALUES ('"+ id +"', '"+ faCode +"', '"+ dateAdded +"', '"+ product +"',"
				    + " '"+ id_Class +"', '"+ id_Brand +"', '"+ manufacturer +"', '"+ license +"', '"+ model +"',"
				    + " '"+ serialNo +"', '"+ barcode +"', '"+ cost +"', '"+ desc +"',"
				    + "  '"+ id_Supplier +"', '"+ currLoc +"', '"+ dateUpdated +"', '"+ rcptInfo +"'," 
				    + "  '"+ assetLife +"', '"+ salvageVal +"', '"+ datePurchase +"', '"+ dateWarranty +"','"+ idRcv +"')";
		}else if(function == "edit")
		{
			sql = "UPDATE fixedasset_tmp SET product= '"+ product +"', idClass='"+ id_Class +"', idBrand='"+ id_Brand +"',"
				+ " manufacturer='"+ manufacturer +"', license='"+ license +"', model='"+ model +"',"
				+ " serialNo='"+ serialNo +"', barcode='"+ barcode +"', cost='"+ cost +"',"
				+ " description='"+ desc +"', idSupplier= '"+ id_Supplier +"',"
				+ " currLoc='"+ currLoc +"', dateUpdated='"+ dateUpdated +"',"
				+ " dateWarranty ='"+ dateWarranty +"', assetLife='"+ assetLife +"',"
				+ " salvageVal='"+ salvageVal +"', datePurchase='"+ datePurchase +"'"
				+ "	WHERE idFa ='"+ id +"'";
		}
		else if(function == "delete")
		{
			sql = "DELETE FROM fixedasset_tmp WHERE idFa ='"+ id +"'";
		}
		else if(function == "cancel")
		{
			sql = "DELETE FROM fixedasset_tmp WHERE idRcv ='"+ idRcv +"'";
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Transaction unsuccessful. ");
		}	
		
		try 
		{
			st = con.createStatement();
			st.executeUpdate(sql);
			
		}catch (Exception e) 
		{
			
			e.printStackTrace();
		}

	}//end manageFixedAsset
		
		
	public void addTransaction(String transaction, int idFa, String faCode, int idTrnsctn, String function, int trnsctnId, String trnsctnNo, String trnsctnDate, int trnsctnBy, int location, int inCharge, int approvedBy,String remarks, String status)
	{
		sql = "INSERT INTO transaction (idTrnsctn, idFa, faCode, trnsctn, trnsctnId,"
			+ "	trnsctnNo, trnsctnDate, trnsctnBy, location, inCharge,"
			+ "	approvedBy, remarks, status)"
			+ " VALUES ('"+ idTrnsctn +"', '"+ idFa +"', '"+ faCode +"','"+ transaction +"', '"+ trnsctnId +"',"
			+ " '"+ trnsctnNo +"', '"+ trnsctnDate +"', '"+ trnsctnBy +"', '"+ location +"', '"+ inCharge +"',"
			+ "'"+ approvedBy +"', '"+ remarks +"', '"+ status +"')";
		
		try 
		{
			st = con.createStatement();
			st.executeUpdate(sql);
			
		}catch (Exception e) 
		{
			
			e.printStackTrace();
			
		}finally
		{
			try
			{
				st.close();
			}catch(Exception error)
			{
				System.out.println("Error final try catch addTrans(): " + error);
			}
		}
		
		
	}
	
	
	//TRANSACTIONS: receiving, transfer, maintenance, pullout
	public void manageTransactions(String transaction, int idTrans, String transNo, int idTrnsctn, String startDate, String endDate, String details, String status, int inCharge, int apprvdBy, int rtrndBy, String remarks)
	{
		if(transaction == "receiving")
		{
			sql = "INSERT INTO receiving (idRcv, rcvNo, idTrnsctn)"
				+ " VALUES ('"+ idTrans +"', '"+ transNo +"', '"+ idTrnsctn +"')";
		}
		else if(transaction == "transfer")
		{
			sql = "INSERT INTO transfer (idTrans, transNo, idTrnsctn)"
				+ " VALUES ('"+ idTrans +"', '"+ transNo +"', '"+ idTrnsctn +"')";
		}
		else if(transaction == "maintenance")
		{
			sql = "INSERT INTO maintenance (idMntn, mntnNo, idTrnsctn, startDate, endDate,"
				+ "	details, status, rtrndBy, remarks)"
				+ " VALUES ('"+ idTrans +"', '"+ transNo +"', '"+ idTrnsctn +"', '"+ startDate +"', '"+ endDate +"',"
				+ "'"+ details +"', '"+ status +"', '"+ rtrndBy +"', '"+ remarks +"')";
		}
		else if(transaction == "pullout")
		{
			sql = "INSERT INTO pullout (idPo, poNo, iTrnsctn, remarks, status)"
				+ " VALUES ('"+ idTrans +"', '"+ transNo +"', '"+ idTrnsctn +"', '"+ remarks +"', '"+ status +"')";
		}
		else
		{
			System.out.println("No queries.");
		}
		
		try 
		{
			st = con.createStatement();
			st.executeUpdate(sql);
			
		}catch (Exception e) 
		{
			
			e.printStackTrace();
			
		}finally
		{
			try
			{
				st.close();
			}catch(Exception error)
			{
				System.out.println("Error final try catch manageTransactions(): " + error);
			}
		}
		
		
	}//end manageTransactions
	
	
	public int restrictDuplicateInfo(String transaction, int id, String transNo, int idTrnsctn, String startDate, String endDate, String details, String status, int inCharge, int apprvdBy, int rtrndBy, String remarks){	
		int countDuplicate = 0;
		
		try{
			st = con.createStatement();
			if(transaction == "receiving")
			{
				rs = st.executeQuery("SELECT COUNT(*) as count FROM receiving WHERE idRcv='"+ id +"' AND rcvNo='"+ transNo +"'");
			}
			else if(transaction == "transfer")
			{
				rs = st.executeQuery("SELECT COUNT(*) as count FROM transfer WHERE idTrans='"+ id +"' AND transNo='"+ transNo +"'");
			}
			else if(transaction == "maintenance")
			{
				rs = st.executeQuery("SELECT COUNT(*) as count FROM maintenance WHERE idMntn='"+ id +"' AND mntnNo='"+ transNo +"'");
			}
			else if(transaction == "pullout")
			{
				rs = st.executeQuery("SELECT COUNT(*) as count FROM pullout WHERE idPo='"+ id +"' AND poNo='"+ transNo +"'");
			}
			else
			{
				
			}	
			while (rs.next()) {
				countDuplicate = (rs.getInt("count"));
				
				if (countDuplicate >= 1){
					
					JOptionPane.showMessageDialog(null, "Information already exists.");
					System.out.println("Info. exists: " + countDuplicate);
					
				}
			}
			
		 if(countDuplicate == 0)
		 {
			 manageTransactions(transaction, id, transNo, idTrnsctn, startDate, endDate, details, status, inCharge, apprvdBy, rtrndBy, remarks);
			 JOptionPane.showMessageDialog(null, "Transaction complete.");
		 }
		}catch(Exception e){
			
			e.printStackTrace();
		}finally
		{
			try
			{
				st.close();
			}catch(Exception error)
			{
				System.out.println("Error final try catch restrictDuplicateInfo(): " + error);
			}
		}
		
		
		return countDuplicate;
	}//end restrictDuplicate
	
	public void deleteTmpData(String transaction)
	{
		
		try{
			st = con.createStatement();
			if(transaction == "receiving")
			{
				sql = "DELETE FROM receiving";
			}
			else if(transaction == "fixedasset")
			{
				sql = "DELETE FROM fixedasset_tmp";
			}
			else if(transaction == "transfer")
			{
				sql = "DELETE FROM transfer";
			}
			else if(transaction == "maintenance")
			{
				sql = "DELETE FROM maintenance";
			}
			else if(transaction == "pullout")
			{
				sql = "DELETE FROM pullout";
			}
			else if(transaction == "tbl_transaction")
			{
				sql = "DELETE FROM transaction";
			}	
			else 
			{
				System.out.println("No queries.");
			}
			st = con.createStatement();
			st.executeUpdate(sql);
		}catch(Exception e){
			
			e.printStackTrace();
		}finally
		{
			try
			{
				st.close();
			}catch(Exception error)
			{
				System.out.println("Error final try catch deleteTmpData(): " + error);
			}
		}
		
	}//end delete
	
	public int getCboId(String transaction, String cboValue)
	{
		
		try
		{
			//Department
			st = con.createStatement();
			if(transaction == "department")
			{
				rs = st.executeQuery("SELECT idDept As id FROM department WHERE department LIKE '%"+ cboValue +"%'");
			}
			else if(transaction == "employee")
			{
				rs = st.executeQuery("SELECT idEmp As id FROM employee WHERE  CONCAT(lName, ', ', fName) LIKE '%"+ cboValue +"%'");
			}
						
			while(rs.next()){
				id = rs.getInt("id");
			}
			
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try 
			{
				st.close();
			}catch(Exception e)
			{
				System.out.println("Final try catch exception getCboId() " + e);
			}
		}
		
		return id;
	}//end getCboId()
	
	public void cancelTransactions(String transaction, int transId, String transNo)
	{
		try{
			st = con.createStatement();
			if(transaction == "transaction")
			{
				sql = "DELETE FROM transaction WHERE trnsctnNo='"+ transNo +"'";
			}
			if(transaction == "receiving")
			{
				sql = "DELETE FROM receiving WHERE idRcv='"+ transId +"'";
			}
			if(transaction == "transfer")
			{
				sql = "DELETE FROM transfer WHERE idTrans='"+ transId +"'";
			}
			if(transaction == "maintenance")
			{
				sql = "DELETE FROM maintenance WHERE idMntn='"+ transId +"'";
			}
			if(transaction == "pullout")
			{
				sql = "DELETE FROM pullout WHERE idPo='"+ transId +"'";
			}
			else 
			{
				System.out.println("No queries.");
			}
			st = con.createStatement();
			st.executeUpdate(sql);
		}catch(Exception e){
			
			e.printStackTrace();
		}finally
		{
			try
			{
				st.close();
			}catch(Exception error)
			{
				System.out.println("Error final try catch calcelTransactions(): " + error);
			}
		}
	}//calcelTransactions
}
