package astar;

public class Point {
	private int x;
	private int y;
	public boolean visited = false;
	public boolean wall = false;
	public Point parrent;
	public boolean inPath = false;
	
	
	public Point(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public Point() {

	}
	
	public int getX() {
		return x;
	}
	private void setX(int x) throws Exception {
		if (x > Config.matrixSize - 1 || x < 0) {			
			this.x = x;
		} else {
			throw new Exception("x value invalid");
		}
	}
	public int getY() {
		return y;
	}
	private void setY(int y) throws Exception {
		if (y > Config.matrixSize - 1 || y < 0) {			
			this.y = y;
		} else {
			throw new Exception("y value invalid");
		}
	}
	
	public void setPoint(int x, int y) {
		try {
			setX(x);
			setY(y);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int fx = 0;
	public int gx = 0;
	
	public int getFx() {
		return this.fx;
	}
	
}
