package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import models.AccountModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.HashMap;
import java.util.Map;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField txtUsername;
	private JPasswordField pwdPassword;
	private JSeparator separator;
	private JSeparator separator_1;
	private JLabel lblpassword;
	private JLabel lblusername;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JLabel lblNewLabel_2;

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
					Login frame = new Login();
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
	public Login() {
		setTitle("Login");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) (screenSize.getWidth() / 2)-250;
		int height = (int) (screenSize.getHeight()/2)-250;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(width, height, 798, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Design by TTFJ");
		lblNewLabel_2.setForeground(new Color(178, 34, 34));
		lblNewLabel_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Myanmar Text", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_2.setBounds(331, 420, 131, 30);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_1 = new JLabel("Library Management System");
		lblNewLabel_1.setForeground(new Color(50, 205, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Perpetua Titling MT", Font.PLAIN, 35));
		lblNewLabel_1.setBounds(114, 24, 558, 75);
		contentPane.add(lblNewLabel_1);
		
		separator_1 = new JSeparator();
		separator_1.setBackground(Color.GREEN);
		separator_1.setBounds(331, 324, 131, 2);
		contentPane.add(separator_1);
		
		separator = new JSeparator();
		separator.setBackground(Color.GREEN);
		separator.setBounds(331, 275, 131, 2);
		contentPane.add(separator);
		
		txtUsername = new JTextField();
		txtUsername.setBackground(new Color(0,0,0,0));
		txtUsername.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblusername.setVisible(false);
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnNewButton_actionPerformed();
				}
			}
		});
		txtUsername.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblusername.setVisible(false);
				if(pwdPassword.getText().equals("")) {
					lblpassword.setVisible(true);
				};
			}
		});
		txtUsername.setForeground(new Color(255, 255, 0));
		txtUsername.setBorder(null);
		txtUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		txtUsername.setBounds(331, 254, 131, 19);
		contentPane.add(txtUsername);
		txtUsername.setColumns(10);
		
		pwdPassword = new JPasswordField();
		pwdPassword.setBackground(new Color(0,0,0,0));
		pwdPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				lblpassword.setVisible(false);
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					btnNewButton_actionPerformed();
				};
			}
		});
		pwdPassword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblpassword.setVisible(false);
				if(txtUsername.getText().equals("")) {
					lblusername.setVisible(true);
				}
				
			}
		});
		pwdPassword.setToolTipText("");
		pwdPassword.setBorder(null);
		pwdPassword.setBounds(331, 300, 131, 19);
		contentPane.add(pwdPassword);
		
		btnNewButton = new JButton("");
		btnNewButton.setBorderPainted(false);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton_actionPerformed( arg0);
			}
		});
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(Login.class.getResource("/resources/227256175_1454698774896303_6797909668648018630_n.png")));
			
		btnNewButton.setBounds(331, 354, 131, 39);
		contentPane.add(btnNewButton);
		
		lblpassword = new JLabel("Password");
		lblpassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblpassword.setForeground(new Color(255, 255, 0));
		lblpassword.setBounds(331, 303, 131, 13);
		contentPane.add(lblpassword);
		
		lblusername = new JLabel("UserName");
		lblusername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 20));
		lblusername.setForeground(new Color(255, 255, 0));
		lblusername.setBounds(331, 259, 131, 13);
		contentPane.add(lblusername);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(Login.class.getResource("/resources/156842460_230745178778148_5073352718554280683_n.jpg")));
		lblNewLabel.setBounds(0, -25, 828, 501);
		contentPane.add(lblNewLabel);
		
	}
	
	public void btnNewButton_actionPerformed() {
		String username = txtUsername.getText().trim();
		String password = new String(pwdPassword.getPassword());
		if(new AccountModel().login(username, password)) {
			Map<String, Object> data = new HashMap<String, Object>();
			data.put("account", new AccountModel().findUser(username));
			Main main = new Main(data);
			main.setVisible(true);
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null, "Login Denine");
		}
	}
	
	
	public void btnNewButton_actionPerformed(ActionEvent e) {
		btnNewButton_actionPerformed();
	}
	
}

