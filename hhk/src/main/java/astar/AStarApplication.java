package astar;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.SpinnerNumberModel;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JToggleButton;

public class AStarApplication extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblCngC;
	private JPanel panel_4;
	private JPanel panel_5;
	private JButton btnDone;
	private JButton btnAuto;
	private JButton btnNext;
	private JPanel panel_6;
	private JToggleButton btnStart;
	private JToggleButton btnEnd;
	private JToggleButton btnWall;
	private JToggleButton btnDelete;
	private JLabel lblInfo;
	
	private ButtonGroup grp = new ButtonGroup();
	
	private ArrayList<Cell> cells = new ArrayList<>();
	private JToggleButton btnDefault;
	private JButton btnClearall;
	
	private AStarAlgorithm AStar = new AStarAlgorithm();
	private JPanel panel_3;
	private JPanel panel_7;
	private JPanel panel_8;
	private JLabel lblNumberOfVisited;
	private JLabel lblPathLength;
	private JLabel lblVisitedCnt;
	private JLabel lblLength;
	private JLabel lblPathFound;
	private JButton btnClearpath;
	private JPanel panel_9;
	private JLabel lblSize;
	private JSpinner spinner;
	private JButton btnUpdateMatrix;
	private JLabel lblCngC_1;
	private JLabel lblSizeBetween;

	/**
	 * Launch the application.
	 */
	
	public Cell getCell(int x, int y) {
		return cells.get(y + x*Config.matrixSize);
	}
	public int[] getCellIndex(int post) {
		int[] ret = new int[2];
		ret[0] = post / Config.matrixSize;
		ret[1] = post % Config.matrixSize;
		return ret;
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
					AStarApplication frame = new AStarApplication();
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
	public AStarApplication() {
		setTitle("A* Algorithm");
		setResizable(false);
		setBackground(new Color(183, 232, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 845, 660);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(28, 60, 38));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		panel = new JPanel();
		panel.setOpaque(false);
		panel.setPreferredSize(new Dimension(300, 10));
		contentPane.add(panel, BorderLayout.EAST);
		panel.setLayout(new BorderLayout(0, 0));
		
		lblInfo = new JLabel("_____ INFO _____");
		lblInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblInfo.setForeground(Color.WHITE);
		lblInfo.setFont(new Font("SansSerif", Font.BOLD, 24));
		panel.add(lblInfo, BorderLayout.NORTH);
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EmptyBorder(15, 0, 0, 0));
		panel_3.setOpaque(false);
		panel.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		panel_7 = new JPanel();
		panel_7.setOpaque(false);
		panel_7.setPreferredSize(new Dimension(90, 10));
		panel_3.add(panel_7, BorderLayout.EAST);
		panel_7.setLayout(new GridLayout(3, 0, 0, 0));
		
		lblVisitedCnt = new JLabel("0");
		lblVisitedCnt.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitedCnt.setForeground(Color.WHITE);
		lblVisitedCnt.setFont(new Font("SansSerif", Font.BOLD, 16));
		panel_7.add(lblVisitedCnt);
		
		lblLength = new JLabel("0");
		lblLength.setHorizontalAlignment(SwingConstants.CENTER);
		lblLength.setForeground(Color.WHITE);
		lblLength.setFont(new Font("SansSerif", Font.BOLD, 16));
		panel_7.add(lblLength);
		
		panel_8 = new JPanel();
		panel_8.setBorder(new EmptyBorder(0, 10, 0, 0));
		panel_8.setPreferredSize(new Dimension(80, 10));
		panel_8.setOpaque(false);
		panel_3.add(panel_8, BorderLayout.CENTER);
		panel_8.setLayout(new GridLayout(3, 0, 0, 0));
		
		lblNumberOfVisited = new JLabel("Number of visited node:");
		lblNumberOfVisited.setForeground(Color.WHITE);
		lblNumberOfVisited.setFont(new Font("SansSerif", Font.BOLD, 16));
		panel_8.add(lblNumberOfVisited);
		
		lblPathLength = new JLabel("Path length:");
		lblPathLength.setForeground(Color.WHITE);
		lblPathLength.setFont(new Font("SansSerif", Font.BOLD, 16));
		panel_8.add(lblPathLength);
		
		lblPathFound = new JLabel("");
		lblPathFound.setHorizontalAlignment(SwingConstants.LEFT);
		lblPathFound.setForeground(Color.WHITE);
		lblPathFound.setFont(new Font("SansSerif", Font.BOLD, 16));
		panel_8.add(lblPathFound);
		
		panel_9 = new JPanel();
		panel_9.setOpaque(false);
		panel_9.setPreferredSize(new Dimension(10, 400));
		panel.add(panel_9, BorderLayout.SOUTH);
		panel_9.setLayout(null);
		
		lblSize = new JLabel("Size:");
		lblSize.setForeground(Color.WHITE);
		lblSize.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSize.setBounds(47, 50, 51, 28);
		panel_9.add(lblSize);
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(12, 12, 30, 1));
		spinner.setFont(new Font("Arial", Font.BOLD, 22));
		spinner.setBounds(108, 50, 83, 28);
		panel_9.add(spinner);
		
		btnUpdateMatrix = new JButton("OK");
		btnUpdateMatrix.setFocusPainted(false);
		btnUpdateMatrix.setForeground(new Color(255, 255, 255));
		btnUpdateMatrix.setBorder(null);
		btnUpdateMatrix.setBackground(new Color(0, 64, 0));
		btnUpdateMatrix.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnUpdateMatrix.setPreferredSize(new Dimension(20, 20));
		btnUpdateMatrix.setBounds(201, 51, 69, 28);
		panel_9.add(btnUpdateMatrix);
		
		lblCngC_1 = new JLabel("Initilize:");
		lblCngC_1.setForeground(Color.WHITE);
		lblCngC_1.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblCngC_1.setBounds(10, 10, 160, 30);
		panel_9.add(lblCngC_1);
		
		lblSizeBetween = new JLabel("Size between 12 and 30");
		lblSizeBetween.setHorizontalAlignment(SwingConstants.CENTER);
		lblSizeBetween.setForeground(Color.WHITE);
		lblSizeBetween.setFont(new Font("SansSerif", Font.BOLD, 16));
		lblSizeBetween.setBounds(47, 88, 223, 28);
		panel_9.add(lblSizeBetween);
		
		panel_1 = new JPanel();
		panel_1.setOpaque(false);
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setOpaque(false);
		panel_2.setPreferredSize(new Dimension(10, 60));
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		
		lblCngC = new JLabel("Tools");
		lblCngC.setForeground(new Color(255, 255, 255));
		lblCngC.setFont(new Font("SansSerif", Font.BOLD, 18));
		panel_2.add(lblCngC);
		
		panel_4 = new JPanel();
		panel_4.setOpaque(false);
		panel_2.add(panel_4);
		
		btnStart = new JToggleButton("Start");
		btnStart.setForeground(new Color(255, 255, 255));
		btnStart.setBackground(new Color(74, 74, 74));
		btnStart.setFocusPainted(false);
		btnStart.setFont(new Font("Roboto Mono", Font.BOLD, 12));
		btnStart.setPreferredSize(new Dimension(80, 25));
		panel_4.add(btnStart);
		
		btnEnd = new JToggleButton("End");
		btnEnd.setForeground(new Color(255, 255, 255));
		btnEnd.setBackground(new Color(74, 74, 74));
		btnEnd.setPreferredSize(new Dimension(80, 25));
		btnEnd.setFont(new Font("Roboto Mono", Font.BOLD, 12));
		btnEnd.setFocusPainted(false);
		panel_4.add(btnEnd);
		
		btnWall = new JToggleButton("Wall");
		btnWall.setForeground(new Color(255, 255, 255));
		btnWall.setBackground(new Color(74, 74, 74));
		btnWall.setPreferredSize(new Dimension(80, 25));
		btnWall.setFont(new Font("Roboto Mono", Font.BOLD, 12));
		btnWall.setFocusPainted(false);
		panel_4.add(btnWall);
		
		btnDelete = new JToggleButton("Delete");
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(74, 74, 74));
		btnDelete.setPreferredSize(new Dimension(80, 25));
		btnDelete.setFont(new Font("Roboto Mono", Font.BOLD, 12));
		btnDelete.setFocusPainted(false);
		panel_4.add(btnDelete);
		
		btnDefault = new JToggleButton("Def");
		btnDefault.setForeground(new Color(255, 255, 255));
		btnDefault.setBackground(new Color(74, 74, 74));
		btnDefault.setPreferredSize(new Dimension(80, 25));
		btnDefault.setFont(new Font("Roboto Mono", Font.BOLD, 12));
		btnDefault.setFocusPainted(false);
		panel_4.add(btnDefault);
		
		panel_5 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_5.getLayout();
		flowLayout.setHgap(15);
		panel_5.setPreferredSize(new Dimension(10, 35));
		panel_5.setOpaque(false);
		panel_1.add(panel_5, BorderLayout.SOUTH);
		
		btnDone = new JButton("DONE");
		btnDone.setFocusPainted(false);
		btnDone.setForeground(new Color(128, 0, 0));
		btnDone.setFont(new Font("Roboto Mono", Font.BOLD, 15));
		btnDone.setBackground(new Color(255, 255, 255));
		btnDone.setPreferredSize(new Dimension(70, 28));
		panel_5.add(btnDone);
		
		btnAuto = new JButton("Auto");
		btnAuto.setEnabled(false);
		btnAuto.setFocusPainted(false);
		btnAuto.setForeground(new Color(0, 0, 0));
		btnAuto.setFont(new Font("Roboto Mono", Font.BOLD, 15));
		btnAuto.setBackground(new Color(183, 152, 28));
		btnAuto.setPreferredSize(new Dimension(70, 28));
		panel_5.add(btnAuto);
		
		btnNext = new JButton("Next");
		btnNext.setEnabled(false);
		btnNext.setFocusPainted(false);
		btnNext.setForeground(new Color(0, 0, 0));
		btnNext.setFont(new Font("Roboto Mono", Font.BOLD, 15));
		btnNext.setBackground(new Color(183, 152, 28));
		btnNext.setPreferredSize(new Dimension(70, 28));
		panel_5.add(btnNext);
		
		btnClearall = new JButton("CLS ALL");
		btnClearall.setForeground(new Color(255, 255, 255));
		btnClearall.setBackground(new Color(128, 128, 255));
		btnClearall.setPreferredSize(new Dimension(90, 25));
		btnClearall.setFont(new Font("Roboto Mono", Font.BOLD, 12));
		btnClearall.setFocusPainted(false);
		panel_5.add(btnClearall);
		
		btnClearpath = new JButton("CLS PATH");
		btnClearpath.setPreferredSize(new Dimension(90, 25));
		btnClearpath.setForeground(Color.WHITE);
		btnClearpath.setFont(new Font("Roboto Mono", Font.BOLD, 12));
		btnClearpath.setFocusPainted(false);
		btnClearpath.setBackground(new Color(128, 128, 255));
		panel_5.add(btnClearpath);
		panel_6 = new JPanel();
		panel_6.setOpaque(false);
		panel_6.setBackground(new Color(255, 255, 255));
		panel_6.setBorder(new EmptyBorder(8, 8, 8, 8));
		panel_1.add(panel_6, BorderLayout.CENTER);
		panel_6.setLayout(new GridLayout(Config.matrixSize, Config.matrixSize, 1, 1));
		
		loadMatrix();
		changeBtn();
	}

	private void changeBtn() {
		// TODO Auto-generated method stub
		grp.add(btnStart);
		grp.add(btnEnd);
		grp.add(btnDelete);
		grp.add(btnDefault);
		grp.add(btnWall);
		grp.setSelected(btnDefault.getModel(), true);

		
		btnStart.addActionListener(e -> {
			Config.selectmode = Config.START;
		});
		btnEnd.addActionListener(e -> {
			Config.selectmode = Config.END;
		});
		btnDelete.addActionListener(e -> {
			Config.selectmode = Config.CLEAR;
		});
		btnDefault.addActionListener(e -> {
			Config.selectmode = Config.DEFAULT;
		});
		btnWall.addActionListener(e -> {
			Config.selectmode = Config.WALL;
		});
		btnDefault.addActionListener(e -> {
			Config.selectmode = Config.DEFAULT;
		});
		btnClearall.addActionListener(e -> {
			cells.forEach(cell -> {
				cell.clear();
			});
			AStar = new AStarAlgorithm();
			refershBtn();
		});
		
		btnClearpath.addActionListener(e -> {
			cells.forEach(cell -> {
				if (!cell.isWall && cell != Config.startCell && cell != Config.endCell) {					
					cell.clear();
				}
				AStar = new AStarAlgorithm();
				refershBtn();
			});
			
			AStar = new AStarAlgorithm();
		});
		btnDone.addActionListener(e -> {
			if (Config.startCell == null || Config.endCell == null) {
				JOptionPane.showMessageDialog(null, "You must define START and END point!!!", "Error", JOptionPane.ERROR_MESSAGE);
				return;
			}
			AStar.setStart(Config.startCell.x, Config.startCell.y);
			AStar.setEnd(Config.endCell.x, Config.endCell.y);
					
			AStar.prepareAlgorithm();
			cells.forEach(cell -> {
				if (cell.isWall) {
					AStar.setWall(cell.x, cell.y);
				}
			});
			showAttempt();
			btnDone.setEnabled(false);
			btnAuto.setEnabled(true);
			btnNext.setEnabled(true);
			btnStart.setEnabled(false);
			btnEnd.setEnabled(false);
			btnWall.setEnabled(false);
			btnDelete.setEnabled(false);
		});
		btnNext.addActionListener(e -> {
			if (AStar.nextState()) {
				showAttempt();
			} else {
				drawPath();
			}
		});
		btnAuto.addActionListener(e -> {
			new Thread(() -> {
				while (AStar.nextState()) {
					showAttempt();
					try {
						Thread.sleep(50);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
				}
				drawPath();
				
			}).start();
		});
		btnUpdateMatrix.addActionListener(e -> {
			reloadMatrix();
			AStar = new AStarAlgorithm();
			refershBtn();
		});

	}
	
	private void refershBtn() {
		btnAuto.setEnabled(false);
		btnNext.setEnabled(false);
		btnDone.setEnabled(true);
		btnStart.setEnabled(true);
		btnEnd.setEnabled(true);
		btnWall.setEnabled(true);
		btnDelete.setEnabled(true);
		grp.setSelected(btnDefault.getModel(), true);
		lblVisitedCnt.setText("0");
		lblLength.setText("0");
		lblPathFound.setText("");
	}
	
	private void drawPath() {
		if (AStar.makePath()) {					
			lblPathFound.setText("PATH FOUND");
			showAttempt();
		} else {
			lblPathFound.setText("PATH NOT FOUND");
		}
		lblVisitedCnt.setText(String.valueOf(AStar.visitedCnt));
		lblLength.setText(String.valueOf(AStar.pathLength));
	}

	private void loadMatrix() {
		// TODO Auto-generated method stub
		for (int i = 0; i < Config.matrixSize*Config.matrixSize; i++) {
			int[] p = getCellIndex(i);
			Cell cell = new Cell(p[0], p[1]);
			panel_6.add(cell);
			cells.add(cell);
		}
	}
	
	private void reloadMatrix() {
		Config.matrixSize = (int) spinner.getValue();
		cells.clear();
		panel_6.removeAll();
		panel_6.setLayout(new GridLayout(Config.matrixSize, Config.matrixSize, 1, 1));
		loadMatrix();
		panel_6.revalidate();
		panel_6.repaint();
		Config.startCell = null;
		Config.endCell = null;
	}
	
	private void showAttempt() {
		for (int i = 0; i < Config.matrixSize; i++) {
			for (int j = 0; j < Config.matrixSize; j++) {
				Point point = AStar.matrix[i][j];
				if (point == AStar.start) {
					getCell(i, j).makeStart();
				} else if (point == AStar.end) {
					getCell(i, j).makeGoal();
				} else if (point.wall) {
					getCell(i, j).makeWall();
				} else if (point.inPath) {
					getCell(i, j).makeRoad();
				} else if (point == AStar.current) {
					getCell(i, j).makeNextMove();
				} else if (point.visited) {
					getCell(i, j).makeMarked();
				} else {
					getCell(i, j).clear();
				}
			}
		}
	}
	
}
