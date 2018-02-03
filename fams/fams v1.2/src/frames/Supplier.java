package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import functions.FcnDbConnect;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Supplier {
	FcnDbConnect mng1;
	
	public JFrame frameSupplier;
	private JTextField txtSupplier;
	private JTextField txtAddress;
	private JTextField txtContact;
	private JTextField txtEmail;
	
	//Table
	public JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	private JTextField txtIdSupplier;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Supplier window = new Supplier();
					window.frameSupplier.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Supplier() {
		mng1 = new FcnDbConnect();
			
		initialize(null, null);
		
		//TABLE
		Object[] columns = {"ID", "Supplier", "Address", "Contact #", "Email"};
		
		model.setColumnIdentifiers(columns);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mng1.i = table.getSelectedRow();
				
				txtIdSupplier.setText(model.getValueAt(mng1.i, 0).toString());
				txtSupplier.setText(model.getValueAt(mng1.i, 1).toString());
				txtAddress.setText(model.getValueAt(mng1.i, 2).toString());
				txtContact.setText(model.getValueAt(mng1.i, 3).toString());
				txtEmail.setText(model.getValueAt(mng1.i, 4).toString());
			}
		});
		table.setModel(model);
		
		txtIdSupplier = new JTextField();
		txtIdSupplier.setText("0");
		txtIdSupplier.setEditable(false);
		txtIdSupplier.setForeground(Color.DARK_GRAY);
		txtIdSupplier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtIdSupplier.setColumns(10);
		txtIdSupplier.setBounds(25, 196, 25, 20);
		frameSupplier.getContentPane().add(txtIdSupplier);
		
		viewSupplier();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(TableModel data, TableColumnModel column) {
		frameSupplier = new JFrame();
		frameSupplier.setResizable(false);
		frameSupplier.setTitle("Supplier");
		frameSupplier.setBounds(100, 100, 710, 195);
		frameSupplier.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameSupplier.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Supplier:");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setBounds(10, 11, 80, 14);
		frameSupplier.getContentPane().add(lblNewLabel);
		
		txtSupplier = new JTextField();
		txtSupplier.setForeground(Color.DARK_GRAY);
		txtSupplier.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtSupplier.setBounds(87, 8, 233, 20);
		frameSupplier.getContentPane().add(txtSupplier);
		txtSupplier.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setForeground(Color.DARK_GRAY);
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(10, 39, 80, 14);
		frameSupplier.getContentPane().add(lblAddress);
		
		txtAddress = new JTextField();
		txtAddress.setForeground(Color.DARK_GRAY);
		txtAddress.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtAddress.setColumns(10);
		txtAddress.setBounds(87, 36, 233, 20);
		frameSupplier.getContentPane().add(txtAddress);
		
		JLabel lblContact = new JLabel("Contact #:");
		lblContact.setForeground(Color.DARK_GRAY);
		lblContact.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContact.setBounds(10, 67, 80, 14);
		frameSupplier.getContentPane().add(lblContact);
		
		txtContact = new JTextField();
		txtContact.setForeground(Color.DARK_GRAY);
		txtContact.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtContact.setColumns(10);
		txtContact.setBounds(87, 64, 233, 20);
		frameSupplier.getContentPane().add(txtContact);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setForeground(Color.DARK_GRAY);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEmail.setBounds(10, 95, 80, 14);
		frameSupplier.getContentPane().add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setForeground(Color.DARK_GRAY);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtEmail.setColumns(10);
		txtEmail.setBounds(87, 92, 233, 20);
		frameSupplier.getContentPane().add(txtEmail);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.DARK_GRAY);
		label.setFont(new Font("Tahoma", Font.PLAIN, 13));
		label.setBounds(10, 123, 80, 14);
		frameSupplier.getContentPane().add(label);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSupplier.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input supplier.");
				}
				else if(txtAddress.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input address.");
				}
				else if(txtContact.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input contact number.");
				}
				else if(txtEmail.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input email.");
				}
				else
				{
					mng1.manageMenuInfo(Integer.parseInt(txtIdSupplier.getText()), txtSupplier.getText(), "supplier", "edit", "", "", "", txtEmail.getText(), txtContact.getText(), txtAddress.getText(), 0, 0);
				}
				
				viewSupplier();
			}
		});
		button.setBackground(SystemColor.controlHighlight);
		button.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\edit32x32.png"));
		button.setBounds(277, 114, 43, 43);
		frameSupplier.getContentPane().add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtSupplier.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input supplier.");
				}
				else if(txtAddress.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input address.");
				}
				else if(txtContact.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input contact number.");
				}
				else if(txtEmail.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input email.");
				}
				else
				{
					mng1.manageMenuInfo(mng1.getMaxId(0, "supplier"), txtSupplier.getText(), "supplier", "add", "", "", "", txtEmail.getText(), txtContact.getText(), txtAddress.getText(), 0, 0);
				}
				
				viewSupplier();
			}
		});
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		button_1.setBounds(234, 114, 43, 43);
		frameSupplier.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtSupplier.setText("");
				txtAddress.setText("");
				txtContact.setText("");
				txtEmail.setText("");
				viewSupplier();
			}
		});
		button_2.setBackground(SystemColor.controlHighlight);
		button_2.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new32x32.png"));
		button_2.setBounds(190, 114, 43, 43);
		frameSupplier.getContentPane().add(button_2);
		
		table.setBackground(SystemColor.control);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(20);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(330, 11, 354, 145);
		frameSupplier.getContentPane().add(pane);
	}
	
	public void viewSupplier(){
		model.setRowCount(0);
		try
		{
			mng1.st = mng1.con.createStatement();
			mng1.rs = mng1.st.executeQuery("SELECT * FROM supplier");
			
			
			model.rowsRemoved(null);;
			while(mng1.rs.next()){			
			
					Object[] row = new Object[1000];
					row[0] = mng1.rs.getString("idSupplier");
					row[1] = mng1.rs.getString("supplier");
					row[2] = mng1.rs.getString("address");
					row[3] = mng1.rs.getString("contactNo");
					row[4] = mng1.rs.getString("email");
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
	}//end viewSupplier
}
