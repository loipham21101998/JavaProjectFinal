package program;

import java.util.List;
import java.util.Map;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowFilter.Entry;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import entities.Book;
import entities.Category;
import entities.GradientPanel;
import models.AccountModel;
import models.BookModel;
import models.CategoryModel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import net.miginfocom.swing.MigLayout;

public class BooksManagement extends JPanel {

	private Map<String, Object> data;
	private JTextField txtSearch;
	private JComboBox comboBoxSearchBy;
	private JLabel lbNumberofbooks;
	private JTable tableBooks;
	private JLabel lbNumberofAuthors;
	private DefaultTableModel defaultTableModel;
	private TableRowSorter<TableModel> sorter;
	private JTextField txtCurrentPage;
	
	/**
	 * Create the panel.
	 */
	public BooksManagement() {
		setBackground(new Color(222,115,255));
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
		
		JPanel panel_4 = new GradientPanel(new Color(175,105,238),new Color(228,160,247),0);
		panel.add(panel_4);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_1 = new JLabel("Number of books: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_1_1.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_4.add(lblNewLabel_1_1);
		
		lbNumberofbooks = new JLabel(String.valueOf(new BookModel().countBook()));
		lbNumberofbooks.setFont(new Font("Tahoma", Font.PLAIN, 27));
		panel_4.add(lbNumberofbooks);
		
		JPanel panel_5 = new GradientPanel(new Color(255,255,102),new Color(255,102,102),0);
		panel.add(panel_5);
		panel_5.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Number of Authors:   ");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 27));
		lblNewLabel_1_1_1.setBorder(new EmptyBorder(10, 0, 10, 0));
		panel_5.add(lblNewLabel_1_1_1);
		
		lbNumberofAuthors = new JLabel(String.valueOf(new BookModel().countAuthor()));
		lbNumberofAuthors.setFont(new Font("Tahoma", Font.PLAIN, 27));
		panel_5.add(lbNumberofAuthors);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		add(panel_1);
		
		lblSearch = new JLabel("Name of book");
		panel_1.add(lblSearch);
		
		txtSearch = new JTextField();
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode()==KeyEvent.VK_ENTER) {
					actionSearch();
				}
			}
		});
		panel_1.add(txtSearch);
		txtSearch.setColumns(20);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				btnSearch_actionPerformed(e);
				actionSearch();
			}
		});
		panel_1.add(btnNewButton);
		
		comboBoxSearchBy = new JComboBox();
		comboBoxSearchBy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBoxSearchBy.getSelectedItem().equals("Search by Name")) {
					lblSearch.setText("Name of book");
				}else if(comboBoxSearchBy.getSelectedItem().equals("Search by Author")) {
					lblSearch.setText("Name of author");
				}else {
					lblSearch.setText("Name of category");
				}
			}
		});
		panel_1.add(comboBoxSearchBy);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		tableBooks = new JTable();
		tableBooks.setFont(new Font("Times New Roman", Font.PLAIN, 14));
//		tableBooks.addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseClicked(MouseEvent e) {
//				int index = ((currentPageIndex -1)* itemsPerPage ) + tableBooks.getSelectedRow();
////				int selectedRow = tableBooks.getSelectedRow();
//				int id = Integer.parseInt(tableBooks.getModel().getValueAt(index, 0).toString());
//				System.out.println(id);
////				System.out.println(index);
//				btnEdit.setEnabled(true);
//			}
//		});
		scrollPane.setViewportView(tableBooks);
		
		JPanel panel_6 = new JPanel();
//		panel_6.setBackground(new Color(222,115,255));
		panel_6.setBackground(Color.white);
		add(panel_6);
		panel_6.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel panel_7 = new JPanel();
