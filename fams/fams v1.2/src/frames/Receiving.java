package frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import functions.CboItem;
import functions.FcnDbConnect;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.util.HashMap;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JCalendar;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


//@SuppressWarnings("serial")
public class Receiving{
	
	FcnDbConnect mng1;
	CboItem cbo;
	
	public JFrame frameReceiving;
	public JTextField txtFaCode;
	public JTextField txtDate;
	public JTextField txtBarcode;
	public JTextField txtSerialNo;
	public JTextField txtTrnsctnBy;
	public JTextField txtRemarks;
	public JTextField txtCost;
	public JTextField txtLicense;
	public JTextField txtManufacturer;
	public JTextField txtDatePurchase;
	public JTextField txtProduct;
	public JTextField txtModel;
	public JTextField txtRcptInfo;
	public JTextField txtRcvNo;
	public JTextField txtIdClass;
	public JTextField txtIdBrand;
	public JTextField txtIdSupplier;
	public JTextField txtIdInCharge;
	public JTextField txtIdLoc;
	public JTextField txtDateWarranty;
	public JTextField txtDesc;
	public JTextField txtSalvageVal;
	public JTextField txtAssetLife;
	public JTextField txtIdRcv;
	public JTextField txtIdTrans;
	public JTextField txtIdFa;
	
