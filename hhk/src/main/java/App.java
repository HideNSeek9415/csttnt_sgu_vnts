import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.UIManager;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class App {

	private JFrame frmMTThut;
	private JLabel lblNewLabel;
	private JLabel lblPhm;
	private JLabel lblNguyn;
	private JLabel lblCSTr;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

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
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(50, 6, 306, 30);
		frmMTThut.getContentPane().add(lblNewLabel);
		
		lblPhm = new JLabel("3122410181 - Phạm Duy Khánh");
		lblPhm.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhm.setForeground(new Color(255, 255, 255));
		lblPhm.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPhm.setBounds(50, 36, 306, 30);
		frmMTThut.getContentPane().add(lblPhm);
		
		lblNguyn = new JLabel("3122410103 - Nguyễn Thị Thanh Hằng");
		lblNguyn.setHorizontalAlignment(SwingConstants.CENTER);
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
		
		btnNewButton = new JButton("1. Bài toán các đoạn thẳng không giao nhau");
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setBackground(new Color(52, 68, 83));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(21, 180, 365, 40);
		frmMTThut.getContentPane().add(btnNewButton);
		
		btnNewButton_1 = new JButton("2. Gia công chi tiết (giải thuật JOHNSON)");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_1.setBackground(new Color(52, 68, 83));
		btnNewButton_1.setBounds(21, 230, 365, 40);
		frmMTThut.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("3. Tìm đường đi ngắn nhất (giải thuật A*)");
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton_2.setForeground(new Color(255, 255, 255));
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_2.setBackground(new Color(52, 68, 83));
		btnNewButton_2.setBounds(21, 280, 365, 40);
		frmMTThut.getContentPane().add(btnNewButton_2);
		frmMTThut.setBounds(100, 100, 421, 377);
		frmMTThut.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
