package program;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.toedter.calendar.JDateChooser;

import entities.Account;
import entities.Book;
import entities.CheckOutDetails;
import entities.CheckIn;
import entities.CheckInDetails;
import entities.CheckOut;
import entities.User;
import models.AccountModel;
import models.BookModel;
import models.CheckInDetailsModel;
import models.CheckOutDetailsModel;
import models.CheckInModel;
import models.CheckOutModel;
import models.UserModels;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JCheckBox;

public class NewCheckIn extends JPanel {
	private JTextField txtSearch;
	private JTable tableCheckOutDetails;
	private JTextField txtIdCheckOut;
	private JTextField txtIdAccount;
	private JTextField txtFine;
	private JTextField txtNodl;
	public Main main;
	private JTable tableCheckOut;
	private JDateChooser dateChooserRD;
	private JDateChooser dateChooserDO;
	private Map<String, Object> data;
	private int idCheckout;
	private double refund;
	private int[] selectedRows;

	private JTextField txtrefund;
	private JTextField txtdeposit;

	/**
	 * Create the panel.
	 */
	public NewCheckIn() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		JPanel panelLeft = new JPanel();
		add(panelLeft);
		panelLeft.setLayout(new BoxLayout(panelLeft, BoxLayout.Y_AXIS));

		JPanel panelTopLeft = new JPanel();
		panelTopLeft
				.setBorder(new TitledBorder(null, "List Check Out", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelTopLeft.setBackground(new Color(172, 236, 213));
		panelLeft.add(panelTopLeft);
		panelTopLeft.setLayout(new BorderLayout(0, 0));

		JPanel panelSearch = new JPanel();
		panelSearch.setBackground(new Color(172, 236, 213));
		panelTopLeft.add(panelSearch, BorderLayout.NORTH);

		JLabel lblSearch = new JLabel("Search");
		panelSearch.add(lblSearch);

		txtSearch = new JTextField();
		panelSearch.add(txtSearch);
		txtSearch.setColumns(10);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSearchactionPerformed(arg0);
			}
		});
		panelSearch.add(btnSearch);

		JPanel panelTable = new JPanel();
		panelTopLeft.add(panelTable, BorderLayout.CENTER);
		panelTable.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelTable.add(scrollPane, BorderLayout.CENTER);

		tableCheckOut = new JTable();
		tableCheckOut.setBackground(new Color(240, 230, 140));
		tableCheckOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableCheckin_mouseClicked(e);
			}
		});
		scrollPane.setViewportView(tableCheckOut);

		JPanel panelBottomLeft = new JPanel();
		panelBottomLeft.setBorder(
				new TitledBorder(null, "Check Out Details", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		panelBottomLeft.setBackground(new Color(172, 236, 213));
		panelLeft.add(panelBottomLeft);
		panelBottomLeft.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane_1 = new JScrollPane();

		panelBottomLeft.add(scrollPane_1, BorderLayout.CENTER);

		tableCheckOutDetails = new JTable();
		tableCheckOutDetails.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableCheckoutDT_mouseClicked(e);
				}
		});
