import java.util.Scanner;

import static java.lang.Math.*;

public class Practice3 {

    static int[] coin = new int[]{1, 4, 7, 13, 28, 52, 91, 365};

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();

        int [] count= new int[k + 1];
        for (int i = 0; i < k + 1; i++) {
            count[i] = 100001;
        }
        count[0] = 0;

        for (int i = 0; i < coin.length; i++) {
            for (int j = coin[i]; j <= k; j++) {
                if(coin[i]==j)
                    count[j]=1;
                count[j] = min(count[j], count[j - coin[i]] + 1);
            }
        }
        System.out.println(count[k] == 100001 ? -1 : count[k]);

        sc.close();
    }
}
