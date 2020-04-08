import java.util.*;
public class MaxPairwiseProduct {
	static long getMaxPairwiseProduct(long[] numbers) {
		
		//Find all possible products and than find max(Error: Time Limit Exceeded)
		/*
        int max_product = 0;

        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < n; j++) {
                max_product = Math.max(max_product,numbers[i] * numbers[j]);
            }
        }
        return max_product;
        */
		int index1 = 0;
		int index2 = 1;
		
		for(int i = 1; i<numbers.length; i++) {
			if(numbers[index1]<numbers[i])	index1 = i;
		}
		
		if(index1 == 0)	index2 = 1;
		else index2 = 0;

		for(int j = 1; j<numbers.length; j++) {
			if(numbers[index2]<numbers[j] && j != index1)	index2 = j;
		}
		return numbers[index1]*numbers[index2];
    }
	
	public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        long[] numbers = new long[size];
        for (int i = 0; i < size; i++) {
            numbers[i] = input.nextInt();
        }
        input.close();
        System.out.println(getMaxPairwiseProduct(numbers));
    }
}
