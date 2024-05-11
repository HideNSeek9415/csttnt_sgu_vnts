package baitoan2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class AddDetail extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel;
	private JLabel lblndProcess;
	private JSpinner f;
	private JSpinner s;
	private JButton btnAdd;
	
	public static int first = -1;
	public static int second = -1;
	public static boolean hasNewVal = false;
	public boolean out = false;
	private JButton btnBack;
	static JohnsonApplication parrent;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDetail frame = new AddDetail();
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
	public AddDetail() {
		setBounds(100, 100, 280, 130);
		setUndecorated(true);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(64, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		lblNewLabel = new JLabel("1st Process");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNewLabel.setBounds(6, 6, 130, 30);
		contentPane.add(lblNewLabel);
		
		lblndProcess = new JLabel("2nd Process");
		lblndProcess.setHorizontalAlignment(SwingConstants.CENTER);
		lblndProcess.setForeground(Color.WHITE);
		lblndProcess.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblndProcess.setBounds(6, 48, 130, 30);
		contentPane.add(lblndProcess);
		
		f = new JSpinner();
		f.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		f.setFont(new Font("SansSerif", Font.BOLD, 14));
		f.setBounds(148, 7, 115, 30);
		contentPane.add(f);
		
		s = new JSpinner();
		s.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		s.setFont(new Font("SansSerif", Font.BOLD, 14));
		s.setBounds(148, 49, 115, 30);
		contentPane.add(s);
		
		btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setBounds(46, 90, 90, 30);
		contentPane.add(btnAdd);
		
		btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnBack.setBackground(Color.WHITE);
		btnBack.setBounds(148, 91, 90, 30);
		contentPane.add(btnBack);
		
		btnAdd.addActionListener(e -> {
			first = (Integer) f.getValue();
			second = (Integer) s.getValue();
			parrent.details.add(new Detail(first, second));
			parrent.reloadTable();
			dispose();
		});
		btnBack.addActionListener(e -> {
			dispose();
		});
	}
	
	public static void add(JohnsonApplication p) {
		parrent = p;
		AddDetail fr = new AddDetail();
		fr.setVisible(true);	
	}

}
