package frames;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import functions.FcnDbConnect;
import functions.FcnViewAsset;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;

public class ViewAsset {
	FcnDbConnect mng1;
	
	public JFrame frameViewAsset;
	public JTextField txtAssetCode;
	public JTable table;
	public JTextField txtTransaction;
	public String transaction, searchFor;
	
	
	//Table
	DefaultTableModel model = new DefaultTableModel();
	private JLabel lblNewLabel;
	private JLabel lblIdTrnsctnBy;
	public JTextField txtTrnsctnBy;
	private JButton btnMaintenance;
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAsset window = new ViewAsset();
					window.frameViewAsset.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewAsset() {
		mng1 = new FcnDbConnect();
		
		initialize();
		findFixedAsset();
		
		
		//table
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		
		txtTransaction = new JTextField();
		txtTransaction.setEditable(false);
		txtTransaction.setBounds(137, 448, 75, 20);
		frameViewAsset.getContentPane().add(txtTransaction);
		txtTransaction.setColumns(10);
		
		lblNewLabel = new JLabel("Transaction");
		lblNewLabel.setBounds(58, 451, 85, 14);
		frameViewAsset.getContentPane().add(lblNewLabel);
		
		lblIdTrnsctnBy = new JLabel("ID Trnsctn By");
		lblIdTrnsctnBy.setBounds(58, 474, 85, 14);
		frameViewAsset.getContentPane().add(lblIdTrnsctnBy);
		
		txtTrnsctnBy = new JTextField();
		txtTrnsctnBy.setEditable(false);
		txtTrnsctnBy.setColumns(10);
		txtTrnsctnBy.setBounds(137, 471, 75, 20);
		frameViewAsset.getContentPane().add(txtTrnsctnBy);
		
		btnMaintenance = new JButton("Maintenance");
		btnMaintenance.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnMaintenance.setForeground(Color.DARK_GRAY);
		btnMaintenance.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(mng1.faCode);
				Maintenance1 window = new Maintenance1();
				window.frameMaintenance1.setVisible(true);
				window.txtFaCode.setText(mng1.faCode);
				window.txtAsset.setText(mng1.asset);
				mng1.idEmpLog = Integer.parseInt(txtTrnsctnBy.getText());
				window.txtTrnsctnBy.setText(Integer.toString(mng1.idEmpLog));
				window.txtIdFa.setText(Integer.toString(mng1.idfa));
			}
		});
		btnMaintenance.setBounds(508, 11, 129, 23);
		frameViewAsset.getContentPane().add(btnMaintenance);
		
		JButton btnPullout = new JButton("Pullout");
		btnPullout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(mng1.faCode);
				PullOut window = new PullOut();
				window.framePullout.setVisible(true);
				window.txtFaCode.setText(mng1.faCode);
				window.txtAsset.setText(mng1.asset);
				mng1.idEmpLog = Integer.parseInt(txtTrnsctnBy.getText());
				window.txtTrnsctnBy.setText(Integer.toString(mng1.idEmpLog));
				window.txtIdInCharge.setText(Integer.toString(mng1.idEmpLog));
				window.txtIdFa.setText(Integer.toString(mng1.idfa));
			}
		});
		btnPullout.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPullout.setForeground(Color.DARK_GRAY);
		btnPullout.setBounds(637, 11, 129, 23);
		frameViewAsset.getContentPane().add(btnPullout);
		
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setPreferredWidth(80);
		
		col = table.getColumnModel().getColumn(1);
		col.setPreferredWidth(150);
		
		col = table.getColumnModel().getColumn(2);
		col.setPreferredWidth(200);
		
		col = table.getColumnModel().getColumn(3);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(4);
		col.setPreferredWidth(130);
		
		col = table.getColumnModel().getColumn(5);
		col.setPreferredWidth(120);
		
		col = table.getColumnModel().getColumn(6);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(7);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(8);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(9);
		col.setPreferredWidth(250);
		
		col = table.getColumnModel().getColumn(10);
		col.setPreferredWidth(200);
		
		col = table.getColumnModel().getColumn(11);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(12);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(13);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(14);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(15);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(16);
		col.setPreferredWidth(100);
		
		col = table.getColumnModel().getColumn(17);
		col.setPreferredWidth(10);
		
		col = table.getColumnModel().getColumn(18);
		col.setPreferredWidth(10);
		
		col = table.getColumnModel().getColumn(19);
		col.setPreferredWidth(10);
		
		col = table.getColumnModel().getColumn(20);
		col.setPreferredWidth(10);
		
		col = table.getColumnModel().getColumn(21);
		col.setPreferredWidth(10);
		
		
	
		
		
		//table.getTableHeader().setDefaultRenderer(arg0);
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameViewAsset = new JFrame();
		frameViewAsset.setResizable(false);
		frameViewAsset.setTitle("Fixed Assets");
		frameViewAsset.setBounds(100, 100, 782, 385);
		frameViewAsset.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameViewAsset.getContentPane().setLayout(null);
		
		JButton btnSearch = new JButton("Search FA Code");
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSearch.setForeground(Color.DARK_GRAY);
		btnSearch.setBounds(193, 11, 186, 23);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				findFixedAsset();
			}
		});
		frameViewAsset.getContentPane().add(btnSearch);
		
		txtAssetCode = new JTextField();
		txtAssetCode.setForeground(Color.DARK_GRAY);
		txtAssetCode.setBounds(20, 12, 171, 20);
		frameViewAsset.getContentPane().add(txtAssetCode);
		txtAssetCode.setColumns(10);
		
		JButton btnTransfer = new JButton("Transfer");
		btnTransfer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnTransfer.setForeground(Color.DARK_GRAY);
		btnTransfer.setBounds(380, 11, 128, 23);
		btnTransfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println(mng1.faCode);
				Transfer window = new Transfer();
				window.frameTransfer.setVisible(true);
				window.txtFaCode.setText(mng1.faCode);
				window.txtAsset.setText(mng1.asset);
				mng1.idEmpLog = Integer.parseInt(txtTrnsctnBy.getText());
				window.txtTrnsctnBy.setText(Integer.toString(mng1.idEmpLog));
				window.txtIdFa.setText(Integer.toString(mng1.idfa));
			}
		});
		frameViewAsset.getContentPane().add(btnTransfer);
		
		
		table = new JTable();
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mng1.faCode = "";
				mng1.asset = "";
				mng1.i = table.getSelectedRow();
				mng1.faCode = model.getValueAt(mng1.i, 0).toString();
				mng1.asset = model.getValueAt(mng1.i, 1).toString();
				mng1.idfa = Integer.parseInt(model.getValueAt(mng1.i, 17).toString());
				txtAssetCode.setText(mng1.faCode);
				
				if(transaction == "transfer")
				{
					Transfer window = new Transfer();
					window.frameTransfer.setVisible(true);
					window.txtFaCode.setText(mng1.faCode);
					window.txtAsset.setText(mng1.asset);
					window.txtIdFa.setText(Integer.toString(mng1.idfa));
					System.out.println(transaction);
					frameViewAsset.dispose();
					
			   }
				
				
				
			}
		});
		
		JScrollPane pane = new JScrollPane(table);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setBounds(20, 45, 746, 300);
		pane.setPreferredSize(new Dimension(480, 300));
		frameViewAsset.getContentPane().add(pane);
		
	}
	
	public ArrayList<FcnViewAsset> ListFcnViewAsset(String ValToSearch)
	{
		model.setRowCount(0);
		ArrayList<FcnViewAsset> fcnViewAssetList = new ArrayList<FcnViewAsset>();
		
		 try 
		 {
			mng1.st = mng1.con.createStatement(); 
			
			//mng1.rs = mng1.st.executeQuery("SELECT * FROM fixedasset_tmp WHERE faCode LIKE '%"+ ValToSearch +"%'");	
		/*	mng1.rs = mng1.st.executeQuery("SELECT * FROM fixedasset_tmp fa"
					+ "	LEFT JOIN classification cl ON cl.idClass = fa.idClass"
					+ " LEFT JOIN brand br ON br.idBrand = fa.idBrand"
					+ " LEFT JOIN supplier su ON su.idSupplier=fa.idSupplier"
					+ " WHERE faCode LIKE '%"+ ValToSearch +"%'");*/	
			mng1.rs = mng1.st.executeQuery("SELECT IFNULL(fa.faCode, '') As faCode, IFNULL(fa.product, '') As product, IFNULL(fa.model, '') As model,"
					+ " IFNULL(b.brand, '') As brand, IFNULL(c.classification, '') As classification, IFNULL(fa.manufacturer, '') As manufacturer,"
					+ " IFNULL(fa.license, '') As license, IFNULL(fa.serialNo, '') As serialNo, IFNULL(fa.barcode, '') As barcode,"
					+ " IFNULL(fa.description, '') As description, IFNULL(s.supplier, '') As supplier, IFNULL(d.department, '') As department,"
					+ " IFNULL(fa.cost, 0) As cost, IFNULL(fa.assetLife, 0) As assetLife, IFNULL(fa.salvageVal, 0) As salvageVal,"
					+ " IFNULL(fa.datePurchase, '0000-00-00') As datePurchase, IFNULL(fa.dateWarranty, '0000-00-00') As dateWarranty,"
					+ " IFNULL(fa.idfa, 0) As idfa, IFNULL(fa.idClass, 0) As idClass, IFNULL(fa.idBrand, 0) As idBrand," 
					+ " IFNULL(fa.idSupplier, 0) As idSupplier, IFNULL(fa.currLoc, 0) As currLoc, IFNULL(fa.idRcv, 0) As idRcv"
					+ " FROM fixedasset_tmp fa"
					+ " LEFT JOIN classification c On c.idClass=fa.idClass"
					+ " LEFT JOIN brand b ON b.idBrand=fa.idBrand"
					+ " LEFT JOIN supplier s ON s.idSupplier=fa.idSupplier"
					+ " LEFT JOIN department d ON d.idDept=fa.currLoc"
					+ " WHERE faCode LIKE '%"+ ValToSearch +"%'"
					+ " ORDER BY faCode DESC");
			
			
			
			FcnViewAsset fcnViewAsset;
			
			while(mng1.rs.next()){										
				
				fcnViewAsset = new FcnViewAsset(
						mng1.rs.getString("faCode"),
						mng1.rs.getString("product"),
						mng1.rs.getString("model"),
						mng1.rs.getString("brand"),
						mng1.rs.getString("classification"),
						mng1.rs.getString("manufacturer"),
						mng1.rs.getString("license"),
						mng1.rs.getString("serialNo"),
						mng1.rs.getString("barcode"),
						mng1.rs.getString("description"),
						mng1.rs.getString("supplier"),
						mng1.rs.getString("department"),
						mng1.rs.getString("cost"),
						mng1.rs.getString("assetLife"),
						mng1.rs.getString("salvageVal"),
						mng1.rs.getString("datePurchase"),
						mng1.rs.getString("dateWarranty"),
						mng1.rs.getString("idfa"),
						mng1.rs.getString("idClass"),
						mng1.rs.getString("idBrand"),
						mng1.rs.getString("idSupplier"),
						mng1.rs.getString("currLoc"),
						mng1.rs.getString("idRcv")
				); //fcnViewAsset = new FcnViewAsset
				fcnViewAssetList.add(fcnViewAsset);
				
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
		  
		return fcnViewAssetList;
	}
	
	public void findFixedAsset()
	{
		model.setRowCount(0);
		ArrayList<FcnViewAsset> fcnViewAsset = ListFcnViewAsset(txtAssetCode.getText());
		model.setColumnIdentifiers(new Object[]{"FA Code", "Product", "Model", "Brand", "Classificaiton", "Manufacturer", "License", "Serial No", "Barcode", "Description", "Supplier", "Location", "Cost", "Asset Life", "Salvage Val", "Purchase", "Warranty", "idFa", "idClass", "idBrand", "idSupplier", "idDept", "idRcv"});
		
		Object[] row = new Object[24];
		
		for(int i=0; i< fcnViewAsset.size(); i++)
		{
			row[0] = fcnViewAsset.get(i).getFaCode();
			row[1] = fcnViewAsset.get(i).getProduct();
			row[2] = fcnViewAsset.get(i).getModel();
			row[3] = fcnViewAsset.get(i).getBrand();
			row[4] = fcnViewAsset.get(i).getClassification();
			row[5] = fcnViewAsset.get(i).getManufacturer();
			row[6] = fcnViewAsset.get(i).getLicense();
			row[7] = fcnViewAsset.get(i).getSerialNo();
			row[8] = fcnViewAsset.get(i).getBarcode();
			row[9] = fcnViewAsset.get(i).getDescription();
			row[10] = fcnViewAsset.get(i).getSupplier();
			row[11] = fcnViewAsset.get(i).getLocation();
			row[12] = fcnViewAsset.get(i).getCost();
			row[13] = fcnViewAsset.get(i).getAssetLife();
			row[14] = fcnViewAsset.get(i).getSalvageVal();
			row[15] = fcnViewAsset.get(i).getDatePurchase();
			row[16] = fcnViewAsset.get(i).getDateWarranty();
			row[17] = fcnViewAsset.get(i).getIdFa();
			row[18] = fcnViewAsset.get(i).getIdClass();
			row[19] = fcnViewAsset.get(i).getIdBrand();
			row[20] = fcnViewAsset.get(i).getIdSupplier();
			row[21] = fcnViewAsset.get(i).getCurrLoc();
			row[22] = fcnViewAsset.get(i).getIdRcv();
			
			model.addRow(row);
			
		}
		
		table.setModel(model);
		
	}
}
