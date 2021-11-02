package program;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import com.toedter.calendar.JDateChooser;

import entities.Account;
import entities.CheckIn;
import entities.Role;
import models.AccountModel;
import models.CheckInModel;


import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.CardLayout;
import javax.swing.border.EmptyBorder;

public class CheckInManagement extends JPanel {
	private Map<String, Object> data;
	private JTextField txtIdcheckin;
	private JTextField txtIdaccount;
	private JTextField txtFine;
	private JTextField txtNodl;
	private JTable jtableCheckOut;
	private JButton jbtnDetail;
	private JButton jbtnAdd;
	private JButton jbtnDelete;
	private JButton jbtnUpdate;
	private JDateChooser dateChooser;
	private JPanel jpanelDetail;
	private JPanel jpanelAdd;
	private JPanel jpanelDelete;
	private JPanel jpanelEdit;
	private JLabel jlblIdcheckin;
	private JLabel lblIdaccount;
	private JLabel lblDateout;
	private JLabel lblFine;
	private JLabel lblNdol;
	public Main main;

	/**
	 * Create the panel.
	 */
	public CheckInManagement() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel jpanelinformation = new JPanel();
		jpanelinformation.setBackground(new Color(172, 236, 213));
		jpanelinformation.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Information", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		add(jpanelinformation, BorderLayout.SOUTH);
		jpanelinformation.setLayout(new BoxLayout(jpanelinformation, BoxLayout.Y_AXIS));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(172, 236, 213));
		jpanelinformation.add(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{45, 0, 45, 42, 46, 84, 57, 114, 84, 0, 0, 0, 0, 267, 29, 0};
		gbl_panel_4.rowHeights = new int[]{21, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		jlblIdcheckin = new JLabel("Id check in");
		jlblIdcheckin.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_jlblIdcheckin = new GridBagConstraints();
		gbc_jlblIdcheckin.anchor = GridBagConstraints.EAST;
		gbc_jlblIdcheckin.insets = new Insets(0, 0, 0, 5);
		gbc_jlblIdcheckin.gridx = 1;
		gbc_jlblIdcheckin.gridy = 0;
		panel_4.add(jlblIdcheckin, gbc_jlblIdcheckin);
		
		txtIdcheckin = new JTextField();
		GridBagConstraints gbc_txtIdcheckin = new GridBagConstraints();
		gbc_txtIdcheckin.fill = GridBagConstraints.BOTH;
		gbc_txtIdcheckin.gridwidth = 3;
		gbc_txtIdcheckin.insets = new Insets(0, 0, 0, 5);
		gbc_txtIdcheckin.gridx = 2;
		gbc_txtIdcheckin.gridy = 0;
		panel_4.add(txtIdcheckin, gbc_txtIdcheckin);
		txtIdcheckin.setColumns(5);
		
		dateChooser = new JDateChooser();
		dateChooser.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		lblDateout = new JLabel("Date out");
		lblDateout.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblDateout = new GridBagConstraints();
		gbc_lblDateout.insets = new Insets(0, 0, 0, 5);
		gbc_lblDateout.gridx = 11;
		gbc_lblDateout.gridy = 0;
		panel_4.add(lblDateout, gbc_lblDateout);
		GridBagConstraints gbc_dateChooser = new GridBagConstraints();
		gbc_dateChooser.gridwidth = 2;
		gbc_dateChooser.insets = new Insets(0, 0, 0, 5);
		gbc_dateChooser.fill = GridBagConstraints.BOTH;
		gbc_dateChooser.gridx = 12;
		gbc_dateChooser.gridy = 0;
		panel_4.add(dateChooser, gbc_dateChooser);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(172, 236, 213));
		jpanelinformation.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		panel.add(lblNewLabel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(172, 236, 213));
		jpanelinformation.add(panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{45, 0, 57, 46, 81, 51, 96, 96, 0, 0, 0, 112, 0, 0, 0, 29, 0};
		gbl_panel_6.rowHeights = new int[]{21, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		
		lblIdaccount = new JLabel("Id account");
		lblIdaccount.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblIdaccount = new GridBagConstraints();
		gbc_lblIdaccount.anchor = GridBagConstraints.WEST;
		gbc_lblIdaccount.insets = new Insets(0, 0, 0, 5);
		gbc_lblIdaccount.gridx = 1;
		gbc_lblIdaccount.gridy = 0;
		panel_6.add(lblIdaccount, gbc_lblIdaccount);
		
		txtIdaccount = new JTextField();
		GridBagConstraints gbc_txtIdaccount = new GridBagConstraints();
		gbc_txtIdaccount.fill = GridBagConstraints.BOTH;
		gbc_txtIdaccount.gridwidth = 2;
		gbc_txtIdaccount.insets = new Insets(0, 0, 0, 5);
		gbc_txtIdaccount.gridx = 2;
		gbc_txtIdaccount.gridy = 0;
		panel_6.add(txtIdaccount, gbc_txtIdaccount);
		txtIdaccount.setColumns(5);
		
		lblFine = new JLabel("Fine");
		lblFine.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblFine = new GridBagConstraints();
		gbc_lblFine.insets = new Insets(0, 0, 0, 5);
		gbc_lblFine.gridx = 5;
		gbc_lblFine.gridy = 0;
		panel_6.add(lblFine, gbc_lblFine);
		
		txtFine = new JTextField();
		GridBagConstraints gbc_txtFine = new GridBagConstraints();
		gbc_txtFine.insets = new Insets(0, 0, 0, 5);
		gbc_txtFine.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtFine.gridx = 6;
		gbc_txtFine.gridy = 0;
		panel_6.add(txtFine, gbc_txtFine);
		txtFine.setColumns(10);
		
		lblNdol = new JLabel("Number of days late");
		lblNdol.setFont(new Font("Tahoma", Font.BOLD, 15));
		GridBagConstraints gbc_lblNdol = new GridBagConstraints();
		gbc_lblNdol.anchor = GridBagConstraints.EAST;
		gbc_lblNdol.insets = new Insets(0, 0, 0, 5);
		gbc_lblNdol.gridx = 10;
		gbc_lblNdol.gridy = 0;
		panel_6.add(lblNdol, gbc_lblNdol);
		
		txtNodl = new JTextField();
		GridBagConstraints gbc_txtNodl = new GridBagConstraints();
		gbc_txtNodl.gridwidth = 4;
		gbc_txtNodl.insets = new Insets(0, 0, 0, 5);
		gbc_txtNodl.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtNodl.gridx = 11;
		gbc_txtNodl.gridy = 0;
		panel_6.add(txtNodl, gbc_txtNodl);
		txtNodl.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(172, 236, 213));
		jpanelinformation.add(panel_1);
		
		JPanel jpanelTop = new JPanel();
		jpanelTop.setBackground(Color.WHITE);
		add(jpanelTop, BorderLayout.CENTER);
		jpanelTop.setLayout(new BorderLayout(0, 0));
		
		JPanel jpanelControl = new JPanel();
		jpanelControl.setBackground(new Color(172, 236, 213));
		jpanelControl.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Control", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpanelTop.add(jpanelControl, BorderLayout.EAST);
		jpanelControl.setLayout(new BoxLayout(jpanelControl, BoxLayout.Y_AXIS));
		
		JPanel jpanelEmpty3 = new JPanel();
		jpanelEmpty3.setBackground(new Color(172, 236, 213));
		jpanelControl.add(jpanelEmpty3);
		jpanelEmpty3.setLayout(new BorderLayout(0, 0));
		
		jpanelDetail = new JPanel();
		jpanelControl.add(jpanelDetail);
		jpanelDetail.setLayout(new BoxLayout(jpanelDetail, BoxLayout.X_AXIS));
		
		jbtnDetail = new JButton("DETAIL");
		jbtnDetail.setIcon(new ImageIcon(CheckInManagement.class.getResource("/resources/FRFT.png")));
		jbtnDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnDetail_actionPerformed(e);
			}
		});
		jbtnDetail.setFont(new Font("Tahoma", Font.BOLD, 20));
		jpanelDetail.add(jbtnDetail);
		
		JPanel jpanelEmpty = new JPanel();
		jpanelEmpty.setBackground(new Color(172, 236, 213));
		jpanelControl.add(jpanelEmpty);
		jpanelEmpty.setLayout(new BorderLayout(0, 0));
		
		jpanelAdd = new JPanel();
		jpanelControl.add(jpanelAdd);
		jpanelAdd.setLayout(new BoxLayout(jpanelAdd, BoxLayout.X_AXIS));
		
		jbtnAdd = new JButton("ADD");
		jbtnAdd.setBorder(new EmptyBorder(5, 30, 5, 30));
		jbtnAdd.setIcon(new ImageIcon(CheckInManagement.class.getResource("/resources/FRGH.png")));
		jbtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnAdd_actionPerformed(e);
			}
		});
		jbtnAdd.setFont(new Font("Tahoma", Font.BOLD, 20));
		jpanelAdd.add(jbtnAdd);
		
		JPanel jpanelEmpty1 = new JPanel();
		jpanelEmpty1.setBackground(new Color(172, 236, 213));
		jpanelControl.add(jpanelEmpty1);
		jpanelEmpty1.setLayout(new BorderLayout(0, 0));
		
		jpanelDelete = new JPanel();
		jpanelControl.add(jpanelDelete);
		jpanelDelete.setLayout(new BoxLayout(jpanelDelete, BoxLayout.X_AXIS));
		
		jbtnDelete = new JButton("DELETE");
		jbtnDelete.setIcon(new ImageIcon(CheckInManagement.class.getResource("/resources/FRBP.png")));
		jbtnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jbtnDelete_actionPerformed( arg0);	
			}
		});
		jbtnDelete.setFont(new Font("Tahoma", Font.BOLD, 20));
		jpanelDelete.add(jbtnDelete);
		
		JPanel jpanelEmpty2 = new JPanel();
		jpanelEmpty2.setBackground(new Color(172, 236, 213));
		jpanelControl.add(jpanelEmpty2);
		jpanelEmpty2.setLayout(new BorderLayout(0, 0));
		
		jpanelEdit = new JPanel();
		jpanelControl.add(jpanelEdit);
		jpanelEdit.setLayout(new BoxLayout(jpanelEdit, BoxLayout.X_AXIS));
		
		jbtnUpdate = new JButton("UPDATE");
		jbtnUpdate.setIcon(new ImageIcon(CheckInManagement.class.getResource("/resources/FROS.png")));
		jbtnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnUpdate_actionPerformed(e);
			}
		});
		jbtnUpdate.setFont(new Font("Tahoma", Font.BOLD, 20));
		jpanelEdit.add(jbtnUpdate);
		
		JPanel jpanelEmpty4 = new JPanel();
		jpanelEmpty4.setBackground(new Color(172, 236, 213));
		jpanelControl.add(jpanelEmpty4);
		jpanelEmpty4.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(172, 236, 213));
		panel_5.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Table", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jpanelTop.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_5.add(scrollPane, BorderLayout.CENTER);
		
		jtableCheckOut = new JTable();
		jtableCheckOut.setBackground(new Color(240, 230, 140));
		jtableCheckOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				jtableCheckOut_MouseClicked(e);
			}
		});
		scrollPane.setViewportView(jtableCheckOut);
		
