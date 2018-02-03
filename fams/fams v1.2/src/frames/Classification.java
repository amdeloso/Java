package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.ImageIcon;

public class Classification {

	public JFrame frame;
	private JTextField textField;
	
	//Table 
	JTable table = new JTable();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Classification window = new Classification();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Classification() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 327, 280);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblClassification = new JLabel("Classification:");
		lblClassification.setForeground(Color.DARK_GRAY);
		lblClassification.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblClassification.setBounds(10, 11, 91, 14);
		frame.getContentPane().add(lblClassification);
		
		textField = new JTextField();
		textField.setForeground(Color.DARK_GRAY);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 13));
		textField.setBounds(107, 8, 201, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnEdit = new JButton("");
		btnEdit.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\edit32x32.png"));
		btnEdit.setBackground(SystemColor.controlHighlight);
		btnEdit.setBounds(265, 31, 43, 44);
		frame.getContentPane().add(btnEdit);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\save32x32 (2).png"));
		button_1.setBackground(SystemColor.controlHighlight);
		button_1.setBounds(222, 31, 43, 44);
		frame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon("C:\\Users\\Vany\\Documents\\nz technology academy\\1.0 Java\\fams v1.2\\lib\\new32x32.png"));
		button_2.setBackground(SystemColor.controlHighlight);
		button_2.setBounds(179, 31, 43, 44);
		frame.getContentPane().add(button_2);
		
		//Table
		JScrollPane pane = new JScrollPane(table);
		pane.setBounds(10, 75, 300, 165);
		frame.getContentPane().add(pane);
		
		
	
	}

}
