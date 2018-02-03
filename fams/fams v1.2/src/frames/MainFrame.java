package frames;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;



public class MainFrame extends JFrame {
	
	JDesktopPane desktopPane = new JDesktopPane();
	//JInternalFrame intFrame = new JInternalFrame("JInternanl Frame");
	JInternalFrame frameDeptPosn = new JInternalFrame("Department");
	//JInternalFrame frameReceiving = new JInternalFrame("Receiving");
	
	//CBO
	
	
	
	private static final long serialVersionUID = -5825828147754286673L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					/*MainFrame frame = new MainFrame();
					frame.setVisible(true);*/
					MainFrame iframe = new MainFrame();
					iframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					iframe.setSize(640, 480);
					iframe.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setFont(new Font("Tahoma", Font.BOLD, 12));	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Fixed Asset Monitoring System v1.2");
		setBounds(100, 100, 720, 662);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setToolTipText("kk");
		menuBar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnFile.setPreferredSize(new Dimension(122, 22));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnFile.add(mntmExit);
		
		JMenu mnManage = new JMenu("Manage       ");
		mnManage.setHorizontalTextPosition(SwingConstants.LEFT);
		mnManage.setPreferredSize(new Dimension(122, 22));
		mnManage.setHorizontalAlignment(SwingConstants.LEFT);
		mnManage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(mnManage);
		
		JMenuItem mntmDepartment = new JMenuItem("Department");
		mntmDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//start
				frameDeptPosn.setLocation(46, 55);
				frameDeptPosn.setSize(320, 240);
				frameDeptPosn.setVisible(true);
				frameDeptPosn.setResizable(true);
				frameDeptPosn.setClosable(true);
				desktopPane.setBackground(Color.LIGHT_GRAY);
				
				desktopPane.add(frameDeptPosn);
				getContentPane().add(desktopPane);
				//end
				
			}
		});
		mntmDepartment.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnManage.add(mntmDepartment);
		
		JMenuItem mntmPosition = new JMenuItem("Position");
		mntmPosition.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnManage.add(mntmPosition);
		
		JMenuItem mntmEmployee = new JMenuItem("Employee");
		mntmEmployee.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnManage.add(mntmEmployee);
		
		JSeparator separator = new JSeparator();
		mnManage.add(separator);
		
		JMenuItem mntmCategory = new JMenuItem("Category");
		mntmCategory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnManage.add(mntmCategory);
		
		JMenuItem mntmItems = new JMenuItem("Items");
		mntmItems.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnManage.add(mntmItems);
		
		JSeparator separator_1 = new JSeparator();
		mnManage.add(separator_1);
		
		JMenuItem mntmUserAccount = new JMenuItem("User Account");
		mntmUserAccount.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnManage.add(mntmUserAccount);
		
		JMenuItem mntmPrivilege = new JMenuItem("Privilege");
		mntmPrivilege.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnManage.add(mntmPrivilege);
		
		JMenu mnSettings = new JMenu("Transactions");
		mnSettings.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnSettings.setPreferredSize(new Dimension(122, 22));
		menuBar.add(mnSettings);
		
		JMenuItem mntmReceiving = new JMenuItem("Receiving");
		mntmReceiving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//start
				/*frameReceiving.setLocation(46, 55);
				frameReceiving.setSize(320, 240);
				frameReceiving.setVisible(true);
				frameReceiving.setResizable(true);
				frameReceiving.setClosable(true);
				desktopPane.setBackground(Color.LIGHT_GRAY);
				
				desktopPane.add(frameReceiving);
				getContentPane().add(desktopPane);*/
				
				//new
				 Receiving window = new Receiving();
		         window.frameReceiving.setVisible(true);
				//end
			}
		});
		mnSettings.add(mntmReceiving);
		
		JMenu mnReports = new JMenu("Reports");
		mnReports.setFont(new Font("Tahoma", Font.PLAIN, 12));
		mnReports.setPreferredSize(new Dimension(122, 22));
		menuBar.add(mnReports);
		
		JMenuItem mntmDaily = new JMenuItem("Daily");
		mnReports.add(mntmDaily);
		
		JMenuItem menuItem = new JMenuItem("");
		menuItem.setFont(new Font("Tahoma", Font.PLAIN, 12));
		menuBar.add(menuItem);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		
		/*intFrame.setLocation(46, 55);
		intFrame.setSize(320, 240);
		intFrame.setVisible(true);
		intFrame.setResizable(true);
		intFrame.setClosable(true);
		desktopPane.setBackground(Color.LIGHT_GRAY);
		
		desktopPane.add(intFrame);
		getContentPane().add(desktopPane);*/
	}
}
