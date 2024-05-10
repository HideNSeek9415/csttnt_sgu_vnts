package baitoan1;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;


public class SegmentApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSoNgay;
	private JTextField txtSoLeHoi;
	private ArrayList<Segment> dsActivities=new ArrayList<>();
	private JTable table;
	private JPanel panel,panel_1;
	private JTextField[] txtStartArray;
	private JTextField[] txtEndArray;
	private DefaultTableModel model;
	private JPanel[] panels;
	private SegmentSelection Seg=new SegmentSelection();
	//private JButton btnNext,btnAuto,btnClear;

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
		setBounds(100, 100, 588, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		panel = new JPanel();
		contentPane.add(panel, "form1");
		panel.setLayout(null);
		
		txtSoNgay = new JTextField();
		txtSoNgay.setBounds(134, 81, 96, 20);
		panel.add(txtSoNgay);
		txtSoNgay.setColumns(10);
		
		txtSoLeHoi = new JTextField();
		txtSoLeHoi.setBounds(333, 81, 96, 20);
		panel.add(txtSoLeHoi);
		txtSoLeHoi.setColumns(10);
		
		JButton btnNhap = new JButton("Nhập");
		btnNhap.setBounds(223, 158, 89, 23);
		panel.add(btnNhap);
		
		JLabel lblNewLabel = new JLabel("Số ngày:");
		lblNewLabel.setBounds(67, 84, 64, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Số lễ hội:");
		lblNewLabel_1.setBounds(263, 84, 72, 14);
		panel.add(lblNewLabel_1);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, "form2");
		panel_1.setLayout(null);
		
		JButton btnAuto = new JButton("Auto");
		btnAuto.setBounds(53, 289, 89, 23);
		panel_1.add(btnAuto);
		
		JButton btnNext = new JButton("Next");
		btnNext.setBounds(230, 290, 89, 23);
		panel_1.add(btnNext);
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(415, 288, 89, 23);
		panel_1.add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(335, 67, 194, 115);
		panel_1.add(scrollPane);
		
		model=new DefaultTableModel();
		model.addColumn("Start");
		model.addColumn("End");
		table = new JTable(model);
		
		
		
		scrollPane.setViewportView(table);
		
		
		
		btnNhap.addActionListener(new ActionListener() {
			
		    String message = "";
		    @Override
		    public void actionPerformed(ActionEvent e) {
		        if (txtSoNgay.getText().isEmpty() ||  txtSoLeHoi.getText().isEmpty()) {
		            message = "Vui lòng nhập đầy đủ thông tin!";
		        } else {
		            try {
		                int soNgay = Integer.parseInt(txtSoNgay.getText());
		                if (soNgay <= 0) {
		                    message = "Số ngày phải là số nguyên dương!";
		                } else {
		                    if (txtSoLeHoi.getText().isEmpty()) {
		                        message = "Vui lòng nhập số lễ hội!";
		                    } else {
		                        try {	
		                        	
		                            int soLH = Integer.parseInt(txtSoLeHoi.getText());
		                            if (soLH <= 0) {
		                                message = "Số lễ hội phải là số nguyên dương!";
		                            } else {
		                                
		                            	panel.removeAll();
		                            	panel.revalidate();
		                                panel.repaint();
		                                
	                                    
	                                    nhapThongTin(soLH);
										paintForm2(soNgay);
										panel_1.repaint();
											
		                                
		                                panel.revalidate();
		                                panel.repaint();		                                
		                            }
		                        } catch (NumberFormatException ex) {
		                            message = "Số lễ hội phải là số nguyên dương!";
		                        }
		                    }
		                }
		            } catch (NumberFormatException ex) {
		                message = "Số ngày phải là số nguyên dương!";
		            }
		        }
		        if (message!="") {
		        	JOptionPane.showMessageDialog(contentPane, message);
		        }
		    }
		});
		
	
	}
	
	public void addToTable(Segment activity) {
		model.addRow(new Object[] {activity.getStart().toString(),activity.getEnd().toString()});
	}
	
	
	public void nhapThongTin(int soLH) {
		txtStartArray=new JTextField[soLH];
		txtEndArray=new JTextField[soLH];
		for (int i = 0; i < soLH; i++) {
        	JLabel lblhoatDong=new JLabel("Hoạt động "+(i+1)+":");
        	lblhoatDong.setBounds(50, 30 + i * 60, 150, 20);
            panel.add(lblhoatDong);
            
            JLabel lblStart = new JLabel("Start:");
            lblStart.setBounds(50, 50 + i * 60, 50, 20);
            panel.add(lblStart);

            txtStartArray[i] = new JTextField();
            txtStartArray[i].setBounds(120, 50 + i * 60, 100, 20);
            panel.add(txtStartArray[i]);

            JLabel lblEnd = new JLabel("End:");
            lblEnd.setBounds(240, 50 + i * 60, 50, 20);
            panel.add(lblEnd);

            txtEndArray[i] = new JTextField();
            txtEndArray[i].setBounds(310, 50 + i * 60, 100, 20);
            panel.add(txtEndArray[i]);
        }
        JButton btnOk= new JButton("OK");
        btnOk.setBounds(390,300,100,20);
        panel.add(btnOk);
        
        btnOk.addActionListener(new ActionListener() {
            String message = "";
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean check_empty = false;
                boolean check_error=false;
                boolean check_format = false;
                boolean check_minute_range = false;
                boolean check_start_end_time = false;
                for(int i = 0; i < soLH; i++) {
                    String startText = txtStartArray[i].getText();
                    String endText = txtEndArray[i].getText();
                    if (startText.isEmpty() || endText.isEmpty()) {
                        check_empty = true;
                        break;
                    }
                    else if (!isValidTimeFormat(startText) || !isValidTimeFormat(endText)) {
                        check_format = true;
                        break; 
                    }
                    else {
                        int startHour = Integer.parseInt(startText.split(":")[0]);
                        int endHour = Integer.parseInt(endText.split(":")[0]);
                        int startMinute = Integer.parseInt(startText.split(":")[1]);
                        int endMinute = Integer.parseInt(endText.split(":")[1]);
                        if (startHour >= 7 && startHour <= 23 && endHour >= 7 && endHour <= 23) {                            
                            if (startHour < endHour || (startHour == endHour && startMinute < endMinute)) {
                                break;
                            } else {
                                check_error = true;
                                break;
                            }
                        } else {
                            check_error = true;                           
                            break;
                        }
                    }
                }
                if (check_error) {
                	message = "Thời gian phải nằm trong khoảng từ 7:0 đến 23:0 và thời gian bắt đầu nhở hơn thời gian kết thúc!";
                } else if (check_format) {
                    message = "Nhập vào không đúng định dạng (vd: 7:15). Vui lòng nhập lại!";
                } else {
                    // Nếu không có lỗi, tiến hành thêm các hoạt động vào dsActivities và bảng
                    for(int i = 0; i < soLH; i++) {
                        String startText = txtStartArray[i].getText();
                        DayTime startTime = DayTime.parse(startText);
                        String endText = txtEndArray[i].getText();
                        DayTime endTime = DayTime.parse(endText);
                        dsActivities.add(new Segment(startTime, endTime));
                        addToTable(new Segment(startTime, endTime));
                    }
                    ((CardLayout) contentPane.getLayout()).show(contentPane, "form2");
                }
                if (message!="") {
                    JOptionPane.showMessageDialog(contentPane, message);
                }
            }
            
        });
        
        
        
        

	}
	
	
	public void paintForm2(int soNgay) {
		panels= new JPanel[soNgay];
		for (int i=0; i<soNgay; i++) {
			panels[i]=new JPanel();
			panels[i].setBounds(10, 30 + i*50, 300, 30);
			panels[i].setBorder(BorderFactory.createLineBorder(Color.black));
			panel_1.add(panels[i]);
					
		}
	}
	
	
	private boolean isValidTimeFormat(String time) {
	    String regex = "^(1[0-9]|2[0-3]|0?[0-9]):([0-5]?[0-9])$";
	    return time.matches(regex);
	}
}
