import java.util.*;

class EditDistance {
  private static int EditDistance(String s, String t) {
    if(s.equals(t))
    	return 0;
    
    int[][]grid = new int[s.length()+1][t.length()+1];
    for(int i = 0; i <= s.length(); i++) {
    	grid[i][0] = i;
    }
    for(int i = 0; i <= t.length(); i++) {
    	grid[0][i] = i;
    }
    
    for (int i = 1; i <= s.length(); i++) {
        for (int j = 1; j <= t.length(); j++) {
            int insertion = grid[i - 1][j] + 1;
            int deletion = grid[i][j - 1] + 1;
            int match = grid[i - 1][j - 1];
            int mismatch = grid[i - 1][j - 1] + 1;

            if (s.charAt(i - 1) == t.charAt(j - 1))
                grid[i][j] = Math.min(insertion, Math.min(deletion, match));
            else
                grid[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
        }
    }
    return grid[s.length()][t.length()];
  }
  
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();
    scan.close();
    System.out.println(EditDistance(s, t));
  }

}
/*
short
ports

editing
distance
*/