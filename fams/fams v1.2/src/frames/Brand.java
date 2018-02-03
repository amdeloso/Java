package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import functions.FcnDbConnect;
import functions.FcnManageMenu;

import javax.swing.JButton;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Brand {
	//functions
	FcnDbConnect mng1;
	FcnManageMenu mng2;
	
	public JFrame frameBrand;
	private JTextField txtbrand;
	
	//Table
	public JTable table = new JTable();
	DefaultTableModel model = new DefaultTableModel();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Brand window = new Brand();
					window.frameBrand.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Brand() {
		mng1 = new FcnDbConnect();
		mng2 = new FcnManageMenu();
			
		initialize(null, null);
		
		//TABLE
		Object[] columns = {"ID", "Brand"};
		
		model.setColumnIdentifiers(columns);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mng1.idBrand =0 ;
				mng1.i = table.getSelectedRow();
				
				mng1.idBrand = Integer.parseInt(model.getValueAt(mng1.i, 0).toString());
				txtbrand.setText(model.getValueAt(mng1.i, 1).toString());
				
				//Check
				System.out.println(mng1.idBrand);
			}
		});
		table.setModel(model);
		
		viewBrand();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(TableModel data, TableColumnModel column) {
		frameBrand = new JFrame();
		frameBrand.setResizable(false);
		frameBrand.setBackground(new Color(240, 240, 240));
		frameBrand.setTitle("Brand");
		frameBrand.setBounds(100, 100, 302, 300);
		frameBrand.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frameBrand.getContentPane().setLayout(null);
		
		JLabel lblBrand = new JLabel("Brand:");
		lblBrand.setForeground(Color.DARK_GRAY);
		lblBrand.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblBrand.setBounds(10, 14, 88, 17);
		frameBrand.getContentPane().add(lblBrand);
		
		txtbrand = new JTextField();
		txtbrand.setForeground(Color.DARK_GRAY);
		txtbrand.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtbrand.setColumns(10);
		txtbrand.setBounds(62, 11, 216, 20);
		frameBrand.getContentPane().add(txtbrand);
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtbrand.setText("");
				viewBrand();
			}
		});
		btnNew.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new32x32.png"));
		btnNew.setBackground(new Color(227, 227, 227));
		btnNew.setBounds(138, 39, 45, 41);
		frameBrand.getContentPane().add(btnNew);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtbrand.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input brand.");
				}
				else
				{
					mng1.manageMenuInfo(mng1.getMaxId(0, "brand"), txtbrand.getText(), "brand", "add", "", "", "","", "", "", 0, 0);
				}
				
				viewBrand();
			}
		});
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		btnAdd.setBackground(SystemColor.controlHighlight);
		btnAdd.setBounds(186, 39, 45, 41);
		frameBrand.getContentPane().add(btnAdd);
		
		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtbrand.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input brand.");
				}
				else if(mng1.idBrand == 0)
				{
					JOptionPane.showMessageDialog(null, "Please specify brand to edit.");
				}	
				else
				{
					mng1.manageMenuInfo(mng1.idBrand, txtbrand.getText(), "brand", "edit", "", "", "", "", "", "", 0, 0);
				}
				viewBrand();
			}
		});
		btnEdit.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\edit32x32.png"));
		btnEdit.setBackground(SystemColor.controlHighlight);
		btnEdit.setBounds(233, 39, 45, 41);
		frameBrand.getContentPane().add(btnEdit);
		table.setBorder(new LineBorder(Color.LIGHT_GRAY));
		
		table.setBackground(SystemColor.control);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(20);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 91, 268, 159);
		frameBrand.getContentPane().add(pane);
	}
	
	public void viewBrand(){
		model.setRowCount(0);
		try
		{
			mng1.st = mng1.con.createStatement();
			mng1.rs = mng1.st.executeQuery("SELECT * FROM brand");
			
			
			model.rowsRemoved(null);;
			while(mng1.rs.next()){			
			
					Object[] row = new Object[1000];
					row[0] = mng1.rs.getString("idBrand");
					row[1] = mng1.rs.getString("brand");
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

}
