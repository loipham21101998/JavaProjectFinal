package program;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import entities.User;
import models.CheckOutModel;
import models.UserModels;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserManagement extends JPanel {
	private JTextField jtextFieldSearch;
	private JTable jtableUser;
	public Main main;

	/**
	 * Create the panel.
	 */
	public UserManagement() {
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
					actionSearch();
				}
			}
		});
		panel.add(jtextFieldSearch);
		jtextFieldSearch.setColumns(10);

		JButton btnSearch = new JButton("");
		btnSearch.setContentAreaFilled(false);
		btnSearch.setBorderPainted(false);
		btnSearch.setIcon(
				new ImageIcon(UserManagement.class.getResource("/resources/search12345-removebg-preview (1).png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSearch_actionPerformed(arg0);

			}
		});
		panel.add(btnSearch);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.YELLOW);
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		jtableUser = new JTable();
		jtableUser.setBackground(Color.ORANGE);
		scrollPane.setViewportView(jtableUser);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		add(panel_2);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(
				UserManagement.class.getResource("/resources/imagekmjhngfdss__1_-removebg-preview (1).png")));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAdd_actionPerformed(arg0);
			}
		});
		panel_2.add(btnAdd);

		loadData();
	}

	private void loadData() {
		UserModels userModels = new UserModels();
		fillDataToJtableUser(userModels.findAll());
	}

	public void btnAdd_actionPerformed(ActionEvent arg0) {
		NewUser newUser = new NewUser();

		newUser.setVisible(true);

	}

	private void actionSearch() {
		try {
			if (!jtextFieldSearch.getText().isEmpty()) {
				int id = Integer.parseInt(jtextFieldSearch.getText());
				UserModels userModels = new UserModels();
				User user = new UserModels().findById(id);
				if (user == null) {
					fillDataToJtableUser(userModels.findAll());
					JOptionPane.showMessageDialog(null, "User Not Found");
				} else {
					fillDataToJtableUser(userModels.searchListbyId(id));
				}
			} else {
				fillDataToJtableUser(new UserModels().findAll());
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Please Enter Number");
		}
	}

	public void btnSearch_actionPerformed(ActionEvent arg0) {
		actionSearch();
	}

	private void fillDataToJtableUser(List<User> users) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}

		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("FullName");
		defaultTableModel.addColumn("Address");
		defaultTableModel.addColumn("Phone");
		defaultTableModel.addColumn("Gender");
		int i = 1;
		for (User user : users) {
			defaultTableModel.addRow(new Object[] { user.getId(), user.getFullname(), user.getAddress(),
					user.getPhone(), user.isGender() ? "Male" : "Female", });
			;
		}
		jtableUser.setModel(defaultTableModel);
		TableColumnModel tableColumnModel = jtableUser.getColumnModel();
		jtableUser.getTableHeader().setReorderingAllowed(false);
		jtableUser.getTableHeader().setResizingAllowed(false);

	}
}