//		loadData();
	}
	
	public CheckInManagement(Map<String, Object> data) {
		this();
		this.data = data;
		loadData();
	}
	
	public  void loadData() { 
		List<CheckIn> checkins =  new CheckInModel().findAll();
		fillDatatoJTable(checkins);
	}
	

	
	public void jbtnAdd_actionPerformed(ActionEvent arg0) {
		NewCheckIn newcheckout = new NewCheckIn(data);
		newcheckout.main = this.main;
		main.clearScreen();
		main.panelContainer.add(newcheckout);
		newcheckout.setVisible(true);
	}
	
	public void jbtnUpdate_actionPerformed(ActionEvent arg0) {
		int selectedRow = jtableCheckOut.getSelectedRow();
		int id = Integer.parseInt(jtableCheckOut.getValueAt(selectedRow, 0).toString());
		CheckIn checkIn = new CheckIn();
		checkIn.setId_checkout(Integer.parseInt(txtIdcheckin.getText()));
		checkIn.setId_account(Integer.parseInt(txtIdaccount.getText()));
		checkIn.setFine(Double.parseDouble(txtFine.getText()));
		checkIn.setDateout(dateChooser.getDate());
		checkIn.setNumber_of_days_late(Integer.parseInt(txtNodl.getText()));
		checkIn.setId(id);
		if(new CheckInModel().update(checkIn)) {
			JOptionPane.showMessageDialog(null, "Done");
			fillDatatoJTable(new CheckInModel().findAll());
		}else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}
	
	public void jbtnDetail_actionPerformed(ActionEvent arg0) {
		int selectedRow = jtableCheckOut.getSelectedRow();
		int idCheckIn = Integer.parseInt(jtableCheckOut.getValueAt(selectedRow, 0).toString());
		int idCheckOut = Integer.parseInt(jtableCheckOut.getValueAt(selectedRow, 1).toString());
		data.put("idCheckOut", idCheckOut);
		data.put("idCheckIn", idCheckIn);
		ShowCheckInDetails showCheckInDetails = new ShowCheckInDetails(data);
		showCheckInDetails.setVisible(true);
		
	}
	
	public void jbtnDelete_actionPerformed(ActionEvent arg0) {
		int selectedRow = jtableCheckOut.getSelectedRow();
		int id = Integer.parseInt(jtableCheckOut.getValueAt(selectedRow, 0).toString());
		CheckInModel checkoutmodel = new CheckInModel();
		boolean deleted = checkoutmodel.delete(id);
		if(deleted) {
			JOptionPane.showMessageDialog(null, "Done");
			fillDatatoJTable(checkoutmodel.findAll());
		}else {
			JOptionPane.showMessageDialog(null, "Failed");
		}
	}
	
	public void fillDatatoJTable (List<CheckIn> checkins) {
		DefaultTableModel defaultTableModel = new DefaultTableModel() {

			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				return false;
			}
			
		};
		defaultTableModel.addColumn("Id");
		defaultTableModel.addColumn("Id check out");
		defaultTableModel.addColumn("Id account");
		defaultTableModel.addColumn("Date out");
		defaultTableModel.addColumn("Fine");
		defaultTableModel.addColumn("Number of days late");
		defaultTableModel.addColumn("Refund");
		
		for(CheckIn c : checkins) {
			defaultTableModel.addRow(new Object[]{
					c.getId(),c.getId_checkout(),c.getId_account(),c.getDateout(),c.getFine(),c.getNumber_of_days_late(),c.getRefund()
			});
		}
		
		
		
		
		jtableCheckOut.setModel(defaultTableModel);
		jtableCheckOut.getTableHeader().setReorderingAllowed(false);
		jtableCheckOut.getTableHeader().setResizingAllowed(false);
	}

	public void jtableCheckOut_MouseClicked(MouseEvent e) {
		int selectedRow = jtableCheckOut.getSelectedRow();
		int id = Integer.parseInt(jtableCheckOut.getValueAt(selectedRow, 0).toString());
		CheckIn checkIn = new CheckInModel().findById(id);
		txtIdcheckin.setText(String.valueOf(checkIn.getId_checkout()));
		txtIdaccount.setText(String.valueOf(checkIn.getId_account()));
		txtFine.setText(String.valueOf(checkIn.getFine()));
		txtNodl.setText(String.valueOf(checkIn.getNumber_of_days_late()));
		dateChooser.setDate(checkIn.getDateout());
		}
	
}
