package program;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.User;
import models.UserModels;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;

public class NewUser extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField jtextFieldFullName;
	private JTextField jtextFieldAddress;
	private JTextField jtextFieldPhone;
	private JCheckBox jchckbxMale;
	private final ButtonGroup GenderGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			NewUser dialog = new NewUser();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public NewUser() {
		setResizable(false);
		getContentPane().setBackground(Color.PINK);
		setBounds(100, 100, 353, 319);
		getContentPane().setLayout(null);
		contentPanel.setBackground(Color.PINK);
		contentPanel.setBounds(0, 0, 317, 20);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblFullName = new JLabel("Full Name");
		lblFullName.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblFullName.setBounds(15, 75, 106, 20);
		getContentPane().add(lblFullName);
		
		jtextFieldFullName = new JTextField();
		jtextFieldFullName.setBounds(127, 72, 190, 26);
		getContentPane().add(jtextFieldFullName);
		jtextFieldFullName.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblGender.setBounds(15, 111, 75, 20);
		getContentPane().add(lblGender);
		
		jchckbxMale = new JCheckBox("Male");
		jchckbxMale.setContentAreaFilled(false);
		GenderGroup.add(jchckbxMale);
		jchckbxMale.setFont(new Font("Arial Black", Font.BOLD, 16));
		jchckbxMale.setBounds(127, 107, 79, 29);
		getContentPane().add(jchckbxMale);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblAddress.setBounds(15, 147, 97, 20);
		getContentPane().add(lblAddress);
		
		jtextFieldAddress = new JTextField();
		jtextFieldAddress.setColumns(10);
		jtextFieldAddress.setBounds(127, 144, 190, 26);
		getContentPane().add(jtextFieldAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblPhone.setBounds(15, 183, 69, 20);
		getContentPane().add(lblPhone);
		
		jtextFieldPhone = new JTextField();
		jtextFieldPhone.setColumns(10);
		jtextFieldPhone.setBounds(127, 180, 190, 26);
		getContentPane().add(jtextFieldPhone);
		
		JButton btnSave = new JButton("Save");
		btnSave.setFont(new Font("VNI-Souvir", Font.BOLD | Font.ITALIC, 18));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnSave_actionPerformed( arg0);
			}
		});
		btnSave.setBounds(127, 222, 115, 29);
		getContentPane().add(btnSave);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewUser.setForeground(new Color(0, 0, 128));
		lblNewUser.setFont(new Font("VNI-Algerian", Font.BOLD, 20));
		lblNewUser.setBounds(87, 16, 184, 43);
		getContentPane().add(lblNewUser);
		
		JSeparator separator = new JSeparator();
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(15, 57, 317, 2);
		getContentPane().add(separator);
		
		JCheckBox chckbxFemale = new JCheckBox("Female");
		chckbxFemale.setContentAreaFilled(false);
		GenderGroup.add(chckbxFemale);
		chckbxFemale.setFont(new Font("Arial Black", Font.BOLD, 16));
		chckbxFemale.setBounds(209, 107, 108, 29);
		getContentPane().add(chckbxFemale);
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
	
	
	
	public void btnSave_actionPerformed(ActionEvent arg0) {
		User user = new User();
		user.setFullname(jtextFieldFullName.getText());
		user.setAddress(jtextFieldAddress.getText());
		user.setPhone(jtextFieldPhone.getText());
		if(buttonGroupSelected(GenderGroup).equals("Male")) {
			user.setGender(true);
		}else {
			user.setGender(false);
		}
		UserModels userModels = new UserModels();
		if(userModels.create(user)) {
			JOptionPane.showMessageDialog(null, "Done");
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}
	
	
}
