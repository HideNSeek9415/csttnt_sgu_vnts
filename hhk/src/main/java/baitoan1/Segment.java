package baitoan1;

import java.util.Scanner;

import baitoan1.Segment;

public class Segment implements Comparable<Segment>{
	DayTime start;
	DayTime end;
	Scanner scanner= new Scanner(System.in);
	
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
		if ((start.getHour() >=7 && start.getHour() <23 && start.getMinute() >=0 && start.getMinute()<60))			
			this.start = start;
		else {
			throw new Exception("Giá trị không hợp lệ.");
		}
	}
	public DayTime getEnd() {
		return end;
	}
	void setEnd(DayTime end) throws Exception {
		if ((end.getHour()>=7 && end.getHour() <23 && end.getMinute()>=0 && end.getMinute()<60)|| (end.getHour()==23 && end.getMinute()==0))
			this.end = end;
		else {
			throw new Exception("Giá trị không hợp lệ.");
		}
	}
	
	public int length() {
        return end.toMinute()-start.toMinute();
    }
	
	
	@Override
	public int compareTo(Segment other) {
	    return Integer.compare(this.length(), other.length());
	}

    
	boolean intersects(Segment other) {
	    if ((this.end.toMinute() >= other.start.toMinute() && this.end.toMinute() <= other.end.toMinute()) ||
		        (this.start.toMinute() >= other.start.toMinute() && this.start.toMinute() <= other.end.toMinute())) {
		        return true;
		    }
		return false;
	}

    
}
