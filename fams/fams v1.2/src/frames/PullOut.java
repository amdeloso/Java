package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import functions.CboItem;
import functions.FcnDbConnect;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.SystemColor;
import java.util.HashMap;

import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;

public class PullOut {
	FcnDbConnect mng1;
	CboItem cbo;
	ViewAsset viewfa;
	
	public JFrame framePullout;
	private JTextField txtPoNo;
	private JTextField txtDate;
	public JTextField txtFaCode;
	public JTextField txtAsset;
	private JTextField txtRemarks;
	
	public JComboBox<String> cboApprovedBy, cboStatus;
	private JTextField txtIdPo;
	public JTextField txtIdInCharge;
	private JTextField txtIdTrnsctn;
	public JTextField txtTrnsctnBy;
	private JTextField txtIdApprvdBy;
	public JTextField txtIdFa;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PullOut window = new PullOut();
					window.framePullout.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PullOut() {
		mng1 = new FcnDbConnect();
		cbo = new CboItem(0,"");
		
		initialize();
		
		bindCbo();
		txtDate.setText(mng1.getDateNow());
		
		JLabel lblIdPo = new JLabel("ID PO");
		lblIdPo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdPo.setBounds(31, 272, 84, 14);
		framePullout.getContentPane().add(lblIdPo);
		
		txtIdPo = new JTextField();
		txtIdPo.setForeground(new Color(0, 0, 128));
		txtIdPo.setEditable(false);
		txtIdPo.setColumns(10);
		txtIdPo.setBounds(115, 269, 46, 20);
		framePullout.getContentPane().add(txtIdPo);
		
		JLabel label_1 = new JLabel("ID InCharge");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_1.setBounds(177, 346, 84, 18);
		framePullout.getContentPane().add(label_1);
		
		txtIdInCharge = new JTextField();
		txtIdInCharge.setForeground(new Color(0, 0, 128));
		txtIdInCharge.setEditable(false);
		txtIdInCharge.setColumns(10);
		txtIdInCharge.setBounds(261, 344, 46, 20);
		framePullout.getContentPane().add(txtIdInCharge);
		
		JLabel label_2 = new JLabel("ID Trnsctn");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(31, 301, 84, 14);
		framePullout.getContentPane().add(label_2);
		
		txtIdTrnsctn = new JTextField();
		txtIdTrnsctn.setForeground(new Color(0, 0, 128));
		txtIdTrnsctn.setEditable(false);
		txtIdTrnsctn.setColumns(10);
		txtIdTrnsctn.setBounds(115, 295, 46, 20);
		framePullout.getContentPane().add(txtIdTrnsctn);
		
		JLabel label_3 = new JLabel("ID Trnsctn By");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(31, 350, 84, 14);
		framePullout.getContentPane().add(label_3);
		
		txtTrnsctnBy = new JTextField();
		txtTrnsctnBy.setForeground(new Color(0, 0, 128));
		txtTrnsctnBy.setEditable(false);
		txtTrnsctnBy.setColumns(10);
		txtTrnsctnBy.setBounds(115, 344, 46, 20);
		framePullout.getContentPane().add(txtTrnsctnBy);
		
		JLabel label_4 = new JLabel("ID Approved");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_4.setBounds(29, 319, 84, 20);
		framePullout.getContentPane().add(label_4);
		
		txtIdApprvdBy = new JTextField();
		txtIdApprvdBy.setForeground(new Color(0, 0, 128));
		txtIdApprvdBy.setEditable(false);
		txtIdApprvdBy.setColumns(10);
		txtIdApprvdBy.setBounds(115, 319, 46, 20);
		framePullout.getContentPane().add(txtIdApprvdBy);
		
		JLabel label = new JLabel("ID FA");
		label.setBounds(186, 318, 81, 14);
		framePullout.getContentPane().add(label);
		
		txtIdFa = new JTextField();
		txtIdFa.setEditable(false);
		txtIdFa.setColumns(10);
		txtIdFa.setBounds(262, 315, 57, 20);
		framePullout.getContentPane().add(txtIdFa);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		framePullout = new JFrame();
		framePullout.setResizable(false);
		framePullout.setTitle("Pullout");
		framePullout.setBounds(100, 100, 687, 227);
		framePullout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePullout.getContentPane().setLayout(null);
		
		JLabel lblPulloutNo = new JLabel("Pullout No:");
		lblPulloutNo.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPulloutNo.setBounds(10, 14, 107, 14);
		framePullout.getContentPane().add(lblPulloutNo);
		
		txtPoNo = new JTextField();
		txtPoNo.setForeground(Color.DARK_GRAY);
		txtPoNo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtPoNo.setEditable(false);
		txtPoNo.setColumns(10);
		txtPoNo.setBackground(Color.WHITE);
		txtPoNo.setBounds(115, 11, 192, 20);
		framePullout.getContentPane().add(txtPoNo);
		
		JLabel label_1 = new JLabel("Date:");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		label_1.setBounds(360, 14, 99, 14);
		framePullout.getContentPane().add(label_1);
		
		txtDate = new JTextField();
		txtDate.setText("2017-01-19");
		txtDate.setForeground(Color.DARK_GRAY);
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBackground(Color.WHITE);
		txtDate.setBounds(464, 11, 192, 20);
		framePullout.getContentPane().add(txtDate);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 36, 646, 5);
		framePullout.getContentPane().add(separator);
		
