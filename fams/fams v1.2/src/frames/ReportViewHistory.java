package frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import functions.FcnDbConnect;
import functions.FcnViewHistory;
import functions.FcnViewHistory1;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JButton;

public class ReportViewHistory {
	FcnDbConnect mng1;
	
	DefaultTableModel model = new DefaultTableModel();
	DefaultTableModel model1 = new DefaultTableModel();
	public JFrame frameReportViewHistory;
	private JTable table;
	private JTextField txtFaCode;
	private JLabel lblReceivedFixedAsset;
	private JLabel lblTransferMaintenance;
	private JTable table_1;
	private JButton btnPrintRvdHistory;
	private JButton btnPrintTOthers;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportViewHistory window = new ReportViewHistory();
					window.frameReportViewHistory.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ReportViewHistory() {
		mng1 = new FcnDbConnect();
		
		initialize();
		
		findRcvdFixedAsset();	
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setPreferredWidth(120);
		
		col = table.getColumnModel().getColumn(1);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(2);
		col.setPreferredWidth(120);
		
		col = table.getColumnModel().getColumn(3);
		col.setPreferredWidth(350);
		
		col = table.getColumnModel().getColumn(4);
		col.setPreferredWidth(150);
		
		col = table.getColumnModel().getColumn(5);
		col.setPreferredWidth(150);
		
		col = table.getColumnModel().getColumn(6);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(7);
		col.setPreferredWidth(200);
		
		col = table.getColumnModel().getColumn(8);
		col.setPreferredWidth(200);
		
		findTransFixedAsset();
		TableColumn col_1 = table_1.getColumnModel().getColumn(0);
		col_1.setPreferredWidth(120);
		
		col_1 = table.getColumnModel().getColumn(1);
		col_1.setPreferredWidth(100);
		
		col_1 = table.getColumnModel().getColumn(2);
		col_1.setPreferredWidth(120);
		
		col_1 = table.getColumnModel().getColumn(3);
		col_1.setPreferredWidth(350);
		
		col_1 = table.getColumnModel().getColumn(4);
		col_1.setPreferredWidth(150);
		
		col_1 = table.getColumnModel().getColumn(5);
		col_1.setPreferredWidth(150);
		
		col_1 = table.getColumnModel().getColumn(6);
		col_1.setPreferredWidth(100);
		
		col_1 = table.getColumnModel().getColumn(7);
		col_1.setPreferredWidth(200);
		
		col_1 = table.getColumnModel().getColumn(8);
		col_1.setPreferredWidth(200);
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameReportViewHistory = new JFrame();
		frameReportViewHistory.setResizable(false);
		frameReportViewHistory.setTitle("Fixed Asset History");
		frameReportViewHistory.setBounds(100, 100, 806, 501);
		frameReportViewHistory.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameReportViewHistory.getContentPane().setLayout(null);
		
		table = new JTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		JScrollPane pane = new JScrollPane(table);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setBounds(10, 35, 780, 193);
		pane.setPreferredSize(new Dimension(480, 300));
		frameReportViewHistory.getContentPane().add(pane);
		
		txtFaCode = new JTextField();
		txtFaCode.setBounds(417, 531, 80, 20);
		frameReportViewHistory.getContentPane().add(txtFaCode);
		txtFaCode.setColumns(10);
		
		lblReceivedFixedAsset = new JLabel("Receiving");
		lblReceivedFixedAsset.setForeground(Color.DARK_GRAY);
		lblReceivedFixedAsset.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblReceivedFixedAsset.setBounds(10, 11, 364, 28);
		frameReportViewHistory.getContentPane().add(lblReceivedFixedAsset);
		
		lblTransferMaintenance = new JLabel("Transfer | Maintenance | Pull-out");
		lblTransferMaintenance.setForeground(Color.DARK_GRAY);
		lblTransferMaintenance.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTransferMaintenance.setBounds(10, 246, 364, 28);
		frameReportViewHistory.getContentPane().add(lblTransferMaintenance);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 271, 780, 193);
		frameReportViewHistory.getContentPane().add(scrollPane);
		
		table_1 = new JTable();
		table_1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scrollPane.setColumnHeaderView(table_1);
		
