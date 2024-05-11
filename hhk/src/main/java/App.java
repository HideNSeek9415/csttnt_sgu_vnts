import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import astar.AStarApplication;
import baitoan1.FirstApplication;
import baitoan2.JohnsonApplication;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.SwingConstants;
import javax.swing.JButton;

public class App {

	private JFrame frmMTThut;
	private JLabel lblNewLabel;
	private JLabel lblPhm;
	private JLabel lblNguyn;
	private JLabel lblCSTr;
	private JButton btnE1;
	private JButton btnE2;
	private JButton btnE3;
	
	private FirstApplication ex1 = new FirstApplication();
	private JohnsonApplication ex2 = new JohnsonApplication();
	private AStarApplication ex3 = new AStarApplication();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					App window = new App();
					window.frmMTThut.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMTThut = new JFrame();
		frmMTThut.setTitle("Mô tả thuật toán");
		frmMTThut.getContentPane().setBackground(new Color(52, 68, 83));
		frmMTThut.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("3122560017 - Bùi Trung Hiếu (L)");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 6, 306, 30);
		frmMTThut.getContentPane().add(lblNewLabel);
		
		lblPhm = new JLabel("3122410181 - Phạm Duy Khánh");
		lblPhm.setForeground(new Color(255, 255, 255));
		lblPhm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhm.setBounds(50, 36, 306, 30);
		frmMTThut.getContentPane().add(lblPhm);
		
		lblNguyn = new JLabel("3122410103 - Nguyễn Thị Thanh Hằng");
		lblNguyn.setForeground(new Color(255, 255, 255));
		lblNguyn.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNguyn.setBounds(50, 66, 306, 30);
		frmMTThut.getContentPane().add(lblNguyn);
		
		lblCSTr = new JLabel("CƠ SỞ TRÍ TUỆ NHÂN TẠO");
		lblCSTr.setHorizontalAlignment(SwingConstants.CENTER);
		lblCSTr.setForeground(new Color(255, 255, 255));
		lblCSTr.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblCSTr.setBounds(21, 108, 365, 64);
		frmMTThut.getContentPane().add(lblCSTr);
		
		btnE1 = new JButton("1. Bài toán các đoạn thẳng không giao nhau");
		btnE1.setFocusPainted(false);
		btnE1.setHorizontalAlignment(SwingConstants.LEADING);
		btnE1.setBackground(new Color(52, 68, 83));
		btnE1.setForeground(new Color(255, 255, 255));
		btnE1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnE1.setBounds(21, 180, 365, 40);
		frmMTThut.getContentPane().add(btnE1);
		
		btnE2 = new JButton("2. Gia công chi tiết (giải thuật JOHNSON)");
		btnE2.setFocusPainted(false);
		btnE2.setHorizontalAlignment(SwingConstants.LEADING);
		btnE2.setForeground(new Color(255, 255, 255));
		btnE2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnE2.setBackground(new Color(52, 68, 83));
		btnE2.setBounds(21, 230, 365, 40);
		frmMTThut.getContentPane().add(btnE2);
		
		btnE3 = new JButton("3. Tìm đường đi ngắn nhất (giải thuật A*)");
		btnE3.setFocusPainted(false);
		btnE3.setHorizontalAlignment(SwingConstants.LEADING);
		btnE3.setForeground(new Color(255, 255, 255));
		btnE3.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnE3.setBackground(new Color(52, 68, 83));
		btnE3.setBounds(21, 280, 365, 40);
		frmMTThut.getContentPane().add(btnE3);
		frmMTThut.setBounds(100, 100, 421, 377);
		frmMTThut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frmMTThut.setLocationRelativeTo(null);
		ex1.setLocationRelativeTo(null);
		ex2.setLocationRelativeTo(null);
		ex3.setLocationRelativeTo(null);

		addEvent();
	}

	private void addEvent() {
		btnE1.addActionListener(e -> {
			frmMTThut.setVisible(false);
			ex1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ex1.setVisible(true);
		});
		btnE2.addActionListener(e -> {
			frmMTThut.setVisible(false);
			ex2.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ex2.setVisible(true);
		});
		btnE3.addActionListener(e -> {
			frmMTThut.setVisible(false);
			ex3.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			ex3.setVisible(true);
		});
		ex1.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {}
			@Override
			public void windowClosed(WindowEvent e) {
				frmMTThut.setVisible(true);
			}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		ex2.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {}
			@Override
			public void windowClosed(WindowEvent e) {
				frmMTThut.setVisible(true);
			}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
		ex3.addWindowListener(new WindowListener() {
			@Override
			public void windowOpened(WindowEvent e) {}
			@Override
			public void windowIconified(WindowEvent e) {}
			@Override
			public void windowDeiconified(WindowEvent e) {}
			@Override
			public void windowDeactivated(WindowEvent e) {}
			@Override
			public void windowClosing(WindowEvent e) {}
			@Override
			public void windowClosed(WindowEvent e) {
				frmMTThut.setVisible(true);
			}
			@Override
			public void windowActivated(WindowEvent e) {}
		});
	}
}
