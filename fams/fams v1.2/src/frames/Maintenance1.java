package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Font;
import java.util.HashMap;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import functions.CboItem;
import functions.FcnDbConnect;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class Maintenance1 {
	FcnDbConnect mng1;
	CboItem cbo;
	ViewAsset viewfa;
	public JFrame frameMaintenance1;
	private JTextField txtIdInCharge;
	private JTextField txtIdLoc;
	private JTextField txtIdApprvdBy;
	private JTextField txtIdRtrndBy;
	
	public JComboBox<String> cboInCharge, cboLoc, cboReleasedBy, cboApprovedBy, cboStatus;
	private JLabel lblMaintenanceNo;
	private JTextField txtMntnNo;
	private JTextField txtDate;
	public JTextField txtFaCode;
	public JTextField txtAsset;
	private JTextField txtDateStart;
	private JTextField txtDateEnd;
	private JTextField txtDetails;
	private JTextField txtRemarks;
	private JTextField txtIdTrnsctn;
	public JTextField txtTrnsctnBy;
	private JTextField txtIdMntn;
	public JTextField txtIdFa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maintenance1 window = new Maintenance1();
					window.frameMaintenance1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Maintenance1() {
		mng1 = new FcnDbConnect();
		cbo = new CboItem(0,"");
		
		initialize();
		
		bindCbo();
		
		txtDate.setText(mng1.getDateNow());
		
		JLabel lblIdFa = new JLabel("ID FA");
		lblIdFa.setBounds(233, 460, 81, 14);
		frameMaintenance1.getContentPane().add(lblIdFa);
		
		txtIdFa = new JTextField();
		txtIdFa.setEditable(false);
		txtIdFa.setColumns(10);
		txtIdFa.setBounds(309, 457, 57, 20);
		frameMaintenance1.getContentPane().add(txtIdFa);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		frameMaintenance1 = new JFrame();
		frameMaintenance1.setResizable(false);
		frameMaintenance1.setTitle("Maintenance");
		frameMaintenance1.getContentPane().setForeground(Color.DARK_GRAY);
		frameMaintenance1.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
		frameMaintenance1.setBounds(100, 100, 717, 351);
		frameMaintenance1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMaintenance1.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("In-Charge:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(382, 93, 97, 20);
		frameMaintenance1.getContentPane().add(lblNewLabel);
		
		cboInCharge = new JComboBox<String>();
		cboInCharge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboInCharge.setForeground(Color.DARK_GRAY);
		cboInCharge.setBackground(Color.WHITE);
		cboInCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdInCharge.setText(Integer.toString(mng1.getCboId("employee", cboInCharge.getSelectedItem().toString())));
				System.out.println(cboInCharge.getSelectedItem().toString());
			}
		});
		cboInCharge.setBounds(467, 93, 192, 20);
		frameMaintenance1.getContentPane().add(cboInCharge);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setForeground(Color.DARK_GRAY);
		lblLocation.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLocation.setBounds(10, 234, 81, 14);
		frameMaintenance1.getContentPane().add(lblLocation);
		
		cboLoc = new JComboBox<String>();
		cboLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboLoc.setForeground(Color.DARK_GRAY);
		cboLoc.setBackground(Color.WHITE);
		cboLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdLoc.setText(Integer.toString(mng1.getCboId("department", cboLoc.getSelectedItem().toString())));
				System.out.println(cboLoc.getSelectedItem().toString());
			}
		});
		cboLoc.setBounds(127, 232, 192, 20);
		frameMaintenance1.getContentPane().add(cboLoc);
		
		JLabel lblApproved = new JLabel("Approved by:");
		lblApproved.setForeground(Color.DARK_GRAY);
		lblApproved.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApproved.setBounds(382, 230, 85, 14);
		frameMaintenance1.getContentPane().add(lblApproved);
		
		cboApprovedBy = new JComboBox<String>();
		cboApprovedBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboApprovedBy.setForeground(Color.DARK_GRAY);
		cboApprovedBy.setBackground(Color.WHITE);
		cboApprovedBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdApprvdBy.setText(Integer.toString(mng1.getCboId("employee", cboApprovedBy.getSelectedItem().toString())));
				System.out.println(cboApprovedBy.getSelectedItem().toString());
			}
		});
		cboApprovedBy.setBounds(467, 228, 192, 20);
		frameMaintenance1.getContentPane().add(cboApprovedBy);
		
		JLabel lblReleases = new JLabel("Returned by:");
		lblReleases.setForeground(Color.DARK_GRAY);
		lblReleases.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReleases.setBounds(382, 164, 81, 14);
		frameMaintenance1.getContentPane().add(lblReleases);
		
		cboReleasedBy = new JComboBox<String>();
		cboReleasedBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboReleasedBy.setForeground(Color.DARK_GRAY);
		cboReleasedBy.setBackground(Color.WHITE);
		cboReleasedBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdRtrndBy.setText(Integer.toString(mng1.getCboId("employee", cboReleasedBy.getSelectedItem().toString())));
				System.out.println(cboReleasedBy.getSelectedItem().toString());
			}
		});
		cboReleasedBy.setBounds(467, 162, 192, 20);
		frameMaintenance1.getContentPane().add(cboReleasedBy);
		
		txtIdInCharge = new JTextField();
		txtIdInCharge.setEditable(false);
		txtIdInCharge.setBounds(140, 373, 57, 20);
		frameMaintenance1.getContentPane().add(txtIdInCharge);
		txtIdInCharge.setColumns(10);
		
		JLabel label = new JLabel("In-Charge");
		label.setBounds(64, 376, 81, 14);
		frameMaintenance1.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Location");
		label_1.setBounds(64, 404, 81, 14);
		frameMaintenance1.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Approved");
		label_2.setBounds(64, 432, 81, 14);
		frameMaintenance1.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("Releases");
		label_3.setBounds(64, 460, 81, 14);
		frameMaintenance1.getContentPane().add(label_3);
		
		txtIdLoc = new JTextField();
		txtIdLoc.setEditable(false);
		txtIdLoc.setColumns(10);
		txtIdLoc.setBounds(140, 401, 57, 20);
		frameMaintenance1.getContentPane().add(txtIdLoc);
		
		txtIdApprvdBy = new JTextField();
		txtIdApprvdBy.setEditable(false);
		txtIdApprvdBy.setColumns(10);
		txtIdApprvdBy.setBounds(140, 429, 57, 20);
		frameMaintenance1.getContentPane().add(txtIdApprvdBy);
		
		txtIdRtrndBy = new JTextField();
		txtIdRtrndBy.setEditable(false);
		txtIdRtrndBy.setColumns(10);
		txtIdRtrndBy.setBounds(140, 457, 57, 20);
		frameMaintenance1.getContentPane().add(txtIdRtrndBy);
		
		lblMaintenanceNo = new JLabel("Maintenance No:");
		lblMaintenanceNo.setForeground(Color.DARK_GRAY);
		lblMaintenanceNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaintenanceNo.setBounds(10, 11, 118, 20);
		frameMaintenance1.getContentPane().add(lblMaintenanceNo);
		
		txtMntnNo = new JTextField();
		txtMntnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMntnNo.setForeground(Color.DARK_GRAY);
		txtMntnNo.setBackground(Color.WHITE);
		txtMntnNo.setEditable(false);
		txtMntnNo.setBounds(127, 12, 192, 20);
		frameMaintenance1.getContentPane().add(txtMntnNo);
		txtMntnNo.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 40, 649, 2);
		frameMaintenance1.getContentPane().add(separator);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setForeground(Color.DARK_GRAY);
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(382, 11, 74, 20);
		frameMaintenance1.getContentPane().add(lblDate);
		
		txtDate = new JTextField();
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDate.setForeground(Color.DARK_GRAY);
		txtDate.setBackground(Color.WHITE);
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(466, 12, 193, 20);
		frameMaintenance1.getContentPane().add(txtDate);
		
		JLabel lblAssetCode = new JLabel("Asset Code:");
		lblAssetCode.setForeground(Color.DARK_GRAY);
		lblAssetCode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAssetCode.setBounds(10, 52, 118, 20);
		frameMaintenance1.getContentPane().add(lblAssetCode);
		
		txtFaCode = new JTextField();
		txtFaCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFaCode.setForeground(Color.DARK_GRAY);
		txtFaCode.setColumns(10);
		txtFaCode.setBounds(127, 53, 192, 20);
		frameMaintenance1.getContentPane().add(txtFaCode);
		
		JLabel lblAsset = new JLabel("Asset:");
		lblAsset.setForeground(Color.DARK_GRAY);
		lblAsset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAsset.setBounds(382, 51, 118, 20);
		frameMaintenance1.getContentPane().add(lblAsset);
		
		txtAsset = new JTextField();
		txtAsset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAsset.setForeground(Color.DARK_GRAY);
		txtAsset.setColumns(10);
		txtAsset.setBounds(466, 52, 193, 20);
		frameMaintenance1.getContentPane().add(txtAsset);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 82, 649, 2);
		frameMaintenance1.getContentPane().add(separator_1);
		
		JLabel lblDateStart = new JLabel("Date Start:");
		lblDateStart.setForeground(Color.DARK_GRAY);
		lblDateStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateStart.setBounds(10, 93, 118, 20);
		frameMaintenance1.getContentPane().add(lblDateStart);
		
		txtDateStart = new JTextField();
		txtDateStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDateStart.setForeground(Color.DARK_GRAY);
		txtDateStart.setColumns(10);
		txtDateStart.setBounds(127, 94, 192, 20);
		frameMaintenance1.getContentPane().add(txtDateStart);
		
		JLabel lblDateEnd = new JLabel("Date End:");
		lblDateEnd.setForeground(Color.DARK_GRAY);
		lblDateEnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateEnd.setBounds(10, 162, 96, 20);
		frameMaintenance1.getContentPane().add(lblDateEnd);
		
		txtDateEnd = new JTextField();
		txtDateEnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDateEnd.setForeground(Color.DARK_GRAY);
		txtDateEnd.setColumns(10);
		txtDateEnd.setBounds(126, 163, 192, 20);
		frameMaintenance1.getContentPane().add(txtDateEnd);
		
		JLabel lblDetails = new JLabel("Details:");
		lblDetails.setForeground(Color.DARK_GRAY);
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDetails.setBounds(10, 121, 118, 20);
		frameMaintenance1.getContentPane().add(lblDetails);
		
		txtDetails = new JTextField();
		txtDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDetails.setForeground(Color.DARK_GRAY);
		txtDetails.setColumns(10);
		txtDetails.setBounds(127, 122, 532, 20);
		frameMaintenance1.getContentPane().add(txtDetails);
		
		txtRemarks = new JTextField();
		txtRemarks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRemarks.setForeground(Color.DARK_GRAY);
		txtRemarks.setColumns(10);
		txtRemarks.setBounds(127, 190, 532, 20);
		frameMaintenance1.getContentPane().add(txtRemarks);
		
		JLabel lblRemarks = new JLabel("Remarks:");
		lblRemarks.setForeground(Color.DARK_GRAY);
		lblRemarks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRemarks.setBounds(10, 189, 118, 20);
		frameMaintenance1.getContentPane().add(lblRemarks);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 152, 649, 2);
		frameMaintenance1.getContentPane().add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(10, 221, 649, 2);
		frameMaintenance1.getContentPane().add(separator_3);
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdTrnsctn.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
				txtIdMntn.setText(Integer.toString(mng1.getMaxId(0, "maintenance")));
				txtMntnNo.setText(mng1.getTransNo("maintenance", "0", ""));
			}
		});
		btnNew.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new32x32.png"));
		btnNew.setBackground(SystemColor.controlHighlight);
		btnNew.setBounds(309, 268, 45, 45);
		frameMaintenance1.getContentPane().add(btnNew);
		
		JButton btnView = new JButton("");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportViewHistory window = new ReportViewHistory();
				window.frameReportViewHistory.setVisible(true);
			}
		});
		btnView.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\view32x32.png"));
		btnView.setBackground(SystemColor.controlHighlight);
		btnView.setBounds(408, 268, 45, 45);
		frameMaintenance1.getContentPane().add(btnView);
		
		JButton btnSave = new JButton("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mng1.assetStatus = cboStatus.getSelectedItem().toString();
				
				if(txtMntnNo.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please click new button to generate new Pullout number.");
				}	
				else if(txtIdApprvdBy.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please specify person for approval of pullout transaction.");
				}	
				else if(txtIdRtrndBy.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please specify person in-charge for returning the asset.");
				}
				else if(txtIdInCharge.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please specify person in-charge for the maintenance of the asset.");
				}
				else
				{
					mng1.addTransaction("maintenance", Integer.parseInt(txtIdFa.getText()), txtFaCode.getText(), Integer.parseInt(txtIdTrnsctn.getText()), "add", Integer.parseInt(txtIdMntn.getText()), txtMntnNo.getText(), txtDate.getText(), Integer.parseInt(txtTrnsctnBy.getText()), Integer.parseInt(txtIdLoc.getText()), Integer.parseInt(txtIdInCharge.getText()), Integer.parseInt(txtIdApprvdBy.getText()), txtRemarks.getText(), "done");
					
					mng1.restrictDuplicateInfo("maintenance", Integer.parseInt(txtIdMntn.getText()), txtMntnNo.getText(), Integer.parseInt(txtIdTrnsctn.getText()), txtDateStart.getText(), txtDateEnd.getText(), txtDetails.getText(), mng1.assetStatus, Integer.parseInt(txtIdInCharge.getText()), Integer.parseInt(txtIdApprvdBy.getText()), Integer.parseInt(txtIdRtrndBy.getText()), txtRemarks.getText());
					
					/* //generate new transNo
				    txtIdTrnsctn.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
					txtIdMntn.setText(Integer.toString(mng1.getMaxId(0, "maintenance")));
					txtMntnNo.setText(mng1.getTransNo("maintenance", "0", ""));
					
					clearFields();*/
					
				}
			
				
			}
		});
		btnSave.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		btnSave.setBackground(SystemColor.controlHighlight);
		btnSave.setBounds(358, 268, 45, 45);
		frameMaintenance1.getContentPane().add(btnSave);
		
		JButton btnCancel = new JButton("");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
								
				int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel transaction", "Cancel", JOptionPane.YES_NO_OPTION);

				if (option == 0) { 
					mng1.cancelTransactions("maintenance", Integer.parseInt(txtIdMntn.getText()), txtMntnNo.getText());
					mng1.cancelTransactions("transaction", Integer.parseInt(txtIdMntn.getText()), txtMntnNo.getText());
					
				    JOptionPane.showMessageDialog(null, "Transaction Cancelled.");
					
				    //generate new transNo
				    clearFields();
				    
				    txtIdTrnsctn.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
					txtIdMntn.setText(Integer.toString(mng1.getMaxId(0, "maintenance")));
					txtMntnNo.setText(mng1.getTransNo("maintenance", "0", ""));
					
					
					
				} else {
				   System.out.print("no");
				}
				
			}
		});
		btnCancel.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\cancel32x32.png"));
		btnCancel.setBackground(SystemColor.controlHighlight);
		btnCancel.setBounds(456, 268, 45, 45);
		frameMaintenance1.getContentPane().add(btnCancel);
		
		JLabel lblIdTrnsctn = new JLabel("ID Trnsctn");
		lblIdTrnsctn.setBounds(233, 376, 81, 14);
		frameMaintenance1.getContentPane().add(lblIdTrnsctn);
		
		txtIdTrnsctn = new JTextField();
		txtIdTrnsctn.setEditable(false);
		txtIdTrnsctn.setColumns(10);
		txtIdTrnsctn.setBounds(309, 373, 57, 20);
		frameMaintenance1.getContentPane().add(txtIdTrnsctn);
		
		JLabel lblTrnsctnby = new JLabel("TrnsctnBy");
		lblTrnsctnby.setBounds(233, 404, 81, 14);
		frameMaintenance1.getContentPane().add(lblTrnsctnby);
		
		txtTrnsctnBy = new JTextField();
		txtTrnsctnBy.setEditable(false);
		txtTrnsctnBy.setColumns(10);
		txtTrnsctnBy.setBounds(309, 401, 57, 20);
		frameMaintenance1.getContentPane().add(txtTrnsctnBy);
		
		JLabel lblIdMaintain = new JLabel("ID Maintain");
		lblIdMaintain.setBounds(233, 432, 81, 14);
		frameMaintenance1.getContentPane().add(lblIdMaintain);
		
		txtIdMntn = new JTextField();
		txtIdMntn.setEditable(false);
		txtIdMntn.setColumns(10);
		txtIdMntn.setBounds(309, 429, 57, 20);
		frameMaintenance1.getContentPane().add(txtIdMntn);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.DARK_GRAY);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatus.setBounds(376, 375, 81, 14);
		frameMaintenance1.getContentPane().add(lblStatus);
		
		cboStatus = new JComboBox<String>();
		cboStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboStatus.setForeground(Color.DARK_GRAY);
		cboStatus.setBackground(Color.WHITE);
		cboStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"maintenance ", "on-progress", "done", "returned"}));
		cboStatus.setBounds(493, 373, 192, 20);
		frameMaintenance1.getContentPane().add(cboStatus);
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
		
		HashMap<String, Integer> mapRlsdBy = cbo.populateCbo("employee");
		for(String s : mapRlsdBy.keySet())
		{
			cboReleasedBy.addItem(s);
		}
		
		HashMap<String, Integer> mapApprvdBy = cbo.populateCbo("employee");
		for(String s : mapApprvdBy.keySet())
		{
			cboApprovedBy.addItem(s);
		}
	}//end bindCbo
	
	public void clearFields()
	{
		txtMntnNo.setText("");
		txtDateStart.setText("");
		txtDateEnd.setText("");
		txtDetails.setText("");
		txtRemarks.setText("");
	
	}
}
