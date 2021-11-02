package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import entities.Book;
import entities.CheckOutDetails;
import entities.User;
import models.BookModel;
import models.CheckOutDetailsModel;
import models.CheckOutModel;
import models.UserModels;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class AddBookDetails extends JFrame {

	private JPanel contentPane;
	private JTable jtableBook;
	private JTextField jtextFieldSearch;
	private Map<String, Object> data;
	int[] selecteds;
	public Main main;
	public ShowDetails details;
	private double deposit;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBookDetails frame = new AddBookDetails();
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
	public AddBookDetails() {
		setResizable(false);
		setBounds(100, 100, 631, 345);
		contentPane = new JPanel();
		contentPane.setForeground(Color.YELLOW);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.RED);
		panel_2.setForeground(new Color(255, 0, 0));
		contentPane.add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblSearch = new JLabel("Search");
		lblSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_2.add(lblSearch);
		
		jtextFieldSearch = new JTextField();
		panel_2.add(jtextFieldSearch);
		jtextFieldSearch.setColumns(10);
		
		JButton jbtnSearch = new JButton("");
		jbtnSearch.setContentAreaFilled(false);
		jbtnSearch.setBorderPainted(false);
		jbtnSearch.setIcon(new ImageIcon(AddBookDetails.class.getResource("/resources/search12345-removebg-preview (1).png")));
		jbtnSearch.setFont(new Font("Tahoma", Font.BOLD, 20));
		jbtnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnSearch_actionPerformed( arg0);
			}
		});
		panel_2.add(jbtnSearch);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, BorderLayout.CENTER);
		
		jtableBook = new JTable();
		jtableBook.setBackground(Color.ORANGE);
		jtableBook.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				selecteds = jtableBook.getSelectedRows();
				
			}
		});
		scrollPane.setViewportView(jtableBook);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		JButton btnOk = new JButton("Ok");
		btnOk.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnOk_actionPerformed( arg0);
			}
		});
		panel_1.add(btnOk);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_1.add(btnCancel);
		
	}
	
	public AddBookDetails(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}
	
	public void loadData() {
		
		CheckOutModel checkOutModel = new CheckOutModel();
		fillDataToJTable(new BookModel().findAll());
		
	}
	
	
	
	public void btnOk_actionPerformed(ActionEvent arg0) {
		int id_checkin = (int) data.get("id_checkin");
		double price = 0;
		for (int row : selecteds) {
			int id = Integer.parseInt(jtableBook.getModel().getValueAt(row, 0).toString());
			CheckOutDetailsModel checkOutDetailsModel = new CheckOutDetailsModel();
			checkOutDetailsModel.create(id_checkin, id);
			price += Double.parseDouble(jtableBook.getValueAt(row, 3).toString());
			
		}
		deposit = price;
		System.out.println(deposit);
		new CheckOutModel().updateAdd(deposit, id_checkin);
		JOptionPane.showMessageDialog(null, "Done");
		this.setVisible(false);
		main.btnCheckOutManagement_actionPerformed(arg0);
		details.loadData();
	}
	
	public void jbtnSearch_actionPerformed(ActionEvent arg0) {
		String keyword = jtextFieldSearch.getText();
		CheckOutModel checkOutModel = new CheckOutModel();
		
		fillDataToJTable(new BookModel().searchByName(keyword));
	}
	
	private void fillDataToJTable (List<Book> books) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int arg0, int arg1) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("No.");
		defaultTableModel.addColumn("Book");
		defaultTableModel.addColumn("Author Name");
		defaultTableModel.addColumn("Price");
		int i = 1;
		for (Book book : books) {
			
			defaultTableModel.addRow(new Object[] { book.getId(),i,book.getName(), book.getAuthor_name(),book.getPrice() });
			i++;
		}
			jtableBook.setModel(defaultTableModel);
			jtableBook.getTableHeader().setReorderingAllowed(false);
			TableColumnModel tableColumnModel = jtableBook.getColumnModel();
			jtableBook.removeColumn(tableColumnModel.getColumn(0));
		}

}
