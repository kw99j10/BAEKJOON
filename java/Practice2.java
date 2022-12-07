import java.util.Scanner;

import static java.lang.Math.max;

public class Practice2 {

    public static int cheese(int a[][], int n) {

        for (int x = 1; x < n; x++) {
            a[0][x]=a[0][x-1];
            a[x][0]+=a[x-1][0];
        }

        for (int x = 1; x < n; x++) {
            for (int y = 1; y < n; y++) {
                a[x][y] += max(a[x][y - 1],a[x - 1][y]);
            }
        }
        return a[n-1][n-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n,m=sc.nextInt();
        //System.out.println(cheese(a,m));
    }
}
