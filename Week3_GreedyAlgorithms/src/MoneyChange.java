import java.util.Scanner;

public class MoneyChange {
    private static int getChange(int m) {
//        int numCoins = 0;
//        if (m < 5) {
//        	numCoins += m;
//        	return numCoins;
//        }
//        else if(m>=5 && m < 10) {
//        	numCoins += m/5;
//        	return numCoins + getChange(m%5);
//        }
//        else{
//        	numCoins += m/10;
//        	return numCoins + getChange(m%=10);
//        }
        return m/10 + (m%10)/5 + (m%10)%5;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        scanner.close();
        System.out.println(getChange(m));

    }

}

