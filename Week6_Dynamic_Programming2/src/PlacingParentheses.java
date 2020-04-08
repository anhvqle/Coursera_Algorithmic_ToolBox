import java.util.Arrays;
import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
    	int size = exp.length()/2 + 1;
    	char[] characters = exp.toCharArray();
    	int[] nums = new int[size];
    	char[] op = new char[size - 1];
    	int index = 0;
    	int index2 = 0;
    	for(int i = 0; i < characters.length; i++) {
    		if(i%2 == 0) {
    			nums[index] = characters[i] - '0';
    			index++;
    		}
    		else {
    			op[index2] = characters[i];
    			index2++;
    		}
    	}
    	
    	//System.out.println(Arrays.toString(op));

    	long[][] MinArr = new long[size][size];
    	long[][] MaxArr = new long[size][size];
    	
    	for(int i = 0; i < size; i++) {
    		MinArr[i][i] = nums[i];
    		MaxArr[i][i] = nums[i];
    	}
    	
    	for (int s = 0; s < size; s++) {
    		for (int i = 0; i < size - s; i++) {
    			int j = i + s;
    			minAndMax(op, MaxArr, MinArr, i, j);
    		}
    	}
    	
//    	for(int i = 0; i < MinArr.length; i++) {
//    		System.out.println(Arrays.toString(MinArr[i]));
//    	}
//    	System.out.println("\t");
//    	for(int i = 0; i < MaxArr.length; i++) {
//    		System.out.println(Arrays.toString(MaxArr[i]));
//    	}
    	
    	return MaxArr[0][size-1];
    }
    
    private static void minAndMax(char[] op, long[][] MaxArr, long[][] MinArr,int i, int j) {
    	long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for (int k = i; k < j; k++) {
        	long a = eval(MaxArr[i][k], MaxArr[k+1][j], op[k]);
        	long b = eval(MaxArr[i][k], MinArr[k+1][j], op[k]);
        	long c = eval(MinArr[i][k], MaxArr[k+1][j], op[k]);
        	long d = eval(MinArr[i][k], MinArr[k+1][j], op[k]);
        	min = calMin(min,a,b,c,d);
        	max = calMax(max,a,b,c,d);
        }
        
        if (max != Long.MIN_VALUE)
            MaxArr[i][j] = max;
        if (min != Long.MAX_VALUE)
            MinArr[i][j] = min;
    }
    
    private static long calMin(long min, long a, long b, long c, long d) {
    	return Math.min(min, Math.min(a, Math.min(b, Math.min(c, d))));
    }
    
    private static long calMax(long max, long a, long b, long c, long d) {
    	return Math.max(max, Math.max(a, Math.max(b, Math.max(c, d))));
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') 
            return a + b;
        else if (op == '-')
            return a - b;
        else if (op == '*')
            return a * b;
        else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        scanner.close();
        System.out.println(getMaximValue(exp));
    }
}

/*
1+5
1+2-3*4-5
5-8+7*4-8+9
*/