//		panel_7.setBackground(new Color(222,115,255));
		panel_7.setBackground(Color.white);
		panel_6.add(panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{43, 0, 0, 0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[]{23, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
		
		btnFirst = new JButton("|<");
		btnFirst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPageIndex = 1;
				initFilter();
			}
		});
		btnFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnFirst = new GridBagConstraints();
		gbc_btnFirst.insets = new Insets(0, 0, 0, 5);
		gbc_btnFirst.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnFirst.gridx = 0;
		gbc_btnFirst.gridy = 0;
		panel_7.add(btnFirst, gbc_btnFirst);
		
		btnPrev = new JButton("<");
		btnPrev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPageIndex -= 1;
				initFilter();
			}
		});
		btnPrev.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnPrev = new GridBagConstraints();
		gbc_btnPrev.insets = new Insets(0, 0, 0, 5);
		gbc_btnPrev.gridx = 1;
		gbc_btnPrev.gridy = 0;
		panel_7.add(btnPrev, gbc_btnPrev);
		
		txtCurrentPage = new JTextField();
		txtCurrentPage.setFont(new Font("Times New Roman", Font.BOLD, 14));
		txtCurrentPage.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					try {
						int v = Integer.parseInt(txtCurrentPage.getText());
						if (v > 0 && v <= maxPageIndex) {
							currentPageIndex = v;
						}
					} catch (Exception ex) {
						ex.printStackTrace();
					}
					initFilter();
				}
			}
		});
		GridBagConstraints gbc_txtCurrentPage = new GridBagConstraints();
		gbc_txtCurrentPage.insets = new Insets(0, 0, 0, 5);
		gbc_txtCurrentPage.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtCurrentPage.gridx = 2;
		gbc_txtCurrentPage.gridy = 0;
		panel_7.add(txtCurrentPage, gbc_txtCurrentPage);
		txtCurrentPage.setColumns(2);
		lblTotalPage = new JLabel("/");
		lblTotalPage.setFont(new Font("Times New Roman", Font.BOLD, 16));
		GridBagConstraints gbc_lblTotalPage = new GridBagConstraints();
		gbc_lblTotalPage.insets = new Insets(0, 0, 0, 5);
		gbc_lblTotalPage.gridx = 3;
		gbc_lblTotalPage.gridy = 0;
		panel_7.add(lblTotalPage, gbc_lblTotalPage);
		
		btnNext = new JButton(">");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPageIndex += 1;
				initFilter();
			}
		});
		btnNext.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnNext = new GridBagConstraints();
		gbc_btnNext.insets = new Insets(0, 0, 0, 5);
		gbc_btnNext.gridx = 4;
		gbc_btnNext.gridy = 0;
		panel_7.add(btnNext, gbc_btnNext);
		
		btnLast = new JButton(">|");
		btnLast.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				currentPageIndex = maxPageIndex;
				initFilter();
			}
		});
		btnLast.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_btnLast = new GridBagConstraints();
		gbc_btnLast.gridx = 5;
		gbc_btnLast.gridy = 0;
		panel_7.add(btnLast, gbc_btnLast);
		
		JPanel panel_3 = new JPanel();
