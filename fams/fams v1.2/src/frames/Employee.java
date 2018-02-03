package frames;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import functions.CboItem;
import functions.FcnDbConnect;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class Employee {
	FcnDbConnect mng1;
	CboItem cbo;
	
	public JFrame frameEmployee;
	private JTextField txtFname;
	private JTextField txtLname;
	private JTextField txtEmail;
	private JTextField txtContact;
	
	//Cbo
	public JComboBox<String> cboDept, cboPosition;
	//Table
		public JTable table = new JTable();
		DefaultTableModel model = new DefaultTableModel();
		private JTextField txtIdDept;
		private JTextField txtIdPosn;
		private JTextField txtIdEmp;
		private JTextField txtAddress;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee window = new Employee();
					window.frameEmployee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Employee() {
		mng1 = new FcnDbConnect();
		cbo = new CboItem(0,"");
		
		initialize(null, null);
		
		//TABLE
		Object[] columns = {"ID", "Employee", "Gender", "Email", "Contact #", "Address", "idDept", "Department", "idPosn","Position"};
		model.setColumnIdentifiers(columns);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mng1.i = table.getSelectedRow();
				
				txtIdEmp.setText(model.getValueAt(mng1.i, 0).toString());
				txtFname.setText(model.getValueAt(mng1.i, 1).toString());
				txtLname.setText(model.getValueAt(mng1.i, 1).toString());
				//gender .setText(model.getValueAt(mng1.i, 2).toString());
				txtEmail.setText(model.getValueAt(mng1.i, 3).toString());
				txtContact.setText(model.getValueAt(mng1.i, 4).toString());
				txtAddress.setText(model.getValueAt(mng1.i, 5).toString());
				txtIdDept.setText(model.getValueAt(mng1.i, 6).toString());
				//cboDept.setText(model.getValueAt(mng1.i, 7).toString());
				txtIdPosn.setText(model.getValueAt(mng1.i, 8).toString());
				//txtIdPosn.setText(model.getValueAt(mng1.i, 9).toString());
				
			}
		});
		table.setShowVerticalLines(false);
		table.setModel(model);
		
		txtIdDept = new JTextField();
		txtIdDept.setText("0");
		txtIdDept.setEditable(false);
		txtIdDept.setForeground(Color.DARK_GRAY);
		txtIdDept.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIdDept.setColumns(10);
		txtIdDept.setBounds(21, 318, 28, 20);
		frameEmployee.getContentPane().add(txtIdDept);
		
		txtIdPosn = new JTextField();
		txtIdPosn.setText("0");
		txtIdPosn.setForeground(Color.DARK_GRAY);
		txtIdPosn.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIdPosn.setEditable(false);
		txtIdPosn.setColumns(10);
		txtIdPosn.setBounds(56, 319, 28, 20);
		frameEmployee.getContentPane().add(txtIdPosn);
		
		txtIdEmp = new JTextField();
		txtIdEmp.setText("0");
		txtIdEmp.setForeground(Color.DARK_GRAY);
		txtIdEmp.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIdEmp.setEditable(false);
		txtIdEmp.setColumns(10);
		txtIdEmp.setBounds(94, 319, 28, 20);
		frameEmployee.getContentPane().add(txtIdEmp);
		
		txtAddress = new JTextField();
		txtAddress.setForeground(Color.DARK_GRAY);
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAddress.setColumns(10);
		txtAddress.setBounds(107, 138, 207, 53);
		frameEmployee.getContentPane().add(txtAddress);
		
		//fillCbo();
		bindCbo();
		viewEmp();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(TableModel data, TableColumnModel column) {
		frameEmployee = new JFrame();
		frameEmployee.setResizable(false);
		frameEmployee.setTitle("Employee");
		frameEmployee.setBounds(100, 100, 723, 334);
		frameEmployee.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameEmployee.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Firstname:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 97, 14);
		frameEmployee.getContentPane().add(lblNewLabel);
		
		txtFname = new JTextField();
		txtFname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtFname.setForeground(Color.DARK_GRAY);
		txtFname.setBounds(107, 9, 207, 20);
		frameEmployee.getContentPane().add(txtFname);
		txtFname.setColumns(10);
		
		JLabel lblLastname = new JLabel("Lastname:");
		lblLastname.setForeground(Color.DARK_GRAY);
		lblLastname.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLastname.setBounds(10, 36, 97, 14);
		frameEmployee.getContentPane().add(lblLastname);
		
		txtLname = new JTextField();
		txtLname.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLname.setForeground(Color.DARK_GRAY);
		txtLname.setColumns(10);
		txtLname.setBounds(107, 34, 207, 20);
		frameEmployee.getContentPane().add(txtLname);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setForeground(Color.DARK_GRAY);
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblGender.setBounds(10, 61, 97, 14);
		frameEmployee.getContentPane().add(lblGender);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rdbtnMale.isSelected())
				{
					mng1.gender = "Male";
				}
			}
		});
		rdbtnMale.setForeground(Color.DARK_GRAY);
		rdbtnMale.setBounds(105, 57, 74, 23);
		frameEmployee.getContentPane().add(rdbtnMale);
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if(rdbtnFemale.isSelected())
				{
					mng1.gender = "Female";
				}
			}
		});
		rdbtnFemale.setForeground(Color.DARK_GRAY);
		rdbtnFemale.setBounds(181, 58, 109, 23);
		frameEmployee.getContentPane().add(rdbtnFemale);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(10, 88, 97, 14);
		frameEmployee.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setColumns(10);
		txtEmail.setBounds(107, 86, 207, 20);
		frameEmployee.getContentPane().add(txtEmail);
		
		JLabel lblContactNo = new JLabel("Contact No:");
		lblContactNo.setForeground(Color.DARK_GRAY);
		lblContactNo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContactNo.setBounds(10, 114, 97, 14);
		frameEmployee.getContentPane().add(lblContactNo);
		
		txtContact = new JTextField();
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContact.setForeground(Color.DARK_GRAY);
		txtContact.setColumns(10);
		txtContact.setBounds(107, 112, 207, 20);
		frameEmployee.getContentPane().add(txtContact);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(10, 140, 97, 14);
		frameEmployee.getContentPane().add(lblAddress);
		
		JLabel lblDepartment = new JLabel("Department:");
		lblDepartment.setForeground(Color.DARK_GRAY);
		lblDepartment.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDepartment.setBounds(10, 204, 97, 14);
		frameEmployee.getContentPane().add(lblDepartment);
		
		cboDept = new JComboBox<String>();
		cboDept.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<String, Integer> map = cbo.populateCbo("department");
				txtIdDept.setText(map.get(cboDept.getSelectedItem().toString()).toString()); ;
				
			}
		});
		cboDept.setForeground(Color.DARK_GRAY);
		cboDept.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboDept.setBounds(107, 202, 207, 20);
		frameEmployee.getContentPane().add(cboDept);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setForeground(Color.DARK_GRAY);
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPosition.setBounds(10, 231, 97, 14);
		frameEmployee.getContentPane().add(lblPosition);
		
		cboPosition = new JComboBox<String>();
		cboPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HashMap<String, Integer> map = cbo.populateCbo("position");
				txtIdPosn.setText(map.get(cboPosition.getSelectedItem().toString()).toString()); ;
			}
		});
		cboPosition.setForeground(Color.DARK_GRAY);
		cboPosition.setFont(new Font("Tahoma", Font.PLAIN, 12));
		cboPosition.setBounds(107, 229, 207, 20);
		frameEmployee.getContentPane().add(cboPosition);
		
		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtFname.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input firstname.");
				}
				else if(txtLname.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input lastname.");
				}
				else if(txtEmail.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input email.");
				}
				else if(txtContact.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input contact number.");
				}
				else if(txtAddress.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input address.");
				}
				else if(txtIdDept.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please specify department of the employee.");
				}
				else if(txtIdPosn.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please specify position of the employee.");
				}
				else
				{
					mng1.manageMenuInfo(Integer.parseInt(txtIdEmp.getText()), "", "employee", "edit", txtFname.getText(), txtLname.getText(), mng1.gender, txtEmail.getText(), txtContact.getText(), txtAddress.getText(), Integer.parseInt(txtIdDept.getText()), Integer.parseInt(txtIdPosn.getText()));
				}
				
				viewEmp();
			}
		});
		btnEdit.setBackground(SystemColor.controlHighlight);
		btnEdit.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\edit32x32.png"));
		btnEdit.setBounds(271, 254, 43, 43);
		frameEmployee.getContentPane().add(btnEdit);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if(txtFname.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input firstname.");
				}
				else if(txtLname.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input lastname.");
				}
				else if(txtEmail.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input email.");
				}
				else if(txtContact.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input contact number.");
				}
				else if(txtAddress.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input address.");
				}
				else if(txtIdDept.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please specify department of the employee.");
				}
				else if(txtIdPosn.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please specify position of the employee.");
				}
				else
				{
					mng1.manageMenuInfo(mng1.getMaxId(0, "employee"), "", "employee", "add", txtFname.getText(), txtLname.getText(), mng1.gender, txtEmail.getText(), txtContact.getText(), txtAddress.getText(), Integer.parseInt(txtIdDept.getText()), Integer.parseInt(txtIdPosn.getText()));
				}
				
				viewEmp();
			}
		});
		btnAdd.setBackground(SystemColor.controlHighlight);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		btnAdd.setBounds(228, 254, 43, 43);
		frameEmployee.getContentPane().add(btnAdd);
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mng1.idEmp = 0;
				mng1.idDept = 0;
				mng1.idPosn = 0;
				txtFname.setText("");
				txtLname.setText("");
				txtEmail.setText("");
				txtContact.setText("");
				txtAddress.setText("");
				viewEmp();		
			}
		});
		btnNew.setBackground(SystemColor.controlHighlight);
		btnNew.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new32x32.png"));
		btnNew.setBounds(185, 254, 43, 43);
		frameEmployee.getContentPane().add(btnNew);
		
		table.setBackground(SystemColor.control);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(20);
		
		
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(324, 11, 373, 286);
		ScrollPaneConstants.VERTICAL_SCROLLBAR.equals(table);
		frameEmployee.getContentPane().add(pane);
	}
	
	public void bindCbo()
	{
		HashMap<String, Integer> mapDept = cbo.populateCbo("department");
		for(String s : mapDept.keySet())
		{
			cboDept.addItem(s);
		}
		
		HashMap<String, Integer> mapPosn = cbo.populateCbo("position");
		for(String s : mapPosn.keySet())
		{
			cboPosition.addItem(s);
		}
	}
	
	
	public void viewEmp(){
		model.setRowCount(0);
		try
		{
			mng1.st = mng1.con.createStatement();
			mng1.rs = mng1.st.executeQuery("SELECT *, CONCAT(lName, ', ', fName) As Name FROM employee e LEFT JOIN department d ON d.idDept=e.idDept LEFT JOIN position p ON p.idPosn=e.idPosn ORDER BY e.lName ASC");
			
			model.rowsRemoved(null);;
			while(mng1.rs.next()){			
			
					Object[] row = new Object[1000];
					row[0] = mng1.rs.getString("idEmp");
					row[1] = mng1.rs.getString("Name");
					row[2] = mng1.rs.getString("gender");
					row[3] = mng1.rs.getString("email");
					row[4] = mng1.rs.getString("contactNo");
					row[5] = mng1.rs.getString("address");
					row[6] = mng1.rs.getString("idDept");
					row[7] = mng1.rs.getString("department");
					row[8] = mng1.rs.getString("idPosn");
					row[9] = mng1.rs.getString("position");
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
				System.out.println("Error at viewEmp() " + er);
			}
		}//end final try catch
	}//end viewBrand
}
