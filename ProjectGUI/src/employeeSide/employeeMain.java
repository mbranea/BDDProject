package employeeSide;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import CurrentEmployee.CurrentEmployee;
import CurrentEmployee.CurrentEmployeeUpdater;
import GUIPages.GUILogin;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class employeeMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeMain window = new employeeMain();
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
	public employeeMain() {
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
		
		JLabel lblEmployeePlaceholder = new JLabel("employee Placeholder");
		lblEmployeePlaceholder.setBounds(20, 28, 153, 14);
		frame.getContentPane().add(lblEmployeePlaceholder);
		lblEmployeePlaceholder.setText(CurrentEmployee.getInstance().getUsername());
		
		JButton btnViewOrders = new JButton("View Orders");
		btnViewOrders.setBounds(155, 59, 118, 23);
		frame.getContentPane().add(btnViewOrders);
		
		btnViewOrders.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				employeeOrders.main(new String[0]);
				
			}
		});
		
		JButton btnViewCar = new JButton("View Car");
		btnViewCar.setBounds(155, 125, 118, 23);
		frame.getContentPane().add(btnViewCar);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.setBounds(345, 238, 89, 23);
		frame.getContentPane().add(btnLogout);
		
		JLabel lblCurrentemployee = new JLabel("currentEmployee");
		lblCurrentemployee.setBounds(20, 28, 101, 14);
		frame.getContentPane().add(lblCurrentemployee);
		lblCurrentemployee.setText(CurrentEmployee.getInstance().getUsername());
		btnLogout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				GUILogin.main(new String[0]);
				CurrentEmployeeUpdater.updateClient("Logout");
				
			}
		});
	}
}
