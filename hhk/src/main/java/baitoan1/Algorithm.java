package baitoan1;

import java.util.ArrayList;
import java.util.Collections;

public class Algorithm {
	public ArrayList<Segment> segList = new ArrayList<>();
	public int numberOfDay;
	public ArrayList<Segment>[] activites;
	public int currentDay = 0;
	
	
	@SuppressWarnings("unchecked")
	public Algorithm(int numberOfDay, ArrayList<Segment> segList) {
		this.segList = new ArrayList<>(segList);
		this.numberOfDay = numberOfDay;
		sort();
		activites = new ArrayList[numberOfDay];
		for (int i = 0; i < numberOfDay; i++) {
			activites[i] = new ArrayList<>();
		}
	}
	
	public void sort() {
		Collections.sort(segList);
	}
	
	public boolean next() {
		if (currentDay == numberOfDay || segList.isEmpty()) {
			return false;
		}
		Segment next = getNextActivity();
		if (next != null) {
			segList.remove(next);
			activites[currentDay].add(next);
			next.happenedDay = currentDay;
		} else {
			currentDay++;
		}
		return true;
	}
	
	public Segment getNextActivity() {
		Segment next = null;
		for (Segment seg : segList) {
	        boolean valid = true;
			for (Segment selected : activites[currentDay]) {
				if (seg.intersects(selected)) {
					valid = false;
				}
			}
			if (valid) {
				next = seg;
				break;
			}
		}
		return next;
	}
	
}