//		tableCheckOutDetails.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int selectedRow = tableCheckOutDetails.getSelectedRow();
//				System.out.println(tableCheckOutDetails.getValueAt(selectedRow, 2));
//				
//	
//			}
//		});

		scrollPane_1.setViewportView(tableCheckOutDetails);

		JPanel panelRight = new JPanel();
		panelRight.setBorder(
				new TitledBorder(null, "Check In Control  ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelRight.setBackground(new Color(172, 236, 213));
		add(panelRight);
		GridBagLayout gbl_panelRight = new GridBagLayout();
		gbl_panelRight.columnWidths = new int[] { 49, 91, 93, 41, 126, 96, 27, 0 };
		gbl_panelRight.rowHeights = new int[] { 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panelRight.columnWeights = new double[] { 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panelRight.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 1.0, 0.0,
				0.0, 0.0, Double.MIN_VALUE };
		panelRight.setLayout(gbl_panelRight);

		JLabel lblNewLabel = new JLabel("ID CHECK OUT");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panelRight.add(lblNewLabel, gbc_lblNewLabel);

		txtIdCheckOut = new JTextField();
		txtIdCheckOut.setEditable(false);
		GridBagConstraints gbc_txtIdCheckOut = new GridBagConstraints();
		gbc_txtIdCheckOut.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdCheckOut.fill = GridBagConstraints.BOTH;
		gbc_txtIdCheckOut.gridx = 2;
		gbc_txtIdCheckOut.gridy = 1;
		panelRight.add(txtIdCheckOut, gbc_txtIdCheckOut);
		txtIdCheckOut.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID ACCOUNT");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 4;
		gbc_lblNewLabel_1.gridy = 1;
		panelRight.add(lblNewLabel_1, gbc_lblNewLabel_1);

		txtIdAccount = new JTextField();
		txtIdAccount.setEditable(false);
		GridBagConstraints gbc_txtIdAccount = new GridBagConstraints();
		gbc_txtIdAccount.insets = new Insets(0, 0, 5, 5);
		gbc_txtIdAccount.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtIdAccount.gridx = 5;
		gbc_txtIdAccount.gridy = 1;
		panelRight.add(txtIdAccount, gbc_txtIdAccount);
		txtIdAccount.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("RETURN DATE");
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 1;
		gbc_lblNewLabel_4.gridy = 3;
		panelRight.add(lblNewLabel_4, gbc_lblNewLabel_4);

		dateChooserRD = new JDateChooser();
		GridBagConstraints gbc_dateChooserRD = new GridBagConstraints();
		gbc_dateChooserRD.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserRD.fill = GridBagConstraints.BOTH;
		gbc_dateChooserRD.gridx = 2;
		gbc_dateChooserRD.gridy = 3;
		panelRight.add(dateChooserRD, gbc_dateChooserRD);

		JLabel lblNewLabel_5 = new JLabel("DATE OUT");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 4;
		gbc_lblNewLabel_5.gridy = 3;
		panelRight.add(lblNewLabel_5, gbc_lblNewLabel_5);

		dateChooserDO = new JDateChooser();
		GridBagConstraints gbc_dateChooserDO = new GridBagConstraints();
		gbc_dateChooserDO.insets = new Insets(0, 0, 5, 5);
		gbc_dateChooserDO.fill = GridBagConstraints.BOTH;
		gbc_dateChooserDO.gridx = 5;
		gbc_dateChooserDO.gridy = 3;
		panelRight.add(dateChooserDO, gbc_dateChooserDO);

		JLabel lblNewLabel_2 = new JLabel("FINE");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 1;
		gbc_lblNewLabel_2.gridy = 5;
		panelRight.add(lblNewLabel_2, gbc_lblNewLabel_2);

		txtFine = new JTextField();
		txtFine.setEditable(false);
		GridBagConstraints gbc_txtFine = new GridBagConstraints();
		gbc_txtFine.insets = new Insets(0, 0, 5, 5);
		gbc_txtFine.fill = GridBagConstraints.BOTH;
		gbc_txtFine.gridx = 2;
		gbc_txtFine.gridy = 5;
		panelRight.add(txtFine, gbc_txtFine);
		txtFine.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("NUMBER OF DAYS LATE");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 4;
		gbc_lblNewLabel_3.gridy = 5;
		panelRight.add(lblNewLabel_3, gbc_lblNewLabel_3);

		txtNodl = new JTextField();
		txtNodl.setEditable(false);
		GridBagConstraints gbc_txtNodl = new GridBagConstraints();
		gbc_txtNodl.insets = new Insets(0, 0, 5, 5);
		gbc_txtNodl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNodl.gridx = 5;
		gbc_txtNodl.gridy = 5;
		panelRight.add(txtNodl, gbc_txtNodl);
		txtNodl.setColumns(10);

		JButton btnOK = new JButton("OK");
		btnOK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnOK_actionPerformed(arg0);
			}
		});

		GridBagConstraints gbc_chckbxNewCheckBox = new GridBagConstraints();
		gbc_chckbxNewCheckBox.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox.gridx = 1;
		gbc_chckbxNewCheckBox.gridy = 9;

		GridBagConstraints gbc_chckbxNewCheckBox_1 = new GridBagConstraints();
		gbc_chckbxNewCheckBox_1.insets = new Insets(0, 0, 5, 5);
		gbc_chckbxNewCheckBox_1.gridx = 1;
		gbc_chckbxNewCheckBox_1.gridy = 11;

		JLabel lblNewLabel_7 = new JLabel("Deposit");
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 1;
		gbc_lblNewLabel_7.gridy = 7;
		panelRight.add(lblNewLabel_7, gbc_lblNewLabel_7);

		txtdeposit = new JTextField();
		txtdeposit.setEditable(false);
		GridBagConstraints gbc_txtdeposit = new GridBagConstraints();
		gbc_txtdeposit.insets = new Insets(0, 0, 5, 5);
		gbc_txtdeposit.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtdeposit.gridx = 2;
		gbc_txtdeposit.gridy = 7;
		panelRight.add(txtdeposit, gbc_txtdeposit);
		txtdeposit.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Refund");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_6.gridx = 4;
		gbc_lblNewLabel_6.gridy = 7;
		panelRight.add(lblNewLabel_6, gbc_lblNewLabel_6);

		txtrefund = new JTextField();
		txtrefund.setEditable(true);
		GridBagConstraints gbc_txtrefund = new GridBagConstraints();
		gbc_txtrefund.insets = new Insets(0, 0, 5, 5);
		gbc_txtrefund.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtrefund.gridx = 5;
		gbc_txtrefund.gridy = 7;
		panelRight.add(txtrefund, gbc_txtrefund);
		txtrefund.setColumns(10);
		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.gridx = 6;
		gbc_btnOK.gridy = 15;
		panelRight.add(btnOK, gbc_btnOK);

		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public NewCheckIn(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}

	private void btnSearchactionPerformed(ActionEvent arg0) {
		String keyword = txtSearch.getText();
		CheckOutModel checkOutModel = new CheckOutModel();

		if (txtSearch.getText().equals("")) {
			fillDataToJTableCheckOut(checkOutModel.findAll());
		} else {
			fillDataToJTableCheckOut(checkOutModel.search(Integer.parseInt(keyword)));
		}
	}

	private void tableCheckin_mouseClicked(MouseEvent e) {
		int selectedRow = tableCheckOut.getSelectedRow();
//		int[] row = tableCheckOutDetails.getSelectedRows();
		
		idCheckout = Integer.parseInt(tableCheckOut.getValueAt(selectedRow, 0).toString());
		fillDataToJTableCheckOutDetails(new CheckOutDetailsModel().search(idCheckout));
		Account account = (Account) data.get("account");

		Date dateReturn = null;
		Date today = new Date();
		try {
			dateReturn = new SimpleDateFormat("yyyy-MM-dd").parse(tableCheckOut.getValueAt(selectedRow, 2).toString());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Calendar returnDate = Calendar.getInstance();
		Calendar dateOut = Calendar.getInstance();
		returnDate.setTime(dateReturn);
		dateOut.setTime(today);
		dateChooserRD.setDate(dateReturn);
		dateChooserDO.setDate(today);
		txtIdCheckOut.setText(String.valueOf(idCheckout));
		txtIdAccount.setText(String.valueOf(account.getId()));
		int nodl = 0;
		if (returnDate.get(Calendar.DAY_OF_MONTH) >= dateOut.get(Calendar.DAY_OF_MONTH)) {
			txtNodl.setText("0");
		} else {
			nodl = dateOut.get(Calendar.DAY_OF_MONTH) - returnDate.get(Calendar.DAY_OF_MONTH);
			txtNodl.setText(String.valueOf(nodl));
		}
		int fine = 0;
		fine = 5 * nodl;
		txtFine.setText(String.valueOf(fine));
		double deposit = 0;
		double price = Double.parseDouble(tableCheckOut.getValueAt(selectedRow, 3).toString());
		deposit += price;
		txtdeposit.setText(String.valueOf(deposit));
		double refund = 0;
//		for(int r : row) {
//			int id_book = Integer.parseInt(tableCheckOutDetails.getModel().getValueAt(r, 0).toString());
//			boolean status = Boolean.parseBoolean(tableCheckOutDetails.getValueAt(r, 2).toString());
//			if (status == true) {
//				refund += price;
//				txtrefund.setText(String.valueOf(refund));
//			}
//		}
		
	}

	private void btnOK_actionPerformed(ActionEvent arg0) {
		CheckIn checkIn = new CheckIn();
		checkIn.setId_checkout(Integer.parseInt(txtIdCheckOut.getText()));
		checkIn.setId_account(Integer.parseInt(txtIdAccount.getText()));
		checkIn.setFine(Double.parseDouble(txtFine.getText()));
		checkIn.setDateout(dateChooserDO.getDate());
		checkIn.setNumber_of_days_late(Integer.parseInt(txtNodl.getText()));
		checkIn.setRefund(Double.parseDouble(txtrefund.getText()));
		if (new CheckInModel().create(checkIn)) {
			JOptionPane.showMessageDialog(null, "Success");
			main.btnCheckInManagement_actionPerformed(arg0);
			this.setVisible(false);
		} else {
			JOptionPane.showMessageDialog(null, "Failed");
		}

		DefaultTableModel tblModel = (DefaultTableModel) tableCheckOutDetails.getModel();
		if (tblModel.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Failed");
		} else {
			CheckInDetails checkInDetails = null;
			for (int i = 0; i < tblModel.getRowCount(); i++) {
				int id_checkin = new CheckInModel().latestId();
				int id_book = Integer.parseInt(tableCheckOutDetails.getModel().getValueAt(i, 0).toString());
				boolean status = Boolean.parseBoolean(tableCheckOutDetails.getValueAt(i, 3).toString());

				if (status == true) {
					new CheckOutDetailsModel().updateQuantityAdd(id_book);

				}

				checkInDetails = new CheckInDetails();
				checkInDetails.setId_checkin(id_checkin);
				checkInDetails.setId_book(id_book);
				checkInDetails.setId_checkout(idCheckout);
				checkInDetails.setStatus(status);

				new CheckInDetailsModel().create(checkInDetails);

			}
		}
	}

	private void tableCheckoutDT_mouseClicked(MouseEvent e) {
		DefaultTableModel tblModel = (DefaultTableModel) tableCheckOutDetails.getModel();
		if (tblModel.getRowCount() != 0) {
			refund = 0;
			for (int i = 0; i < tblModel.getRowCount(); i++) {
				boolean status = Boolean.parseBoolean(tableCheckOutDetails.getValueAt(i, 3).toString());
				double price1 = Double.parseDouble(tableCheckOutDetails.getValueAt(i, 2).toString());
				
				if (status == true) {
					refund += price1;
					txtrefund.setText(String.valueOf(refund));
				}
			}
			
		}

	}

	
	
	private void loadData() {
		CheckOutModel checkOutModel = new CheckOutModel();
		fillDataToJTableCheckOut(checkOutModel.findAll());
	}

	private void fillDataToJTableCheckOut(List<CheckOut> checkOuts) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}

		};

		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("NameUser");
		defaultTableModel.addColumn("Return_Date");
		defaultTableModel.addColumn("Deposit");
		for (CheckOut checkOut : checkOuts) {
			Account account = new AccountModel().findById(checkOut.getId_account());

			UserModels userModels = new UserModels();
			User user = userModels.findById(checkOut.getId_user());

			defaultTableModel.addRow(new Object[] { checkOut.getId(), user.getFullname(), checkOut.getReturn_date(),
					checkOut.getDeposit() });
		}
		tableCheckOut.setModel(defaultTableModel);
		tableCheckOut.getTableHeader().setReorderingAllowed(false);
		tableCheckOut.getTableHeader().setResizingAllowed(false);
	}

	private void fillDataToJTableCheckOutDetails(List<CheckOutDetails> checkOutDetails) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public Class<?> getColumnClass(int columnIndex) {
				switch (columnIndex) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return Double.class;
				case 4:
					return Boolean.class;
				default:
					return String.class;
				}
			}

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return arg1 == 4;
			}

		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Book");
		defaultTableModel.addColumn("Author Name");
		defaultTableModel.addColumn("Price");
		defaultTableModel.addColumn("Status");
		int row = 0;
		for (CheckOutDetails checkOutDetails2 : checkOutDetails) {
			Book book = new BookModel().searchBookId(checkOutDetails2.getId_book());
			defaultTableModel.addRow(new Object[0]);
			defaultTableModel.setValueAt(book.getId(), row, 0);
			defaultTableModel.setValueAt(book.getName(), row, 1);
			defaultTableModel.setValueAt(book.getAuthor_name(), row, 2);
			defaultTableModel.setValueAt(book.getPrice(), row, 3);
			defaultTableModel.setValueAt(false, row, 4);
//			{ book.getId(), book.getName(), book.getAuthor_name(),false }
			row++;
		}
		tableCheckOutDetails.setModel(defaultTableModel);
		tableCheckOutDetails.getTableHeader().setReorderingAllowed(false);
		TableColumnModel tableColumnModel = tableCheckOutDetails.getColumnModel();
		tableCheckOutDetails.removeColumn(tableColumnModel.getColumn(0));
	}

}
