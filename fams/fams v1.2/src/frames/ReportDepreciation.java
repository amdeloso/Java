package frames;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import functions.FcnDbConnect;
import functions.FcnViewDepreciation;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ReportDepreciation {
	FcnDbConnect mng1;
	
	DefaultTableModel model = new DefaultTableModel();
	public JFrame frameReportDepreciation;
	private JTable table;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportDepreciation window = new ReportDepreciation();
					window.frameReportDepreciation.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReportDepreciation() {
		mng1 = new FcnDbConnect();
		initialize();
		findFixedAsset();
		
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setPreferredWidth(70);
		
		col = table.getColumnModel().getColumn(1);
		col.setPreferredWidth(150);
		
		col = table.getColumnModel().getColumn(2);
		col.setPreferredWidth(150);
		
		col = table.getColumnModel().getColumn(3);
		col.setPreferredWidth(130);
		
		col = table.getColumnModel().getColumn(4);
		col.setPreferredWidth(80);
		
		col = table.getColumnModel().getColumn(5);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(6);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(7);
		col.setPreferredWidth(130);
			
		//column align right
		DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
		rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
		table.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
		table.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);

		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameReportDepreciation = new JFrame();
		frameReportDepreciation.setBackground(new Color(240, 240, 240));
		frameReportDepreciation.setTitle("Fixed Asset Depreciation");
		frameReportDepreciation.setResizable(false);
		frameReportDepreciation.setBounds(100, 100, 922, 404);
		frameReportDepreciation.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameReportDepreciation.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.setBackground(new Color(255, 255, 255));
		JScrollPane pane = new JScrollPane(table);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setBounds(10, 34, 896, 337);
		pane.setPreferredSize(new Dimension(480, 300));
		frameReportDepreciation.getContentPane().add(pane);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.setForeground(Color.DARK_GRAY);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try
				{
					MessageFormat header = new MessageFormat("Fixed Asset Yearly Depreciation Value");
					MessageFormat footer = new MessageFormat("Page(1, number, integer)");
				
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
					//System.out.println(e);
				}
			}
		});
		btnPrint.setBounds(10, 8, 89, 23);
		frameReportDepreciation.getContentPane().add(btnPrint);
	}
	
	public ArrayList<FcnViewDepreciation> ListFcnViewDepreciation() //String ValToSearch
	{
		//Convert 
		
		
		
		ArrayList<FcnViewDepreciation> fcnViewDepreciationList = new ArrayList<FcnViewDepreciation>();
		
		 try 
		 {
			mng1.st = mng1.con.createStatement(); 
			mng1.rs = mng1.st.executeQuery("SELECT IFNULL(fa.faCode, '') As faCode, IFNULL(fa.product, '') As product, IFNULL(fa.model, '') As model,"
					+ " IFNULL(b.brand, '') As brand, IFNULL(c.classification, '') As classification, IFNULL(fa.manufacturer, '') As manufacturer,"
					+ " IFNULL(fa.license, '') As license, IFNULL(fa.serialNo, '') As serialNo, IFNULL(fa.barcode, '') As barcode,"
					+ " IFNULL(fa.description, '') As description, IFNULL(s.supplier, '') As supplier, IFNULL(d.department, '') As department,"
					+ " IFNULL(fa.cost, 0) As cost, IFNULL(fa.assetLife, 0) As assetLife, IFNULL(fa.salvageVal, 0) As salvageVal,"
					+ " IFNULL(fa.datePurchase, '0000-00-00') As datePurchase, IFNULL(fa.dateWarranty, '0000-00-00') As dateWarranty,"
					+ " IFNULL(fa.idfa, 0) As idfa, IFNULL(fa.idClass, 0) As idClass, IFNULL(fa.idBrand, 0) As idBrand," 
					+ " IFNULL(fa.idSupplier, 0) As idSupplier, IFNULL(fa.currLoc, 0) As currLoc, IFNULL(fa.idRcv, 0) As idRcv,"
					+ " IFNULL(fa.dateAdded, '0000-00-00') As dateAdded,"
					+ " ((1/IFNULL(fa.assetLife, 0))*(IFNULL(fa.cost, 0) - IFNULL(fa.salvageVal, 0))) As depVal"
					+ " FROM fixedasset_tmp fa"
					+ " LEFT JOIN classification c On c.idClass=fa.idClass"
					+ " LEFT JOIN brand b ON b.idBrand=fa.idBrand"
					+ " LEFT JOIN supplier s ON s.idSupplier=fa.idSupplier"
					+ " LEFT JOIN department d ON d.idDept=fa.currLoc"
					+ " ORDER BY faCode");
			
				//	+ " WHERE faCode LIKE '%"+ ValToSearch +"%'"
			
			FcnViewDepreciation fcnViewDepreciation;
			
			while(mng1.rs.next()){										
				
				//mng1.result = mng1.df.format(mng1.rs.getString("depVal"));
				
				fcnViewDepreciation = new FcnViewDepreciation(
						mng1.rs.getString("faCode"),
						mng1.rs.getString("product"),
						mng1.rs.getString("model"),
						mng1.rs.getString("classification"),
						mng1.rs.getString("cost"),
						mng1.rs.getString("assetLife"),
						mng1.rs.getString("salvageVal"),
						mng1.rs.getString("depVal")
				); //fcnViewAsset = new FcnViewAsset
				fcnViewDepreciationList.add(fcnViewDepreciation);
				
				
			}//end while
			
		 }catch (Exception e) {
			e.printStackTrace();
		 }finally
		  {
				try {
					mng1.st.close();
				} catch (SQLException e) {
					System.out.println("Final catch ArrayList<FcnViewAsset>() " + e);
				}
				
		  }//end try catch
		  
		return fcnViewDepreciationList;
	}
	
	public void findFixedAsset()
	{
		ArrayList<FcnViewDepreciation> fcnViewDepreciation = ListFcnViewDepreciation();
		model.setColumnIdentifiers(new Object[]{"FA Code", "Product", "Model", "Classificaton", "Cost", "Asset Life", "Salvage Val", "Depreciation Value"});
		 
		Object[] row = new Object[24];
		
		for(int i=0; i< fcnViewDepreciation.size(); i++)
		{
			row[0] = fcnViewDepreciation.get(i).getFaCode();
			row[1] = fcnViewDepreciation.get(i).getProduct();
			row[2] = fcnViewDepreciation.get(i).getModel();
			row[3] = fcnViewDepreciation.get(i).getClassification();
			row[4] = fcnViewDepreciation.get(i).getCost();
			row[5] = fcnViewDepreciation.get(i).getAssetLife();
			row[6] = fcnViewDepreciation.get(i).getSalvageVal();
			row[7] = fcnViewDepreciation.get(i).getDepVal();
			
			
			model.addRow(row);
			
		}
		
		table.setModel(model);
		
	}
}