		btnPrintRvdHistory = new JButton("Print");
		btnPrintRvdHistory.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrintRvdHistory.setForeground(Color.DARK_GRAY);
		btnPrintRvdHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try
				{
					MessageFormat header = new MessageFormat("Fixed Asset Receiving History");
					MessageFormat footer = new MessageFormat("Page(1, number, integer)");
				
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				}catch(Exception e)
				{
					JOptionPane.showMessageDialog(null, e);
					//System.out.println(e);
				}
			}
		});
		btnPrintRvdHistory.setBounds(701, 11, 89, 23);
		frameReportViewHistory.getContentPane().add(btnPrintRvdHistory);
		
		btnPrintTOthers = new JButton("Print");
		btnPrintTOthers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					MessageFormat header = new MessageFormat("Fixed Asset Transfer | Maintenance | Pullout History");
					MessageFormat footer = new MessageFormat("Page(1, number, integer)");
				
					table.print(JTable.PrintMode.FIT_WIDTH, header, footer);
				}catch(Exception error)
				{
					JOptionPane.showMessageDialog(null, error);
					//System.out.println(e);
				}
			}
		});
		btnPrintTOthers.setForeground(Color.DARK_GRAY);
		btnPrintTOthers.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPrintTOthers.setBounds(701, 246, 89, 23);
		frameReportViewHistory.getContentPane().add(btnPrintTOthers);
		
	}
	
	//Receiving History
	public ArrayList<FcnViewHistory> ListFcnViewHistory(String ValToSearch)
	{
		ArrayList<FcnViewHistory> fcnViewHistoryList = new ArrayList<FcnViewHistory>();
		
		 try 
		 {
			mng1.st = mng1.con.createStatement(); 	
			mng1.rs = mng1.st.executeQuery("SELECT IFNULL(t.trnsctnNo, '') As trnsctnNo, IFNULL(t.trnsctn, '') As trnsctn,"
					+ " IFNULL(f.faCode, '') As faCode, IFNULL(f.product, '') As product,"
					+ " IFNULL(f.serialNo, '') As serialNo, IFNULL(f.barcode, '') As barcode,"
					+ " IFNULL(t.trnsctnDate, '0000-00-00') As trnsctnDate," 
					+ " IFNULL(d.department, '') As department,"
					+ " IFNULL(CONCAT(e.lName, ', ', e.fName), '') As InCharge"
					+ " FROM transaction t"
					+ " LEFT JOIN receiving r ON r.idRcv=t.trnsctnId"
					+ " LEFT JOIN fixedasset_tmp f ON f.idRcv=r.idRcv"
					+ " LEFT JOIN department d ON d.idDept=f.currLoc"
					+ " LEFT JOIN employee e ON e.idEmp=t.inCharge"
					+ " WHERE t.trnsctn = 'receiving'"
					+ " ORDER BY faCode DESC");
			
			FcnViewHistory fcnViewHistory;
			
			while(mng1.rs.next()){										
				
				fcnViewHistory = new FcnViewHistory(
						mng1.rs.getString("trnsctnNo"),
						mng1.rs.getString("trnsctn"),
						mng1.rs.getString("faCode"),
						mng1.rs.getString("product"),
						mng1.rs.getString("serialNo"),
						mng1.rs.getString("barcode"),
						mng1.rs.getString("trnsctnDate"),
						mng1.rs.getString("department"),
						mng1.rs.getString("InCharge")
				); 
				fcnViewHistoryList.add(fcnViewHistory);
				
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
		  
		return fcnViewHistoryList;
	}
	
	public void findRcvdFixedAsset()
	{
		ArrayList<FcnViewHistory> fcnViewHistory = ListFcnViewHistory(txtFaCode.getText());
		model.setColumnIdentifiers(new Object[]{"Trans. No", "Transaction", "FA Code", "Product", "Serial No", "Barcode", "Rcv Date", "Location", "In-Charge"});
		
		Object[] row = new Object[11];
		
		for(int i=0; i< fcnViewHistory.size(); i++)
		{
			row[0] = fcnViewHistory.get(i).getTransNo();
			row[1] = fcnViewHistory.get(i).getTransaction();
			row[2] = fcnViewHistory.get(i).getFaCode();
			row[3] = fcnViewHistory.get(i).getProduct();
			row[4] = fcnViewHistory.get(i).getSerialNo();
			row[5] = fcnViewHistory.get(i).getBarcode();
			row[6] = fcnViewHistory.get(i).getTransDate();
			row[7] = fcnViewHistory.get(i).getLocation();
			row[8] = fcnViewHistory.get(i).getInCharge();		
			model.addRow(row);
			
		}
		
		table.setModel(model);
		
	}
	//End Receiving History
	
	
	
	//Transfer, Maintenance, PullOut
	public ArrayList<FcnViewHistory1> ListFcnViewHistory1(String ValToSearch)
	{
		ArrayList<FcnViewHistory1> fcnViewHistoryList1 = new ArrayList<FcnViewHistory1>();
		
		 try 
		 {
			mng1.st = mng1.con.createStatement(); 	
			mng1.rs = mng1.st.executeQuery("SELECT IFNULL(t.trnsctnNo, '') As trnsctnNo, IFNULL(t.trnsctn, '') As trnsctn,"
					+ " IFNULL(f.faCode, '') As faCode, IFNULL(f.product, '') As product,"
					+ " IFNULL(f.serialNo, '') As serialNo, IFNULL(f.barcode, '') As barcode,"
					+ " IFNULL(t.trnsctnDate, '0000-00-00') As trnsctnDate," 
					+ " IFNULL(d.department, '') As department,"
					+ " IFNULL(CONCAT(e.lName, ', ', e.fName), '') As InCharge"
					+ " FROM transaction t" 
					+ " LEFT JOIN transfer tx ON tx.idTrans = t.trnsctnId"
					+ " LEFT JOIN maintenance mx ON mx.idMntn = t.trnsctnId"
					+ " LEFT JOIN pullout po ON po.idPo = t.trnsctnId"
					+ " LEFT JOIN fixedasset_tmp f ON f.idfa=t.idFa"
					+ " LEFT JOIN department d ON d.idDept=f.currLoc"
					+ " LEFT JOIN employee e ON e.idEmp=t.inCharge"
					+ " WHERE t.trnsctn != 'receiving'"
					+ " ORDER BY faCode DESC");
			
			FcnViewHistory1 fcnViewHistory1;
			
			while(mng1.rs.next()){										
				
				fcnViewHistory1 = new FcnViewHistory1(
						mng1.rs.getString("trnsctnNo"),
						mng1.rs.getString("trnsctn"),
						mng1.rs.getString("faCode"),
						mng1.rs.getString("product"),
						mng1.rs.getString("serialNo"),
						mng1.rs.getString("barcode"),
						mng1.rs.getString("trnsctnDate"),
						mng1.rs.getString("department"),
						mng1.rs.getString("InCharge")
				); 
				fcnViewHistoryList1.add(fcnViewHistory1);
				
			}//end while
			
		 }catch (Exception e) {
			e.printStackTrace();
		 }finally
		  {
				try {
					mng1.st.close();
				} catch (SQLException e) {
					System.out.println("Final catch ArrayList<FcnViewAsset1>() " + e);
				}
				
		  }//end try catch
		  
		return fcnViewHistoryList1;
	}
	
	public void findTransFixedAsset()
	{
		ArrayList<FcnViewHistory1> fcnViewHistory1 = ListFcnViewHistory1(txtFaCode.getText());
		model1.setColumnIdentifiers(new Object[]{"Trans. No", "Transaction", "FA Code", "Product", "Serial No", "Barcode", "Rcv Date", "Location", "In-Charge"});
		
		Object[] row1 = new Object[11];
		
		for(int i=0; i< fcnViewHistory1.size(); i++)
		{
			row1[0] = fcnViewHistory1.get(i).getTransNo();
			row1[1] = fcnViewHistory1.get(i).getTransaction();
			row1[2] = fcnViewHistory1.get(i).getFaCode();
			row1[3] = fcnViewHistory1.get(i).getProduct();
			row1[4] = fcnViewHistory1.get(i).getSerialNo();
			row1[5] = fcnViewHistory1.get(i).getBarcode();
			row1[6] = fcnViewHistory1.get(i).getTransDate();
			row1[7] = fcnViewHistory1.get(i).getLocation();
			row1[8] = fcnViewHistory1.get(i).getInCharge();		
			model1.addRow(row1);
			
		}
		
		table_1.setModel(model1);
		
	}
	//end Transfer, Maintenance, Pullout
}
