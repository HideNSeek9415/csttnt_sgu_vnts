package baitoan1;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.SwingConstants;

public class GanttChart extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel gantt;
	private JLabel lblDay;

	/**
	 * Create the panel.
	 */
	public GanttChart(int day) {
		setBackground(new Color(255, 255, 255));
		setPreferredSize(new Dimension(770, 50));
		setLayout(null);
		
		gantt = new JPanel();
		gantt.setBounds(120, 10, 640, 30);
		add(gantt);
		gantt.setLayout(null);
		
		lblDay = new JLabel("Day " + day);
		lblDay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDay.setFont(new Font("SansSerif", Font.BOLD, 15));
		lblDay.setBounds(10, 10, 100, 30);
		add(lblDay);

	}
	
	public void addActivity(JPanel panel) {
		gantt.add(panel);
		revalidate();
		repaint();
	}
}