		JLabel label_2 = new JLabel("Asset Code:");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_2.setBounds(10, 50, 84, 14);
		framePullout.getContentPane().add(label_2);
		
		txtFaCode = new JTextField();
		txtFaCode.setForeground(Color.DARK_GRAY);
		txtFaCode.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFaCode.setEditable(false);
		txtFaCode.setColumns(10);
		txtFaCode.setBackground(Color.WHITE);
		txtFaCode.setBounds(115, 47, 192, 20);
		framePullout.getContentPane().add(txtFaCode);
		
		JLabel label_3 = new JLabel("Asset:");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_3.setBounds(360, 47, 99, 14);
		framePullout.getContentPane().add(label_3);
		
		txtAsset = new JTextField();
		txtAsset.setForeground(Color.DARK_GRAY);
		txtAsset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAsset.setEditable(false);
		txtAsset.setColumns(10);
		txtAsset.setBackground(Color.WHITE);
		txtAsset.setBounds(464, 44, 192, 20);
		framePullout.getContentPane().add(txtAsset);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 73, 646, 5);
		framePullout.getContentPane().add(separator_1);
		
		JLabel label_5 = new JLabel("Remarks:");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label_5.setBounds(10, 123, 107, 14);
		framePullout.getContentPane().add(label_5);
		
		txtRemarks = new JTextField();
		txtRemarks.setForeground(Color.DARK_GRAY);
		txtRemarks.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtRemarks.setColumns(10);
		txtRemarks.setBackground(Color.WHITE);
		txtRemarks.setBounds(115, 120, 541, 20);
		framePullout.getContentPane().add(txtRemarks);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtIdTrnsctn.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
				txtIdPo.setText(Integer.toString(mng1.getMaxId(0, "pullout")));
				txtPoNo.setText(mng1.getTransNo("pullout", "0", ""));
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new32x32.png"));
		button.setBackground(SystemColor.controlHighlight);
		button.setBounds(262, 148, 45, 45);
		framePullout.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\view32x32.png"));
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(308, 148, 45, 45);
		framePullout.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mng1.assetStatus = cboStatus.getSelectedItem().toString();
				if(txtPoNo.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please click new button to generate new Pullout number.");
				}	
				else if(txtIdApprvdBy.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please specify person for approval of pullout transaction.");
				}	
				else if(txtRemarks.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please transaction remarks.");
				}
				else
				{
					mng1.addTransaction("pullout", Integer.parseInt(txtIdFa.getText()), txtFaCode.getText(),Integer.parseInt(txtIdTrnsctn.getText()), "add", Integer.parseInt(txtIdPo.getText()), txtPoNo.getText(), txtDate.getText(), Integer.parseInt(txtTrnsctnBy.getText()), 0, Integer.parseInt(txtIdInCharge.getText()), Integer.parseInt(txtIdApprvdBy.getText()), txtRemarks.getText(), "done");
					mng1.restrictDuplicateInfo("pullout", Integer.parseInt(txtIdPo.getText()), txtPoNo.getText(), Integer.parseInt(txtIdTrnsctn.getText()), "", "", "", mng1.assetStatus, Integer.parseInt(txtIdInCharge.getText()), Integer.parseInt(txtIdApprvdBy.getText()), 0, txtRemarks.getText());

				}
				
			}
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		button_2.setBackground(SystemColor.controlHighlight);
		button_2.setBounds(355, 148, 40, 45);
		framePullout.getContentPane().add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int option = JOptionPane.showConfirmDialog(null, "Do you want to cancel transaction", "Cancel", JOptionPane.YES_NO_OPTION);

				if (option == 0) { 
					mng1.cancelTransactions("pullout", Integer.parseInt(txtIdPo.getText()), txtPoNo.getText());
					mng1.cancelTransactions("transaction",Integer.parseInt(txtIdPo.getText()), txtPoNo.getText());
				    JOptionPane.showMessageDialog(null, "Transaction Cancelled.");
					
				    //generate new transNo
				    clearFields();
				    
				    txtIdTrnsctn.setText(Integer.toString(mng1.getMaxId(0, "transaction")));
					txtIdPo.setText(Integer.toString(mng1.getMaxId(0, "pullout")));
					txtPoNo.setText(mng1.getTransNo("pullout", "0", ""));
					
					
					
				} else {
				   System.out.print("no");
				}
			}
		});
		button_3.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\cancel32x32.png"));
		button_3.setBackground(SystemColor.controlHighlight);
		button_3.setBounds(396, 148, 45, 45);
		framePullout.getContentPane().add(button_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(514, 286, 179, 68);
		framePullout.getContentPane().add(scrollPane);
		
		JLabel lblAssetStatus = new JLabel("Asset status:");
		lblAssetStatus.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAssetStatus.setBounds(359, 89, 107, 20);
		framePullout.getContentPane().add(lblAssetStatus);
		
		cboStatus = new JComboBox<String>();
		cboStatus.setModel(new DefaultComboBoxModel<String>(new String[] {"disposed", "sold"}));
		cboStatus.setForeground(Color.DARK_GRAY);
		cboStatus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboStatus.setBackground(Color.WHITE);
		cboStatus.setBounds(464, 86, 192, 20);
		framePullout.getContentPane().add(cboStatus);
		
		JLabel lblApprovedBy = new JLabel("Approved by:");
		lblApprovedBy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblApprovedBy.setBounds(10, 89, 107, 20);
		framePullout.getContentPane().add(lblApprovedBy);
		
		cboApprovedBy = new JComboBox<String>();
		cboApprovedBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					//Department
					mng1.st = mng1.con.createStatement();
					mng1.rs = mng1.st.executeQuery("SELECT idEmp As id FROM employee WHERE  CONCAT(lName, ', ', fName) LIKE '%"+ cboApprovedBy.getSelectedItem().toString() +"%'");
				
								
					while(mng1.rs.next()){
						txtIdApprvdBy.setText(Integer.toString(mng1.rs.getInt("id")));
					}
					
						
				} catch (Exception error) {
					// TODO Auto-generated catch block
					System.out.println("try catch exception cboApprovedBy() " + error);
				}finally
				{
					try 
					{
						mng1.st.close();
					}catch(Exception error)
					{
						System.out.println("Final try catch exception cboApprovedBy() " + error);
					}
				}
			}
		});
		cboApprovedBy.setForeground(Color.DARK_GRAY);
		cboApprovedBy.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboApprovedBy.setBackground(Color.WHITE);
		cboApprovedBy.setBounds(115, 86, 192, 20);
		framePullout.getContentPane().add(cboApprovedBy);
	}//end initialize
	
	public void bindCbo()
	{	
		HashMap<String, Integer> mapApprvdBy = cbo.populateCbo("employee");
		for(String s : mapApprvdBy.keySet())
		{
			cboApprovedBy.addItem(s);
		}
	}//end bindCbo
	
	public void clearFields()
	{
		txtRemarks.setText("");
	}
}
