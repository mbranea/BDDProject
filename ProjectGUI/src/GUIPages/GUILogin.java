package GUIPages;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import accountCreation.AccountCreator;
import accountCreation.WrongDataEnteredException;
import employeeLogin.EmployeeLogin;
import employeeSide.employeeMain;
import login.AccountLogin;

import javax.swing.JSplitPane;
import javax.swing.JPanel;
import javax.swing.JDesktopPane;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

public class GUILogin {

	private JFrame frame;
	private JTextField usernameField;
	private JPasswordField passwordField;
	private JLabel titleLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUILogin window = new GUILogin();
				//	UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
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
	public GUILogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{51, 91, 40, 101, 0};
		gridBagLayout.rowHeights = new int[]{33, 49, 23, 23, 35, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		titleLabel = new JLabel("                            CabApp                          ");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBackground(Color.GRAY);
		GridBagConstraints gbc_titleLabel = new GridBagConstraints();
		gbc_titleLabel.fill = GridBagConstraints.VERTICAL;
		gbc_titleLabel.insets = new Insets(0, 0, 5, 0);
		gbc_titleLabel.gridx = 3;
		gbc_titleLabel.gridy = 0;
		frame.getContentPane().add(titleLabel, gbc_titleLabel);
		
		JLabel lblUsername = new JLabel("Username");
		GridBagConstraints gbc_lblUsername = new GridBagConstraints();
		gbc_lblUsername.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblUsername.insets = new Insets(0, 0, 5, 5);
		gbc_lblUsername.gridx = 0;
		gbc_lblUsername.gridy = 2;
		frame.getContentPane().add(lblUsername, gbc_lblUsername);
		
		usernameField = new JTextField();
		GridBagConstraints gbc_usernameField = new GridBagConstraints();
		gbc_usernameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_usernameField.insets = new Insets(0, 0, 5, 5);
		gbc_usernameField.gridx = 1;
		gbc_usernameField.gridy = 2;
		frame.getContentPane().add(usernameField, gbc_usernameField);
		usernameField.setColumns(10);
		
		JButton btnLogin = new JButton("Login");
		GridBagConstraints gbc_btnLogin = new GridBagConstraints();
		gbc_btnLogin.anchor = GridBagConstraints.NORTH;
		gbc_btnLogin.insets = new Insets(0, 0, 5, 0);
		gbc_btnLogin.gridx = 3;
		gbc_btnLogin.gridy = 2;
		frame.getContentPane().add(btnLogin, gbc_btnLogin);
		JRadioButton rdbtnEmployee = new JRadioButton("Employee");
		GridBagConstraints gbc_rdbtnEmployee = new GridBagConstraints();
		gbc_rdbtnEmployee.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnEmployee.gridx = 3;
		gbc_rdbtnEmployee.gridy = 5;
		frame.getContentPane().add(rdbtnEmployee, gbc_rdbtnEmployee);
		btnLogin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!rdbtnEmployee.isSelected()) {
				
				AccountLogin login = new AccountLogin();
				try {
				String message =	login.verifyLogin(usernameField.getText(), new String(passwordField.getPassword()));
				titleLabel.setText(message);
				if(message.equals("Login Successfull"))
				{
					frame.dispose();
				MainWindowClient.main(new String[0]);
				frame.dispose();
				}
				} catch (WrongDataEnteredException e1) {
					// TODO Auto-generated catch block
					
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}else 
			{   
				EmployeeLogin login = new EmployeeLogin();
				try {
				String message =	login.verifyLogin(usernameField.getText(), new String(passwordField.getPassword()));
				titleLabel.setText(message);
				if(message.equals("Login Successfull"))
				{
					frame.dispose();
				employeeMain.main(new String[0]);
				frame.dispose();
				}
				} catch (WrongDataEnteredException e1) {
					// TODO Auto-generated catch block
					
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			}
		});
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.anchor = GridBagConstraints.WEST;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 5);
		gbc_lblPassword.gridx = 0;
		gbc_lblPassword.gridy = 3;
		frame.getContentPane().add(lblPassword, gbc_lblPassword);
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 1;
		gbc_passwordField.gridy = 3;
		frame.getContentPane().add(passwordField, gbc_passwordField);
		
		JButton btnNewAccount = new JButton("New Account?");
		btnNewAccount.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				GUIRegistration.main(new String[0]);;
				frame.dispose();
				
				
			}
		});
		
		GridBagConstraints gbc_btnNewAccount = new GridBagConstraints();
		gbc_btnNewAccount.anchor = GridBagConstraints.NORTH;
		gbc_btnNewAccount.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewAccount.gridx = 3;
		gbc_btnNewAccount.gridy = 3;
		frame.getContentPane().add(btnNewAccount, gbc_btnNewAccount);
		
		
	}
	public String getLblCabappText() {
		return titleLabel.getText();
	}
	public void setLblCabappText(String text) {
		titleLabel.setText(text);
	}
}
