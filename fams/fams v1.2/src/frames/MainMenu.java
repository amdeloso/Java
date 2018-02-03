package frames;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import functions.FcnDbConnect;
import java.awt.SystemColor;

public class MainMenu {
	FcnDbConnect mng1;
	
	public JFrame frameMainMenu;
	public JTextField txtIdEmp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu();
					window.frameMainMenu.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MainMenu() {
		mng1 = new FcnDbConnect();
		initialize();
	
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frameMainMenu = new JFrame();
		frameMainMenu.setResizable(false);
		frameMainMenu.setBounds(100, 100, 834, 689);
		frameMainMenu.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		JMenuBar menuBar = new JMenuBar();
		frameMainMenu.setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mnFile.add(mntmLogout);
		
		JMenu mnManage = new JMenu("Manage");
		menuBar.add(mnManage);
		
		JMenuItem mntmDepartment = new JMenuItem("Department");
		mntmDepartment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Department window = new Department();
				window.frameDepartment.setVisible(true);
			}
		});
		mnManage.add(mntmDepartment);
		
		JMenuItem mntmPosition = new JMenuItem("Position");
		mntmPosition.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Position window = new Position();
				window.framePosition.setVisible(true);
			}
		});
		mnManage.add(mntmPosition);
		
		JMenuItem mntmEmployee = new JMenuItem("Employee");
		mntmEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Employee window = new Employee();
				window.frameEmployee.setVisible(true);
			}
		});
		mnManage.add(mntmEmployee);
		
		JSeparator separator = new JSeparator();
		mnManage.add(separator);
		
		JMenuItem mntmSupplier = new JMenuItem("Supplier");
		mntmSupplier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Supplier window = new Supplier();
				window.frameSupplier.setVisible(true);
			}
		});
		mnManage.add(mntmSupplier);
		
		JSeparator separator_1 = new JSeparator();
		mnManage.add(separator_1);
		
		JMenuItem mntmBrand = new JMenuItem("Brand");
		mntmBrand.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Brand window = new Brand();
				window.frameBrand.setVisible(true);
			}
		});
		mnManage.add(mntmBrand);
		
		JMenu mnTransaction = new JMenu("Transaction");
		menuBar.add(mnTransaction);
		
		JMenuItem mntmReceiving = new JMenuItem("Receiving");
		mntmReceiving.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mng1.idEmpLog = Integer.parseInt(txtIdEmp.getText());
				Receiving window = new Receiving();
				window.frameReceiving.setVisible(true);
				window.txtTrnsctnBy.setText(Integer.toString(mng1.idEmpLog));
			}
		});
		mnTransaction.add(mntmReceiving);
		
		JMenu mnReports = new JMenu("Reports");
		menuBar.add(mnReports);
		
		JMenuItem mntmFixedAsset = new JMenuItem("Fixed Asset");
		mntmFixedAsset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				mng1.idEmpLog = Integer.parseInt(txtIdEmp.getText());
				ViewAsset window = new ViewAsset();
				window.frameViewAsset.setVisible(true);
				window.txtTrnsctnBy.setText(Integer.toString(mng1.idEmpLog));
			}
		});
		mnReports.add(mntmFixedAsset);
		
		JMenuItem mntmViewTrnsactionHistory = new JMenuItem("Transaction History");
		mntmViewTrnsactionHistory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportViewHistory window = new ReportViewHistory();
				window.frameReportViewHistory.setVisible(true);
				
			}
		});
		mnReports.add(mntmViewTrnsactionHistory);
		
		JMenuItem mntmViewDepreciationCalc = new JMenuItem("View Depreciation Calc");
		mntmViewDepreciationCalc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReportDepreciation window = new ReportDepreciation();
				window.frameReportDepreciation.setVisible(true);
				
			}
		});
		mnReports.add(mntmViewDepreciationCalc);
		frameMainMenu.getContentPane().setLayout(null);
		
		txtIdEmp = new JTextField();
		txtIdEmp.setEditable(false);
		txtIdEmp.setBackground(SystemColor.control);
		txtIdEmp.setBounds(36, 644, 51, 20);
		frameMainMenu.getContentPane().add(txtIdEmp);
		txtIdEmp.setColumns(10);
	}
}
