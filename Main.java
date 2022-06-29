import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] n = new int[10];
        int result_count=0;

        for (int i = 0; i < n.length; i++) {
            n[i] = sc.nextInt() % 42;
        }

        for (int i = 0; i < n.length; i++) {

            int count=0;

            for (int j = 0; j < i; j++) {
                if (n[j] == n[i]) {
                    count++;
                }//서로 같다면 count해주고 초기화 한다.
            }
            if(count==0)
                result_count++; //서로 같지 않다면 그 개수를 센다.
        }
        System.out.println(result_count);
    }
}

