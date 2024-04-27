package baitoan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class SegmentSelection  {
	private int n,m;
    private ArrayList<Segment> selectedSegments=new ArrayList<>();
    private Segment[] segments;
    private Segment seg;
    private boolean printedAllSegments = false;
    
    public SegmentSelection() {
	}
    
    
   

    public void input() throws Exception {
        Scanner sc= new Scanner(System.in); 
        System.out.println("Nhập số ngày: ");
        n=sc.nextInt();
        System.out.println("Nhập số hoạt động: ");
        m=sc.nextInt();
        segments = new Segment[m];
        for (int i = 0; i < m; i++) {
            segments[i] = new Segment();
            System.out.println("Hoạt động "+(i+1)+" :");
            System.out.println("Thời gian bắt đầu (theo định dạng giờ:phút): ");
            String startTimeInput = sc.next();
            DayTime start = parseTime(startTimeInput);
            System.out.println("Thời gian kết thúc (theo định dạng giờ:phút): ");
            String endTimeInput = sc.next();
            DayTime end = parseTime(endTimeInput);

            segments[i].setStart(start);
            segments[i].setEnd(end);
        }      
    }

    private DayTime parseTime(String timeInput) {
        String[] parts = timeInput.split(":");
        int hour = Integer.parseInt(parts[0]);
        int minute = Integer.parseInt(parts[1]);
        return new DayTime(hour, minute);
    }

  
    
    public void show() {
    	Scanner sc = new Scanner(System.in);
    	selectSegments();
    	while(!selectedSegments.isEmpty()) {    		
    		System.out.println("[" + selectedSegments.get(0).getStart() + ", " + selectedSegments.get(0).getEnd() + "]");
    		selectedSegments.remove(0);
    		sc.nextLine();
    	}
    	sc.close();
    	
    }

    public List<Segment> selectSegments() {    	
        Arrays.sort(segments);        
           
        for (Segment current : segments) {
            boolean intersects = false;
            for (Segment selected : selectedSegments) {
                if (current.intersects(selected)) {
                    intersects = true;
                    break;
                }
            }
            if (!intersects) {
            	selectedSegments.add(current);
            }
        }
        return selectedSegments;
    }
    
    
    public static void main(String[] args) throws Exception {
    	SegmentSelection  main=new SegmentSelection ();
	   	 main.input();
	   	 main.show(); 
   }
    
   
}
