import java.io.*;
import java.util.*;

public class Sorting {
    private static Random random = new Random();

    private static int[] partition3(int[] a, int l, int r) {
    	int pivot = a[l];  
        int lessThan = l, greaterThan = r;
        int i = l + 1;
        
        while(i <= greaterThan) {
        	if(a[i] < pivot) {
        		swap(a, lessThan, i);
        		lessThan++;
        		i++;
        		//System.out.println(Arrays.toString(a));
        	}
        	else if (a[i] > pivot) {
        		swap(a, i, greaterThan);
        		greaterThan--;
        		//System.out.println(Arrays.toString(a));
        	}
        	else
        		i++;
        }

    	return new int[]{lessThan, greaterThan};
    }
    
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static int partition2(int[] a, int l, int r) {
        int x = a[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (a[i] <= x) {
                j++;
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }
        int temp = a[l];
        a[l] = a[j];
        a[j] = temp;
        return j;
    }

    private static void randomizedQuickSort(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int pivot = random.nextInt(r - l + 1) + l;
        swap(a, l, pivot); //To get the pivot to be at the starting index of the array
        
        int m[] = partition3(a, l, r);
        
        randomizedQuickSort(a, l, m[0]-1);
        randomizedQuickSort(a, m[1]+1, r);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}
/*
5
2 3 9 2 2 

5
2 3 9 2 9
*/

