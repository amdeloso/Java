package functions;

import java.util.HashMap;

public class CboItem {
	FcnDbConnect mng1;
	
	
	private int id;
	private String name;
	
	public CboItem(int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public int getId()
	{
		return id;
	}
	
	public String getItem()
	{
		return name;
	}
	
	public HashMap<String, Integer> populateCbo(String transaction)
	{
		mng1 = new FcnDbConnect();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		try
		{
			//Department
			mng1.st = mng1.con.createStatement();
			if(transaction == "department")
			{
				mng1.rs = mng1.st.executeQuery("SELECT idDept, department FROM department ORDER BY department ASC");
			}
			else if(transaction == "position")
			{
				mng1.rs = mng1.st.executeQuery("SELECT idPosn, position FROM position ORDER BY position ASC");
			}
			else if(transaction == "classification")
			{
				mng1.rs = mng1.st.executeQuery("SELECT idClass, classification FROM classification ORDER BY classification ASC");
			}
			else if(transaction == "brand")
			{
				mng1.rs = mng1.st.executeQuery("SELECT idBrand, brand FROM brand ORDER BY brand ASC");
			}
			else if(transaction == "supplier")
			{
				mng1.rs = mng1.st.executeQuery("SELECT idSupplier, supplier FROM supplier ORDER BY supplier ASC");
			}
			else if(transaction == "employee")
			{
				mng1.rs = mng1.st.executeQuery("SELECT idEmp, CONCAT(lName, ', ', fName) As employee FROM employee ORDER BY lName ASC");
			}
			
			CboItem cmi;
			
			while(mng1.rs.next()){
				cmi = new CboItem(mng1.rs.getInt(1), mng1.rs.getString(2));
				map.put(cmi.getItem(), cmi.getId());
			}
			
			mng1.st.close();		
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try 
			{
				mng1.st.close();
			}catch(Exception e)
			{
				System.out.println("Final try catch exception" + e);
			}
		}
		
		return map;
	}
	
	
	public HashMap<String, Integer> populateCbo1(String transaction)
	{
		mng1 = new FcnDbConnect();
		HashMap<String, Integer> map1 = new HashMap<String, Integer>();
		try
		{
			//Department
			mng1.st = mng1.con.createStatement();
			if(transaction == "department")
			{
				mng1.rs = mng1.st.executeQuery("SELECT idDept, department FROM department ORDER BY department ASC");
			}
			else if(transaction == "employee")
			{
				mng1.rs = mng1.st.executeQuery("SELECT idEmp, CONCAT(lName, ', ', fName) As employee FROM employee ORDER BY lName ASC");
			}
			
			CboItem cmi1;
			
			while(mng1.rs.next()){
				cmi1 = new CboItem(mng1.rs.getInt(1), mng1.rs.getString(2));
				map1.put(cmi1.getItem(), cmi1.getId());
			}
			
			mng1.st.close();		
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
		{
			try 
			{
				mng1.st.close();
			}catch(Exception e)
			{
				System.out.println("Final try catch exception" + e);
			}
		}
		
		return map1;
	}
	
}
