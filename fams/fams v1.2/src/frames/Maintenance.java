package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.util.HashMap;
import functions.CboItem;
import functions.FcnDbConnect;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;

public class Maintenance {
	FcnDbConnect mng1;
	CboItem cbo;
	ViewAsset viewfa;
	
	public JFrame frameMaintenance;
	public JTextField txtAsset;
	public JTextField txtFaCode;
	private JTextField txtDate;
	private JTextField txtDetails;
	private JTextField txtDateStart;
	private JTextField txtDateEnd;
	private JTextField txtMntnNo;
	private JTextField txtRemarks;
	//CBO
	public JComboBox<String> cboInCharge, cboLoc, cboApprovedBy;
	
	public JTextField txtTrnsctnBy;
	private JTextField txtIdTrnsctn;
	private JTextField txtIdInCharge;
	private JTextField txtIdTransfer;
	private JTextField txtIdLoc;
	private JTextField txtIdApprvdBy;
	private JTextField textField_13;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Maintenance window = new Maintenance(0,"");
					window.frameMaintenance.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Maintenance(int id, String name) {
		mng1 = new FcnDbConnect();
		cbo = new CboItem(0,"");
		
		initialize();
		
		//CBO
		bindCbo();
		//CBO
		
		txtDate.setText(mng1.getDateNow());
	
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setForeground(Color.DARK_GRAY);
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStatus.setBounds(360, 74, 107, 22);
		frameMaintenance.getContentPane().add(lblStatus);
		
		JLabel label = new JLabel("ID Transfer");
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 442, 84, 14);
		frameMaintenance.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("ID InCharge");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(10, 466, 84, 14);
		frameMaintenance.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("ID Trnsctn");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(10, 495, 84, 14);
		frameMaintenance.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("ID Trnsctn By");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(10, 520, 84, 14);
		frameMaintenance.getContentPane().add(label_3);
		
		txtTrnsctnBy = new JTextField();
		txtTrnsctnBy.setForeground(new Color(0, 0, 128));
		txtTrnsctnBy.setEditable(false);
		txtTrnsctnBy.setColumns(10);
		txtTrnsctnBy.setBounds(94, 514, 46, 20);
		frameMaintenance.getContentPane().add(txtTrnsctnBy);
		
		txtIdTrnsctn = new JTextField();
		txtIdTrnsctn.setForeground(new Color(0, 0, 128));
		txtIdTrnsctn.setEditable(false);
		txtIdTrnsctn.setColumns(10);
		txtIdTrnsctn.setBounds(94, 489, 46, 20);
		frameMaintenance.getContentPane().add(txtIdTrnsctn);
		
		txtIdInCharge = new JTextField();
		txtIdInCharge.setForeground(new Color(0, 0, 128));
		txtIdInCharge.setEditable(false);
		txtIdInCharge.setColumns(10);
		txtIdInCharge.setBounds(94, 464, 46, 20);
		frameMaintenance.getContentPane().add(txtIdInCharge);
		
		txtIdTransfer = new JTextField();
		txtIdTransfer.setForeground(new Color(0, 0, 128));
		txtIdTransfer.setEditable(false);
		txtIdTransfer.setColumns(10);
		txtIdTransfer.setBounds(94, 439, 46, 20);
		frameMaintenance.getContentPane().add(txtIdTransfer);
		
		JLabel label_4 = new JLabel("ID Received");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(150, 439, 84, 14);
		frameMaintenance.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("ID Approved");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(150, 464, 84, 14);
		frameMaintenance.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("ID Location");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_6.setBounds(150, 489, 84, 14);
		frameMaintenance.getContentPane().add(label_6);
		
		txtIdLoc = new JTextField();
		txtIdLoc.setForeground(new Color(0, 0, 128));
		txtIdLoc.setEditable(false);
		txtIdLoc.setColumns(10);
		txtIdLoc.setBounds(236, 489, 46, 20);
		frameMaintenance.getContentPane().add(txtIdLoc);
		
		txtIdApprvdBy = new JTextField();
		txtIdApprvdBy.setForeground(new Color(0, 0, 128));
		txtIdApprvdBy.setEditable(false);
		txtIdApprvdBy.setColumns(10);
		txtIdApprvdBy.setBounds(236, 464, 46, 20);
		frameMaintenance.getContentPane().add(txtIdApprvdBy);
		
