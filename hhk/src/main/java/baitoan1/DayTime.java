package baitoan1;

public class DayTime {
	private int hour;
	private int minute;
	
	public DayTime(int hour, int minute) {
		setHour(hour);
		setMinute(minute);
	}
	
	public DayTime(int minutes) {
		minutes = minutes % (24*60);
		minutes = (minutes < 0) ? 24*60 + minutes : minutes;
		setHour(minutes/60);
		setMinute(minutes%60);
	}
	
	public int toMinute() {
		return this.hour*60 + this.minute;
	}
	
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		hour = hour % 24;
		hour = (hour < 0) ? 24 + hour : hour;
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		minute = minute % 60;
		minute = (minute < 0) ? 60 + minute : minute;
		this.minute = minute;
	}
	
	@Override
	public String toString() {
		return String.format("%02d:%02d", this.hour, this.minute);
	}
	
	public DayTime add(DayTime time) {
		int minutes = toMinute() + time.toMinute();
		return new DayTime(minutes);
	}
	
	public DayTime sub(DayTime time) {
		int minutes = toMinute() - time.toMinute();
		return new DayTime(minutes);
	}
	
	public int compareTo(DayTime other) {
	    int thisMinute = this.toMinute();
	    int otherMinute = other.toMinute();
	    return Integer.compare(thisMinute, otherMinute);
	}

	public static DayTime parse(String timeStr) {
        String[] parts = timeStr.split(":");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Định dạng thời gian không hợp lệ. Phải là giờ:phút.");
        }
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return new DayTime(hour, minute);
    }

	
//	public static void main(String[] args) {
//		System.out.println((new DayTime(4, 0)).sub(new DayTime(7, 45)));
//	}
}
