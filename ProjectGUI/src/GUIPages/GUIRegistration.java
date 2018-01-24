package GUIPages;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;

import accountCreation.AccountCreator;
import accountCreation.AccountInfo;
import accountCreation.WrongDataEnteredException;

import javax.swing.JButton;
import javax.swing.SwingConstants;

public class GUIRegistration {

	private JFrame frame;
	private JTextField usernameField;
	private JTextField firstField;
	private JTextField lastField;
	private JTextField phoneField;
	private JTextField emailField;
	private JPasswordField passwordField;
	private JPasswordField confirmField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIRegistration window = new GUIRegistration();
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
	public GUIRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		usernameField = new JTextField();
		usernameField.setBounds(163, 11, 86, 20);
		frame.getContentPane().add(usernameField);
		usernameField.setColumns(10);
		
		firstField = new JTextField();
		firstField.setBounds(163, 42, 86, 20);
		frame.getContentPane().add(firstField);
		firstField.setColumns(10);
		
		lastField = new JTextField();
		lastField.setBounds(163, 73, 86, 20);
		frame.getContentPane().add(lastField);
		lastField.setColumns(10);
		
		phoneField = new JTextField();
		phoneField.setBounds(163, 104, 86, 20);
		frame.getContentPane().add(phoneField);
		phoneField.setColumns(10);
		
		emailField = new JTextField();
		emailField.setBounds(163, 139, 86, 20);
		frame.getContentPane().add(emailField);
		emailField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(163, 170, 86, 20);
		frame.getContentPane().add(passwordField);
		
		confirmField = new JPasswordField();
		confirmField.setBounds(163, 201, 86, 20);
		frame.getContentPane().add(confirmField);
		
		JLabel usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(0, 14, 86, 14);
		frame.getContentPane().add(usernameLabel);
		
		JLabel firstnameLabel = new JLabel("First Name");
		firstnameLabel.setBounds(0, 45, 86, 14);
		frame.getContentPane().add(firstnameLabel);
		
		JLabel lastnameLabel = new JLabel("Last Name");
		lastnameLabel.setBounds(0, 76, 86, 14);
		frame.getContentPane().add(lastnameLabel);
		
		JLabel phoneLabel = new JLabel("Phone");
		phoneLabel.setBounds(0, 107, 86, 14);
		frame.getContentPane().add(phoneLabel);
		
		JLabel emailLabel = new JLabel("E-Mail");
		emailLabel.setBounds(0, 142, 86, 14);
		frame.getContentPane().add(emailLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(0, 173, 95, 14);
		frame.getContentPane().add(passwordLabel);
		
		JLabel confirmLabel = new JLabel("Confirm Password");
		confirmLabel.setBounds(0, 204, 95, 14);
		frame.getContentPane().add(confirmLabel);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(305, 60, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(305, 138, 89, 23);
		frame.getContentPane().add(btnExit);
		JLabel lblStatusLabel = new JLabel("  123");
		lblStatusLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblStatusLabel.setBounds(35, 232, 359, 14);
		frame.getContentPane().add(lblStatusLabel);
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				AccountInfo info = new AccountInfo();
				try {
					info.initialiseAccountInfoObject(usernameField.getText(), new String(passwordField.getPassword()), emailField.getText(), lastField.getText(), firstField.getText(),phoneField.getText());
					
					
						new AccountCreator().registerAccount(info);
						JOptionPane.showMessageDialog(frame,
							    "Account created successfully");
						
						
					
				} catch (SQLException | ClassNotFoundException |WrongDataEnteredException e1) {
					
					if(e1 instanceof SQLException) {
					JOptionPane.showMessageDialog(frame, "Connection to the database has failed");
					}else if(e1 instanceof WrongDataEnteredException) {
					JOptionPane.showMessageDialog(frame, "Please fill out all the forms correctly");
					}
					} catch (NoSuchAlgorithmException e1) {
				
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} 
				
			}
		
		});
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GUILogin.main(null);
				
			}
		});
	}
}
