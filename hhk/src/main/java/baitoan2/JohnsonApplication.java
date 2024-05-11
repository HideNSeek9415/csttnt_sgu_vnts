package baitoan2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JButton;

public class JohnsonApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel ganttZone;
	private JPanel gantt1;
	private JLabel lblM1;
	private JLabel lblM2;
	private JPanel gantt2;
	private JPanel tableZone;
	private JPanel btnZone;
	private JScrollPane scrollPane;
	private JPanel groupZone;
	private JScrollPane scrollPaneGrp1;
	private JScrollPane scrollPaneGrp2;
	private JTable table;
	private JTable grp1;
	private JTable grp2;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnRmall;
	private JButton btnReset;
	private JButton btnStep1;
	private JButton btnStep2;
	private JButton btnStep3;
	private JButton btnDone;
	
	public ArrayList<Detail> details = new ArrayList<>();
	JohnsonAlgorithm algorithm;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					JohnsonApplication frame = new JohnsonApplication();
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
	public JohnsonApplication() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1182, 578);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		ganttZone = new JPanel();
		ganttZone.setPreferredSize(new Dimension(10, 100));
		ganttZone.setBackground(new Color(255, 255, 255));
		contentPane.add(ganttZone, BorderLayout.NORTH);
		ganttZone.setLayout(null);
		
		gantt1 = new JPanel();
		gantt1.setBounds(100, 10, 1040, 30);
		ganttZone.add(gantt1);
		gantt1.setLayout(null);
		
		lblM1 = new JLabel("Máy 1");
		lblM1.setHorizontalAlignment(SwingConstants.CENTER);
		lblM1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblM1.setBounds(10, 10, 80, 30);
		ganttZone.add(lblM1);
		
		lblM2 = new JLabel("Máy 2");
		lblM2.setHorizontalAlignment(SwingConstants.CENTER);
		lblM2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblM2.setBounds(10, 50, 80, 30);
		ganttZone.add(lblM2);
		
		gantt2 = new JPanel();
		gantt2.setBounds(100, 50, 1040, 30);
		ganttZone.add(gantt2);
		gantt2.setLayout(null);
		
		tableZone = new JPanel();
		tableZone.setOpaque(false);
		tableZone.setPreferredSize(new Dimension(10, 50));
		contentPane.add(tableZone, BorderLayout.SOUTH);
		tableZone.setLayout(null);
		
		btnAdd = new JButton("Add");
		btnAdd.setFocusPainted(false);
		btnAdd.setBackground(new Color(64, 128, 128));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setBounds(10, 10, 90, 30);
		tableZone.add(btnAdd);
		
		btnRemove = new JButton("Remove");
		btnRemove.setFocusPainted(false);
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRemove.setBackground(new Color(235, 82, 86));
		btnRemove.setBounds(110, 10, 90, 30);
		tableZone.add(btnRemove);
		
		btnRmall = new JButton("RmAll");
		btnRmall.setFocusPainted(false);
		btnRmall.setForeground(Color.WHITE);
		btnRmall.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRmall.setBackground(new Color(235, 82, 86));
		btnRmall.setBounds(210, 10, 90, 30);
		tableZone.add(btnRmall);
		
		btnReset = new JButton("Reset");
		btnReset.setFocusPainted(false);
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBackground(new Color(200, 138, 55));
		btnReset.setBounds(310, 10, 90, 30);
		tableZone.add(btnReset);
		
		btnStep1 = new JButton("Step 1");
		btnStep1.setFocusPainted(false);
		btnStep1.setForeground(Color.WHITE);
		btnStep1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStep1.setBackground(new Color(128, 128, 255));
		btnStep1.setBounds(740, 10, 90, 30);
		tableZone.add(btnStep1);
		
		btnStep2 = new JButton("Step 2");
		btnStep2.setFocusPainted(false);
		btnStep2.setForeground(Color.WHITE);
		btnStep2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStep2.setBackground(new Color(128, 128, 255));
		btnStep2.setBounds(840, 10, 90, 30);
		tableZone.add(btnStep2);
		
		btnStep3 = new JButton("Step 3");
		btnStep3.setFocusPainted(false);
		btnStep3.setForeground(Color.WHITE);
		btnStep3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnStep3.setBackground(new Color(128, 128, 255));
		btnStep3.setBounds(940, 10, 90, 30);
		tableZone.add(btnStep3);
		
		btnDone = new JButton("Done");
		btnDone.setForeground(Color.WHITE);
		btnDone.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDone.setFocusPainted(false);
		btnDone.setBackground(new Color(0, 128, 0));
		btnDone.setBounds(640, 10, 90, 30);
		tableZone.add(btnDone);
		
		btnZone = new JPanel();
		btnZone.setPreferredSize(new Dimension(10, 400));
		contentPane.add(btnZone, BorderLayout.CENTER);
		btnZone.setLayout(new BorderLayout(0, 0));
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(600, 2));
		btnZone.add(scrollPane, BorderLayout.WEST);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order", "1st process", "2nd Process", "Group"
			}
		));
		scrollPane.setViewportView(table);
		
		groupZone = new JPanel();
		btnZone.add(groupZone, BorderLayout.CENTER);
		groupZone.setLayout(new GridLayout(2, 0, 0, 0));
		
		scrollPaneGrp1 = new JScrollPane();
		groupZone.add(scrollPaneGrp1);
		
		grp1 = new JTable();
		grp1.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order", "1st Process", "2nd Process", "Group"
			}
		));
		scrollPaneGrp1.setViewportView(grp1);
		
		scrollPaneGrp2 = new JScrollPane();
		groupZone.add(scrollPaneGrp2);
		
		grp2 = new JTable();
		grp2.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order", "1st Process", "2nd Process", "Group"
			}
		));
		scrollPaneGrp2.setViewportView(grp2);
		
		addEvent();
		makeSampleData();
		btnReset.doClick();
	}

	private void makeSampleData() {
		Random random = new Random();
		for (int i = 0; i < 13; i++) {
			int f = random.nextInt(12) + 1;
			int s = random.nextInt(12) + 1;
			Detail sample = new Detail(f, s);
			details.add(sample);
		}
	}

	private void addEvent() {
		btnAdd.addActionListener(e -> {
			AddDetail.add(this);
		});
		btnRemove.addActionListener(e -> {
			details.remove(table.getSelectedRow());
		});
		btnRmall.addActionListener(e -> {
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			details.clear();
			model.setRowCount(0);
		});
		btnDone.addActionListener(e -> {
			algorithm = new JohnsonAlgorithm(details);
			
			btnAdd.setEnabled(false);
			btnRemove.setEnabled(false);
			btnRmall.setEnabled(false);

			btnDone.setEnabled(false);
			btnStep1.setEnabled(true);
		});
		btnReset.addActionListener(e -> {
			algorithm = new JohnsonAlgorithm(details);
			reloadTable();
			gantt1.removeAll();
			gantt1.revalidate();
			gantt1.repaint();
			gantt2.removeAll();
			gantt2.revalidate();
			gantt2.repaint();
			
			btnAdd.setEnabled(true);
			btnRemove.setEnabled(true);
			btnRmall.setEnabled(true);
			btnDone.setEnabled(true);


			btnStep1.setEnabled(false);
			btnStep2.setEnabled(false);
			btnStep3.setEnabled(false);
		});
		btnStep1.addActionListener(e -> {
			algorithm.step1();
			loadGroup(grp1, algorithm.group1);
			loadGroup(grp2, algorithm.group2);
			
			btnStep1.setEnabled(false);
			btnStep2.setEnabled(true);

		});
		btnStep2.addActionListener(e -> {
			algorithm.step2();
			loadGroup(grp1, algorithm.group1);
			loadGroup(grp2, algorithm.group2);
			
			btnStep2.setEnabled(false);
			btnStep3.setEnabled(true);
			
		});
		btnStep3.addActionListener(e -> {
			algorithm.step3();
			drawGantt();
		});
	}

	private void drawGantt() {
		details.forEach(d -> {
			int id = details.indexOf(d) + 1;
			String toolkit1 = String.format("Detail: %d - Dration: %d - Start: %d - End: %d", id, d.firstProcess, d.firstProcessStarted, d.firstDone);
			String toolkit2 = String.format("Detail: %d - Dration: %d - Start: %d - End: %d", id, d.secondProcess, d.secondProcessStarted, d.secondProcess + d.secondProcessStarted);
			
			JPanel g1pn = new JPanel();
			int g1x = d.firstProcessStarted*10;
			int g1w = d.firstProcess*10;
			g1pn.setBounds(g1x, 0, g1w, 30);
			g1pn.setBackground(Color.decode("#328e58"));
			g1pn.setBorder(new MatteBorder(0, 1, 0, 0, Color.white));
			g1pn.setToolTipText(toolkit1);
			g1pn.setLayout(new GridLayout());
			JLabel lbl1 = new JLabel(String.valueOf(id));
			lbl1.setForeground(Color.white);
			lbl1.setFont(new Font("Tahoma", Font.BOLD, 8));
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			g1pn.add(lbl1);
			
			JPanel g2pn = new JPanel();
			int g2x = d.secondProcessStarted*10;
			int g2w = d.secondProcess*10;
			g2pn.setBounds(g2x, 0, g2w, 30);
			g2pn.setBackground(Color.decode("#328e58"));
			g2pn.setBorder(new MatteBorder(0, 1, 0, 0, Color.white));
			g2pn.setToolTipText(toolkit2);
			g2pn.setLayout(new GridLayout());
			JLabel lbl2 = new JLabel(String.valueOf(id));
			lbl2.setForeground(Color.white);
			lbl2.setFont(new Font("Tahoma", Font.BOLD, 8));
			lbl2.setHorizontalAlignment(SwingConstants.CENTER);
			g2pn.add(lbl2);
			
			gantt1.add(g1pn);
			gantt2.add(g2pn);
			
			gantt1.revalidate();
			gantt1.repaint();
			gantt2.revalidate();
			gantt2.repaint();
		});
	}

	private void loadGroup(JTable grp, ArrayList<Detail> dat) {
		DefaultTableModel gmodel = (DefaultTableModel) grp.getModel();
		gmodel.setRowCount(0);
		dat.forEach(d -> {
			Object[] data = {
				details.indexOf(d) + 1,
				d.firstProcess,
				d.secondProcess,
				d.group
			};
			gmodel.addRow(data);
		});
	}

	public void reloadTable() {
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		details.forEach(d -> {
			Object[] data = {
				details.indexOf(d) + 1,
				d.firstProcess,
				d.secondProcess,
				d.group
			};
			model.addRow(data);
		});
	}
}
