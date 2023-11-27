import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] p = new int[n + 1][n + 1];

        for (int i = 1; i <=n; i++) {
            for (int j = 1; j <= n; j++) {
                p[i][j] = 1000000; //배열 초기화: 초기에 연결 X
            }
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            p[a][b] = 1;
            p[b][a] = 1;
        }

        for (int i = 1; i <= n; i++) {
            p[i][i] = 0; //자기 자신은 0
        }

        //플로이드 - 워셜
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    p[i][j] = Math.min(p[i][j], p[i][k] + p[k][j]);
                }
            }
        }

        int minValue = 101;
        int minSum = Integer.MAX_VALUE;

        for (int i = 1; i <= n; i++) {

            int sum = 0;

            for (int j = 1; j <= n; j++) {
                sum += p[i][j]; //해당 사람의 케빈 베이컨의 수 누적
            }
            //케빈 베이컨의 수가 가장 작은 사람, 같다면 번호가 가장 작은 사람 출력
            if (minSum > sum) {
                minValue = i;
                minSum = sum;
            }
        }
        System.out.println(minValue);
    }
}
