import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int c = sc.nextInt();

        int a = 0;
        int b = n - 1;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (a >= b) {
                break;
            }

            if (arr[a] + arr[b] == c) {
                a += 1;
                b -= 1;
                count += 1;
            }
            else if (arr[a] + arr[b] > c) {
                b -= 1;
            }
            else{
                a += 1;
            }
        }
        System.out.println(count);
    }
}
