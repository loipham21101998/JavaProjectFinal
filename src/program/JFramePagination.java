package program;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import entities.Book;
import models.BookModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.RowFilter;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFramePagination extends JFrame {

	private final int itemsPerPage = 4;

	private int maxPageIndex;

	private int currentPageIndex = 1;

	private String[] columnNames = { "Id", "Name", "Title" };

	private DefaultTableModel model = new DefaultTableModel(null, columnNames);

	private final TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);

	private JPanel contentPane;
	private JTable table;
	private JPanel panel;
	private JButton next;
	private JButton prev;
	private JButton first;
	private JTextField field;
	private JLabel label;
	private JButton last;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFramePagination frame = new JFramePagination();
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
	public JFramePagination() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 579, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int selectedRow = table.getSelectedRow();
				int id = Integer.parseInt(table.getValueAt(selectedRow, 0).toString());
				System.out.println(id);
			}
		});
		scrollPane.setViewportView(table);

		panel = new JPanel();
		contentPane.add(panel, BorderLayout.SOUTH);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		first = new JButton("|<");
		first.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				first_actionPerformed(e);
			}
		});
		panel.add(first);

		prev = new JButton("<");
		prev.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				prev_actionPerformed(e);
			}
		});
		panel.add(prev);

		field = new JTextField();
		field.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				field_actionPerformed(arg0);
			}
		});
		panel.add(field);
		field.setColumns(10);

		label = new JLabel("");
		panel.add(label);

		next = new JButton(">");
		next.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				next_actionPerformed(e);
			}
		});
		panel.add(next);

		last = new JButton(">|");
		last.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				last_actionPerformed(e);
			}
		});
		panel.add(last);

		loadData();
	}

	public void next_actionPerformed(ActionEvent e) {
		currentPageIndex += 1;
		initFilterAndButton();
	}

	public void prev_actionPerformed(ActionEvent e) {
		currentPageIndex -= 1;
		initFilterAndButton();
	}

	public void last_actionPerformed(ActionEvent e) {
		currentPageIndex = maxPageIndex;
		initFilterAndButton();
	}

	public void first_actionPerformed(ActionEvent e) {
		currentPageIndex = 1;
		initFilterAndButton();
	}

	private void loadData() {
		table.setModel(model);
		BookModel bookModel = new BookModel();
		table.setRowSorter(sorter);
		for (Book book : bookModel.findAll()) {
			model.addRow(new Object[] { book.getId(), book.getName(), book.getTitle() });
		}
		int rowCount = model.getRowCount();
		int v = rowCount % itemsPerPage == 0 ? 0 : 1;
		maxPageIndex = rowCount / itemsPerPage + v;
		initFilterAndButton();
		label.setText(String.format("/ %d", maxPageIndex));
	}

	public void field_actionPerformed(ActionEvent arg0) {
		try {
			int v = Integer.parseInt(field.getText());
			if (v > 0 && v <= maxPageIndex) {
				currentPageIndex = v;
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		initFilterAndButton();
	}

	private void initFilterAndButton() {
		sorter.setRowFilter(new RowFilter<TableModel, Integer>() {
			@Override
			public boolean include(Entry<? extends TableModel, ? extends Integer> entry) {
				int ti = currentPageIndex - 1;
				int ei = entry.getIdentifier();
				return ti * itemsPerPage <= ei && ei < ti * itemsPerPage + itemsPerPage;
			}
		});
		first.setEnabled(currentPageIndex > 1);
		prev.setEnabled(currentPageIndex > 1);
		next.setEnabled(currentPageIndex < maxPageIndex);
		field.setText(Integer.toString(currentPageIndex));
	}

}
