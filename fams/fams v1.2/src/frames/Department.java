package frames;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import functions.FcnDbConnect;
import functions.FcnManageMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Department {
	
	FcnDbConnect mng1;
	FcnManageMenu mng2;
	
	public JFrame frameDepartment;
	private JTextField txtdept;
	//TABLE
	public JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	
	
	private JTextField txtidDept;
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Department window = new Department();
					window.frameDepartment.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Department() {
		mng1 = new FcnDbConnect();
		mng2 = new FcnManageMenu();
			
		initialize(null, null);
		
		//TABLE
		Object[] columns = {"ID", "Department"};
		model.setColumnIdentifiers(columns);
		
		txtidDept = new JTextField();
		txtidDept.setBounds(320, 14, 86, 20);
		frameDepartment.getContentPane().add(txtidDept);
		txtidDept.setColumns(10);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				mng1.idDept =0 ;
				mng1.i = table.getSelectedRow();
				
				mng1.idDept = Integer.parseInt(model.getValueAt(mng1.i, 0).toString());
				txtdept.setText(model.getValueAt(mng1.i, 1).toString());
				
				//Check
				System.out.println(mng1.idDept);
				
				
			}
		});
		table.setModel(model);
		
		
		viewDept();
	}

	/**
	 * Initialize the contents of the frame.
	 * @param data 
	 * @param column 
	 */
	private void initialize(TableModel data, TableColumnModel column) {
		frameDepartment = new JFrame();
		frameDepartment.setResizable(false);
		frameDepartment.setTitle("Department");
		frameDepartment.setBounds(100, 100, 298, 274);
		frameDepartment.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameDepartment.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Department:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setBounds(10, 14, 92, 17);
		frameDepartment.getContentPane().add(lblNewLabel);
		
		txtdept = new JTextField();
		txtdept.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtdept.setForeground(Color.DARK_GRAY);
		txtdept.setBounds(94, 11, 188, 20);
		frameDepartment.getContentPane().add(txtdept);
		txtdept.setColumns(10);
		
		JButton btnNew = new JButton("");
		btnNew.setBackground(SystemColor.controlHighlight);
		btnNew.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new32x32.png"));
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtdept.setText("");
				viewDept();
			}
		});
		btnNew.setBounds(148, 39, 39, 41);
		frameDepartment.getContentPane().add(btnNew);
		
		//BTN ADD
		
		
		JButton btnAdd = new JButton("");
		btnAdd.setBackground(SystemColor.controlHighlight);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtdept.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input department.");
				}
				else
				{
					mng1.manageMenuInfo(mng1.getMaxId(0, "department"), txtdept.getText(), "department", "add", "", "", "", "", "", "", 0, 0);
				}
				viewDept();
			}
		});
		btnAdd.setBounds(190, 39, 45, 41);
		frameDepartment.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtdept.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input department.");
				}
				else if(mng1.idDept == 0)
				{
					JOptionPane.showMessageDialog(null, "Please specify department to edit.");
				}	
				else
				{
					mng1.manageMenuInfo(mng1.idDept, txtdept.getText(), "department", "edit", "", "", "", "", "", "", 0, 0);
				}
				viewDept();
			}
		});
		btnEdit.setBackground(SystemColor.controlHighlight);
		btnEdit.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\edit32x32.png"));
		btnEdit.setBounds(237, 39, 45, 41);
		frameDepartment.getContentPane().add(btnEdit);
		
		table.setBackground(SystemColor.control);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(20);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 91, 272, 143);
		frameDepartment.getContentPane().add(pane);
		
	}
	
	public void viewDept(){
		model.setRowCount(0);
		try
		{
			mng1.st = mng1.con.createStatement();
			mng1.rs = mng1.st.executeQuery("SELECT * FROM department");	
			while(mng1.rs.next()){			
			
					Object[] row = new Object[1000];
					row[0] = mng1.rs.getString("idDept");
					row[1] = mng1.rs.getString("department");
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
				System.out.println("Error at viewDept() " + er);
			}
		}//end final try catch
	}
}