	//CBO
	public JComboBox<String> cboClass, cboBrand, cboSupplier, cboStatus, cboStat, cboLoc, cboInCharge;	
	
	
	//Table
	public JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	
	//Panel
	public JPanel panelFa;

	
	//Date
	JCalendar jCalendar1 = new JCalendar();
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Receiving window = new Receiving();
					window.frameReceiving.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param catName 
	 * @param catID 
	 */
	public Receiving() {
		mng1 = new FcnDbConnect();
		cbo = new CboItem(0,"");
		
		initialize(null, null);
		
		//TABLE
		Object[] columns = {"FA Code", "Product", "Model", "Brand", "Classificaiton", "Manufacturer", "License", "Serial No", "Barcode", "Description", "Supplier", "Location", "Cost", "Asset Life", "Salvage Val", "Purchase", "Warranty", "idFa", "idClass", "idBrand", "idSupplier", "idDept"};
		
		model.setColumnIdentifiers(columns);
		//TABLE
				
		mng1.getDateNow();
		txtDate.setText(mng1.dateString);
		
		bindCbo();
		
		TableColumn col = table.getColumnModel().getColumn(0);
		col.setPreferredWidth(250);
		
		col = table.getColumnModel().getColumn(1);
		col.setPreferredWidth(500);
		
		col = table.getColumnModel().getColumn(2);
		col.setPreferredWidth(300);
		
		col = table.getColumnModel().getColumn(3);
		col.setPreferredWidth(300);
		
		col = table.getColumnModel().getColumn(4);
		col.setPreferredWidth(400);
		
		col = table.getColumnModel().getColumn(5);
		col.setPreferredWidth(300);
		
		col = table.getColumnModel().getColumn(6);
		col.setPreferredWidth(300);
		
		col = table.getColumnModel().getColumn(7);
		col.setPreferredWidth(300);
		
		col = table.getColumnModel().getColumn(8);
		col.setPreferredWidth(300);
		
		col = table.getColumnModel().getColumn(9);
		col.setPreferredWidth(300);
		
		col = table.getColumnModel().getColumn(10);
		col = table.getColumnModel().getColumn(11);
		col = table.getColumnModel().getColumn(12);
		col = table.getColumnModel().getColumn(13);
		col = table.getColumnModel().getColumn(14);
		col = table.getColumnModel().getColumn(15);
		col = table.getColumnModel().getColumn(16);
		col = table.getColumnModel().getColumn(17);
		col = table.getColumnModel().getColumn(18);
		col = table.getColumnModel().getColumn(19);
		col = table.getColumnModel().getColumn(20);
		col = table.getColumnModel().getColumn(21);
		
		
		
		
		
		
		
		
		/*//Disbled Fields
		txtProduct.setEnabled(false);
		txtProduct.setBackground(Color.WHITE);
		txtModel.setEnabled(false);
		txtModel.setBackground(Color.WHITE);
		txtLicense.setEnabled(false);
		txtLicense.setBackground(Color.WHITE);
		txtBarcode.setEnabled(false);
		txtBarcode.setBackground(Color.WHITE);
		txtSerialNo.setEnabled(false);
		txtSerialNo.setBackground(Color.WHITE);
		txtDesc.setEnabled(false);
		txtDesc.setBackground(Color.WHITE);
		txtDatePurchase.setEnabled(false);
		txtDatePurchase.setBackground(Color.WHITE);
		txtAssetLife.setEnabled(false);
		txtAssetLife.setBackground(Color.WHITE);
		txtCost.setEnabled(false);
		txtCost.setBackground(Color.WHITE);
		txtSalvageVal.setEnabled(false);
		txtSalvageVal.setBackground(Color.WHITE);
		txtWarranty.setEnabled(false);
		txtWarranty.setBackground(Color.LIGHT_GRAY);
		txtRemarks.setEnabled(false);
		txtRemarks.setBackground(Color.LIGHT_GRAY);
		//Disable Fields
*/		
		JLabel lblReceiptNo = new JLabel("Receipt Info:");
		lblReceiptNo.setBounds(50, 791, 98, 14);
		frameReceiving.getContentPane().add(lblReceiptNo);
		lblReceiptNo.setForeground(Color.DARK_GRAY);
		lblReceiptNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtRcptInfo = new JTextField();
		txtRcptInfo.setBounds(158, 785, 31, 20);
		frameReceiving.getContentPane().add(txtRcptInfo);
		txtRcptInfo.setForeground(Color.DARK_GRAY);
		txtRcptInfo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRcptInfo.setColumns(10);
		
		txtIdRcv = new JTextField();
		txtIdRcv.setForeground(Color.DARK_GRAY);
		txtIdRcv.setEditable(false);
		txtIdRcv.setColumns(10);
		txtIdRcv.setBounds(225, 753, 42, 20);
		frameReceiving.getContentPane().add(txtIdRcv);
		
		txtIdTrans = new JTextField();
		txtIdTrans.setForeground(Color.DARK_GRAY);
		txtIdTrans.setEditable(false);
		txtIdTrans.setColumns(10);
		txtIdTrans.setBounds(351, 691, 42, 20);
		frameReceiving.getContentPane().add(txtIdTrans);
		
		txtIdFa = new JTextField();
		txtIdFa.setForeground(Color.DARK_GRAY);
		txtIdFa.setEditable(false);
		txtIdFa.setColumns(10);
		txtIdFa.setBounds(351, 715, 42, 20);
		frameReceiving.getContentPane().add(txtIdFa);
		
		JLabel lblIdClass = new JLabel("Id Class");
		lblIdClass.setForeground(Color.DARK_GRAY);
		lblIdClass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdClass.setBounds(50, 709, 82, 14);
		frameReceiving.getContentPane().add(lblIdClass);
		
		JLabel lblIdBrand = new JLabel("Id Brand");
		lblIdBrand.setForeground(Color.DARK_GRAY);
		lblIdBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdBrand.setBounds(50, 737, 82, 14);
		frameReceiving.getContentPane().add(lblIdBrand);
		
		JLabel lblIdSupplier = new JLabel("Id Supplier");
		lblIdSupplier.setForeground(Color.DARK_GRAY);
		lblIdSupplier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdSupplier.setBounds(50, 756, 82, 14);
		frameReceiving.getContentPane().add(lblIdSupplier);
		
		JLabel lblIdEmp = new JLabel("Id Incharge");
		lblIdEmp.setForeground(Color.DARK_GRAY);
		lblIdEmp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdEmp.setBounds(171, 709, 82, 14);
		frameReceiving.getContentPane().add(lblIdEmp);
		
		JLabel lblIdLoc = new JLabel("Id Loc");
		lblIdLoc.setForeground(Color.DARK_GRAY);
		lblIdLoc.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdLoc.setBounds(171, 736, 82, 14);
		frameReceiving.getContentPane().add(lblIdLoc);
		
		JLabel lblIdRcv = new JLabel("Id Rcv");
		lblIdRcv.setForeground(Color.DARK_GRAY);
		lblIdRcv.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdRcv.setBounds(171, 756, 82, 14);
		frameReceiving.getContentPane().add(lblIdRcv);
		
		JLabel lblIdTrans = new JLabel("Id Trans");
		lblIdTrans.setForeground(Color.DARK_GRAY);
		lblIdTrans.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdTrans.setBounds(284, 708, 82, 14);
		frameReceiving.getContentPane().add(lblIdTrans);
		
		JLabel lblIdFa = new JLabel("Id Fa");
		lblIdFa.setForeground(Color.DARK_GRAY);
		lblIdFa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdFa.setBounds(284, 718, 82, 14);
		frameReceiving.getContentPane().add(lblIdFa);
		
		JLabel lblTrnsctnby = new JLabel("TrnsctnBy");
		lblTrnsctnby.setForeground(Color.DARK_GRAY);
		lblTrnsctnby.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblTrnsctnby.setBounds(284, 741, 82, 14);
		frameReceiving.getContentPane().add(lblTrnsctnby);
		
		
		
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(TableModel data, TableColumnModel column) {
		frameReceiving =  new JFrame();
		frameReceiving.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frameReceiving.setResizable(false);
		frameReceiving.setTitle("Receive Fixed Assets");
		frameReceiving.setBounds(100, 100, 689, 588);
		frameReceiving.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameReceiving.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("In-charge:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 472, 97, 17);
		frameReceiving.getContentPane().add(lblNewLabel);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.DARK_GRAY);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(350, 14, 85, 14);
		frameReceiving.getContentPane().add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBackground(Color.WHITE);
		txtDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtDate.setForeground(Color.DARK_GRAY);
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(457, 11, 199, 20);
		frameReceiving.getContentPane().add(txtDate);
		
		txtTrnsctnBy = new JTextField();
		txtTrnsctnBy.setEditable(false);
		txtTrnsctnBy.setBackground(Color.WHITE);
		txtTrnsctnBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTrnsctnBy.setForeground(Color.DARK_GRAY);
		txtTrnsctnBy.setColumns(10);
		txtTrnsctnBy.setBounds(351, 737, 42, 20);
		frameReceiving.getContentPane().add(txtTrnsctnBy);
		
		JButton btnReceive = new JButton("");
		btnReceive.setBackground(SystemColor.controlHighlight);
		btnReceive.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\receive_trans48x48.png"));
		btnReceive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mng1.assetStatus = cboStat.getSelectedItem().toString();
				if(txtRemarks.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input remarks.");
				}
				else
				{
					//Transaction
					mng1.addTransaction("receiving", 0, "", Integer.parseInt(txtIdTrans.getText()), "add", Integer.parseInt(txtIdRcv.getText()), txtRcvNo.getText(), txtDate.getText(), Integer.parseInt(txtTrnsctnBy.getText()), Integer.parseInt(txtIdLoc.getText()), Integer.parseInt(txtIdInCharge.getText()), 0, txtRemarks.getText(), mng1.assetStatus);
					
					//Receiving
					//mng1.manageTransactions("receiving", Integer.parseInt(txtIdRcv.getText()), txtRcvNo.getText(), Integer.parseInt(txtIdTrans.getText()), "", "", "", "", 0, 0, 0, "");
					mng1.restrictDuplicateInfo("receiving", Integer.parseInt(txtIdRcv.getText()), txtRcvNo.getText(), Integer.parseInt(txtIdTrans.getText()), "", "", "", "", 0, 0, 0,  txtRemarks.getText());

				}
				
			}
		});
		btnReceive.setBounds(320, 500, 50, 50);
		frameReceiving.getContentPane().add(btnReceive);
		
		JButton btnCancel = new JButton("");
		btnCancel.setBackground(SystemColor.controlHighlight);
		btnCancel.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\cancel_trans48x48.png"));
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel transaction", "Cancel", JOptionPane.YES_NO_OPTION);

				if (option == 0) { 
					mng1.manageFixedAsset("fixedasset_tmp", 0, "cancel", "", "", "", 0, 0, "", "", "", "", "", 0, "", 0, 0, "", "", 0, 0, "", "", Integer.parseInt(txtIdRcv.getText()));
					mng1.cancelTransactions("receiving", Integer.parseInt(txtIdRcv.getText()), "");
					mng1.cancelTransactions("transaction", 0, txtRcvNo.getText());
					
				    JOptionPane.showMessageDialog(null, "Transaction Cancelled.");
					
				    //generate new transNo
				    txtFaCode.setText((mng1.getTransNo("fixedasset", "0", "")));
					txtIdFa.setText(Integer.toString(mng1.getMaxId(0, "fixedAsset")));
					txtRcvNo.setText((mng1.getTransNo("receiving", "0", "")));
					txtIdTrans.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
					txtIdRcv.setText(Integer.toString(mng1.getMaxId(0, "receiving")));
				} else {
				   System.out.print("no");
				}
			}
		});
		btnCancel.setBounds(423, 500, 50, 50);
		frameReceiving.getContentPane().add(btnCancel);
		
		JLabel lblRemarks = new JLabel("Remarks:");
		lblRemarks.setForeground(Color.DARK_GRAY);
		lblRemarks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRemarks.setBounds(350, 471, 97, 14);
		frameReceiving.getContentPane().add(lblRemarks);
		
		txtRemarks = new JTextField();
		txtRemarks.setForeground(Color.DARK_GRAY);
		txtRemarks.setColumns(10);
		txtRemarks.setBounds(457, 469, 216, 20);
		frameReceiving.getContentPane().add(txtRemarks);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 39, 663, 2);
		frameReceiving.getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 459, 663, 2);
		frameReceiving.getContentPane().add(separator_1);
		
		JButton btnUpload = new JButton("Upload Photo");
		btnUpload.setForeground(Color.DARK_GRAY);
		btnUpload.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnUpload.setBounds(801, 671, 82, 23);
		frameReceiving.getContentPane().add(btnUpload);
		
		JTextArea txtimage = new JTextArea();
		txtimage.setForeground(new Color(0, 0, 139));
		txtimage.setBounds(791, 607, 107, 63);
		frameReceiving.getContentPane().add(txtimage);
		
		JButton btnView = new JButton("");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mng1.idEmpLog = Integer.parseInt(txtTrnsctnBy.getText());
				ViewAsset window = new ViewAsset();
				window.frameViewAsset.setVisible(true);
				window.txtTrnsctnBy.setText(Integer.toString(mng1.idEmpLog));
				
			}
		});
		btnView.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\view_trans48x48.png"));
		btnView.setBackground(SystemColor.controlHighlight);
		btnView.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				  if(arg0.getKeyCode() == KeyEvent.VK_V)
				        System.out.println("View");
			}
		});
		btnView.setBounds(371, 500, 50, 50);
		frameReceiving.getContentPane().add(btnView);
		
		cboInCharge = new JComboBox<String>();
		cboInCharge.setBackground(Color.WHITE);
		cboInCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Integer> mapInCharge = cbo.populateCbo("employee");
				txtIdInCharge.setText(mapInCharge.get(cboInCharge.getSelectedItem().toString()).toString());
			}
		});
		cboInCharge.setForeground(Color.DARK_GRAY);
		cboInCharge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboInCharge.setBounds(97, 469, 210, 20);
		frameReceiving.getContentPane().add(cboInCharge);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtRcvNo.setText((mng1.getTransNo("receiving", "0", "")));
				txtIdTrans.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
				txtIdRcv.setText(Integer.toString(mng1.getMaxId(0, "receiving")));
				
				//Disbled Fields
				txtProduct.setEnabled(true);
				txtProduct.setBackground(Color.WHITE);
				txtModel.setEnabled(true);
				txtModel.setBackground(Color.WHITE);
				txtLicense.setEnabled(true);
				txtLicense.setBackground(Color.WHITE);
				txtBarcode.setEnabled(true);
				txtBarcode.setBackground(Color.WHITE);
				txtSerialNo.setEnabled(true);
				txtSerialNo.setBackground(Color.WHITE);
				txtDesc.setEnabled(true);
				txtDesc.setBackground(Color.WHITE);
				txtDatePurchase.setEnabled(true);
				txtDatePurchase.setBackground(Color.WHITE);
				txtAssetLife.setEnabled(true);
				txtAssetLife.setBackground(Color.WHITE);
				txtCost.setEnabled(true);
				txtCost.setBackground(Color.WHITE);
				txtSalvageVal.setEnabled(true);
				txtSalvageVal.setBackground(Color.WHITE);
				txtDateWarranty.setEnabled(true);
				txtDateWarranty.setBackground(Color.WHITE);
				txtRemarks.setEnabled(true);
				txtRemarks.setBackground(Color.WHITE);
				//Disable Fields
			}
		});
		button.setBackground(SystemColor.controlHighlight);
		button.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new_trans48x48.png"));
		button.setBounds(270, 500, 50, 50);
		frameReceiving.getContentPane().add(button);
		
		JLabel lblReceivingNo = new JLabel("Transaction No:");
		lblReceivingNo.setForeground(Color.DARK_GRAY);
		lblReceivingNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReceivingNo.setBounds(10, 14, 107, 14);
		frameReceiving.getContentPane().add(lblReceivingNo);
		
		JPanel panelFa = new JPanel();
		panelFa.setBounds(10, 52, 663, 409);
		frameReceiving.getContentPane().add(panelFa);
		panelFa.setLayout(null);
		
		JLabel lblAssetCode = new JLabel("Asset Code:");
		lblAssetCode.setBounds(10, 15, 82, 14);
		panelFa.add(lblAssetCode);
		lblAssetCode.setForeground(Color.DARK_GRAY);
		lblAssetCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblLocation = new JLabel("Product:");
		lblLocation.setBounds(10, 43, 82, 14);
		panelFa.add(lblLocation);
		lblLocation.setForeground(Color.DARK_GRAY);
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCategory = new JLabel("Classification:");
		lblCategory.setBounds(10, 71, 82, 14);
		panelFa.add(lblCategory);
		lblCategory.setForeground(Color.DARK_GRAY);
		lblCategory.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblModel = new JLabel("Model:");
		lblModel.setBounds(10, 100, 82, 14);
		panelFa.add(lblModel);
		lblModel.setForeground(Color.DARK_GRAY);
		lblModel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setBounds(10, 128, 82, 14);
		panelFa.add(lblBrand);
		lblBrand.setForeground(Color.DARK_GRAY);
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblManufacturer = new JLabel("Manufacturer:");
		lblManufacturer.setBounds(10, 156, 82, 14);
		panelFa.add(lblManufacturer);
		lblManufacturer.setForeground(Color.DARK_GRAY);
		lblManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblLicense = new JLabel("License:");
		lblLicense.setBounds(10, 184, 82, 14);
		panelFa.add(lblLicense);
		lblLicense.setForeground(Color.DARK_GRAY);
		lblLicense.setFont(new Font("Tahoma", Font.PLAIN, 13));
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				mng1.i = table.getSelectedRow();
				mng1.faCode = model.getValueAt(mng1.i, 0).toString();
				mng1.product = model.getValueAt(mng1.i, 1).toString();
				mng1.model = model.getValueAt(mng1.i, 2).toString();
				mng1.brand = model.getValueAt(mng1.i, 3).toString();
				mng1.classification = model.getValueAt(mng1.i, 4).toString();
				mng1.manufacturer = model.getValueAt(mng1.i, 5).toString();
				mng1.license = model.getValueAt(mng1.i, 6).toString();
				mng1.serialNo = model.getValueAt(mng1.i, 7).toString();
				mng1.barcode = model.getValueAt(mng1.i, 8).toString();
				mng1.description = model.getValueAt(mng1.i, 9).toString();
				mng1.supplier = model.getValueAt(mng1.i, 10).toString();
				mng1.location = model.getValueAt(mng1.i, 11).toString();
				mng1.cost = Double.parseDouble((String) model.getValueAt(mng1.i, 12));
				mng1.assetLife = Integer.parseInt((String) model.getValueAt(mng1.i, 13));
				mng1.salvageVal = Double.parseDouble((String) model.getValueAt(mng1.i, 14));
				mng1.datePurchase = model.getValueAt(mng1.i, 15).toString();
				mng1.dateWarranty = model.getValueAt(mng1.i, 16).toString();
				mng1.idfa = Integer.parseInt(model.getValueAt(mng1.i, 17).toString());
				mng1.idClass = Integer.parseInt(model.getValueAt(mng1.i, 18).toString());
				mng1.idBrand = Integer.parseInt(model.getValueAt(mng1.i, 19).toString());
				mng1.idSupplier = Integer.parseInt(model.getValueAt(mng1.i, 20).toString());
				mng1.idDept = Integer.parseInt(model.getValueAt(mng1.i, 21).toString());
				
				
				txtIdFa.setText(Integer.toString(mng1.idfa));
				txtFaCode.setText(mng1.faCode);
				txtProduct.setText(mng1.product);
				txtIdClass.setText(Integer.toString(mng1.idClass));
				txtModel.setText(mng1.model);
				txtIdBrand.setText(Integer.toString(mng1.idBrand));
				txtManufacturer.setText(mng1.manufacturer);
				txtLicense.setText(mng1.license);
				txtBarcode.setText(mng1.barcode);
				txtSerialNo.setText(mng1.serialNo);
				txtDesc.setText(mng1.description);
				txtDatePurchase.setText(mng1.datePurchase);
				txtDateWarranty.setText(mng1.dateWarranty);
				txtAssetLife.setText(Integer.toString(mng1.assetLife));
				txtCost.setText(Double.toString(mng1.cost));
				txtSalvageVal.setText(Double.toString(mng1.salvageVal));
				
				
			}
		});
		table.setModel(model);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		pane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		pane.setBounds(10, 300, 646, 98);
		pane.setPreferredSize(new Dimension(700, 300));
		panelFa.add(pane);
		
		
		
		
		txtLicense = new JTextField();
		txtLicense.setBounds(108, 181, 199, 20);
		panelFa.add(txtLicense);
		txtLicense.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLicense.setForeground(Color.DARK_GRAY);
		txtLicense.setColumns(10);
		
		txtManufacturer = new JTextField();
		txtManufacturer.setBounds(108, 153, 199, 20);
		panelFa.add(txtManufacturer);
		txtManufacturer.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtManufacturer.setForeground(Color.DARK_GRAY);
		txtManufacturer.setColumns(10);
		
		cboBrand = new JComboBox<String>();
		cboBrand.setBackground(Color.WHITE);
		cboBrand.setBounds(108, 125, 199, 20);
		panelFa.add(cboBrand);
		cboBrand.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboBrand.setForeground(Color.DARK_GRAY);
		
		txtModel = new JTextField();
		txtModel.setBounds(108, 97, 199, 20);
		panelFa.add(txtModel);
		txtModel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtModel.setForeground(Color.DARK_GRAY);
		txtModel.setColumns(10);
		
		cboClass = new JComboBox<String>();
		cboClass.setBackground(Color.WHITE);
		cboClass.setBounds(108, 68, 199, 20);
		panelFa.add(cboClass);
		cboClass.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboClass.setForeground(Color.DARK_GRAY);
		cboClass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Integer> mapClass = cbo.populateCbo("classification");
				txtIdClass.setText(mapClass.get(cboClass.getSelectedItem().toString()).toString());
			}
		});
		cboClass.setToolTipText("");
		
		txtProduct = new JTextField();
		txtProduct.setBounds(108, 40, 199, 20);
		panelFa.add(txtProduct);
		txtProduct.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtProduct.setForeground(Color.DARK_GRAY);
		txtProduct.setColumns(10);
		
		txtFaCode = new JTextField();
		txtFaCode.setBackground(Color.WHITE);
		txtFaCode.setBounds(108, 12, 199, 20);
		panelFa.add(txtFaCode);
		txtFaCode.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtFaCode.setForeground(Color.DARK_GRAY);
		txtFaCode.setEditable(false);
		txtFaCode.setColumns(10);
		
		JLabel lblBarcode = new JLabel("Barcode:");
		lblBarcode.setBounds(10, 209, 63, 14);
		panelFa.add(lblBarcode);
		lblBarcode.setForeground(Color.DARK_GRAY);
		lblBarcode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblSerialNumber = new JLabel("Serial No:");
		lblSerialNumber.setBounds(337, 9, 82, 14);
		panelFa.add(lblSerialNumber);
		lblSerialNumber.setForeground(Color.DARK_GRAY);
		lblSerialNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDescription = new JLabel("Description:");
		lblDescription.setBounds(337, 38, 98, 14);
		panelFa.add(lblDescription);
		lblDescription.setForeground(Color.DARK_GRAY);
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblCost = new JLabel("Cost:");
		lblCost.setBounds(337, 124, 98, 14);
		panelFa.add(lblCost);
		lblCost.setForeground(Color.DARK_GRAY);
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(337, 179, 98, 14);
		panelFa.add(lblStatus);
		lblStatus.setForeground(Color.DARK_GRAY);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnNewProd = new JButton("");
		btnNewProd.setBounds(218, 262, 50, 34);
		panelFa.add(btnNewProd);
		btnNewProd.setBackground(SystemColor.controlHighlight);
		btnNewProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtFaCode.setText((mng1.getTransNo("fixedasset", "0", "")));
				txtIdFa.setText(Integer.toString(mng1.getMaxId(0, "fixedAsset")));
				txtRcvNo.setText((mng1.getTransNo("receiving", "0", "")));
				txtIdTrans.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
				txtIdRcv.setText(Integer.toString(mng1.getMaxId(0, "receiving")));
				
				txtProduct.setText("");
				txtModel.setText("");
				txtManufacturer.setText("");
				txtLicense.setText("");
				txtRcptInfo.setText("");
				txtCost.setText("");
				txtBarcode.setText("");
				txtSerialNo.setText("");
				txtAssetLife.setText("");
				txtSalvageVal.setText("");
				txtDatePurchase.setText("0000-00-00");
				txtDateWarranty.setText("0000-00-00");

			}
		});
		btnNewProd.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new_prod32x32.png"));
		
		JButton btnAddProd = new JButton("");
		btnAddProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtProduct.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input product name.");
				}
				else if(txtModel.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input model.");
				}
				else if(txtManufacturer.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input manufacturer.");
				}
				else if(txtSerialNo.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input serial number.");
				}
				else if(txtCost.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input product cost.");
				}
				else
				{
					//save @ table fixedassset_tmp	
					mng1.manageFixedAsset("fixedasset_tmp", Integer.parseInt(txtIdFa.getText()), "add", txtFaCode.getText(), mng1.getDateNow(), txtProduct.getText(), Integer.parseInt(txtIdClass.getText()), Integer.parseInt(txtIdBrand.getText()), txtManufacturer.getText(), txtLicense.getText(), txtModel.getText(), txtSerialNo.getText(), txtBarcode.getText(), Double.parseDouble(txtCost.getText()), txtDesc.getText(), Integer.parseInt(txtIdSupplier.getText()), Integer.parseInt(txtIdLoc.getText()), mng1.getDateNow(), txtRcptInfo.getText(), Integer.parseInt(txtAssetLife.getText()), Integer.parseInt(txtSalvageVal.getText()), txtDatePurchase.getText(), txtDateWarranty.getText(), Integer.parseInt(txtIdRcv.getText()));
					viewRcvTrans();
				}
				
				//viewBrand();
			}
		});
		btnAddProd.setBounds(268, 262, 50, 34);
		panelFa.add(btnAddProd);
		btnAddProd.setBackground(SystemColor.controlHighlight);
		btnAddProd.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\add_prod32x32.png"));
		
		JButton btnEditProd = new JButton("");
		btnEditProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mng1.manageFixedAsset("fixedasset_tmp", Integer.parseInt(txtIdFa.getText()), "edit", txtFaCode.getText(), mng1.getDateNow(), txtProduct.getText(), Integer.parseInt(txtIdClass.getText()), Integer.parseInt(txtIdBrand.getText()), txtManufacturer.getText(), txtLicense.getText(), txtModel.getText(), txtSerialNo.getText(), txtBarcode.getText(), Double.parseDouble(txtCost.getText()), txtDesc.getText(), Integer.parseInt(txtIdSupplier.getText()), Integer.parseInt(txtIdLoc.getText()), mng1.getDateNow(), txtRcptInfo.getText(), Integer.parseInt(txtAssetLife.getText()), Double.parseDouble(txtSalvageVal.getText()), txtDatePurchase.getText(), txtDateWarranty.getText(), Integer.parseInt(txtIdRcv.getText()));
				viewRcvTrans();
			}
		});
		btnEditProd.setBounds(319, 262, 50, 34);
		panelFa.add(btnEditProd);
		btnEditProd.setBackground(SystemColor.controlHighlight);
		btnEditProd.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\edit_prod32x32.png"));
		
		JButton btnDelProd = new JButton("");
		btnDelProd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mng1.manageFixedAsset("fixedasset_tmp", Integer.parseInt(txtIdFa.getText()), "delete", txtFaCode.getText(), mng1.getDateNow(), txtProduct.getText(), Integer.parseInt(txtIdClass.getText()), Integer.parseInt(txtIdBrand.getText()), txtManufacturer.getText(), txtLicense.getText(), txtModel.getText(), txtSerialNo.getText(), txtBarcode.getText(), Double.parseDouble(txtCost.getText()), txtDesc.getText(), Integer.parseInt(txtIdSupplier.getText()), Integer.parseInt(txtIdLoc.getText()), mng1.getDateNow(), txtRcptInfo.getText(), Integer.parseInt(txtAssetLife.getText()), Double.parseDouble(txtSalvageVal.getText()), txtDatePurchase.getText(), txtDateWarranty.getText(), Integer.parseInt(txtIdRcv.getText()));
				viewRcvTrans();
			}
		});
		btnDelProd.setBounds(369, 262, 50, 34);
		panelFa.add(btnDelProd);
		btnDelProd.setBackground(SystemColor.controlHighlight);
		btnDelProd.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\del_prod32x32.png"));
		
		cboStat = new JComboBox<String>();
		cboStat.setBackground(Color.WHITE);
		cboStat.setModel(new DefaultComboBoxModel<String>(new String[] {"Brand New", "Second Hand"}));
		cboStat.setBounds(445, 173, 211, 20);
		panelFa.add(cboStat);
		cboStat.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboStat.setForeground(Color.DARK_GRAY);
		
		txtCost = new JTextField();
		txtCost.setBounds(445, 118, 211, 20);
		panelFa.add(txtCost);
		txtCost.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtCost.setForeground(Color.DARK_GRAY);
		txtCost.setColumns(10);
		
		txtSerialNo = new JTextField();
		txtSerialNo.setBounds(445, 9, 208, 20);
		panelFa.add(txtSerialNo);
		txtSerialNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSerialNo.setForeground(Color.DARK_GRAY);
		txtSerialNo.setColumns(10);
		
		txtBarcode = new JTextField();
		txtBarcode.setBounds(108, 209, 199, 20);
		panelFa.add(txtBarcode);
		txtBarcode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtBarcode.setForeground(Color.DARK_GRAY);
		txtBarcode.setColumns(10);
		cboStat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mng1.status = (String)cboStat.getSelectedItem();
				System.out.println(mng1.status);
			}
		});
		cboBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Integer> mapBrand = cbo.populateCbo("brand");
				txtIdBrand.setText(mapBrand.get(cboBrand.getSelectedItem().toString()).toString());
			}
		});
		
		txtRcvNo = new JTextField();
		txtRcvNo.setBackground(Color.WHITE);
		txtRcvNo.setForeground(Color.DARK_GRAY);
		txtRcvNo.setFont(new Font("Tahoma", Font.BOLD, 12));
		txtRcvNo.setEditable(false);
		txtRcvNo.setColumns(10);
		txtRcvNo.setBounds(117, 11, 199, 20);
		frameReceiving.getContentPane().add(txtRcvNo);
		
		txtIdClass = new JTextField();
		txtIdClass.setEditable(false);
		txtIdClass.setForeground(Color.DARK_GRAY);
		txtIdClass.setColumns(10);
		txtIdClass.setBounds(115, 706, 42, 20);
		frameReceiving.getContentPane().add(txtIdClass);
		
		txtIdBrand = new JTextField();
		txtIdBrand.setForeground(Color.DARK_GRAY);
		txtIdBrand.setEditable(false);
		txtIdBrand.setColumns(10);
		txtIdBrand.setBounds(115, 730, 42, 20);
		frameReceiving.getContentPane().add(txtIdBrand);
		
		txtIdSupplier = new JTextField();
		txtIdSupplier.setForeground(Color.DARK_GRAY);
		txtIdSupplier.setEditable(false);
		txtIdSupplier.setColumns(10);
		txtIdSupplier.setBounds(115, 753, 42, 20);
		frameReceiving.getContentPane().add(txtIdSupplier);
		
		txtIdInCharge = new JTextField();
		txtIdInCharge.setForeground(Color.DARK_GRAY);
		txtIdInCharge.setEditable(false);
		txtIdInCharge.setColumns(10);
		txtIdInCharge.setBounds(225, 706, 42, 20);
		frameReceiving.getContentPane().add(txtIdInCharge);
		
		txtIdLoc = new JTextField();
		txtIdLoc.setForeground(Color.DARK_GRAY);
		txtIdLoc.setEditable(false);
		txtIdLoc.setColumns(10);
		txtIdLoc.setBounds(225, 730, 42, 20);
		frameReceiving.getContentPane().add(txtIdLoc);
		
		table.setBackground(new Color(240, 240, 240));
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(20);
		
		txtDesc = new JTextField();
		txtDesc.setForeground(Color.DARK_GRAY);
		txtDesc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDesc.setColumns(10);
		txtDesc.setBounds(445, 34, 211, 22);
		panelFa.add(txtDesc);
		
		JLabel lblAssetLife = new JLabel("Salvage Value:");
		lblAssetLife.setForeground(Color.DARK_GRAY);
		lblAssetLife.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAssetLife.setBounds(337, 148, 98, 14);
		panelFa.add(lblAssetLife);
		
		txtSalvageVal = new JTextField();
		txtSalvageVal.setForeground(Color.DARK_GRAY);
		txtSalvageVal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSalvageVal.setColumns(10);
		txtSalvageVal.setBounds(445, 144, 211, 22);
		panelFa.add(txtSalvageVal);
		
		JLabel lblAsset = new JLabel("Asset Life:");
		lblAsset.setForeground(Color.DARK_GRAY);
		lblAsset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAsset.setBounds(337, 96, 98, 14);
		panelFa.add(lblAsset);
		
		JLabel lblDatePurchase = new JLabel("Date Purchase:");
		lblDatePurchase.setForeground(Color.DARK_GRAY);
		lblDatePurchase.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDatePurchase.setBounds(337, 65, 98, 14);
		panelFa.add(lblDatePurchase);
		
		txtAssetLife = new JTextField();
		txtAssetLife.setForeground(Color.DARK_GRAY);
		txtAssetLife.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAssetLife.setColumns(10);
		txtAssetLife.setBounds(445, 90, 211, 20);
		panelFa.add(txtAssetLife);
		
		txtDatePurchase = new JTextField();
		txtDatePurchase.setText("0000-00-00");
		txtDatePurchase.setBounds(445, 62, 211, 20);
		panelFa.add(txtDatePurchase);
		txtDatePurchase.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDatePurchase.setForeground(Color.DARK_GRAY);
		txtDatePurchase.setColumns(10);
		
		JLabel lblSupplier = new JLabel("Supplier:");
		lblSupplier.setBounds(337, 209, 82, 14);
		panelFa.add(lblSupplier);
		lblSupplier.setForeground(Color.DARK_GRAY);
		lblSupplier.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cboSupplier = new JComboBox<String>();
		cboSupplier.setBounds(446, 203, 210, 20);
		panelFa.add(cboSupplier);
		cboSupplier.setBackground(Color.WHITE);
		cboSupplier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboSupplier.setForeground(Color.DARK_GRAY);
		
		JLabel lblWarranty = new JLabel("Warranty Exp.");
		lblWarranty.setBounds(337, 237, 89, 14);
		panelFa.add(lblWarranty);
		lblWarranty.setForeground(Color.DARK_GRAY);
		lblWarranty.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtDateWarranty = new JTextField();
		txtDateWarranty.setBounds(447, 234, 209, 20);
		panelFa.add(txtDateWarranty);
		txtDateWarranty.setText("0000-00-00");
		txtDateWarranty.setForeground(Color.DARK_GRAY);
		txtDateWarranty.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDateWarranty.setColumns(10);
		
		JLabel lblLocation_1 = new JLabel("Location:");
		lblLocation_1.setBounds(10, 237, 65, 14);
		panelFa.add(lblLocation_1);
		lblLocation_1.setForeground(Color.DARK_GRAY);
		lblLocation_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		cboLoc = new JComboBox<String>();
		cboLoc.setBounds(108, 234, 199, 20);
		panelFa.add(cboLoc);
		cboLoc.setBackground(Color.WHITE);
		cboLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<String, Integer> mapDept = cbo.populateCbo("department");
				txtIdLoc.setText(mapDept.get(cboLoc.getSelectedItem().toString()).toString());
			}
		});
		cboLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboLoc.setForeground(Color.DARK_GRAY);
		cboSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Integer> mapSupplier = cbo.populateCbo("supplier");
				txtIdSupplier.setText(mapSupplier.get(cboSupplier.getSelectedItem().toString()).toString());
			}
		});
	}//end initialize
	
	public void bindCbo()
	{
		HashMap<String, Integer> mapClass = cbo.populateCbo("classification");
		for(String s : mapClass.keySet())
		{
			cboClass.addItem(s);
		}
		
		HashMap<String, Integer> mapBrand = cbo.populateCbo("brand");
		for(String s : mapBrand.keySet())
		{
			cboBrand.addItem(s);
		}
		
		HashMap<String, Integer> mapDept = cbo.populateCbo("department");
		for(String s : mapDept.keySet())
		{
			cboLoc.addItem(s);
		}
		
		HashMap<String, Integer> mapSupplier = cbo.populateCbo("supplier");
		for(String s : mapSupplier.keySet())
		{
			cboSupplier.addItem(s);
		}
		
		HashMap<String, Integer> mapEmp = cbo.populateCbo("employee");
		for(String s : mapEmp.keySet())
		{
			cboInCharge.addItem(s);
		}
	}
	
	public void viewRcvTrans(){
		model.setRowCount(0);
		try
		{
			mng1.st = mng1.con.createStatement();
			/*mng1.rs = mng1.st.executeQuery("SELECT * FROM fixedasset_tmp fa"
					+ " LEFT JOIN classification c On c.idClass=fa.idClass"
					+ " LEFT JOIN brand b ON b.idBrand=fa.idBrand"
					+ " LEFT JOIN supplier s ON s.idSupplier=fa.idSupplier"
					+ " LEFT JOIN department d ON d.idDept=fa.currLoc"
					+ " WHERE fa.idRcv='"+ txtIdRcv.getText() +"'"
					+ " ORDER BY fa.faCode");*/
			mng1.rs = mng1.st.executeQuery("SELECT IFNULL(fa.faCode, '') As faCode, IFNULL(fa.product, '') As product, IFNULL(fa.model, '') As model,"
					+ " IFNULL(b.brand, '') As brand, IFNULL(c.classification, '') As classification, IFNULL(fa.manufacturer, '') As manufacturer,"
					+ " IFNULL(fa.license, '') As license, IFNULL(fa.serialNo, '') As serialNo, IFNULL(fa.barcode, '') As barcode,"
					+ " IFNULL(fa.description, '') As description, IFNULL(s.supplier, '') As supplier, IFNULL(d.department, '') As department,"
					+ " IFNULL(fa.cost, 0) As cost, IFNULL(fa.assetLife, 0) As assetLife, IFNULL(fa.salvageVal, 0) As salvageVal,"
					+ " IFNULL(fa.datePurchase, '0000-00-00') As datePurchase, IFNULL(fa.dateWarranty, '0000-00-00') As dateWarranty,"
					+ " IFNULL(fa.idfa, 0) As idfa, IFNULL(fa.idClass, 0) As idClass, IFNULL(fa.idBrand, 0) As idBrand," 
					+ " IFNULL(fa.idSupplier, 0) As idSupplier, IFNULL(fa.currLoc, 0) As currLoc"
					+ " FROM fixedasset_tmp fa"
					+ " LEFT JOIN classification c On c.idClass=fa.idClass"
					+ " LEFT JOIN brand b ON b.idBrand=fa.idBrand"
					+ " LEFT JOIN supplier s ON s.idSupplier=fa.idSupplier"
					+ " LEFT JOIN department d ON d.idDept=fa.currLoc"
					+ " WHERE fa.idRcv='"+ txtIdRcv.getText() +"'"
					+ " ORDER BY fa.faCode");
			
			model.rowsRemoved(null);;
			while(mng1.rs.next()){			
			
					Object[] row = new Object[1000];
					row[0] = mng1.rs.getString("faCode");
					row[1] = mng1.rs.getString("product");
					row[2] = mng1.rs.getString("model");
					row[3] = mng1.rs.getString("brand");
					row[4] = mng1.rs.getString("classification");
					row[5] = mng1.rs.getString("manufacturer");
					row[6] = mng1.rs.getString("license");
					row[7] = mng1.rs.getString("serialNo");
					row[8] = mng1.rs.getString("barcode");
					row[9] = mng1.rs.getString("description");
					row[10] = mng1.rs.getString("supplier");
					row[11] = mng1.rs.getString("department");
					row[12] = mng1.rs.getString("cost");
					row[13] = mng1.rs.getString("assetLife");
					row[14] = mng1.rs.getString("salvageVal");
					row[15] = mng1.rs.getString("datePurchase");
					row[16] = mng1.rs.getString("dateWarranty");
					row[17] = mng1.rs.getString("idfa");
					row[18] = mng1.rs.getString("idClass");
					row[19] = mng1.rs.getString("idBrand");
					row[20] = mng1.rs.getString("idSupplier");
					row[21] = mng1.rs.getString("currLoc");
					
					model.addRow(row);
				
			}
		
		}catch(Exception e)
		{
			System.out.println(e);
			
		}finally
		{
			try
			{
				mng1.st.close();
			}catch(Exception er)
			{
				System.out.println("Error at viewBrand() " + er);
			}
		}//end final try catch
	}//end viewBrand
}//end class
