package program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import entities.*;
import models.BookModel;
import models.CategoryModel;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;

public class AddBook extends JFrame {

	private JPanel contentPane;
	public JTextField txtName;
	public JTextField txtTitle;
	public JTextField txtAuthorName;
	public JTextArea txtDescription;
	public JTextField txtQuantity;
	public JComboBox comboBoxCategory;
	public BooksManagement booksManagement;
	public JTextField txtPrice;
	public JLabel lbTitle;
	public JButton btnCreate;
	public int idBook;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBook frame = new AddBook();
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
	public AddBook() {
		setTitle("New Book");
		setResizable(false);
		setBounds(100, 100, 565, 597);
		contentPane = new GradientPanel(new Color(255, 255, 102), new Color(255, 102, 102), 3);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(29, 82, 55, 16);
		contentPane.add(lblNewLabel);

		txtName = new JTextField();
		txtName.setBounds(137, 76, 255, 28);
		contentPane.add(txtName);
		txtName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("Title:");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(29, 132, 40, 16);
		contentPane.add(lblNewLabel_1);

		txtTitle = new JTextField();
		txtTitle.setBounds(137, 126, 255, 28);
		contentPane.add(txtTitle);
		txtTitle.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Author Name: ");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(29, 184, 108, 16);
		contentPane.add(lblNewLabel_2);

		txtAuthorName = new JTextField();
		txtAuthorName.setBounds(137, 178, 255, 28);
		contentPane.add(txtAuthorName);
		txtAuthorName.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Description:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(29, 234, 91, 16);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Quantity:");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(29, 366, 67, 16);
		contentPane.add(lblNewLabel_4);

		txtQuantity = new JTextField();
		txtQuantity.setBounds(137, 365, 255, 28);
		contentPane.add(txtQuantity);
		txtQuantity.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Category: ");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(29, 451, 67, 16);
		contentPane.add(lblNewLabel_5);

		comboBoxCategory = new JComboBox();
		comboBoxCategory.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBoxCategory.setBounds(137, 446, 255, 27);
		contentPane.add(comboBoxCategory);

		JButton btnNewButton = new JButton("New Category");
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addNewCategory_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(404, 445, 149, 28);
		contentPane.add(btnNewButton);

		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBook_actionPerformed(e);
			}
		});
		btnCreate.setBounds(226, 485, 97, 41);
		contentPane.add(btnCreate);

		JLabel lblNewLabel_6 = new JLabel("Price:");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(29, 409, 55, 16);
		contentPane.add(lblNewLabel_6);

		txtPrice = new JTextField();
		txtPrice.setBounds(137, 405, 122, 28);
		contentPane.add(txtPrice);
		txtPrice.setColumns(10);

		lbTitle = new JLabel("New Book");
		lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lbTitle.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 28));
		lbTitle.setBounds(196, 6, 176, 35);
		contentPane.add(lbTitle);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 43, 547, 2);
		contentPane.add(separator);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(137, 225, 261, 126);
		contentPane.add(scrollPane);

		txtDescription = new JTextArea();
		scrollPane.setViewportView(txtDescription);
		loadData();
	}

	public void loadData() {
		fillDataToCategoryComboBox(new CategoryModel().findAll());
	}

	public void setItemInComboBox(Category category) {
		for (int i = 0; i < comboBoxCategory.getItemCount(); i++) {
			if (category.getName().equals(((Category) comboBoxCategory.getItemAt(i)).getName())) {
				comboBoxCategory.setSelectedIndex(i);
				break;
			}
		}

	}

	public void addBook_actionPerformed(ActionEvent e) {
		if (btnCreate.getText().equals("Create")) {
			Book book = new Book();
			book.setName(txtName.getText());
			book.setTitle(txtTitle.getText());
			book.setAuthor_name(txtAuthorName.getText());
			book.setDescription(txtDescription.getText());
			book.setQuantity(Integer.parseInt(txtQuantity.getText()));
			book.setPrice(Double.parseDouble(txtPrice.getText()));
			Category category = (Category) comboBoxCategory.getSelectedItem();
			book.setId_category(category.getId());
			if (new BookModel().insert(book)) {
				JOptionPane.showMessageDialog(null, "Done");
				booksManagement.loadData();
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		} else {
			Book book = new Book();
			book.setName(txtName.getText());
			book.setTitle(txtTitle.getText());
			book.setAuthor_name(txtAuthorName.getText());
			book.setDescription(txtDescription.getText());
			book.setQuantity(Integer.parseInt(txtQuantity.getText()));
			book.setPrice(Double.parseDouble(txtPrice.getText()));
			Category category = (Category) comboBoxCategory.getSelectedItem();
			book.setId_category(category.getId());
			book.setId(idBook);
			if (new BookModel().update(book)) {
				JOptionPane.showMessageDialog(null, "Done");
				booksManagement.loadData();
				this.setVisible(false);
			} else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		}

	}

	public void addNewCategory_actionPerformed(ActionEvent e) {
		AddCategory addCategory = new AddCategory();
		addCategory.addBook = this;
		addCategory.setVisible(true);
	}

	public void fillDataToCategoryComboBox(List<Category> categories) {
		DefaultComboBoxModel<Category> defaultComboBoxModel = new DefaultComboBoxModel<Category>();
		for (Category c : categories) {
			defaultComboBoxModel.addElement(c);
		}
		comboBoxCategory.setModel(defaultComboBoxModel);
		comboBoxCategory.setRenderer(new CaterogyListCellRenderer());

	}

	private class CaterogyListCellRenderer extends DefaultListCellRenderer {
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Category category = (Category) value;
			return super.getListCellRendererComponent(list, category.getName(), index, isSelected, cellHasFocus);
		}

	}
}
