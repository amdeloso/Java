package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.ImageIcon;
import functions.CboItem;
import functions.FcnDbConnect;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class Transfer {
	FcnDbConnect mng1;
	CboItem cbo;
	ViewAsset viewfa;
	
	public JFrame frameTransfer;
	
	//Cbo
	public JComboBox<String> cboInCharge, cboLoc, cboReceivedBy, cboApprovedBy;
	private JTextField txtIdLoc;
	public JTextField txtIdInCharge;
	private JTextField txtIdRcvdBy;
	private JTextField txtIdApprvdBy;
	private JTextField txtTransferNo;
	private JTextField txtIdTransfer;
	private JTextField txtIdTrnsctn;
	public JTextField txtTrnsctnBy;
	public JTextField txtIdFa;
	public JTextField txtFaCode;
	private JTextField txtDate;
	private JTextField txtRemarks;
	public JTextField txtAsset;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Transfer window = new Transfer();
					window.frameTransfer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Transfer() {
		mng1 = new FcnDbConnect();
		cbo = new CboItem(0,"");
		
		initialize();
		
		bindCbo();
		txtDate.setText(mng1.getDateNow());
		
		JButton btnView = new JButton("");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				ReportViewHistory window = new ReportViewHistory();
				window.frameReportViewHistory.setVisible(true);
				
			}
		});
		btnView.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\view32x32.png"));
		btnView.setBackground(SystemColor.controlHighlight);
		btnView.setBounds(355, 152, 45, 45);
		frameTransfer.getContentPane().add(btnView);
		
		txtIdTransfer = new JTextField();
		txtIdTransfer.setForeground(new Color(0, 0, 128));
		txtIdTransfer.setEditable(false);
		txtIdTransfer.setColumns(10);
		txtIdTransfer.setBounds(151, 314, 46, 20);
		frameTransfer.getContentPane().add(txtIdTransfer);
		
		JLabel lblIdTransfer = new JLabel("ID Transfer");
		lblIdTransfer.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdTransfer.setBounds(67, 317, 84, 14);
		frameTransfer.getContentPane().add(lblIdTransfer);
		
		JLabel lblIdIncharge = new JLabel("ID InCharge");
		lblIdIncharge.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdIncharge.setBounds(67, 341, 84, 14);
		frameTransfer.getContentPane().add(lblIdIncharge);
		
		JLabel lblIdTrnsctn = new JLabel("ID Trnsctn");
		lblIdTrnsctn.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdTrnsctn.setBounds(67, 370, 84, 14);
		frameTransfer.getContentPane().add(lblIdTrnsctn);
		
		txtIdTrnsctn = new JTextField();
		txtIdTrnsctn.setForeground(new Color(0, 0, 128));
		txtIdTrnsctn.setEditable(false);
		txtIdTrnsctn.setColumns(10);
		txtIdTrnsctn.setBounds(151, 364, 46, 20);
		frameTransfer.getContentPane().add(txtIdTrnsctn);
		
		JLabel lblReceivedBy = new JLabel("ID Received");
		lblReceivedBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReceivedBy.setBounds(207, 339, 84, 14);
		frameTransfer.getContentPane().add(lblReceivedBy);
		
		JLabel lblApprovedBy_1 = new JLabel("ID Approved");
		lblApprovedBy_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApprovedBy_1.setBounds(207, 364, 84, 14);
		frameTransfer.getContentPane().add(lblApprovedBy_1);
		
		JLabel lblLocation = new JLabel("ID Location");
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocation.setBounds(207, 389, 84, 14);
		frameTransfer.getContentPane().add(lblLocation);
		
		txtTrnsctnBy = new JTextField();
		txtTrnsctnBy.setForeground(new Color(0, 0, 128));
		txtTrnsctnBy.setEditable(false);
		txtTrnsctnBy.setColumns(10);
		txtTrnsctnBy.setBounds(151, 389, 46, 20);
		frameTransfer.getContentPane().add(txtTrnsctnBy);
		
		JLabel lblIdTrnsctnBy = new JLabel("ID Trnsctn By");
		lblIdTrnsctnBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdTrnsctnBy.setBounds(67, 395, 84, 14);
		frameTransfer.getContentPane().add(lblIdTrnsctnBy);
		
		JButton btnFixedAsset = new JButton("");
		btnFixedAsset.setBackground(SystemColor.controlHighlight);
		btnFixedAsset.setBounds(383, 345, 45, 45);
		frameTransfer.getContentPane().add(btnFixedAsset);
		
		txtIdFa = new JTextField();
		txtIdFa.setForeground(new Color(0, 0, 128));
		txtIdFa.setEditable(false);
		txtIdFa.setColumns(10);
		txtIdFa.setBounds(293, 314, 46, 20);
		frameTransfer.getContentPane().add(txtIdFa);
		
		JLabel lblIdFa = new JLabel("ID FA");
		lblIdFa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdFa.setBounds(207, 314, 84, 20);
		frameTransfer.getContentPane().add(lblIdFa);
		
		
	
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameTransfer = new JFrame();
		frameTransfer.setTitle("Transfer Fixed Asset");
		frameTransfer.setResizable(false);
		frameTransfer.setBounds(100, 100, 672, 232);
		frameTransfer.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameTransfer.getContentPane().setLayout(null);
		
		JLabel lblAssetCode = new JLabel("Asset Code:");
		lblAssetCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAssetCode.setBounds(10, 53, 84, 14);
		frameTransfer.getContentPane().add(lblAssetCode);
		
		txtFaCode = new JTextField();
		txtFaCode.setBackground(Color.WHITE);
		txtFaCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFaCode.setEditable(false);
		txtFaCode.setForeground(Color.DARK_GRAY);
		txtFaCode.setBounds(115, 50, 192, 20);
		frameTransfer.getContentPane().add(txtFaCode);
		txtFaCode.setColumns(10);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblDate.setBounds(360, 17, 99, 14);
		frameTransfer.getContentPane().add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setBackground(Color.WHITE);
		txtDate.setEditable(false);
		txtDate.setForeground(Color.DARK_GRAY);
		txtDate.setColumns(10);
		txtDate.setBounds(464, 14, 192, 20);
		frameTransfer.getContentPane().add(txtDate);
		
		JLabel label = new JLabel("Person in-charge:");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 92, 107, 20);
		frameTransfer.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Location:");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(10, 123, 107, 14);
		frameTransfer.getContentPane().add(label_1);
		
		cboLoc = new JComboBox<String>();
		cboLoc.setBackground(Color.WHITE);
		cboLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Integer> map = cbo.populateCbo("department");
				txtIdLoc.setText(map.get(cboLoc.getSelectedItem().toString()).toString()); 
			}
		});
		cboLoc.setForeground(Color.DARK_GRAY);
		cboLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboLoc.setBounds(115, 120, 192, 20);
		frameTransfer.getContentPane().add(cboLoc);
		
		JLabel label_3 = new JLabel("Remarks:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(360, 123, 98, 14);
		frameTransfer.getContentPane().add(label_3);
		
		txtRemarks = new JTextField();
		txtRemarks.setBackground(Color.WHITE);
		txtRemarks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRemarks.setForeground(Color.DARK_GRAY);
		txtRemarks.setColumns(10);
		txtRemarks.setBounds(464, 117, 192, 20);
		frameTransfer.getContentPane().add(txtRemarks);
		
		JButton btnTransfer = new JButton("");
		btnTransfer.setBackground(SystemColor.controlHighlight);
		btnTransfer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtTransferNo.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "Please press New Button to generate the Transfer Number.");
				}
				else if(txtFaCode.getText().length() == 0)
				{
					JOptionPane.showMessageDialog(null, "Please specify the fixed asset.");
				}
				else
				{
				
					mng1.addTransaction("transfer", Integer.parseInt(txtIdFa.getText()), txtFaCode.getText(),Integer.parseInt(txtIdTrnsctn.getText()), "add", Integer.parseInt(txtIdTransfer.getText()), txtTransferNo.getText(), txtDate.getText(), Integer.parseInt(txtTrnsctnBy.getText()), Integer.parseInt(txtIdLoc.getText()), Integer.parseInt(txtIdInCharge.getText()), Integer.parseInt(txtIdApprvdBy.getText()),txtRemarks.getText(), "done");
										
					mng1.restrictDuplicateInfo("transfer", Integer.parseInt(txtIdTransfer.getText()), txtTransferNo.getText(), Integer.parseInt(txtIdTrnsctn.getText()), txtDate.getText(), "", "", "", Integer.parseInt(txtIdInCharge.getText()), Integer.parseInt(txtIdApprvdBy.getText()), 0, txtRemarks.getText());

				}
				
			}
		});
		btnTransfer.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		btnTransfer.setBounds(314, 152, 40, 45);
		frameTransfer.getContentPane().add(btnTransfer);
		
		JButton tbnCancel = new JButton("");
		tbnCancel.setBackground(SystemColor.controlHighlight);
		tbnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel transaction", "Cancel", JOptionPane.YES_NO_OPTION);

				if (option == 0) { 
					mng1.cancelTransactions("transfer", Integer.parseInt(txtIdTransfer.getText()), txtTransferNo.getText());
					mng1.cancelTransactions("transaction", Integer.parseInt(txtIdTransfer.getText()), txtTransferNo.getText());
					
				    JOptionPane.showMessageDialog(null, "Transaction Cancelled.");
					
				    //generate new transNo
				    clearFields();
				    
				    txtIdTrnsctn.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
					txtIdTransfer.setText(Integer.toString(mng1.getMaxId(0, "transfer")));
					txtTransferNo.setText(mng1.getTransNo("transfer", "0", ""));
					
					
					
				} else {
				   System.out.print("no");
				}
				
				
			}
		});
		tbnCancel.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\cancel32x32.png"));
		tbnCancel.setBounds(401, 152, 45, 45);
		frameTransfer.getContentPane().add(tbnCancel);
		
		JLabel lblItem = new JLabel("Asset:");
		lblItem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblItem.setBounds(360, 50, 99, 14);
		frameTransfer.getContentPane().add(lblItem);
		
		txtAsset = new JTextField();
		txtAsset.setBackground(Color.WHITE);
		txtAsset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAsset.setEditable(false);
		txtAsset.setForeground(Color.DARK_GRAY);
		txtAsset.setColumns(10);
		txtAsset.setBounds(464, 47, 192, 20);
		frameTransfer.getContentPane().add(txtAsset);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 76, 646, 5);
		frameTransfer.getContentPane().add(separator);
		
		JLabel lblApprovedBy = new JLabel("Approved by:");
		lblApprovedBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApprovedBy.setBounds(360, 95, 107, 14);
		frameTransfer.getContentPane().add(lblApprovedBy);
		
		cboApprovedBy = new JComboBox<String>();
		cboApprovedBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Integer> map = cbo.populateCbo("employee");
				txtIdApprvdBy.setText(map.get(cboApprovedBy.getSelectedItem().toString()).toString()); 
			}
		});
		cboApprovedBy.setBackground(Color.WHITE);
		cboApprovedBy.setForeground(Color.DARK_GRAY);
		cboApprovedBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboApprovedBy.setBounds(464, 92, 193, 20);
		frameTransfer.getContentPane().add(cboApprovedBy);
		
		cboInCharge = new JComboBox<String>();
		cboInCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Integer> map = cbo.populateCbo("employee");
				txtIdInCharge.setText(map.get(cboInCharge.getSelectedItem().toString()).toString()); 
			}
		});
		cboInCharge.setBackground(Color.WHITE);
		cboInCharge.setForeground(Color.DARK_GRAY);
		cboInCharge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboInCharge.setBounds(115, 89, 192, 20);
		frameTransfer.getContentPane().add(cboInCharge);
		
		cboReceivedBy = new JComboBox<String>();
		cboReceivedBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HashMap<String, Integer> map = cbo.populateCbo("employee");
				txtIdRcvdBy.setText(map.get(cboReceivedBy.getSelectedItem().toString()).toString()); 
			}
		});
		cboReceivedBy.setBackground(Color.WHITE);
		cboReceivedBy.setForeground(Color.DARK_GRAY);
		cboReceivedBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboReceivedBy.setBounds(382, 313, 46, 20);
		frameTransfer.getContentPane().add(cboReceivedBy);
		
		txtIdLoc = new JTextField();
		txtIdLoc.setForeground(new Color(0, 0, 128));
		txtIdLoc.setEditable(false);
		txtIdLoc.setColumns(10);
		txtIdLoc.setBounds(293, 389, 46, 20);
		frameTransfer.getContentPane().add(txtIdLoc);
		
		txtIdInCharge = new JTextField();
		txtIdInCharge.setForeground(new Color(0, 0, 128));
		txtIdInCharge.setEditable(false);
		txtIdInCharge.setColumns(10);
		txtIdInCharge.setBounds(151, 339, 46, 20);
		frameTransfer.getContentPane().add(txtIdInCharge);
		
		txtIdRcvdBy = new JTextField();
		txtIdRcvdBy.setForeground(new Color(0, 0, 128));
		txtIdRcvdBy.setEditable(false);
		txtIdRcvdBy.setColumns(10);
		txtIdRcvdBy.setBounds(293, 339, 46, 20);
		frameTransfer.getContentPane().add(txtIdRcvdBy);
		
		txtIdApprvdBy = new JTextField();
		txtIdApprvdBy.setForeground(new Color(0, 0, 128));
		txtIdApprvdBy.setEditable(false);
		txtIdApprvdBy.setColumns(10);
		txtIdApprvdBy.setBounds(293, 364, 46, 20);
		frameTransfer.getContentPane().add(txtIdApprvdBy);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 39, 646, 5);
		frameTransfer.getContentPane().add(separator_2);
		
		JLabel lblMaintenanceNumber = new JLabel("Transfer No:");
		lblMaintenanceNumber.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblMaintenanceNumber.setBounds(10, 17, 107, 14);
		frameTransfer.getContentPane().add(lblMaintenanceNumber);
		
		txtTransferNo = new JTextField();
		txtTransferNo.setEditable(false);
		txtTransferNo.setForeground(Color.DARK_GRAY);
		txtTransferNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtTransferNo.setColumns(10);
		txtTransferNo.setBackground(Color.WHITE);
		txtTransferNo.setBounds(115, 14, 192, 20);
		frameTransfer.getContentPane().add(txtTransferNo);
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdTrnsctn.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
				txtIdTransfer.setText(Integer.toString(mng1.getMaxId(0, "transfer")));
				txtTransferNo.setText(mng1.getTransNo("transfer", "0", ""));
			}
		});
		btnNew.setBackground(SystemColor.controlHighlight);
		btnNew.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\newtrnsctn32x32.png"));
		btnNew.setBounds(269, 152, 45, 45);
		frameTransfer.getContentPane().add(btnNew);
	}
	
	
	public void bindCbo()
	{
		HashMap<String, Integer> mapDept = cbo.populateCbo("department");
		for(String s : mapDept.keySet())
		{
			cboLoc.addItem(s);
		}
		
		HashMap<String, Integer> mapInCharge = cbo.populateCbo("employee");
		for(String s : mapInCharge.keySet())
		{
			cboInCharge.addItem(s);
		}
		
		HashMap<String, Integer> mapRcvBy = cbo.populateCbo("employee");
		for(String s : mapRcvBy.keySet())
		{
			cboReceivedBy.addItem(s);
		}
		
		HashMap<String, Integer> mapApprvdBy = cbo.populateCbo("employee");
		for(String s : mapApprvdBy.keySet())
		{
			cboApprovedBy.addItem(s);
		}
	}//end bindCbo
	
	public void clearFields()
	{

		txtTransferNo.setText("");
		txtRemarks.setText("");
			
		
	}//end clearFields
}
