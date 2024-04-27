package baitoan1;

import baitoan1.Segment;

public class Segment implements Comparable<Segment>{
	DayTime start;
	DayTime end;
	
	public Segment(DayTime start, DayTime end) {
        this.start = start;
        this.end = end;
    }
    public Segment() {
		
	}
	public DayTime getStart() {
		return start;
	}
	void setStart(DayTime start) throws Exception{
		if (start.getHour()>=7)			
			this.start = start;
		else {
			throw new Exception("Giá trị không hợp lệ.");
		}
	}
	public DayTime getEnd() {
		return end;
	}
	void setEnd(DayTime end) throws Exception {
		if (end.toMinute()>=start.toMinute() && (end.getHour()<23 || (end.getHour()==23 && end.getMinute()==0)))
			this.end = end;
		else {
			throw new Exception("Giá trị không hợp lệ.");
		}
	}
	
	DayTime length() {
        return end.sub(start);
    }
	
	
	@Override
	public int compareTo(Segment other) {
	    return this.length().compareTo(other.length());
	}

    
	boolean intersects(Segment other) {
	    return this.start.compareTo(other.end) < 0 && other.start.compareTo(this.end) < 0;
	}

    
}
