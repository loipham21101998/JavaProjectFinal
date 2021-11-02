package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import entities.Book;
import entities.CheckInDetails;
import entities.CheckOutDetails;
import models.BookModel;
import models.CheckInDetailsModel;

public class ShowCheckInDetails extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdCheckIn;
	private JTextField txtIdCheckOut;
	private JTable jtablebook;
	public int idCheckOut;
	public int idCheckIn;
	private Map<String, Object> data;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_1;
	private JPanel panel;
	

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
					ShowCheckInDetails frame = new ShowCheckInDetails();
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
	public ShowCheckInDetails() {
		setBounds(100, 100, 905, 397);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(172, 236, 213));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));
		
		panel = new JPanel();
		panel.setBorder(new MatteBorder(0, 0, 2, 0, (Color) new Color(0, 0, 0)));
		panel.setBackground(new Color(172, 236, 213));
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("Check In Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Sitka Banner", Font.BOLD, 25));
		panel.add(lblNewLabel);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(172, 236, 213));
		contentPane.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		
		JLabel lblIdcheckout = new JLabel("Id Check In");
		lblIdcheckout.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblIdcheckout);
		
		txtIdCheckIn = new JTextField();
		txtIdCheckIn.setEditable(false);
		panel_1.add(txtIdCheckIn);
		txtIdCheckIn.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Id Check Out");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_2);
		
		txtIdCheckOut = new JTextField();
		txtIdCheckOut.setEditable(false);
		panel_1.add(txtIdCheckOut);
		txtIdCheckOut.setColumns(10);
		
		panel_2 = new JPanel();
		contentPane.add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_2.add(scrollPane, BorderLayout.CENTER);
		
		jtablebook = new JTable();
		jtablebook.setBackground(new Color(240, 230, 140));
		scrollPane.setViewportView(jtablebook);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(172, 236, 213));
		FlowLayout fl_panel_3 = (FlowLayout) panel_3.getLayout();
		fl_panel_3.setAlignment(FlowLayout.RIGHT);
		contentPane.add(panel_3);
		
		JButton btnClose = new JButton("Close");
		btnClose.setFont(new Font("SansSerif", Font.PLAIN, 14));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		panel_3.add(btnClose);
		
		
	}
	
	public ShowCheckInDetails(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}
	
	
	public void loadData() {
		txtIdCheckOut.setText(String.valueOf(data.get("idCheckOut")));
		txtIdCheckIn.setText(String.valueOf(data.get("idCheckIn")));
		int id = (int) data.get("idCheckIn");
		fillDataToJTable(new CheckInDetailsModel().search(id));
	}
	
	private void fillDataToJTable(List<CheckInDetails> checkInDetails) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		 defaultTableModel.addColumn("Book");
		 defaultTableModel.addColumn("Status");
		 for(CheckInDetails c :checkInDetails ) {
			 Book b = new BookModel().searchBookId(c.getId_book());
			 defaultTableModel.addRow(new Object[] {
					 b.getName(),c.isStatus()? "paid":"unpaid"
			 });
		 }
		 
		 jtablebook.setModel(defaultTableModel);
		 jtablebook.getTableHeader().setReorderingAllowed(false);
		
		
		
	}
	
}
