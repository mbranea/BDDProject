package GUIPages;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import CurrentClient.CurrentAccount;
import accountCreation.WrongDataEnteredException;
import adressManagement.AdressCreator;
import adressManagement.AdressInfo;
import adressManagement.AdressUtil;
import validation.EmptyValidation;
import validation.NoNumbersValidation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AdressRegistration {

	private String[] types = {"Home","Work","Favorite"};
	
	private JFrame frame;
	private JTextField streetField;
	private JTextField nameField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdressRegistration window = new AdressRegistration();
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
	public AdressRegistration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings("unchecked")
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox areaBox = new JComboBox();
		areaBox.setBounds(147, 61, 86, 20);
		frame.getContentPane().add(areaBox);
		
		JComboBox cityBox = new JComboBox();
		
		cityBox.setBounds(147, 30, 86, 20);
		frame.getContentPane().add(cityBox);
		for(String key : AdressUtil.getIdCityMap().keySet())
		{
			cityBox.addItem(key);
		}
		
		cityBox.addItemListener(new ItemListener() {
			
			@SuppressWarnings("unchecked")
			@Override
			public void itemStateChanged(ItemEvent e) {
				try {
					areaBox.setModel(new DefaultComboBoxModel(AdressUtil.areasFromCity(AdressUtil.getIdCityMap().get(e.getItem())).values().toArray()));
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		cityBox.setSelectedIndex(2);
		cityBox.setSelectedIndex(0);
		
		
		
		
		streetField = new JTextField();
		streetField.setBounds(147, 92, 86, 20);
		frame.getContentPane().add(streetField);
		streetField.setColumns(10);
		
		nameField = new JTextField();
		nameField.setBounds(147, 123, 86, 20);
		frame.getContentPane().add(nameField);
		nameField.setColumns(10);
		
		JComboBox typeBox = new JComboBox();
		typeBox.setBounds(147, 154, 86, 20);
		typeBox.setModel(new DefaultComboBoxModel(types));
		frame.getContentPane().add(typeBox);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(10, 33, 46, 14);
		frame.getContentPane().add(lblCity);
		
		JLabel lblArea = new JLabel("Area");
		lblArea.setBounds(10, 64, 46, 14);
		frame.getContentPane().add(lblArea);
		
		JLabel lblStreet = new JLabel("Street number");
		lblStreet.setBounds(10, 95, 86, 14);
		frame.getContentPane().add(lblStreet);
		
		JLabel lblname = new JLabel("Adress Name");
		lblname.setBounds(10, 126, 86, 14);
		frame.getContentPane().add(lblname);
		
		JLabel lblAdressType = new JLabel("Adress Type");
		lblAdressType.setBounds(10, 157, 86, 14);
		frame.getContentPane().add(lblAdressType);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setBounds(144, 185, 89, 23);
		frame.getContentPane().add(btnRegister);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(144, 219, 89, 23);
		frame.getContentPane().add(btnExit);
		
		JLabel lblAdressRegistration = new JLabel("Adress Registration");
		lblAdressRegistration.setBounds(166, 11, 134, 14);
		frame.getContentPane().add(lblAdressRegistration);
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MainWindowClient.main(null);
				frame.dispose();
				
			}
		});
		btnRegister.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				try {
				EmptyValidation emptyValidation = new EmptyValidation();
									AdressCreator registration = new AdressCreator();
					if(emptyValidation.validate(streetField.getText())&&emptyValidation.validate(nameField.getText())) {
					int id = CurrentAccount.getInstance().getId();
					Integer area = AdressUtil.getIntegerKeyFromValue(
							AdressUtil.areasFromCity(
									AdressUtil.getIdCityMap().
									get((String)cityBox.
											getSelectedItem())),
							(String)areaBox.getSelectedItem());
					AdressInfo info = new AdressInfo(nameField.getText(),
							area,id , 
							Integer.parseInt(streetField.getText()),
							(String)typeBox.getSelectedItem()
							,AdressUtil.getIdCityMap().
							get(cityBox.getSelectedItem()));
				    registration.registerAdress(info);
				    JOptionPane.showMessageDialog(frame, "Success");
					}
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(frame, "Connection unavailable");
					e1.printStackTrace();
				} catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(frame, "Please fill out the street number field with numbers only");
					e1.printStackTrace();
				} catch (WrongDataEnteredException e1) {
					JOptionPane.showMessageDialog(frame, "Please fill out all the forms");
				}
						
				
				
			}
		});
	}
	 
}
