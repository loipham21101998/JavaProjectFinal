package program;

import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.JButton;
import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import entities.Account;
import entities.Role;
import models.AccountModel;
import models.RoleModel;

import java.awt.Component;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;
import java.awt.GridLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JCheckBox;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.JList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import java.awt.Font;

public class EmployeeManagement extends JPanel {

	private Map<String, Object> data;
	private JTable tableEmployee;
	private JButton btnDelete;
	private JButton btnAdd;
	private JButton btnUpdate;
	private JPanel panel_1;
	private JLabel lblNewLabel;
	private JTextField txtName;
	private JLabel lblNewLabel_1;
	private JCheckBox checkboxMale;
	private JCheckBox checkboxFemale;
	private final ButtonGroup GenderGroup = new ButtonGroup();
	private JPanel panel_2;
	private JLabel lblNewLabel_2;
	private JTextField txtAddress;
	private JLabel lblNewLabel_3;
	private JTextField txtPhone;
	private JLabel lblNewLabel_4;
	private JComboBox comboboxRole;

	/**
	 * Create the panel.
	 */
	public EmployeeManagement() {
		setBackground(Color.WHITE);
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		JPanel panelMain = new JPanel();
		panelMain.setBackground(Color.WHITE);
		add(panelMain);
		panelMain.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		panelMain.add(scrollPane, BorderLayout.CENTER);

		tableEmployee = new JTable();
		tableEmployee.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				tableEmployee_MouseClicked(e);
			}
		});
		scrollPane.setViewportView(tableEmployee);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 10));
		
		lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel);
		
		txtName = new JTextField();
		panel_1.add(txtName);
		txtName.setColumns(20);
		
		lblNewLabel_1 = new JLabel("Gender");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_1.add(lblNewLabel_1);
		
		checkboxMale = new JCheckBox("Male");
		checkboxMale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GenderGroup.add(checkboxMale);
		checkboxMale.setBackground(Color.WHITE);
		panel_1.add(checkboxMale);
		
		checkboxFemale = new JCheckBox("Female");
		checkboxFemale.setFont(new Font("Times New Roman", Font.BOLD, 14));
		GenderGroup.add(checkboxFemale);
		checkboxFemale.setBackground(Color.WHITE);
		panel_1.add(checkboxFemale);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
		flowLayout.setHgap(10);
		flowLayout.setAlignment(FlowLayout.LEFT);
		add(panel_2);
		
		lblNewLabel_2 = new JLabel("Address");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblNewLabel_2);
		
		txtAddress = new JTextField();
		panel_2.add(txtAddress);
		txtAddress.setColumns(20);
		
		lblNewLabel_3 = new JLabel("Phone");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBorder(new EmptyBorder(0, 2, 0, 0));
		panel_2.add(lblNewLabel_3);
		
		txtPhone = new JTextField();
		panel_2.add(txtPhone);
		txtPhone.setColumns(15);
		
		lblNewLabel_4 = new JLabel("Role");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(lblNewLabel_4);
		
		comboboxRole = new JComboBox();
		comboboxRole.setFont(new Font("Times New Roman", Font.BOLD, 14));
		panel_2.add(comboboxRole);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnAdd.setBackground(new Color(112,195,245));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed(e);
			}
		});
		panel.add(btnAdd);

		btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnUpdate.setBackground(new Color(112,195,245));
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUpdate_actionPerformed(e);
			}
		});
		panel.add(btnUpdate);

		btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnDelete.setBackground(new Color(112,195,245));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnDelete_actionPerformed(e);
			}
		});
		panel.add(btnDelete);
		
		
	}

	public EmployeeManagement(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}
	
	

	public void loadData() {
		fillDataToJTable(new AccountModel().findAll());
		enableBtn();
//		fillDataToJCombobox();
		btnUpdate.setEnabled(false);
	}
	
	private void enableBtn() {
		Account account = (Account) data.get("account");
		if(account.getId_role() != 1) {
			btnAdd.setEnabled(false);
			btnDelete.setEnabled(false);
			btnUpdate.setEnabled(false);
			txtName.setEnabled(false);
			txtPhone.setEnabled(false);
			txtAddress.setEnabled(false);
			checkboxMale.setEnabled(false);
			checkboxFemale.setEnabled(false);
			comboboxRole.setEnabled(false);
		}
	}
	
	public void fillDataToJTable(List<Account> accounts) {
//		DefaultTableModel defaultTableModel = new DefaultTableModel() {
//			@Override
//			public boolean isCellEditable(int row, int column) {
//				return false;
//			}
//		};
		String[] columns = {"ID","FullName","Gender","Address","Phone","Role"};
		DefaultTableModel defaultTableModel = new DefaultTableModel(null,columns) {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(defaultTableModel);
//		defaultTableModel.addColumn("ID");
//		defaultTableModel.addColumn("FullName");
//		defaultTableModel.addColumn("Gender");
//		defaultTableModel.addColumn("Address");
//		defaultTableModel.addColumn("Phone");
//		defaultTableModel.addColumn("Role");
		
		for(Account c : new AccountModel().findAll()) {
			Role role = new RoleModel().findById(c.getId_role());
			defaultTableModel.addRow(new Object[] {
				c.getId(),c.getFullname() , c.isGender() ? "Male" : "Female" , c.getAddress(),c.getPhone(),role.getName()
			});
		}
		
		tableEmployee.setModel(defaultTableModel);
		tableEmployee.setRowSorter(sorter);
		tableEmployee.getTableHeader().setReorderingAllowed(false);
	}
	
//	public void fillDataToJCombobox() {
//		DefaultComboBoxModel<Role> defaultComboBoxModel = new DefaultComboBoxModel<Role>();
//		for(Role r : new RoleModel().findAll()) {
//			defaultComboBoxModel.addElement(r);
//		}
//		comboboxRole.setModel(defaultComboBoxModel);
//		comboboxRole.setRenderer(new RoleListCellRenderer());
////		RoleModel roleModel = new RoleModel();
////		comboboxRole.setSelectedItem(roleModel.findById(account.getId_role()));
//	}
	
	public void tableEmployee_MouseClicked(MouseEvent e) {
		btnUpdate.setEnabled(true);
		int selectedRow = tableEmployee.getSelectedRow();
		int id = Integer.parseInt(tableEmployee.getValueAt(selectedRow, 0).toString());
		Account account = new AccountModel().findById(id);
		txtName.setText(account.getFullname());
		if(account.isGender()) {
			checkboxMale.setSelected(true);
		}else {
			checkboxFemale.setSelected(true);
		}
		txtAddress.setText(account.getAddress());
		txtPhone.setText(account.getPhone());
		DefaultComboBoxModel<Role> defaultComboBoxModel = new DefaultComboBoxModel<Role>();
		for(Role r : new RoleModel().findAll()) {
			defaultComboBoxModel.addElement(r);
		}
		comboboxRole.setModel(defaultComboBoxModel);
		comboboxRole.setRenderer(new RoleListCellRenderer());
		RoleModel roleModel = new RoleModel();
		setItemInComboBox(roleModel.findById(account.getId_role()));
		
	}
	
	private void setItemInComboBox(Role role) {
		for (int i = 0; i < comboboxRole.getItemCount(); i++) {			
			if (role.getName().equals(((Role) comboboxRole.getItemAt(i)).getName())) {
				comboboxRole.setSelectedIndex(i);
				break;
			}
		}
		
	}
	
	private class RoleListCellRenderer extends DefaultListCellRenderer{
		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			// TODO Auto-generated method stub
			Role role = (Role)value;
			return super.getListCellRendererComponent(list, role.getName(), index, isSelected, cellHasFocus);
		}
		
	}
	
	//get value of buttongroup
	public String buttonGroupSelected(ButtonGroup buttonGroup) {
		Enumeration<AbstractButton> abtractButtons = buttonGroup.getElements();
		while(abtractButtons.hasMoreElements()) {
			AbstractButton abstractButton = abtractButtons.nextElement();
			if (abstractButton.isSelected()) {
				return abstractButton.getText();
			}
		}
		return null;
	}
	
	public void btnAdd_actionPerformed(ActionEvent e) {
		Register register = new Register();
		register.employeeManagement= this;
		register.setVisible(true);
	}
	
	public void btnUpdate_actionPerformed(ActionEvent e) {
		int selectedRow = tableEmployee.getSelectedRow();
		int id = Integer.parseInt(tableEmployee.getValueAt(selectedRow, 0).toString());
		Role role = (Role) comboboxRole.getSelectedItem();
		Account account = new AccountModel().findById(id);
		account.setFullname(txtName.getText());
		account.setAddress(txtAddress.getText());
		account.setPhone(txtPhone.getText());
		if(buttonGroupSelected(GenderGroup).equals("Male")) {
			account.setGender(true);
		}else {
			account.setGender(false);
		}
		account.setId_role(role.getId());
		if(new AccountModel().update(account)) {
			JOptionPane.showMessageDialog(null, "Done");
			fillDataToJTable(new AccountModel().findAll());
		}else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}
	
	public void btnDelete_actionPerformed(ActionEvent e) {
		int result = JOptionPane.showConfirmDialog(null, "Confirm", "Are you sure ?", JOptionPane.YES_NO_OPTION);
		if(result == JOptionPane.YES_OPTION) {
			int selectedRow = tableEmployee.getSelectedRow();
			int id = Integer.parseInt(tableEmployee.getValueAt(selectedRow, 0).toString());
			if(new AccountModel().delete(id)) {
				JOptionPane.showMessageDialog(null, "Done");
				fillDataToJTable(new AccountModel().findAll());
			}else {
				JOptionPane.showMessageDialog(null, "Failed");
			}
		
		}
	}
}
