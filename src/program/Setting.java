package program;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Setting extends JFrame {

	private JPanel contentPane;
	public Main main;
	private JComboBox comboBoxColor;

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
					Setting frame = new Setting();
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
	public Setting() {
		setTitle("Setting");
		setResizable(false);
		setBounds(100, 100, 235, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Change color Application");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 14));
		lblNewLabel.setBounds(28, 24, 176, 19);
		contentPane.add(lblNewLabel);
		
		comboBoxColor = new JComboBox();
		comboBoxColor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor_mouseClicked(e);
			}
		});
		comboBoxColor.setBounds(38, 53, 154, 33);
		contentPane.add(comboBoxColor);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSave_acctionPerformed(e);
			}
		});
		btnNewButton.setBounds(66, 98, 90, 28);
		contentPane.add(btnNewButton);
		loadData();
	}
	
	public void loadData() {
		fillDataToComboBox();
	}
	public void changeColor_mouseClicked(ActionEvent e) {
		if(comboBoxColor.getSelectedItem().equals("Green")) {
			main.color = new Color(172,236,213);
			main.changeBackground();
		}else if(comboBoxColor.getSelectedItem().equals("Violet")){
			main.color = new Color(222,115,255);
			main.changeBackground();
		}else if(comboBoxColor.getSelectedItem().equals("Brown")) {
			main.color = new Color(213,176,149);
			main.changeBackground();
		}
	}
	
	public void btnSave_acctionPerformed(ActionEvent e) {
		this.setVisible(false);
	}
	
	public void fillDataToComboBox() {
		DefaultComboBoxModel<String> defaultComboBoxModel = new DefaultComboBoxModel<String>();
		String[] colors = {"Green","Violet","Brown"};
		for(String c : colors) {
			defaultComboBoxModel.addElement(c);
		}
		comboBoxColor.setModel(defaultComboBoxModel);
	}
	
}
