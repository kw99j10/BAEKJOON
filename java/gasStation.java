import java.util.Scanner;

//백준 주유소 
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long cost = 0L; //최소 비용

        int[] city = new int[n]; //도로의 길이
        int[] liter = new int[n]; //리터당 가격

        for (int i = 0; i < n - 1; i++) {
            city[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            liter[i] = sc.nextInt();
        }

        long min = liter[0];

        for (int i = 0; i < n - 1; i++) {

            if (min > liter[i]) {
                cost += (long) liter[i] * city[i];
                min = liter[i];
            }

            else{
                cost += min * city[i];
            }
        }
        System.out.println(cost);
    }
}
