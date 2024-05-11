package baitoan1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.FlowLayout;

public class FirstApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel chartZone;
	private JPanel funcView;
	private JPanel btnZone;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnAdd;
	private JButton btnRemove;
	private JButton btnReload;
	private JLabel lblStart;
	private JLabel lblEnd;
	private JLabel lblT;
	private JSpinner sH;
	private JSpinner sM;
	private JSpinner eH;
	private JSpinner eM;
	private JLabel lblNumberOfDay;
	private JSpinner nod;
	private JButton btnDone;
	private JButton btnNext;
	private JButton btnAuto;
	private DefaultTableModel model;
	private ArrayList<Segment> segList = new ArrayList<>();
	private GanttChart[] days;

	private Algorithm algorithm;
	private JLabel lblT_1;
	private JButton btnRmAll;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					FirstApplication frame = new FirstApplication();
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
	public FirstApplication() {
		setTitle("Lập lịch không trùng");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1220, 610);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		chartZone = new JPanel();
		chartZone.setBackground(new Color(255, 255, 255));
		chartZone.setPreferredSize(new Dimension(820, 10));
		contentPane.add(chartZone, BorderLayout.WEST);
		chartZone.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		funcView = new JPanel();
		funcView.setBackground(new Color(255, 255, 255));
		contentPane.add(funcView, BorderLayout.CENTER);
		funcView.setLayout(new BorderLayout(0, 0));
		
		btnZone = new JPanel();
		btnZone.setBackground(new Color(255, 255, 255));
		funcView.add(btnZone, BorderLayout.CENTER);
		btnZone.setLayout(null);
		
		btnAdd = new JButton("Add");
		btnAdd.setFocusPainted(false);
		btnAdd.setBackground(new Color(0, 128, 64));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAdd.setBounds(5, 5, 90, 30);
		btnZone.add(btnAdd);
		
		btnRemove = new JButton("Remove");
		btnRemove.setFocusPainted(false);
		btnRemove.setForeground(Color.WHITE);
		btnRemove.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnRemove.setBackground(new Color(172, 73, 73));
		btnRemove.setBounds(5, 40, 90, 30);
		btnZone.add(btnRemove);
		
		btnReload = new JButton("Reload");
		btnReload.setFocusPainted(false);
		btnReload.setForeground(Color.WHITE);
		btnReload.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnReload.setBackground(new Color(241, 146, 7));
		btnReload.setBounds(5, 110, 90, 30);
		btnZone.add(btnReload);
		
		lblStart = new JLabel("Start:");
		lblStart.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblStart.setBounds(100, 5, 50, 30);
		btnZone.add(lblStart);
		
		lblEnd = new JLabel("End:");
		lblEnd.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblEnd.setBounds(100, 40, 50, 30);
		btnZone.add(lblEnd);
		
		lblT = new JLabel(":");
		lblT.setHorizontalAlignment(SwingConstants.CENTER);
		lblT.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblT.setBounds(215, 40, 10, 30);
		btnZone.add(lblT);
		
		sH = new JSpinner();
		sH.setModel(new SpinnerNumberModel(7, 7, 23, 1));
		sH.setFont(new Font("Tahoma", Font.BOLD, 12));
		sH.setBounds(155, 5, 60, 30);
		btnZone.add(sH);
		
		sM = new JSpinner();
		sM.setModel(new SpinnerNumberModel(0, 0, 45, 15));
		sM.setFont(new Font("Tahoma", Font.BOLD, 12));
		sM.setBounds(225, 5, 60, 30);
		btnZone.add(sM);
		
		eH = new JSpinner();
		eH.setModel(new SpinnerNumberModel(7, 7, 23, 1));
		eH.setFont(new Font("Tahoma", Font.BOLD, 12));
		eH.setBounds(155, 40, 60, 30);
		btnZone.add(eH);
		
		eM = new JSpinner();
		eM.setModel(new SpinnerNumberModel(0, 0, 45, 15));
		eM.setFont(new Font("Tahoma", Font.BOLD, 12));
		eM.setBounds(225, 40, 60, 30);
		btnZone.add(eM);
		
		lblNumberOfDay = new JLabel("Festival days:");
		lblNumberOfDay.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblNumberOfDay.setBounds(100, 75, 120, 30);
		btnZone.add(lblNumberOfDay);
		
		nod = new JSpinner();
		nod.setModel(new SpinnerNumberModel(1, 1, 10, 1));
		nod.setFont(new Font("Tahoma", Font.BOLD, 12));
		nod.setBounds(225, 75, 60, 30);
		btnZone.add(nod);
		
		btnDone = new JButton("Done");
		btnDone.setFocusPainted(false);
		btnDone.setForeground(Color.WHITE);
		btnDone.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnDone.setBackground(new Color(26, 128, 183));
		btnDone.setBounds(300, 5, 70, 30);
		btnZone.add(btnDone);
		
		btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.setFocusPainted(false);
		btnNext.setForeground(Color.WHITE);
		btnNext.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNext.setBackground(new Color(26, 128, 183));
		btnNext.setBounds(300, 40, 70, 30);
		btnZone.add(btnNext);
		
		btnAuto = new JButton("Auto");
		btnAuto.setEnabled(false);
		btnAuto.setFocusPainted(false);
		btnAuto.setForeground(Color.WHITE);
		btnAuto.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnAuto.setBackground(new Color(26, 128, 183));
		btnAuto.setBounds(300, 75, 70, 30);
		btnZone.add(btnAuto);
		
		lblT_1 = new JLabel(":");
		lblT_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblT_1.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblT_1.setBounds(215, 5, 10, 30);
		btnZone.add(lblT_1);
		
		btnRmAll = new JButton("RmAll");
		btnRmAll.setForeground(Color.WHITE);
		btnRmAll.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnRmAll.setFocusPainted(false);
		btnRmAll.setBackground(new Color(172, 73, 73));
		btnRmAll.setBounds(5, 75, 90, 30);
		btnZone.add(btnRmAll);
		
		scrollPane = new JScrollPane();
		scrollPane.setPreferredSize(new Dimension(0, 400));
		funcView.add(scrollPane, BorderLayout.NORTH);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Order", "Duration", "Start", "End", "Selected"
			}
		));
		table.getColumnModel().getColumn(0).setResizable(false);
		table.getColumnModel().getColumn(1).setResizable(false);
		table.getColumnModel().getColumn(2).setResizable(false);
		table.getColumnModel().getColumn(3).setResizable(false);
		table.getColumnModel().getColumn(4).setResizable(false);
		model = (DefaultTableModel) table.getModel();
		scrollPane.setViewportView(table);
		addEvent();
		btnReload.doClick();
	}

	private void addEvent() {
		btnReload.addActionListener(e -> {
			int numOfDay = (Integer) nod.getValue();
			resetState();
			reloadTable();
			chartZone.removeAll();
			days = new GanttChart[numOfDay];
			for (int i = 0; i < numOfDay; i++) {
				days[i] = new GanttChart(i + 1);
				chartZone.add(days[i]);
			}
			reloadChartZone();
			
			btnAdd.setEnabled(true);
			btnRemove.setEnabled(true);
			btnRmAll.setEnabled(true);
			btnNext.setEnabled(false);
			btnAuto.setEnabled(false);
		});
		btnAdd.addActionListener(e -> {
			int startH = (Integer) sH.getValue();
			int startM = (Integer) sM.getValue();
			int endH = (Integer) eH.getValue();
			int endM = (Integer) eM.getValue();
			if ((startH > endH) || (startH == endH && startM >= endM)) {
				JOptionPane.showMessageDialog(null, "Start time must occur first", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				Segment seg = new Segment(new DayTime(startH, startM), new DayTime(endH, endM));
				segList.add(seg);
				reloadTable();
			}
		});
		btnRemove.addActionListener(e -> {
			int index = table.getSelectedRow();
			segList.remove(index);
			reloadTable();
		});
		btnRmAll.addActionListener(e -> {
			segList.clear();
			reloadTable();
		});
		btnDone.addActionListener(e -> {
			int numOfDay = (Integer) nod.getValue();
			algorithm = new Algorithm(numOfDay, segList);
			Collections.sort(segList);
			reloadTable();
			
			btnAdd.setEnabled(false);
			btnRemove.setEnabled(false);
			btnRmAll.setEnabled(false);
			btnNext.setEnabled(true);
			btnAuto.setEnabled(true);
		});
		btnNext.addActionListener(e -> {
			if (algorithm.next()) {
				segList.forEach(seg -> {
					int day = seg.happenedDay;
					if (day >= 0) {
						days[day].addActivity((designActivity(seg)));
					} 
				});
				reloadChartZone();
				reloadTable();
			} else {
				JOptionPane.showMessageDialog(null, "Activities have been planned", "Notification", JOptionPane.INFORMATION_MESSAGE);
			}
		});
		btnAuto.addActionListener(e -> {
			new Thread(new Runnable() {
				public void run() {
					while (algorithm.next()) {
						segList.forEach(seg -> {
							int day = seg.happenedDay;
							if (day >= 0) {
								days[day].addActivity((designActivity(seg)));
							} 
						});
						reloadChartZone();
						reloadTable();
						try {
							Thread.sleep(300);
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					JOptionPane.showMessageDialog(null, "Activities have been planned", "Notification", JOptionPane.INFORMATION_MESSAGE);
				}
			}).start();
		});
	}

	private void reloadChartZone() {
		chartZone.revalidate();
		chartZone.repaint();
	}

	private void resetState() {
		segList.forEach(seg -> {
			seg.happenedDay = -1;
		});

	}

	private void reloadTable() {
		model.setRowCount(0);
		segList.forEach(seg -> {
			Object[] data = {
				segList.indexOf(seg) + 1,
				seg.length(),
				seg.start,
				seg.end,
				seg.happenedDay >= 0 ? "TRUE" : ""
			};
			model.addRow(data);
		});
	}

	public JPanel designActivity(Segment seg) {
		JPanel pn = new JPanel();
		int x = (seg.getStart().toMinute() - 420)*2/3;
		int y = 0;
		int width = seg.length()*2/3;
		int height = 30;
		pn.setBounds(x, y, width, height);
		pn.setLayout(new GridLayout());
		pn.setBackground(Color.decode("#35913b"));
		pn.setBorder(new MatteBorder(0, 1, 0, 1, Color.white));
		pn.setToolTipText(String.format("Start: %s - End: %s", seg.start, seg.end));
		JLabel lbl = new JLabel(String.valueOf(segList.indexOf(seg) + 1));
		lbl.setForeground(Color.white);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setFont(new Font("Tahoma", Font.BOLD, 10));
		pn.add(lbl);
		return pn;
	}
}
