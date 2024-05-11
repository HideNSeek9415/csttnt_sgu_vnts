package baitoan2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class JohnsonAlgorithm {

	public ArrayList<Detail> details = new ArrayList<>();
	ArrayList<Detail> group1 = new ArrayList<>();
	ArrayList<Detail> group2 = new ArrayList<>();
	
	public JohnsonAlgorithm(ArrayList<Detail> details) {
		this.details = new ArrayList<>(details);
	}
	
	public void step1() {
		group1 = (ArrayList<Detail>) details.stream().filter(d -> d.group == 1).collect(Collectors.toList());
		group2 = (ArrayList<Detail>) details.stream().filter(d -> d.group == 2).collect(Collectors.toList());
	}
	
	public void step2() {
		Collections.sort(group1);
		Collections.sort(group2);
	}
	
	public void step3() {
		details = new ArrayList<>(group1);
		details.addAll(group2);
		calcTimeline();
	}
	
	public void calcTimeline() {
		if (details.size() > 2) {
			details.get(0).firstProcessStarted = 0;
			details.get(0).firstDone = details.get(0).firstProcess;
			for (int i = 1; i < details.size(); i++) {
				details.get(i).firstProcessStarted = details.get(i - 1).firstDone;
				details.get(i).firstDone = details.get(i).firstProcessStarted + details.get(i).firstProcess;
			}
			int currTime = details.get(0).firstDone;
			for (int i = 0; i < details.size(); i++) {
				Detail d = details.get(i);
				if (d.firstDone <= currTime) {
					d.secondProcessStarted = currTime;
					currTime += d.secondProcess;
				} else {
					d.secondProcessStarted = d.firstDone;
					currTime = d.firstDone + d.secondProcess;
				}

			} 
		}
	}

}
