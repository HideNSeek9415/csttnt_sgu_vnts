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
	public Point end = new Point(11, 11);
	public Point current;
	
	public int visitedCnt = 0;
	public int pathLength = 0;
	
	private ArrayList<Point> lst = new ArrayList<>();

	
	public Point[][] generateMatrix() {
		Point[][] matrix = new Point[12][12];
		for (int i = 0; i < 12; i++) {
			for (int j = 0; j < 12; j++) {
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
		
	public void prepareAlgorithm() {
		matrix = generateMatrix();
		current = start;
		current.visited = true;
		lst.add(current);
	}
	
	public boolean nextState() {
		if (lst.isEmpty() || end.visited) {
			return false;
		}
		lst.remove(current);
		ArrayList<Point> adjacencyPointList = getNextMove();
		for (Point point : adjacencyPointList) {
			lst.add(point);
		}
		Point nextPoint = adjacencyPointList.stream().min(Comparator.comparingInt(Point::getFx)).orElse(null);
		if (nextPoint != null) {
			if (nextPoint.fx <= current.fx) {				
				current = nextPoint;
			} else {
				current = lst.stream().min(Comparator.comparingInt(Point::getFx)).orElse(null);
			}
		} else {
			current = lst.stream().min(Comparator.comparingInt(Point::getFx)).orElse(null);
		}
		return true;
	}
	
	private ArrayList<Point> getNextMove() {
		ArrayList<Point> points = new ArrayList<>();
		for (int[] move : MOVES) {
			try {
				Point nextPoint = matrix[current.getX() + move[0]][current.getY() + move[1]];
				if (!nextPoint.wall && !nextPoint.visited) {
					nextPoint.visited = true;
					visitedCnt++;
					nextPoint.gx = current.gx + 1;
					nextPoint.fx = nextPoint.gx + hx(nextPoint);					
					nextPoint.parrent = current;
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
	
	public void refresh() {
		for (Point[] row : matrix) {
			for (Point point : row) {
				point.visited = false;
				point.fx = 9999;
				point.gx = 0;
				point.parrent = null;
			}
		}
	}
	
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
		start = new Point(3, 0);
		end = new Point(7, 11);
		prepareAlgorithm();
		for (int i = 2; i <= 7; i++) {
			setWall(i, 4);
		}
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
