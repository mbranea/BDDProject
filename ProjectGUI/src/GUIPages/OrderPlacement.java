package GUIPages;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import CurrentClient.CurrentAccount;
import OrderManagement.OrderCreator;
import OrderManagement.OrderInfo;
import adressManagement.AdressCreator;
import adressManagement.AdressUtil;
import cardManagement.CardAdder;
import validation.SQLValidation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class OrderPlacement {

	private JFrame frame;
	private JTable AdressTable;

	private Vector<String> adressVector;
	  private String selectedLocation;
	private JPasswordField passwordField;
	public static boolean correct;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OrderPlacement window = new OrderPlacement();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public OrderPlacement() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(200, 200, 600, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JScrollPane adressScrollPane = new JScrollPane();
		adressScrollPane.setBounds(41, 29, 485, 121);
		
		frame.getContentPane().add(adressScrollPane);

		AdressTable = new JTable();

		DefaultTableModel adressModel = new DefaultTableModel(0, 0);
		String header[] = new String[] { "Tip adresa", "Nume", "Oras", "Cartier", "Numar Strada" };
		adressModel.setColumnIdentifiers(header);

		List<Vector<Object>> vectorList = AdressUtil
				.convertVector(AdressCreator.getAdressesById(CurrentAccount.getInstance().getId()));
		for (Vector<Object> vector : vectorList) {

			adressModel.addRow(vector);
		}
		AdressTable.setModel(adressModel);
		adressScrollPane.setViewportView(AdressTable);

		JLabel lblAdress = new JLabel("Please Select the pick up adress");
		lblAdress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdress.setBounds(41, 11, 467, 14);
		frame.getContentPane().add(lblAdress);

		JLabel lblPayment = new JLabel("Please Select the credit card for the payment");
		lblPayment.setHorizontalAlignment(SwingConstants.CENTER);
		lblPayment.setBounds(41, 172, 467, 14);
		frame.getContentPane().add(lblPayment);

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(411, 447, 115, 23);
		frame.getContentPane().add(btnCancel);

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				OrderPlacement.correct = false;
				frame.dispose();
				MainWindowClient.main(new String[0]);
				frame.dispose();

			}
		});

		JButton btnPlaceOrder = new JButton("Place order");
		btnPlaceOrder.setBounds(41, 447, 115, 23);
		frame.getContentPane().add(btnPlaceOrder);

		JButton btnCheck = new JButton("Check");
		btnCheck.setBounds(237, 447, 89, 23);
		frame.getContentPane().add(btnCheck);

		passwordField = new JPasswordField();
		passwordField.setBounds(237, 416, 89, 20);
		frame.getContentPane().add(passwordField);

		JLabel lblPleaseEnterYour = new JLabel("Please enter your password here");
		lblPleaseEnterYour.setHorizontalAlignment(SwingConstants.CENTER);
		lblPleaseEnterYour.setBounds(184, 391, 196, 14);
		frame.getContentPane().add(lblPleaseEnterYour);
		btnCheck.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				SQLValidation validation = new SQLValidation();
				try {
					if (validation.validate(CurrentAccount.getInstance().getUsername(), passwordField.getText())) {
						OrderPlacement.correct = true;
						lblPleaseEnterYour.setText("Success");
					}else {lblPleaseEnterYour.setText("Wrong Password entered");
					OrderPlacement.correct = false;}
				} catch (NoSuchAlgorithmException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (UnsupportedEncodingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnPlaceOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (correct) {
					Calendar c = Calendar.getInstance();
					c.setTimeInMillis(System.currentTimeMillis());

					String date = c.get(Calendar.YEAR) + "-" + c.get(Calendar.MONTH) + "-"
							+ c.get(Calendar.DAY_OF_MONTH);
					String time = c.get(Calendar.HOUR_OF_DAY) + ":" + c.get(Calendar.MINUTE) + ":"
							+ c.get(Calendar.SECOND);

					OrderInfo info = new OrderInfo(date + "-" + time, 3);
					OrderCreator creator = new OrderCreator();
					try {
						creator.registerOrder(info);
						JOptionPane.showMessageDialog(frame,
							    "Successfully placed the order");
						
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});


		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(294, 197, 70, 20);
		frame.getContentPane().add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel<>(CardAdder.getCardNumbers()));

		ListSelectionModel cardSelectionModel = AdressTable.getSelectionModel();
		cardSelectionModel.addListSelectionListener(new ListSelectionListener() {
     
			@Override
			public void valueChanged(ListSelectionEvent e) {
				adressVector = (Vector<String>) ((DefaultTableModel) AdressTable.getModel()).getDataVector()
						.elementAt(AdressTable.getSelectedRow());
				System.out.println(adressVector);
				selectedLocation = adressVector.get(3);
			}
		});
		
		

	}
}
