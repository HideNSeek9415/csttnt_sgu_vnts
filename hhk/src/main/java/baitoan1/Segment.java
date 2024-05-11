package baitoan1;

import baitoan1.Segment;

public class Segment implements Comparable<Segment> {
	DayTime start;
	DayTime end;
//	public boolean selected = false;
	public int happenedDay = -1;
	
	public Segment(DayTime start, DayTime end) {
        this.start = start;
        this.end = end;
    }
	
	public DayTime getStart() {
		return start;
	}
	void setStart(DayTime start) {
		this.start = start;
	}
	public DayTime getEnd() {
		return end;
	}
	void setEnd(DayTime end) throws Exception {
		this.end = end;
	}
	
	public int length() {
        return end.toMinute()-start.toMinute();
    }
	
	@Override
	public int compareTo(Segment other) {
	    return Integer.compare(this.length(), other.length());
	}
    
	boolean intersects(Segment other) {
		int tStart = this.start.toMinute();
		int tEnd = this.end.toMinute();
		int oStart = other.start.toMinute();
		int oEnd = other.end.toMinute();
		return (tStart - oEnd)*(oStart - tEnd) > 0;
	}

    
}
