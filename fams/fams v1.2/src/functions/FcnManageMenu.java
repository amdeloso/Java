package functions;

import java.sql.SQLException;
//import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import frames.Department;

public class FcnManageMenu {
	//Class
	FcnDbConnect mng1;
	FcnManageMenu mng2;
	Department frmDept;
	Vector<Vector<String>> data = new Vector<Vector<String>>();
	Vector<String> row = new Vector<String>();
	
	//Var
	public void  mngData(int id, String name, String transaction, String function){
		
		if(transaction == "department" && function == "insert"){
			
			try {
				mng1.st = mng1.con.createStatement();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			mng1.sql = "INSERT INTO `dbfams`.`department` (`department`) VALUES ('"+ name +"');";
		    executeSQLQuery(mng1.sql, " added ", transaction);
		    
		}else if(transaction == "Department" && function == "Update"){
			 
			mng1.sql = "UPDATE `dbfams`.`department` SET `department`='"+ name +"' WHERE  `idDept`='"+ id +"'";
			executeSQLQuery(mng1.sql, "updated", transaction);
			
		}else if(transaction == "Position" && function == "Insert"){
			
			mng1.sql = "INSERT INTO `dbfams`.`position` (`position`) VALUES ('"+ name +"');";
		    executeSQLQuery(mng1.sql, " added", transaction);
			
		}else if(transaction == "Position" && function == "Update"){
			
			mng1.sql = "UPDATE `dbfams`.`position` SET `position`='"+ name +"' WHERE  `idPosn`='"+ id +"'";
			executeSQLQuery(mng1.sql, " updated ", transaction);
			
		}else{
			
			 JOptionPane.showMessageDialog(null, "No transaction.");
			
		}
		
	}//end mngData
	
	public void executeSQLQuery(String sql, String message, String transaction){
		
		try{
			
			if(mng1.st.executeUpdate(sql) == 1){
				//refresh table
				DefaultTableModel model = (DefaultTableModel)frmDept.table.getModel();
				model.setRowCount(0);
				frmDept.viewDept();
				
				//prompt
				JOptionPane.showMessageDialog(null, "Data " + message + " successfully");
			}else{
				//refresh table
				DefaultTableModel model = (DefaultTableModel)frmDept.table.getModel();
				model.setRowCount(0);
				frmDept.viewDept();

				//prompt
				JOptionPane.showMessageDialog(null, "Data not " + message + " successfully");

			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		
	}
	
	public int getMaxId(int maxIds, String trans){
		
		try{
			
			mng1.st = mng1.con.createStatement();
			mng1.rs = mng1.st.executeQuery("SELECT MAX(idDept) + 1 As maxId FROM department");
			
			while (mng1.rs.next()) {
				maxIds = mng1.rs.getInt("maxId");
			}
			
		}catch(Exception e){
			
			e.printStackTrace();
		}finally
		{
			try
			{
				mng1.st.close();
			}catch(Exception error)
			{
				System.out.println("Error final try catch getMaxId(): " + error);
			}
		}
		
		return maxIds;
	}//end getMaxID
	
	
	
}
