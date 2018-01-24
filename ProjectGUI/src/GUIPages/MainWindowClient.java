package GUIPages;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import CurrentClient.CurrentAccount;

import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JLabel;

public class MainWindowClient {

	private JFrame frame;
	private DefaultTableModel model;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindowClient window = new MainWindowClient();
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
	public MainWindowClient() {
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
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(147, 205, 149, 23);
		frame.getContentPane().add(btnLogout);
		
		JButton btnAdressregistration = new JButton("AdressRegistration");
		btnAdressregistration.setBounds(147, 156, 149, 23);
		frame.getContentPane().add(btnAdressregistration);
		
		JButton btnCardregistration = new JButton("CardRegistration");
		btnCardregistration.setBounds(147, 101, 149, 23);
		frame.getContentPane().add(btnCardregistration);
		
		JButton btnPlaceOrder = new JButton("Place order");
		btnPlaceOrder.setBounds(147, 53, 149, 23);
		frame.getContentPane().add(btnPlaceOrder);
		
		JLabel CurrentAccountLabel = new JLabel("CurrentAccount");
		CurrentAccountLabel.setBounds(10, 41, 106, 14);
		frame.getContentPane().add(CurrentAccountLabel);
		CurrentAccountLabel.setText(CurrentAccount.getInstance().getUsername());
		
		btnAdressregistration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				AdressRegistration.main(new String[0]);
				frame.dispose();
				
			}
		});
btnCardregistration.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				CardRegistration.main(new String[0]);
				frame.dispose();
				
			}
		});
btnLogout.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		GUILogin.main(new String[0]);
		frame.dispose();
		
	}
});
btnPlaceOrder.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		OrderPlacement.main(new String[0]);
		frame.dispose();
		
	}
});
	}
}
