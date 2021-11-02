package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import entities.Category;
import models.CategoryModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AddCategory extends JFrame {

	private JPanel contentPane;
	private JTextField txtCategory;
	public AddBook addBook ;

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
					AddCategory frame = new AddCategory();
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
	public AddCategory() {
		setTitle("New Category");
		setResizable(false);
		setBounds(100, 100, 317, 166);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Category: ");
		lblNewLabel.setBounds(31, 43, 69, 16);
		contentPane.add(lblNewLabel);
		
		txtCategory = new JTextField();
		txtCategory.setBounds(112, 37, 166, 28);
		contentPane.add(txtCategory);
		txtCategory.setColumns(10);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(e);
			}
		});
		btnNewButton.setBounds(112, 77, 90, 28);
		contentPane.add(btnNewButton);
	}

	public void btnAdd_actionPerformed(ActionEvent e) {
		Category category = new Category();
		category.setName(txtCategory.getText());
		if(new CategoryModel().insert(category)) {
			JOptionPane.showMessageDialog(null, "Done");
			addBook.loadData();
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}
}