		textField_13 = new JTextField();
		textField_13.setForeground(new Color(0, 0, 128));
		textField_13.setEditable(false);
		textField_13.setColumns(10);
		textField_13.setBounds(236, 439, 46, 20);
		frameMaintenance.getContentPane().add(textField_13);
		
		JComboBox<String> cboStatus = new JComboBox<String>();
		cboStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"on-progress", "done", "returned"}));
		cboStatus.setForeground(Color.DARK_GRAY);
		cboStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboStatus.setBackground(Color.WHITE);
		cboStatus.setBounds(464, 76, 193, 20);
		frameMaintenance.getContentPane().add(cboStatus);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(11, 192, 646, 5);
		frameMaintenance.getContentPane().add(separator);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMaintenance = new JFrame();
		frameMaintenance.setTitle("Maintenance");
		frameMaintenance.setBounds(100, 100, 680, 362);
		frameMaintenance.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameMaintenance.getContentPane().setLayout(null);
		
		JLabel label = new JLabel("Asset Code:");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 48, 84, 14);
		frameMaintenance.getContentPane().add(label);
		
		JLabel lblAsset = new JLabel("Asset Name:");
		lblAsset.setForeground(Color.DARK_GRAY);
		lblAsset.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAsset.setBounds(360, 48, 84, 14);
		frameMaintenance.getContentPane().add(lblAsset);
		
		txtAsset = new JTextField();
		txtAsset.setBackground(new Color(255, 255, 255));
		txtAsset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAsset.setForeground(Color.DARK_GRAY);
		txtAsset.setEditable(false);
		txtAsset.setColumns(10);
		txtAsset.setBounds(465, 45, 192, 20);
		frameMaintenance.getContentPane().add(txtAsset);
		
		txtFaCode = new JTextField();
		txtFaCode.setBackground(new Color(255, 255, 255));
		txtFaCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFaCode.setForeground(Color.DARK_GRAY);
		txtFaCode.setEditable(false);
		txtFaCode.setColumns(10);
		txtFaCode.setBounds(115, 45, 192, 20);
		frameMaintenance.getContentPane().add(txtFaCode);
		
		JLabel label_2 = new JLabel("Date:");
		label_2.setForeground(Color.DARK_GRAY);
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(365, 14, 52, 14);
		frameMaintenance.getContentPane().add(label_2);
		
		txtDate = new JTextField();
		txtDate.setBackground(new Color(255, 255, 255));
		txtDate.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDate.setForeground(Color.DARK_GRAY);
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(464, 11, 192, 20);
		frameMaintenance.getContentPane().add(txtDate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 39, 646, 5);
		frameMaintenance.getContentPane().add(separator);
		
		JLabel label_3 = new JLabel("Person in-charge:");
		label_3.setForeground(Color.DARK_GRAY);
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(10, 199, 107, 22);
		frameMaintenance.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Location:");
		label_4.setForeground(Color.DARK_GRAY);
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(10, 232, 107, 14);
		frameMaintenance.getContentPane().add(label_4);
		
		txtDetails = new JTextField();
		txtDetails.setBackground(new Color(255, 255, 255));
		txtDetails.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDetails.setForeground(Color.DARK_GRAY);
		txtDetails.setColumns(10);
		txtDetails.setBounds(115, 104, 542, 20);
		frameMaintenance.getContentPane().add(txtDetails);
		
		JLabel label_7 = new JLabel("Approved by:");
		label_7.setForeground(Color.DARK_GRAY);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_7.setBounds(360, 203, 107, 14);
		frameMaintenance.getContentPane().add(label_7);
		
		JLabel lblDateStart = new JLabel("Date Start:");
		lblDateStart.setForeground(Color.DARK_GRAY);
		lblDateStart.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateStart.setBounds(10, 73, 107, 20);
		frameMaintenance.getContentPane().add(lblDateStart);
		
		txtDateStart = new JTextField();
		txtDateStart.setBackground(new Color(255, 255, 255));
		txtDateStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDateStart.setForeground(Color.DARK_GRAY);
		txtDateStart.setColumns(10);
		txtDateStart.setBounds(115, 73, 192, 20);
		frameMaintenance.getContentPane().add(txtDateStart);
		
		JLabel lblDateEnd = new JLabel("Date End:");
		lblDateEnd.setForeground(Color.DARK_GRAY);
		lblDateEnd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDateEnd.setBounds(10, 130, 107, 20);
		frameMaintenance.getContentPane().add(lblDateEnd);
		
		txtDateEnd = new JTextField();
		txtDateEnd.setBackground(new Color(255, 255, 255));
		txtDateEnd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtDateEnd.setForeground(Color.DARK_GRAY);
		txtDateEnd.setColumns(10);
		txtDateEnd.setBounds(114, 130, 192, 20);
		frameMaintenance.getContentPane().add(txtDateEnd);
		
		JLabel lblMaintenanceno = new JLabel("Maintenance No:");
		lblMaintenanceno.setForeground(Color.DARK_GRAY);
		lblMaintenanceno.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMaintenanceno.setBounds(10, 14, 107, 14);
		frameMaintenance.getContentPane().add(lblMaintenanceno);
		
		txtMntnNo = new JTextField();
		txtMntnNo.setForeground(Color.DARK_GRAY);
		txtMntnNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtMntnNo.setEditable(false);
		txtMntnNo.setColumns(10);
		txtMntnNo.setBackground(Color.WHITE);
		txtMntnNo.setBounds(115, 11, 192, 20);
		frameMaintenance.getContentPane().add(txtMntnNo);
		
		JLabel lblDetails = new JLabel("Details:");
		lblDetails.setForeground(Color.DARK_GRAY);
		lblDetails.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDetails.setBounds(10, 104, 107, 20);
		frameMaintenance.getContentPane().add(lblDetails);
		
		JLabel lblRemarks = new JLabel("Remarks:");
		lblRemarks.setForeground(Color.DARK_GRAY);
		lblRemarks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRemarks.setBounds(10, 161, 107, 20);
		frameMaintenance.getContentPane().add(lblRemarks);
		
		txtRemarks = new JTextField();
		txtRemarks.setForeground(Color.DARK_GRAY);
		txtRemarks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRemarks.setColumns(10);
		txtRemarks.setBackground(Color.WHITE);
		txtRemarks.setBounds(115, 161, 542, 20);
		frameMaintenance.getContentPane().add(txtRemarks);
		
		cboLoc = new JComboBox<String>();
		cboLoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//txtIdLoc.setText(Integer.toString(mng1.getCboId("department", cboLoc.getSelectedItem().toString())));
				//System.out.println(cboLoc.getSelectedItem().toString());
			}
		});
		cboLoc.setBackground(Color.WHITE);
		cboLoc.setForeground(Color.DARK_GRAY);
		cboLoc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboLoc.setBounds(115, 226, 192, 20);
		frameMaintenance.getContentPane().add(cboLoc);
		
		cboInCharge = new JComboBox<String>();
		cboInCharge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdInCharge.setText(Integer.toString(mng1.getCboId("employee", cboInCharge.getSelectedItem().toString())));
				System.out.println(cboInCharge.getSelectedItem().toString());			}
		});
		cboInCharge.setBackground(Color.WHITE);
		cboInCharge.setForeground(Color.DARK_GRAY);
		cboInCharge.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboInCharge.setBounds(115, 200, 192, 20);
		frameMaintenance.getContentPane().add(cboInCharge);
		
		cboApprovedBy = new JComboBox<String>();
		cboApprovedBy.setBackground(Color.WHITE);
		cboApprovedBy.setForeground(Color.DARK_GRAY);
		cboApprovedBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboApprovedBy.setBounds(465, 200, 193, 20);
		frameMaintenance.getContentPane().add(cboApprovedBy);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\newtrnsctn32x32.png"));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(314, 268, 45, 45);
		frameMaintenance.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\view32x32.png"));
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(406, 268, 45, 45);
		frameMaintenance.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		button_2.setBackground(SystemColor.controlHighlight);
		button_2.setBounds(360, 268, 45, 45);
		frameMaintenance.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\cancel32x32.png"));
		button_3.setBackground(SystemColor.controlHighlight);
		button_3.setBounds(452, 268, 45, 45);
		frameMaintenance.getContentPane().add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 384, 646, 20);
		frameMaintenance.getContentPane().add(scrollPane);
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
		
		/*HashMap<String, Integer> mapRlsdBy = cbo.populateCbo("employee");
		for(String s : mapRlsdBy.keySet())
		{
			cboReleasedBy.addItem(s);
		}
		*/
		HashMap<String, Integer> mapApprvdBy = cbo.populateCbo("employee");
		for(String s : mapApprvdBy.keySet())
		{
			cboApprovedBy.addItem(s);
		}
	}//end bindCbo
	
}
