package employeeSide;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;


import orderManagement.OrderGetter;
import javax.swing.JButton;

public class employeeOrders {
    private JTable table;
	private JFrame frame;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					employeeOrders window = new employeeOrders();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public employeeOrders() throws ClassNotFoundException, SQLException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws ClassNotFoundException, SQLException {
		frame = new JFrame();
		frame.setBounds(200, 200, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEmployeeplaceholder = new JLabel("employeePlaceholder");
		lblEmployeeplaceholder.setBounds(10, 34, 139, 14);
		frame.getContentPane().add(lblEmployeeplaceholder);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 33, 220, 82);
		
		frame.getContentPane().add(scrollPane);
		
		
		table = new JTable();

		DefaultTableModel model = new DefaultTableModel(0, 0);
		String header[] = new String[] { "Nume Cartier", "Data comanda" };
		model.setColumnIdentifiers(header);

		List<Vector<Object>> vectorList = (new OrderGetter()).getOrders();
		for (Vector<Object> vector : vectorList) {

			model.addRow(vector);
		}
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JButton btnCompleteOrder = new JButton("Complete order");
		btnCompleteOrder.setBounds(159, 145, 220, 23);
		frame.getContentPane().add(btnCompleteOrder);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(290, 179, 89, 23);
		frame.getContentPane().add(btnBack);
		
		ListSelectionModel cardSelectionModel = table.getSelectionModel();
		cardSelectionModel.addListSelectionListener(new ListSelectionListener() {
			Vector<String> orderVector;
			@SuppressWarnings("unchecked")
			@Override
			public void valueChanged(ListSelectionEvent e) {
				orderVector = (Vector<String>) ((DefaultTableModel) table.getModel()).getDataVector()
						.elementAt(table.getSelectedRow());
				System.out.println(orderVector);
				cardSelectionModel.removeListSelectionListener(this);
			}
		});
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				employeeMain.main(null);
				
			}
		});
		
		btnCompleteOrder.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				 DefaultTableModel model = (DefaultTableModel) table.getModel();
				   int[] rows = table.getSelectedRows();
				   for(int i=0;i<rows.length;i++){
				     model.removeRow(rows[i]-i);
				   }
				   cardSelectionModel.addListSelectionListener(new ListSelectionListener() {
						Vector<String> orderVector;
						@SuppressWarnings("unchecked")
						@Override
						public void valueChanged(ListSelectionEvent e) {
							orderVector = (Vector<String>) ((DefaultTableModel) table.getModel()).getDataVector()
									.elementAt(table.getSelectedRow());
							System.out.println(orderVector);
							cardSelectionModel.removeListSelectionListener(this);
						}
					});
			}
		});
		
	}
}
