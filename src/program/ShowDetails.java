package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import entities.Account;
import entities.Book;
import entities.CheckOutDetails;
import entities.CheckOut;
import entities.User;
import models.AccountModel;
import models.BookModel;
import models.CheckOutDetailsModel;
import models.CheckOutModel;
import models.UserModels;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowDetails extends JFrame {

	private JPanel contentPane;
	private Map<String, Object> data;
	private JPanel panel;
	private JPanel panel_1;
	public JLabel lblId;
	private JLabel lblEmployee;
	private JTextField jtextFieldEmployee;
	private JLabel lblNameUser;
	private JTextField jtextFieldNameUser;
	private JScrollPane scrollPane;
	private JTable jtableBook;
	private JPanel panel_2;
	private JButton btnDelete;
	private JButton btnAddBook;
	private int[] selectedRows;
	public Main main;
	private int id;
	private double deposit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowDetails frame = new ShowDetails();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ShowDetails() {
		setTitle("Details");
		setBounds(100, 100, 796, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

		panel = new JPanel();
		panel.setBackground(Color.RED);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

		lblId = new JLabel("ID");
		lblId.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblId);

		lblEmployee = new JLabel("Employee");
		lblEmployee.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblEmployee);

		jtextFieldEmployee = new JTextField();
		jtextFieldEmployee.setEnabled(false);
		panel.add(jtextFieldEmployee);
		jtextFieldEmployee.setColumns(10);

		lblNameUser = new JLabel("Name User");
		lblNameUser.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel.add(lblNameUser);

		jtextFieldNameUser = new JTextField();
		jtextFieldNameUser.setEnabled(false);
		panel.add(jtextFieldNameUser);
		jtextFieldNameUser.setColumns(10);

		panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		jtableBook = new JTable();
		jtableBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selectedRows = jtableBook.getSelectedRows();
				double price = 0;
				for (int row : selectedRows) {
					price += Double.parseDouble(jtableBook.getValueAt(row, 2).toString());
				}
				deposit = price;
//				System.out.println(deposit);
				btnDelete.setEnabled(true);
			}
		});
		jtableBook.setBackground(Color.ORANGE);
		scrollPane.setViewportView(jtableBook);

		panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnDelete_actionPerformed(arg0);
			}
		});
		btnDelete.setEnabled(false);
		panel_2.add(btnDelete);

		btnAddBook = new JButton("Add Book");
		btnAddBook.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAddBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAddBook_actionPerformed(arg0);
			}
		});
		panel_2.add(btnAddBook);
	}

	public ShowDetails(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}

	public void btnAddBook_actionPerformed(ActionEvent arg0) {
		data.put("id_checkin", this.id);
		AddBookDetails addBookDetails = new AddBookDetails(data);
		addBookDetails.details = this;
		addBookDetails.main = main;
		addBookDetails.setVisible(true);

	}


	public void btnDelete_actionPerformed(ActionEvent arg0) {
		int result = JOptionPane.showConfirmDialog(null, "Confirm", "Are you sure ?", JOptionPane.YES_NO_OPTION);
		if (result == JOptionPane.YES_OPTION) {
			for (int row : selectedRows) {
				int id = Integer.parseInt(jtableBook.getModel().getValueAt(row, 0).toString());
				if (new CheckOutDetailsModel().delete(Integer.parseInt(data.get("id").toString()), id)) {
					
				} else {
					JOptionPane.showMessageDialog(null, "Failed");
				}
			}
			new CheckOutModel().updateSub(deposit, Integer.parseInt(data.get("id").toString()));
			JOptionPane.showMessageDialog(null, "Done");
		}
		fillDataToJTable(new CheckOutDetailsModel().search(this.id));
		main.btnCheckOutManagement_actionPerformed(arg0);
	}

	public void loadData() {
		id = Integer.parseInt(data.get("id").toString());
		jtextFieldEmployee.setText(data.get("employee").toString());
		jtextFieldNameUser.setText(data.get("nameUser").toString());

		CheckOutDetailsModel checkOutDetailsModel = new CheckOutDetailsModel();
		fillDataToJTable(checkOutDetailsModel.search(id));

	}

	private void fillDataToJTable(List<CheckOutDetails> checkOutDetails) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}

		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Book");
		defaultTableModel.addColumn("Author Name");
		defaultTableModel.addColumn("Price");
		for (CheckOutDetails checkInDetails2 : checkOutDetails) {
			Book book = new BookModel().searchBookId(checkInDetails2.getId_book());
			defaultTableModel.addRow(new Object[] { book.getId(), book.getName(), book.getAuthor_name(),book.getPrice() });
		}
		jtableBook.setModel(defaultTableModel);
		jtableBook.getTableHeader().setReorderingAllowed(false);
		TableColumnModel tableColumnModel = jtableBook.getColumnModel();
		jtableBook.removeColumn(tableColumnModel.getColumn(0));
	}

}
