package program;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import entities.Account;
import entities.CheckOut;
import entities.User;
import models.AccountModel;
import models.CheckOutModel;

import models.UserModels;

import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CheckOutManagement extends JPanel {

	private JTextField jtextFieldSeach;
	private JTable jtalbeCheckOut;
	private Map<String, Object> data;
	public Main main;
	private JButton jbtnDetails;

	/**
	 * Create the panel.
	 */
	public CheckOutManagement() {

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}

		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		add(panel);

		JLabel lblSeach = new JLabel("Id user");
		lblSeach.setBackground(Color.BLACK);
		lblSeach.setForeground(Color.BLACK);
		lblSeach.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblSeach);

		jtextFieldSeach = new JTextField();
		jtextFieldSeach.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					actionSearch();
				}
			}
		});
		panel.add(jtextFieldSeach);
		jtextFieldSeach.setColumns(20);

		JButton jbtnNewButtonSeach = new JButton("");
		jbtnNewButtonSeach.setBorderPainted(false);
		jbtnNewButtonSeach.setContentAreaFilled(false);
		jbtnNewButtonSeach.setBackground(new Color(255, 228, 196));
		jbtnNewButtonSeach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnNewButtonSeach_actionPerformed(arg0);
			}
		});
		jbtnNewButtonSeach.setFont(new Font("Tahoma", Font.PLAIN, 20));
		jbtnNewButtonSeach
				.setIcon(new ImageIcon(CheckOutManagement.class.getResource("/resources/search12345-removebg-preview (1).png")));
		panel.add(jbtnNewButtonSeach);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		jtalbeCheckOut = new JTable();
		jtalbeCheckOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jbtnDetails.setEnabled(true);
			}
		});
		jtalbeCheckOut.setBackground(Color.ORANGE);
		scrollPane.setViewportView(jtalbeCheckOut);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

		jbtnDetails = new JButton("Details");
		jbtnDetails.setEnabled(false);
		jbtnDetails.setBorderPainted(false);
		jbtnDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnDetails_actionPerformed(arg0);
			}
		});
		jbtnDetails.setBackground(new Color(255, 228, 196));
		jbtnDetails.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtnDetails.setIcon(new ImageIcon(CheckOutManagement.class.getResource("/resources/product-details-1-763726.png")));
		panel_2.add(jbtnDetails);

		JButton jbtnAdd = new JButton("Add");
		jbtnAdd.setBackground(new Color(255, 228, 196));
		jbtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnAdd_actionPerformed(arg0);
			}
		});
		jbtnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtnAdd.setIcon(
				new ImageIcon(CheckOutManagement.class.getResource("/resources/imagekmjhngfdss__1_-removebg-preview (1).png")));
		panel_2.add(jbtnAdd);

		JButton jbtnDelete = new JButton("Delete");
		jbtnDelete.setBackground(new Color(255, 228, 196));
		jbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnDelete_actionPerformed(arg0);
			}
		});
		jbtnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtnDelete.setIcon(new ImageIcon(
				CheckOutManagement.class.getResource("/resources/deleteeeeeeeeeeeeeeeeeeeee-removebg-preview (1).png")));
		panel_2.add(jbtnDelete);

	}

	public CheckOutManagement(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}

	private void loadData() {
		CheckOutModel checkOutModel = new CheckOutModel();
		fillDataToJTable(checkOutModel.findAll());
	}

	public void jbtnDetails_actionPerformed(ActionEvent arg0) {
		int selectedRow = jtalbeCheckOut.getSelectedRow();
		int id = Integer.parseInt(jtalbeCheckOut.getValueAt(selectedRow, 0).toString());
		String nameUser = jtalbeCheckOut.getValueAt(selectedRow, 1).toString();
		String employee = jtalbeCheckOut.getValueAt(selectedRow, 2).toString();
		Map<String, Object> data = new HashMap<String, Object>();
		data.put("id", id);
		data.put("nameUser", nameUser);
		data.put("employee", employee);
		ShowDetails showDetails = new ShowDetails(data);
		showDetails.setVisible(true);
		showDetails.main = main;
		showDetails.lblId.setText("Id: " + id);
	}

	public void jbtnAdd_actionPerformed(ActionEvent arg0) {
//		new Check_in_models().create();
		NewCheckOut newCheckOut = new NewCheckOut(data);
		newCheckOut.main = this.main;
		main.clearScreen();
		main.panelContainer.add(newCheckOut);
		newCheckOut.setVisible(true);

	}

	public void jbtnDelete_actionPerformed(ActionEvent arg0) {
		int selectedRow = jtalbeCheckOut.getSelectedRow();
		int id = Integer.parseInt(jtalbeCheckOut.getValueAt(selectedRow, 0).toString());
		CheckOutModel checkOutModel = new CheckOutModel();
		boolean deleted = checkOutModel.delete(id);
		if (deleted) {
			JOptionPane.showMessageDialog(null, "Done");
			fillDataToJTable(checkOutModel.findAll());
		} else {
			JOptionPane.showMessageDialog(null, "Failed");
		}

	}	
	private void actionSearch() {

			if (!jtextFieldSeach.getText().isEmpty()) {
//				int id = 0;
				try {
				int	id = Integer.parseInt(jtextFieldSeach.getText());
					CheckOutModel checkOutModel = new CheckOutModel();
					User user = new UserModels().findById(id);
					if (user == null) {
						fillDataToJTable(checkOutModel.findAll());
						JOptionPane.showMessageDialog(null, "User Not Found");
					} else {
						fillDataToJTable(checkOutModel.search(user.getId()));
					}
				}catch(NumberFormatException e) {
					JOptionPane.showMessageDialog(null, "Please Enter Number");
//					e.printStackTrace();
				}
				
			} else {
				fillDataToJTable(new CheckOutModel().findAll());
			}
		}


	public void jbtnNewButtonSeach_actionPerformed(ActionEvent arg0) {

		actionSearch();
		
	}

	private void fillDataToJTable(List<CheckOut> checkOuts) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}

		};

		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("NameUser");
		defaultTableModel.addColumn("Employee");
		defaultTableModel.addColumn("Date_in");
		defaultTableModel.addColumn("Return_Date");
		defaultTableModel.addColumn("Deposit");
		defaultTableModel.addColumn("Status");
		for (CheckOut checkOut : checkOuts) {
			Account account = new AccountModel().findById(checkOut.getId_account());

			UserModels userModels = new UserModels();
			User user = userModels.findById(checkOut.getId_user());

			defaultTableModel.addRow(new Object[] { checkOut.getId(), user.getFullname(), account.getFullname(),
					checkOut.getDate_in(), checkOut.getReturn_date(), checkOut.getDeposit(),
					checkOut.isStatus() ? "paid" : "unpaid" });
		}
		jtalbeCheckOut.setModel(defaultTableModel);
		jtalbeCheckOut.getTableHeader().setReorderingAllowed(false);
		jtalbeCheckOut.getTableHeader().setResizingAllowed(false);
	}

}
