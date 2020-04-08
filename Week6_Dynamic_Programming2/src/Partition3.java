import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
        return 0;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        scanner.close();
        System.out.println(partition3(A));
    }
}

/*
4 
3 3 3 3

1
40

11
17 59 34 57 17 23 67 1 18 2 59

13
1 2 3 4 5 5 7 7 8 10 12 19 25
*/

