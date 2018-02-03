package functions;


public class FcnTransMenu {
	FcnDbConnect mng1;
	
	public void deleteTransInfo(String transaction){
			
		{
			try
			{
				mng1.st = mng1.con.createStatement();
				if(transaction == "receiving")
				{
					mng1.rs = mng1.st.executeQuery("DELETE FROM transfer");
				}
				else 
				{
					System.out.println("No queries.");
				}
			}
			catch(Exception e){
				
				e.printStackTrace();
			}finally
			{
				try
				{
					mng1.st.close();
				}catch(Exception error)
				{
					System.out.println("Error final try catch deleteTransInfo(): " + error);
				}
			}	
			
	}//end delete
	
	
	
 }
	
}	//end class
