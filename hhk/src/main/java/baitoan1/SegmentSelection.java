package baitoan1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


class SegmentSelection  {
	private int n,m;
    private ArrayList<ArrayList<Segment>> S= new ArrayList<>();
    
    private Segment[] segments=new Segment[100];
    private Segment seg;
    private boolean printedAllSegments = false;
    
    public SegmentSelection() {
    	
	}
    
    

	public void input() throws Exception {
        Scanner sc= new Scanner(System.in); 
        System.out.println("Nhập số ngày: ");
        n=Integer.parseInt(sc.nextLine());
        System.out.println("Nhập số hoạt động: ");
        m=Integer.parseInt(sc.nextLine());
        segments = new Segment[m];
        for (int i = 0; i < m; i++) {
        	seg= new Segment();
            segments[i] = new Segment();
            System.out.println("Hoạt động "+(i+1)+" :");
            System.out.println("Thời gian bắt đầu: ");
            DayTime starTime=DayTime.parse(sc.nextLine());
            seg.setStart(starTime);
            System.out.println("Thời gian kết thúc: ");
            DayTime endTime=DayTime.parse(sc.nextLine());
            seg.setEnd(endTime);
            System.out.println("["+seg.getStart().toString()+","+seg.getEnd().toString()+"]");
            segments[i]=seg;
        }      
    }

    
    public void show() {
    	Scanner sc = new Scanner(System.in);
    	selectSegments();
    	int i=1;
    	List<ArrayList<Segment>> toRemove =new ArrayList<>();
    	for (ArrayList<Segment> Si: S) {    		
    		System.out.println("Ngày "+i+": ");
    		sc.nextLine();
    		List<Segment> SiCopy = new ArrayList<>(Si);
    		while(!SiCopy.isEmpty()) {  			
        		System.out.println("[" + SiCopy.get(0).getStart().toString() + ", " + SiCopy.get(0).getEnd().toString() + "]");
        		SiCopy.remove(0);
        		sc.nextLine();
        	}
    		toRemove.add(Si);    		
    		i++;
    	}	
    	S.removeAll(toRemove);
    	sc.close();	
    	
    }

    public ArrayList<ArrayList<Segment>> selectSegments() {    	
        Arrays.sort(segments);        
        int total=0;
        while (m!=0) {
        	ArrayList<Segment> selectedSegments= new ArrayList<>();
        	
        	for (int i=0; i<segments.length; i++) {
        		System.out.println(segments.length);
        		System.out.println("["+segments[i].start+","+segments[i].end+"]");
                boolean intersects = false;
                for (Segment selected : selectedSegments) {
                    if (segments[i]!=null && segments[i].intersects(selected)) {
                        intersects = true;
                        break;
                    }
                }
                if (intersects)
                	break;
                else if (segments[i]!=null && intersects==false ) {
                	selectedSegments.add(segments[i]);
                	if (i<m-1)
                		segments[i]=segments[i+1];
                	else 
                		segments[i]=null;
                	Segment[] temp = new Segment[segments.length - 1];
                    System.arraycopy(segments, 0, temp, 0, segments.length - 1);
                    segments = temp;
                	m--;   	
                	
                }                     
            }
        	S.add(selectedSegments);
        	if (S.size()==n) {
        		break;
        	}
        }
        for (ArrayList<Segment> Si: S) 
    		for (Segment seg: Si)
    			System.out.println("["+seg.start+","+seg.end+"]");
        return S;
    }
  
    
    public static void main(String[] args) throws Exception {
    	SegmentSelection  main=new SegmentSelection ();
	   	 main.input();
	   	 main.show(); 
   }
    
   
}
