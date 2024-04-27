package baitoan1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SegmentApplication extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JButton btnThem,btnNext,btnAuto,btnClear;
	private JTable table;
	private JScrollPane scrollPane;
	private ArrayList<Segment> segments=new ArrayList<>();
	private DefaultTableModel model;
	private SegmentSelection seg=new SegmentSelection() ;
	private themHĐ dialog;
	
	
	public ArrayList<Segment> getSegments() {
		return segments;
	}

	public void setSegments(ArrayList<Segment> segments) {
		this.segments = segments;
	}

	public void addToTable(Segment segment) {
        Object[] rowData = {segment.getStart(), segment.getEnd(), segment.length()};
        model.addRow(rowData);
        model.fireTableDataChanged(); // Cập nhật bảng
    }
	
	private themHĐ themHD;

    public void setThemHD(themHĐ themHD) {
        this.themHD = themHD;
    }

    public void updateTable() {
        model.setRowCount(0); // Xóa tất cả các hàng trong bảng
        for (Segment segment : segments) {
            addToTable(segment); // Thêm lại dữ liệu vào bảng
        }
    }
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SegmentApplication frame = new SegmentApplication();
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
	public SegmentApplication() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 638, 446);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(54, 54, 170, 28);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(54, 112, 170, 28);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(54, 179, 170, 28);
		contentPane.add(panel_2);
		
		btnAuto = new JButton("Auto");
		btnAuto.setBounds(76, 282, 89, 23);
		contentPane.add(btnAuto);
		
		btnNext = new JButton("Next");
		btnNext.setBounds(232, 282, 89, 23);
		contentPane.add(btnNext);
		
		btnClear = new JButton("Clear");
		btnClear.setBounds(390, 282, 89, 23);
		contentPane.add(btnClear);
		
		btnThem = new JButton("Thêm hoạt động");
		btnThem.setBounds(408, 200, 123, 23);
		contentPane.add(btnThem);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(349, 54, 232, 128);
		contentPane.add(scrollPane);
		
		segments= new ArrayList<>();
		model= new DefaultTableModel();
		model.addColumn("Start");
		model.addColumn("End");
		model.addColumn("Length");
		table = new JTable(model);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Start", "End", "Length"
			}
		));
		scrollPane.setViewportView(table);
		
		btnThem.addActionListener(this);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		model = (DefaultTableModel) table.getModel();
		if(e.getSource()==btnThem) {
			dialog= new themHĐ(this);
			dialog.setVisible(true);
			
		}
		else if (e.getSource()==btnClear) {
			
		}
		else if (e.getSource()== btnAuto) {
			
		}
	}
	
}
