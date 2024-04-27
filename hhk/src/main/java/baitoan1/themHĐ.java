package baitoan1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class themHĐ extends JDialog implements ActionListener{

	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtHoursStart;
	private JTextField txtMinuteStart;
	private JTextField txtHoursEnd;
	private JTextField txtMinuteEnd;
	private JButton btnAdd, cancelButton;
	private SegmentApplication segApp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SegmentApplication segApp = new SegmentApplication();
			themHĐ dialog = new themHĐ(segApp);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	
	public themHĐ(SegmentApplication segApp) {
		super();
		this.segApp = segApp;
		init();
	}
	
	public void init() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("hours");
			lblNewLabel.setBounds(127, 82, 49, 14);
			contentPanel.add(lblNewLabel);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("minute");
			lblNewLabel_1.setBounds(338, 82, 49, 14);
			contentPanel.add(lblNewLabel_1);
		}
		{
			txtHoursStart = new JTextField();
			txtHoursStart.setBounds(23, 79, 96, 20);
			contentPanel.add(txtHoursStart);
			txtHoursStart.setColumns(10);
		}
		{
			txtMinuteStart = new JTextField();
			txtMinuteStart.setBounds(210, 79, 96, 20);
			contentPanel.add(txtMinuteStart);
			txtMinuteStart.setColumns(10);
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Start:");
			lblNewLabel_2.setBounds(23, 40, 96, 14);
			contentPanel.add(lblNewLabel_2);
		}
		{
			JLabel lblNewLabel_3 = new JLabel("End:");
			lblNewLabel_3.setBounds(23, 128, 96, 14);
			contentPanel.add(lblNewLabel_3);
		}
		{
			JLabel lblNewLabel_4 = new JLabel("hours");
			lblNewLabel_4.setBounds(143, 156, 49, 14);
			contentPanel.add(lblNewLabel_4);
		}
		{
			JLabel lblNewLabel_5 = new JLabel("minute");
			lblNewLabel_5.setBounds(338, 156, 49, 14);
			contentPanel.add(lblNewLabel_5);
		}
		{
			txtHoursEnd = new JTextField();
			txtHoursEnd.setBounds(23, 153, 96, 20);
			contentPanel.add(txtHoursEnd);
			txtHoursEnd.setColumns(10);
		}
		{
			txtMinuteEnd = new JTextField();
			txtMinuteEnd.setBounds(210, 153, 96, 20);
			contentPanel.add(txtMinuteEnd);
			txtMinuteEnd.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnAdd = new JButton("Add");
				btnAdd.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				btnAdd.setActionCommand("OK");
				buttonPane.add(btnAdd);
				getRootPane().setDefaultButton(btnAdd);
			}
			{
				cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
		btnAdd.addActionListener(this);
		cancelButton.addActionListener(this);
	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		String message="";
		if (e.getSource()==btnAdd) {
			message="";
			if (txtHoursStart.getText().isEmpty() || txtMinuteStart.getText().isEmpty() || txtHoursEnd.getText().isEmpty() || txtMinuteEnd.getText().isEmpty()) {
				message="Vui lòng điền đầy đủ thông tin.";
			}
			else {				
				DayTime Start=new DayTime(Integer.parseInt(txtHoursStart.getText()),Integer.parseInt(txtMinuteStart.getText())) ;
				DayTime End=new DayTime(Integer.parseInt(txtHoursEnd.getText()),Integer.parseInt(txtMinuteEnd.getText())) ;	            
				segApp = new SegmentApplication();
				segApp.getSegments().add(new Segment(Start, End));
				segApp.addToTable(new Segment(Start, End));
				segApp.updateTable();
				this.dispose();
			}
			
		}
		else if (e.getSource()== cancelButton){
			dispose();
			
		}
		if (message!="")
			JOptionPane.showMessageDialog(this, message);		
			
		
	}
	

}
