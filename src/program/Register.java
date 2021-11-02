package program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.mindrot.jbcrypt.BCrypt;

import entities.Account;
import entities.GradientPanel;
import entities.Role;
import models.AccountModel;
import models.RoleModel;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JComboBox;

public class Register extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JPasswordField txtPassword;
	private JTextField txtFullname;
	private final ButtonGroup GenderGroup = new ButtonGroup();
	private JTextField txtAddress;
	private JTextField txtPhone;
	private JButton btnSave;
	public EmployeeManagement employeeManagement;
	private JComboBox comboBoxRole;

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
					Register frame = new Register();
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
	public Register() {
		setTitle("Register");
		setResizable(false);
		setBounds(100, 100, 273, 500);
		contentPane = new GradientPanel(new Color(255,255,102),new Color(255,102,102),2);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel.setBounds(24, 89, 67, 21);
		contentPane.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(97, 89, 124, 25);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_1.setBounds(24, 134, 67, 21);
		contentPane.add(lblNewLabel_1);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(97, 134, 124, 25);
		contentPane.add(txtPassword);
		
		JLabel lblNewLabel_2 = new JLabel("FullName");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_2.setBounds(24, 183, 67, 21);
		contentPane.add(lblNewLabel_2);
		
		txtFullname = new JTextField();
		txtFullname.setBounds(97, 183, 124, 25);
		contentPane.add(txtFullname);
		txtFullname.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Gender");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_3.setBounds(24, 233, 61, 14);
		contentPane.add(lblNewLabel_3);
		
		JCheckBox checkboxMale = new JCheckBox("Male");
		GenderGroup.add(checkboxMale);
		checkboxMale.setBounds(97, 229, 52, 21);
		contentPane.add(checkboxMale);
		
		JCheckBox checkboxFemale = new JCheckBox("Female");
		GenderGroup.add(checkboxFemale);
		checkboxFemale.setBounds(151, 229, 67, 21);
		contentPane.add(checkboxFemale);
		
		JLabel lblNewLabel_4 = new JLabel("Address");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_4.setBounds(24, 272, 67, 14);
		contentPane.add(lblNewLabel_4);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(97, 269, 124, 25);
		contentPane.add(txtAddress);
		txtAddress.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Phone");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_5.setBounds(24, 318, 46, 14);
		contentPane.add(lblNewLabel_5);
		
		txtPhone = new JTextField();
		txtPhone.setBounds(97, 315, 124, 25);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Role");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.BOLD, 14));
		lblNewLabel_6.setBounds(24, 362, 46, 14);
		contentPane.add(lblNewLabel_6);
		
		btnSave = new JButton("Save");
		btnSave.setFont(new Font("VNI-Souvir", Font.BOLD | Font.ITALIC, 18));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave_actionPerformed(e);
			}
		});
		btnSave.setBounds(79, 404, 106, 37);
		contentPane.add(btnSave);
		
		JLabel lblNewLabel_7 = new JLabel("New Employee");
		lblNewLabel_7.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setBounds(54, 20, 167, 43);
		contentPane.add(lblNewLabel_7);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 60, 255, 6);
		contentPane.add(separator);
		
		comboBoxRole = new JComboBox();
		comboBoxRole.setBounds(97, 356, 124, 26);
		contentPane.add(comboBoxRole);
		loadData();
	}
	
	public void loadData() {
		fillDataToCombobox();
	}
	
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
	
	public void fillDataToCombobox() {
		DefaultComboBoxModel<Role> defaultComboBoxModel = new DefaultComboBoxModel<Role>();
		for(Role r : new RoleModel().findAll()) {
			defaultComboBoxModel.addElement(r);
		}
		comboBoxRole.setModel(defaultComboBoxModel);
		comboBoxRole.setRenderer(new RoleListCellRenderer());
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
	
	public void btnSave_actionPerformed(ActionEvent e) {
		String hash = BCrypt.hashpw(new String(txtPassword.getPassword()), BCrypt.gensalt());
		Account account = new Account();
		account.setUsername(txtUser.getText());
		account.setPassword(hash);
		account.setFullname(txtFullname.getText());
		if(buttonGroupSelected(GenderGroup).equals("Male")) {
			account.setGender(true);
		}else {
			account.setGender(false);
		}
		account.setAddress(txtAddress.getText());
		account.setPhone(txtPhone.getText());
		Role role = (Role) comboBoxRole.getSelectedItem();
		account.setId_role(role.getId());
		if(new AccountModel().create(account)) {
			JOptionPane.showMessageDialog(null, "Success");
			employeeManagement.loadData();
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}
}
