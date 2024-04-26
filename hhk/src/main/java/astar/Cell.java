package astar;

import javax.swing.JPanel;

import org.kordamp.ikonli.materialdesign2.MaterialDesignA;
import org.kordamp.ikonli.materialdesign2.MaterialDesignF;
import org.kordamp.ikonli.materialdesign2.MaterialDesignH;
import org.kordamp.ikonli.materialdesign2.MaterialDesignW;
import org.kordamp.ikonli.swing.FontIcon;

import java.awt.Color;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Cell extends JPanel {

	private static final long serialVersionUID = 1L;
	private JLabel lblNewLabel;
	private FontIcon icon = FontIcon.of(MaterialDesignA.AB_TESTING);
	private Cell self = this;
	
	public int x, y;

		
	/**
	 * Create the panel.
	 */
	public Cell(int x, int y) {
		this.x = x;
		this.y = y;
		setPreferredSize(new Dimension(300, 300));
		setBackground(new Color(247, 247, 247));
		setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel();
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setBorder(null);
		lblNewLabel.setBackground(new Color(242, 242, 242));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblNewLabel, BorderLayout.CENTER);
		icon.setIconSize(280/Config.matrixSize);
		clear();

		lblNewLabel.addMouseListener(new MouseAdapter() {
		    public void mousePressed(MouseEvent e) {
		    	switch (Config.selectmode) {
		    	case Config.START:
		    		makeStart();
		    		if (Config.endCell == self) {
		    			Config.endCell = Config.startCell;
		    			Config.endCell.makeGoal();
		    		} else if (Config.startCell != null) {
		    			Config.startCell.clear();
		    			Config.startCell = null;
		    		}
		    		Config.startCell = self;
		    		break;
		    	case Config.END:
		    		makeGoal();
		    		if (Config.startCell == self) {
		    			Config.startCell = Config.endCell;
		    			Config.startCell.makeStart();
		    		} else if (Config.endCell != null) {
		    			Config.endCell.clear();
		    			Config.endCell = null;
		    		}
		    		Config.endCell = self;
		    		break;
		    	case Config.WALL:
		    		makeWall();
		    		reload();
		    		break;
		    	case Config.CLEAR:
		    		clear();
		    		break;
		    	}
		    	Config.isMousePressed = true;
		    }
		    
		    public void mouseReleased(MouseEvent e) {
		    	Config.isMousePressed = false;
		    }

		    
		    public void mouseEntered(MouseEvent e) {
		    	if (Config.isMousePressed) {
		    		if (Config.selectmode == Config.WALL) {
		    			makeWall();
		    			reload();
		    		} else if (Config.selectmode == Config.CLEAR) {
			    		clear();
		    		}
		    	}
		    }

		});
	}
	
	private void reload() {
		if (self == Config.startCell) {
			Config.startCell = null;
		}
		if (self == Config.endCell) {
			Config.endCell = null;
		}
	}
	
	public void makeStart() {
		lblNewLabel.setIcon(null);
		lblNewLabel.setText("S");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 180/Config.matrixSize));
		setBackground(Color.decode("#e0e0e0"));
		isWall = false;
	}
	
	public void makeGoal() {
		lblNewLabel.setIcon(icon);
		lblNewLabel.setText("");
		icon.setIkon(MaterialDesignF.FLAG_CHECKERED);
		icon.setIconColor(Color.decode("#000000"));
		setBackground(Color.decode("#cae8fc"));
		isWall = false;
	}
	
	public void makeWall() {
		lblNewLabel.setIcon(null);
		lblNewLabel.setText("");
		isWall = true;
		setBackground(Color.black);
	}
	
	public void makeRoad() {
		lblNewLabel.setIcon(null);
		lblNewLabel.setText("");
		setBackground(Color.decode("#f8652f"));
	}
	
	public void makeMarked() {
		lblNewLabel.setIcon(null);
		lblNewLabel.setText("");
		setBackground(Color.decode("#4facff"));
	}
	
	public void makeNextMove() {
		lblNewLabel.setIcon(null);
		lblNewLabel.setText("");
		setBackground(Color.decode("#9a0000"));
	}
	
	public void clear() {
		lblNewLabel.setIcon(null);
		lblNewLabel.setText("");
		setBackground(Color.decode("#ffffff"));
		isWall = false;
	}
	
	public boolean isWall = false;

}
