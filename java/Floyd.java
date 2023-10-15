import java.util.*;

// 플로이드-워셜
public class Floyd {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int max = 100000001; //최대 비용 설정

        int[][] arr = new int[n + 1][n + 1];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(arr[i], max); //최대 값으로 초기화
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            arr[a][b] = Math.min(arr[a][b], c);
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i][i] = 0; //자기 자신으로의 도시는 최소 비용 0
        }

        //플로이드-워셜 알고리즘
        for (int k = 1; k < arr.length; k++) {
            for (int i = 1; i < arr.length; i++) {
                for (int j = 1; j < arr.length; j++) {
                    arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                }
            }
        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (arr[i][j] == max) {
                    arr[i][j] = 0; //경로가 없으면 0으로 초기화
                }
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
