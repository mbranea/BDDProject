package GUIPages;
import java.awt.EventQueue;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import CurrentClient.CurrentAccount;
import accountCreation.WrongDataEnteredException;
import cardManagement.CardAdder;
import validation.EmptyValidation;

public class CardRegistration {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CardRegistration window = new CardRegistration();
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
	public CardRegistration() {
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
		
		JFormattedTextField formattedTextField = new JFormattedTextField();
		formattedTextField.setBounds(163, 55, 261, 20);
		frame.getContentPane().add(formattedTextField);
		
		JLabel lblCardNumber = new JLabel("Card Number");
		lblCardNumber.setBounds(21, 58, 102, 14);
		frame.getContentPane().add(lblCardNumber);
		
		JSpinner monthSpinner = new JSpinner();
		monthSpinner.setBounds(184, 109, 49, 30);
		frame.getContentPane().add(monthSpinner);
		
		JSpinner yearSpinner = new JSpinner();
		yearSpinner.setBounds(253, 109, 63, 30);
		frame.getContentPane().add(yearSpinner);
		 JSpinner.NumberEditor editor = new JSpinner.NumberEditor( yearSpinner, "#" );
		 yearSpinner.setEditor( editor );
		
		
		JLabel lblExpirationDate = new JLabel("Expiration Date");
		lblExpirationDate.setBounds(21, 112, 102, 14);
		frame.getContentPane().add(lblExpirationDate);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(163, 162, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnExit = new JButton("Back");
		btnExit.setBounds(163, 200, 89, 23);
		frame.getContentPane().add(btnExit);
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				MainWindowClient.main(new String[0]);
				
			}
		});
		
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardAdder adder = new CardAdder();
				EmptyValidation validation = new EmptyValidation();
				try {
					if(validation.validate(formattedTextField.getText())&&!monthSpinner.getValue().equals("")&&!yearSpinner.getValue().equals("")){
					adder.addCard(formattedTextField.getText(), monthSpinner.getValue() +" "+yearSpinner.getValue() );
					JOptionPane.showMessageDialog(frame,
						    "Successfully added the card");
}
				} catch (HeadlessException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (WrongDataEnteredException e1) {
					JOptionPane.showMessageDialog(frame,
						    "Please fill out the forms");
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Connection unavailable");
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblCardregistration = new JLabel("Card Registration");
		lblCardregistration.setHorizontalAlignment(SwingConstants.CENTER);
		lblCardregistration.setBounds(133, 11, 153, 14);
		frame.getContentPane().add(lblCardregistration);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setBounds(187, 86, 46, 14);
		frame.getContentPane().add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setBounds(263, 86, 46, 14);
		frame.getContentPane().add(lblYear);
	}
}
