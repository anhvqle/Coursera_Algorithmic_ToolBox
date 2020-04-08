import java.util.*;

public class Inversions {

    private static long getNumberOfInversions(int[] a, int[] b, int left, int right) {
   	
        long numberOfInversions = 0;
        if (right <= left) {
            return numberOfInversions;
        }
        int middle = left + (right - left) / 2;
        numberOfInversions += getNumberOfInversions(b, a, left, middle);
        numberOfInversions += getNumberOfInversions(b, a, middle + 1, right);
        numberOfInversions += mergeAndCount(a, b, left, middle, right);
        return numberOfInversions;
    }
    
    private static int mergeAndCount(int[] a, int[] temp, int left, int mid, int right) {
    	int numInvert = 0;
//    	System.arraycopy(a, left, temp, left, right - left +1);	//copy original array to temp array
    	
    	int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid)           
            	temp[k] = a[j++];	// Fill from the rest of the right subarray 
            else if (j > right)         
            	temp[k] = a[i++];	// Fill from the rest of the left subarray 
            else if (a[i] <= a[j])  
            	temp[k] = a[i++];
            else {
                temp[k] = a[j++];
                numInvert += (mid - i + 1);
            }
        }
        return numInvert;
        
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        int[] b = a.clone();
        scanner.close();
        System.out.println(getNumberOfInversions(a, b, 0, a.length-1));
    }
}
/*
5
2 3 9 2 9

6
2 3 9 2 9 1
*/

