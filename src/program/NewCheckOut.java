package program;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JToolBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import com.toedter.calendar.JDateChooser;

import entities.Account;
import entities.Book;
import entities.CheckOut;
import entities.User;
import models.BookModel;
import models.CheckOutDetailsModel;
import models.CheckOutModel;
import models.UserModels;

import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NewCheckOut extends JPanel {
	private JTextField jtextFieldSearch;
	private JTable table;
	private JTextField jtextFieldName;
	private JTextField jtextFieldGender;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldPhone;
	private JTable jtableBook;
	private JTextField txtDeposit;
	public JDateChooser jdateChooserDateIN;
	public Main main;
	public Map<String, Object> data;
	private int id_user;
	private int id_account;
	private int[] selectedRows;
	private JDateChooser dateChooserReturnDate;

	/**
	 * Create the panel.
	 */
	public NewCheckOut() {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblSearch = new JLabel("Id user");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblSearch);

		jtextFieldSearch = new JTextField();
		jtextFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					jbtnSearch_actionPerformed();
				}
			}
		});
		panel.add(jtextFieldSearch);
		jtextFieldSearch.setColumns(10);

		JButton jbtnSearch = new JButton("Search");
		jbtnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSearch_actionPerformed(arg0);
			}
		});
		panel.add(jbtnSearch);

		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnUpdate_actionPerformed(arg0);
			}
		});
		panel.add(btnUpdate);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBorder(new EmptyBorder(0, 0, 0, 25));
		panel_1.add(lblName);

		jtextFieldName = new JTextField();
		panel_1.add(jtextFieldName);
		jtextFieldName.setColumns(10);

		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGender.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_1.add(lblGender);

		jtextFieldGender = new JTextField();
		panel_1.add(jtextFieldGender);
		jtextFieldGender.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.PINK);
		FlowLayout flowLayout = (FlowLayout) panel_3.getLayout();
		flowLayout.setHgap(25);
		add(panel_3);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_3.add(lblAddress);

		jtextFieldAddress = new JTextField();
		panel_3.add(jtextFieldAddress);
		jtextFieldAddress.setColumns(10);

		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_3.add(lblPhone);

		jtextFieldPhone = new JTextField();
		panel_3.add(jtextFieldPhone);
		jtextFieldPhone.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.YELLOW);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);

		jtableBook = new JTable();
		jtableBook.setBackground(Color.ORANGE);
		jtableBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tableBook_mouseClicked(arg0);
			}
		});
		scrollPane.setViewportView(jtableBook);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

		JLabel lblDateIn = new JLabel("Date In");
		lblDateIn.setForeground(Color.GREEN);
		lblDateIn.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblDateIn);

		jdateChooserDateIN = new JDateChooser();
		jdateChooserDateIN.setEnabled(false);
		panel_4.add(jdateChooserDateIN);

		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setForeground(Color.GREEN);
		lblReturnDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblReturnDate);

		dateChooserReturnDate = new JDateChooser();
		dateChooserReturnDate.setEnabled(false);
		panel_4.add(dateChooserReturnDate);

		JLabel lblDeposit = new JLabel("Deposit");
		lblDeposit.setForeground(Color.GREEN);
		lblDeposit.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_4.add(lblDeposit);

		txtDeposit = new JTextField();
		txtDeposit.setEditable(false);
		panel_4.add(txtDeposit);
		txtDeposit.setColumns(10);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.DARK_GRAY);
		add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnOk_actionPerformed(e);
			}
		});
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(btnOk);

		JButton btnCancle = new JButton("Cancel");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnCancel_actionPerformed(arg0);
			}
		});
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_5.add(btnCancle);

		table = new JTable();

	}

	public NewCheckOut(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}

	private void loadData() {
		BookModel bookModel = new BookModel();
		fillDataToJtableBook(bookModel.findAll());
		Account account = (Account) data.get("account");
		id_account = account.getId();
		jdateChooserDateIN.setDate(new Date());
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 5);
		dateChooserReturnDate.setDate(c.getTime());
	}

	public void btnOk_actionPerformed(ActionEvent e) {
		CheckOut checkIn = new CheckOut();
		checkIn.setId_account(id_account);
		checkIn.setId_user(id_user);
		checkIn.setDate_in(jdateChooserDateIN.getDate());
		checkIn.setReturn_date(dateChooserReturnDate.getDate());
		checkIn.setDeposit(Double.parseDouble(txtDeposit.getText()));
		checkIn.setStatus(false);
		if (new CheckOutModel().create(checkIn)) {
			JOptionPane.showMessageDialog(null, "Done");
			main.clearScreen();
			main.btnCheckOutManagement_actionPerformed(e);
			for (int row : selectedRows) {
				int id = Integer.parseInt(jtableBook.getModel().getValueAt(row, 0).toString());
				CheckOutDetailsModel checkOutDetailsModel = new CheckOutDetailsModel();
				checkOutDetailsModel.create(new CheckOutModel().latestId(), id);
				checkOutDetailsModel.updateQuantity(id);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}

	public void btnCancel_actionPerformed(ActionEvent arg0) {
		main.clearScreen();
		main.btnCheckOutManagement_actionPerformed(arg0);

	}

	public void tableBook_mouseClicked(MouseEvent arg0) {
		selectedRows = jtableBook.getSelectedRows();
		double deposit = 0;
		for (int row : selectedRows) {
			double price = Double.parseDouble(jtableBook.getValueAt(row, 3).toString());
			deposit += price;
		}
		txtDeposit.setText(String.valueOf(deposit));

	}

	public void btnUpdate_actionPerformed(ActionEvent arg0) {
		User user = new User();
		user.setFullname(jtextFieldName.getText());
		user.setAddress(jtextFieldAddress.getText());
		user.setPhone(jtextFieldPhone.getText());
		if (jtextFieldGender.getText().equalsIgnoreCase("Male")) {
			user.setGender(true);
		} else {
			user.setGender(false);
		}
		user.setId(id_user);
		if (new UserModels().update(user)) {
			JOptionPane.showMessageDialog(null, "Done");
			jtextFieldName.setText("");
			jtextFieldGender.setText("");
			jtextFieldAddress.setText("");
			jtextFieldPhone.setText("");
			jtextFieldSearch.setText("");
		} else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}

	public void jbtnSearch_actionPerformed() {
		try {
			if (!jtextFieldSearch.getText().isEmpty()) {
				int id = Integer.parseInt(jtextFieldSearch.getText().trim());
				User user = new UserModels().searchById(id);
				if (user == null) {
					int result = JOptionPane.showConfirmDialog(null, "User not found. Create User ?", "Warning",
							JOptionPane.OK_CANCEL_OPTION);
					if (result == JOptionPane.OK_OPTION) {
						NewUser newUser = new NewUser();
						newUser.setVisible(true);
					}
				} else {
					id_user = user.getId();
					jtextFieldName.setText(user.getFullname());
					jtextFieldAddress.setText(user.getAddress());
					jtextFieldPhone.setText(user.getPhone());
					jtextFieldGender.setText(user.isGender() ? "Male" : "Female");
				}
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please Enter Number");
		}
	}

	public void jbtnSearch_actionPerformed(ActionEvent arg0) {
		jbtnSearch_actionPerformed();
	}

	private void fillDataToJtableBook(List<Book> books) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("No.");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Author Name");
		defaultTableModel.addColumn("Price");
		int i = 1;
		for (Book book : books) {
			defaultTableModel
					.addRow(new Object[] { book.getId(), i, book.getName(), book.getAuthor_name(), book.getPrice() });
			i++;
		}
		jtableBook.setModel(defaultTableModel);
		TableColumnModel tableColumnModel = jtableBook.getColumnModel();
		jtableBook.removeColumn(tableColumnModel.getColumn(0));
		jtableBook.getTableHeader().setReorderingAllowed(false);
		jtableBook.getTableHeader().setResizingAllowed(false);

	}

}
