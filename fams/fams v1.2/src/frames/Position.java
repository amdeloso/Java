package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import functions.FcnDbConnect;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Position {
	FcnDbConnect mng1;

	JFrame framePosition;
	private JTextField txtposition;
	
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
					Position window = new Position();
					window.framePosition.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Position() {
		mng1 = new FcnDbConnect();
			
		initialize(null, null);
		
		//TABLE
		Object[] columns = {"ID", "Position"};
		
		model.setColumnIdentifiers(columns);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mng1.idPosn =0 ;
				mng1.i = table.getSelectedRow();
				
				mng1.idPosn = Integer.parseInt(model.getValueAt(mng1.i, 0).toString());
				txtposition.setText(model.getValueAt(mng1.i, 1).toString());
				
				//Check
				System.out.println(mng1.idPosn);
			}
		});
		table.setModel(model);
		
		viewPosition();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(TableModel data, TableColumnModel column) {
		framePosition = new JFrame();
		framePosition.setTitle("Position");
		framePosition.setBounds(100, 100, 315, 300);
		framePosition.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		framePosition.getContentPane().setLayout(null);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setForeground(Color.DARK_GRAY);
		lblPosition.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPosition.setBounds(10, 11, 68, 14);
		framePosition.getContentPane().add(lblPosition);
		
		txtposition = new JTextField();
		txtposition.setForeground(Color.DARK_GRAY);
		txtposition.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtposition.setBounds(75, 8, 216, 20);
		framePosition.getContentPane().add(txtposition);
		txtposition.setColumns(10);
		
		JButton btnEdit = new JButton("");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtposition.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input position.");
				}
				else if(mng1.idPosn== 0)
				{
					JOptionPane.showMessageDialog(null, "Please specify position to edit.");
				}	
				else
				{
					mng1.manageMenuInfo(mng1.idPosn, txtposition.getText(), "position", "edit", "", "", "", "", "", "", 0, 0);
				}
				viewPosition();
				
			}
		});
		btnEdit.setBackground(SystemColor.controlHighlight);
		btnEdit.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\edit32x32.png"));
		btnEdit.setBounds(248, 31, 43, 43);
		framePosition.getContentPane().add(btnEdit);
		
		JButton btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtposition.getText().length()==0)
				{
					JOptionPane.showMessageDialog(null, "Please input position.");
				}
				else
				{
					mng1.manageMenuInfo(mng1.getMaxId(0, "position"), txtposition.getText(), "position", "add", "", "", "", "", "", "", 0, 0);
				}
				
				viewPosition();
			}
		});
		btnAdd.setBackground(SystemColor.controlHighlight);
		btnAdd.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		btnAdd.setBounds(205, 31, 43, 43);
		framePosition.getContentPane().add(btnAdd);
		
		JButton btnNew = new JButton("");
		btnNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtposition.setText("");
				viewPosition();
			}
		});
		btnNew.setBackground(SystemColor.controlHighlight);
		btnNew.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new32x32.png"));
		btnNew.setBounds(162, 31, 43, 43);
		framePosition.getContentPane().add(btnNew);
		
		table.setBackground(SystemColor.control);
		table.setForeground(Color.DARK_GRAY);
		table.setFont(new Font("Tahoma", Font.PLAIN, 12));
		table.setRowHeight(20);
		
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 85, 281, 165);
		framePosition.getContentPane().add(pane);
	}
	
	public void viewPosition(){
		model.setRowCount(0);
		try
		{
			mng1.st = mng1.con.createStatement();
			mng1.rs = mng1.st.executeQuery("SELECT * FROM position");
			
			
			model.rowsRemoved(null);;
			while(mng1.rs.next()){			
			
					Object[] row = new Object[1000];
					row[0] = mng1.rs.getString("idPosn");
					row[1] = mng1.rs.getString("position");
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
				System.out.println("Error at viewPosition() " + er);
			}
		}//end final try catch
	}//end viewBrand
}