//		panel_3.setBackground(new Color(222,115,255));
		panel_3.setBackground(Color.white);
		add(panel_3);
		
		JButton btnNewButton_1 = new JButton("New");
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_1.setBackground(new Color(112,195,245));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNew_actionPerformed(e);
			}
		});
		panel_3.add(btnNewButton_1);
		
		btnEdit = new JButton("Edit");
		btnEdit.setEnabled(false);
		btnEdit.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnEdit.setBackground(new Color(112,195,245));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEdit_actionPerformed(e);
			}
		});
		panel_3.add(btnEdit);
		
		JButton btnNewButton_3 = new JButton("Delete");
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnNewButton_3.setBackground(new Color(112,195,245));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_actionPerformed(e);
			}
		});
		panel_3.add(btnNewButton_3);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		loadData();
	}
	
	public BooksManagement(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}
	
	public void loadData() {
		fillDataToJTable(new BookModel().findAll());
		fillDataToJComboBox();
		lbNumberofbooks.setText(String.valueOf(new BookModel().countBook()));
		lbNumberofAuthors.setText(String.valueOf(new BookModel().countAuthor()));
		txtCurrentPage.setText(String.valueOf(currentPageIndex));
		
		int rowCount = defaultTableModel.getRowCount();
		int v = rowCount % itemsPerPage == 0 ? 0 : 1;
		maxPageIndex = rowCount / itemsPerPage + v;
		initFilter();
		lblTotalPage.setText(String.format("/ %d", maxPageIndex));
	}
	
	public void btnEdit_actionPerformed(ActionEvent e) {
		int index = ((currentPageIndex -1)* itemsPerPage ) + tableBooks.getSelectedRow();
		int id = Integer.parseInt(tableBooks.getModel().getValueAt(index, 0).toString());
		Book book = new BookModel().searchBookId(id);
		AddBook addBook = new AddBook();
		addBook.booksManagement = this;
		addBook.lbTitle.setText("Edit Book");
		addBook.btnCreate.setText("Update");
		addBook.txtName.setText(book.getName());
		addBook.txtTitle.setText(book.getTitle());
		addBook.txtAuthorName.setText(book.getAuthor_name());
		addBook.txtDescription.setText(book.getDescription());
		addBook.txtQuantity.setText(String.valueOf(book.getQuantity()));
		addBook.txtPrice.setText(String.valueOf(book.getPrice()));
		addBook.setItemInComboBox(new CategoryModel().findByid(book.getId_category()));
		addBook.idBook = book.getId();
		addBook.setVisible(true);
	}
	
	public void fillDataToJComboBox() {
		DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<String>();
		String[] c = {"Search by Name","Search by Author","Search by Category"};
		for(String s : c) {
			comboBoxModel.addElement(s);
		}
		comboBoxSearchBy.setModel(comboBoxModel);
		
	}
	
	private final int itemsPerPage = 5;
	private int maxPageIndex;
	private int currentPageIndex = 1;
	private JLabel lblTotalPage;
	private JButton btnPrev;
	private JButton btnNext;
	private JButton btnLast;
	private JButton btnFirst;
	private JLabel lblSearch;
	private JButton btnEdit;
	
	private void initFilter() {
		sorter.setRowFilter(new RowFilter<TableModel, Integer>(){
			@Override
			public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
				int ti = currentPageIndex - 1;
				int ei = entry.getIdentifier();
				return ti * itemsPerPage <= ei && ei < ti * itemsPerPage + itemsPerPage;
			}
			
		});
		btnFirst.setEnabled(currentPageIndex > 1);
		btnPrev.setEnabled(currentPageIndex > 1);
		btnNext.setEnabled(currentPageIndex < maxPageIndex);
		btnLast.setEnabled(currentPageIndex < maxPageIndex);
		txtCurrentPage.setText(Integer.toString(currentPageIndex));
	}
	
	public void fillDataToJTable(List<Book> books) {
		defaultTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
		};
		sorter = new TableRowSorter<TableModel>(defaultTableModel);
		
//			
		
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("No.");
		defaultTableModel.addColumn("Name");
		defaultTableModel.addColumn("Title");
		defaultTableModel.addColumn("Author_name");
		defaultTableModel.addColumn("Description");
		defaultTableModel.addColumn("Quantity");
		defaultTableModel.addColumn("Category");
		int i = 1;
		for(Book b : books) {
			Category c = new CategoryModel().findByid(b.getId_category());
			defaultTableModel.addRow(new Object[] {
				b.getId(),i,b.getName(),b.getTitle(),b.getAuthor_name(),b.getDescription(),b.getQuantity(),c.getName()
			});
			i++;
		}
		initFilter();

		tableBooks.setFillsViewportHeight(true);
		tableBooks.setModel(defaultTableModel);
		tableBooks.getTableHeader().setReorderingAllowed(false);
		tableBooks.setRowSorter(sorter);
		TableColumnModel tableColumnModel = tableBooks.getColumnModel();
		tableColumnModel.removeColumn(tableColumnModel.getColumn(0));
	}
	
	public void btnDelete_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Confirm", "Are you sure ?", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			int selectedRow = tableBooks.getSelectedRow();
			int id = Integer.parseInt(tableBooks.getModel().getValueAt(selectedRow, 0).toString());
			System.out.println(id);
			if(new BookModel().delete(id)) {
				JOptionPane.showMessageDialog(null, "Done");
				loadData();
			}else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}
	}
	
	public void actionSearch() {
		if(comboBoxSearchBy.getSelectedItem().equals("Search by Name")) {
			fillDataToJTable(new BookModel().searchByName(txtSearch.getText()));
		}else if(comboBoxSearchBy.getSelectedItem().equals("Search by Author")) {
			fillDataToJTable(new BookModel().searchByAuthor(txtSearch.getText()));
		}else {
//			fillDataToJTable(new BookModel().searchByIdCategory(new CategoryModel().findByName(txtSearch.getText()).getId()));
			fillDataToJTable(new BookModel().findAll(txtSearch.getText()));
		}
	}
	
	public void btnNew_actionPerformed(ActionEvent e) {
		AddBook addBook = new AddBook();
		addBook.booksManagement = this;
		addBook.setVisible(true);
	}

}
