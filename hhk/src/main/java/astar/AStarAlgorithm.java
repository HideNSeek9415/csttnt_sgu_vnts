package astar;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class AStarAlgorithm {
	
	public static final int PATH_FOUND = 1;
	public static final int PATH_NOT_FOUND = -1;


	private static final int[][] MOVES = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
	
	private int hx(Point p) {
		return Math.abs(p.getX() - end.getX()) + Math.abs(p.getY() - end.getY());
	}
	
	public int state = 0;
		
	public Point start = new Point(0, 0);
	public Point end = new Point(Config.matrixSize - 1, Config.matrixSize - 1);
	public Point current;
	
	public int visitedCnt = 0;
	public int pathLength = 0;
	
	private ArrayList<Point> open = new ArrayList<>();
	private ArrayList<Point> close = new ArrayList<>();

	
	public Point[][] generateMatrix() {
		Point[][] matrix = new Point[Config.matrixSize][Config.matrixSize];
		for (int i = 0; i < Config.matrixSize; i++) {
			for (int j = 0; j < Config.matrixSize; j++) {
				matrix[i][j] = new Point(i, j);
			}
		}
		matrix[start.getX()][start.getY()] = start;
		matrix[end.getX()][end.getY()] = end;
		return matrix;
	}
	
	public void setWall(int x, int y) {
		matrix[x][y].wall = true;
	}
	
	public void setStart(int x, int y) {
		start = new Point(x, y);
	}
	
	public void setEnd(int x, int y) {
		end = new Point(x, y);
	}
	
	public Point[][] matrix;
	
	private Point getMin() {
		Point min = open.get(0);
		for (Point p : open) {
			if (min.fx > p.fx) {
				min = p;
			} else if (min.fx == p.fx && (min.fx - min.gx) > (p.fx - p.gx)) {
				min = p;
			}
		}
		return min;
	}
		
	public void prepareAlgorithm() {
		matrix = generateMatrix();
		open.add(start);
	}
	
	public boolean nextState() {
		if (open.isEmpty()) {
			return false;
		}
		
		current = getMin();
		current.visited = true;
		visitedCnt++;
		
		if (current == end) {
			end.visited = true;
			return false;
		} else {
			open.remove(current);
			close.add(current);
		}
		
		for (Point next : getNextMove()) {
			if (!close.contains(next)) {
				int Gx = current.gx + 1;
				int Fx = Gx + hx(next);
				boolean isInOpen = open.contains(next);
				if (!isInOpen) {
					next.gx = Gx;
					next.fx = Fx;
					next.parrent = current;
					open.add(next);
				} else if (isInOpen && Gx < next.gx) {
					next.gx = Gx;
					next.fx = Fx;
					next.parrent = current;
				}
			}
		}
		return true;
	}
	
	private ArrayList<Point> getNextMove() {
		ArrayList<Point> points = new ArrayList<>();
		for (int[] move : MOVES) {
			try {
				Point nextPoint = matrix[current.getX() + move[0]][current.getY() + move[1]];
				if (!nextPoint.wall) {					
					points.add(nextPoint);
				}
			} catch (Exception e) {}
		}
		return points;
	}
	
	public boolean makePath() {
		if (end.visited) {
			Point curPoint = end;
			curPoint.inPath = true;
			while (start.inPath != true) {
				curPoint = curPoint.parrent;
				curPoint.inPath = true;
				pathLength++;
			}
		} else {
			return false;
		}
		return true;
	}
	
//	public void refresh() {
//		for (Point[] row : matrix) {
//			for (Point point : row) {
//				point.visited = false;
//				point.fx = 0;
//				point.gx = 0;
//				point.parrent = null;
//			}
//		}
//	}
	
	public void printMatrix() {
		for (Point[] row : matrix) {
			for (Point point : row) {
				if (point == start) {
					System.out.print("S  ");
				} else if (point == end) {
					System.out.print("E  ");
				} else if (point.wall) {
					System.out.print("*  ");
				} else if (point.inPath) {
					System.out.print("p  ");
				} else if (point == current) {
					System.out.print("C  ");
				} else if (point.visited) {
					System.out.print(".  ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println("");
		}
	}
	
	public void show() {
		Scanner sc = new Scanner(System.in);
		start = new Point(0, 0);
		end = new Point(Config.matrixSize - 1, Config.matrixSize - 1);
		prepareAlgorithm();
		while (nextState()) {
			printMatrix();
			sc.nextLine();
		}
		makePath();
		printMatrix();
		sc.close();
	}
	
	public static void main(String[] args) {
		(new AStarAlgorithm()).show();
	}
	
}
