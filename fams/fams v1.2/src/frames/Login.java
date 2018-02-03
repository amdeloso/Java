package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import functions.FcnDbConnect;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login {

	private JTextField txtUsername;
	private JPasswordField fldPassword;
	
	//Functions
	FcnDbConnect mngFcnDbCon;
	
	//Forms
	JFrame frmLogin;
	MainFrame frmMainFrame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frmLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
		mngFcnDbCon = new FcnDbConnect();
		frmMainFrame = new MainFrame();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLogin = new JFrame();
		frmLogin.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmLogin.setTitle("Login");
		frmLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		frmLogin.setBounds(100, 100, 329, 154);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Username: ");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblUsername.setBounds(10, 21, 74, 14);
		frmLogin.getContentPane().add(lblUsername);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtUsername.setBounds(80, 18, 191, 20);
		frmLogin.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password: ");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPassword.setBounds(10, 49, 74, 14);
		frmLogin.getContentPane().add(lblPassword);
		
		fldPassword = new JPasswordField();
		fldPassword.setFont(new Font("Tahoma", Font.PLAIN, 12));
		fldPassword.setBounds(80, 46, 191, 20);
		frmLogin.getContentPane().add(fldPassword);
		
		JButton btnLogin = new JButton("OK");
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//start
				mngFcnDbCon.loginUser(txtUsername.getText(), String.copyValueOf(fldPassword.getPassword()));
				if(mngFcnDbCon.usrCnt == 1) {
					mngFcnDbCon.getHostInfo();
					mngFcnDbCon.addTransLogInfo(mngFcnDbCon.idEmp, mngFcnDbCon.ipAdd, mngFcnDbCon.pcName, "LOGIN", 0, "INSERT", "NEW","Login");
				}
				
				//end
				
			}
		});
		
		btnLogin.setBounds(80, 77, 74, 23);
		frmLogin.getContentPane().add(btnLogin);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnCancel.setBounds(159, 77, 74, 23);
		frmLogin.getContentPane().add(btnCancel);
	}
}
