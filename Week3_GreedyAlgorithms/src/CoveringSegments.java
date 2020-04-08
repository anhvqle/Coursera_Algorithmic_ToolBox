import java.util.*;

public class CoveringSegments {
	private static class compareSegments implements Comparator<Segment>{
		@Override
		public int compare(Segment s1, Segment s2) {
			if(s1.end < s2.end) return -1;
			else if(s1.end > s2.end) return 1;
			return 0;
		}
	}
	
	private static List<Integer> optimalPoints(Segment[] segments) {
		Arrays.sort(segments, new compareSegments());
//	    for(Segment s: segments) {
//	    	System.out.println("("+s.start+ " "+s.end+")");
//	    }
	    
	    List<Integer> points = new ArrayList<Integer>();
	    
	    int i = 0;
	    while (i < segments.length) {
	        Segment segment = segments[i];
	        int j = i;
	        while (j < segments.length && segments[j].start <= segment.end) 
	            j++;
	        points.add(segment.end);
	        i = j;
	    }

	    return points;
	}

	private static class Segment {
	    int start, end;

	    Segment(int start, int end) {
	        this.start = start;
	        this.end = end;
	    }
	}
	
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Segment[] segments = new Segment[n];
        for (int i = 0; i < n; i++) {
            int start, end;
            start = scanner.nextInt();
            end = scanner.nextInt();
            segments[i] = new Segment(start, end);
        }
        scanner.close();
        List<Integer> points = optimalPoints(segments);
        System.out.println(points.size());
        for (int point : points) {
            System.out.print(point + " ");
        }
    }
}
/*
4
4 7
1 3
2 5
5 6

2
3 6

3
1 3
2 5
3 6
*/