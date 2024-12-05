import java.util.Scanner;

public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] arr = new int[101][101];

        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            for (int t = a; t < a + 10; t++) {
                for (int k = b; k < b + 10; k++) {
                    arr[t][k] = 1;
                }
            }
        }

        int area = 0;
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (arr[i][j] == 1) {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (arr[nx][ny] == 0 || nx < 0 || nx > 100 || ny < 0 || ny > 100) {
                            area += 1;
                        }
                    }
                }

            }
        }
        System.out.println(area);
    }
}
