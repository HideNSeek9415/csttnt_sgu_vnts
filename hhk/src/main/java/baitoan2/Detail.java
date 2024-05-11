package baitoan2;

public class Detail implements Comparable<Detail> {
	public int firstProcess;
	public int secondProcess;
	public int firstProcessStarted = 0;
	public int secondProcessStarted;
	public int firstDone = -1;
	
	/*
	 * Group 1: firstProcess < secondProcess
	 * Group 2: firstProcess > secondProcess
	 * */
	public int group; 

	public Detail(int firstProcess, int secondProcess) {			
		this.firstProcess = firstProcess;
		this.secondProcess = secondProcess;
		group = this.firstProcess < this.secondProcess ? 1 : 2;
	}

	@Override
	public int compareTo(Detail other) {
		int rslt = 0;
		if (this.group == other.group) {
			if (this.group == 1) {
				rslt = this.firstProcess - other.firstProcess;
			} else if (this.group == 2) {
				rslt = other.secondProcess - this.secondProcess;
			}
		}
		return rslt;
	}
	
}
