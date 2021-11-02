package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

import entities.*;

import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.SwingConstants;
import java.awt.GridLayout;

public class Main extends JFrame {

	private JPanel contentPane;
	public JPanel panelContainer;
	private Map<String,Object> data;
	private JPanel panelSide;
	private JPanel panelFooter;
	public Color color = new Color(172,236,213);

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
					Main frame = new Main();
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
	public Main() {
		setTitle("Library Management System");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1104, 630);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		JButton btnNewButton_1 = new JButton("Setting");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.setContentAreaFilled(false);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setIcon(new ImageIcon(Main.class.getResource("/resources/Setting.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSetting_actionPerformed(e);
			}
		});
		toolBar.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Logout");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setIcon(new ImageIcon(Main.class.getResource("/resources/Logout.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnLogout_actionPerformed(e);
			}
		});
		toolBar.add(btnNewButton);
		
		panelSide = new JPanel();
		panelSide.setBorder(new EmptyBorder(10, 5, 0, 5));
//		panelSide.setBackground(new Color(83,187,98));
		panelSide.setBackground(new Color(172,236,213));
		contentPane.add(panelSide, BorderLayout.WEST);
		panelSide.setLayout(new BoxLayout(panelSide, BoxLayout.Y_AXIS));
		JButton btnEmployee = new JButton("Employee Management");
		btnEmployee.setBorderPainted(false);
		btnEmployee.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnEmployee_actionPerformed(e);
			}
		});
		btnEmployee.setIconTextGap(6);
		btnEmployee.setBorder(new EmptyBorder(15, 5, 10, 0));
		btnEmployee.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnEmployee.setContentAreaFilled(false);
		btnEmployee.setIcon(new ImageIcon(Main.class.getResource("/resources/Profile.png")));
		panelSide.add(btnEmployee);
		
		JButton btnBook = new JButton("Books Management");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnBook_actionPerformed(e);
			}
		});
		
		JButton btnUserManagement = new JButton("User Management");
		btnUserManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnUser_actionPerformed(e);
			}
		});
		btnUserManagement.setIcon(new ImageIcon(Main.class.getResource("/resources/Profile.png")));
		btnUserManagement.setIconTextGap(6);
		btnUserManagement.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnUserManagement.setContentAreaFilled(false);
		btnUserManagement.setBorderPainted(false);
		btnUserManagement.setBorder(new EmptyBorder(15, 5, 10, 0));
		panelSide.add(btnUserManagement);
		btnBook.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnBook.setIconTextGap(6);
		btnBook.setBorder(new EmptyBorder(15, 5, 15, 0));
		btnBook.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnBook.setBorderPainted(false);
		btnBook.setContentAreaFilled(false);
		btnBook.setIcon(new ImageIcon(Main.class.getResource("/resources/book.png")));
		panelSide.add(btnBook);
		
		JButton btnCheckOut = new JButton("Check Out Management");
		btnCheckOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheckOutManagement_actionPerformed(e);
			}
		});
		btnCheckOut.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCheckOut.setBorder(new EmptyBorder(15, 0, 15, 0));
		btnCheckOut.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnCheckOut.setIcon(new ImageIcon(Main.class.getResource("/resources/Slip (1).png")));
		btnCheckOut.setContentAreaFilled(false);
		btnCheckOut.setBorderPainted(false);
		panelSide.add(btnCheckOut);
		
		JButton btnCheckIn = new JButton("Check In Management");
		btnCheckIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnCheckInManagement_actionPerformed(e);
			}
		});
		btnCheckIn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnCheckIn.setBorder(new EmptyBorder(15, 0, 15, 0));
		btnCheckIn.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnCheckIn.setBorderPainted(false);
		btnCheckIn.setContentAreaFilled(false);
		btnCheckIn.setIcon(new ImageIcon(Main.class.getResource("/resources/Slip (1).png")));
		panelSide.add(btnCheckIn);
		
		JButton btnAbout = new JButton("About Us");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAboutUs_actionPerformed(e);
			}
		});
		btnAbout.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnAbout.setBorder(new EmptyBorder(15, 5, 0, 0));
		btnAbout.setFont(new Font("SansSerif", Font.BOLD, 16));
		btnAbout.setBorderPainted(false);
		btnAbout.setContentAreaFilled(false);
		btnAbout.setIcon(new ImageIcon(Main.class.getResource("/resources/Info.png")));
		panelSide.add(btnAbout);
		
		panelFooter = new JPanel();
//	panelFooter.setBackground(new Color(83,187,98));
		panelFooter.setBackground(new Color(172,236,213));
		contentPane.add(panelFooter, BorderLayout.SOUTH);
		panelFooter.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Desgin by TTFJ");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 14));
		panelFooter.add(lblNewLabel);
		
		panelContainer = new JPanel();
		contentPane.add(panelContainer, BorderLayout.CENTER);
		panelContainer.setLayout(new BorderLayout(0, 0));
		
	}
	
	public Main(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}
	
	public void changeBackground() {
		panelSide.setBackground(color);
		panelFooter.setBackground(color);
	}
	
	public void loadData() {
		
		book();
	}

	
	public void btnEmployee_actionPerformed(ActionEvent e) {
		Account account = (Account) data.get("account");
		if(account.getId_role()!= 1) {
			JOptionPane.showMessageDialog(null, "This function is for admin only");
			loadEmployee();
		}else {
			loadEmployee();
		}
	}
	
	public void btnCheckOutManagement_actionPerformed(ActionEvent e) {
		clearScreen();
		CheckOutManagement checkOutManagement = new CheckOutManagement(data);
		checkOutManagement.main = this;
		panelContainer.add(checkOutManagement);
		checkOutManagement.setVisible(true);
	}
	
	public void btnCheckInManagement_actionPerformed(ActionEvent e) {
		clearScreen();
		CheckInManagement checkInManagement = new CheckInManagement(data);
		checkInManagement.main = this;
		panelContainer.add(checkInManagement);
		checkInManagement.setVisible(true);
	}
	
	public void book() {
		clearScreen();
		BooksManagement booksManagement = new BooksManagement(data);
		panelContainer.add(booksManagement);
		booksManagement.setVisible(true);
	}
	
	public void btnBook_actionPerformed(ActionEvent e) {
		clearScreen();
		BooksManagement booksManagement = new BooksManagement(data);
		panelContainer.add(booksManagement);
		booksManagement.setVisible(true);
	}
	
	public void btnLogout_actionPerformed(ActionEvent e) {
		this.setVisible(false);
		Login login = new Login();
		login.setVisible(true);
	}
	
	private void loadEmployee() {
		clearScreen();
		EmployeeManagement employeeManagement = new EmployeeManagement(data);
		panelContainer.add(employeeManagement);
		employeeManagement.setVisible(true);
	}
	public void clearScreen() {
		panelContainer.removeAll();
		panelContainer.revalidate();
	}

	public void btnSetting_actionPerformed(ActionEvent e) {
		Setting setting = new Setting();
		setting.main = this;
		setting.setVisible(true);
	}
	
	public void btnUser_actionPerformed(ActionEvent e) {
		clearScreen();
		UserManagement user = new UserManagement();
		panelContainer.add(user);
		user.setVisible(true);
	}
	
	public void btnAboutUs_actionPerformed(ActionEvent e) {
		clearScreen();
		AboutUs aboutUs = new AboutUs();
		aboutUs.setVisible(true);
			
	}
	

}
