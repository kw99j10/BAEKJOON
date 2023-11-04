import java.util.Scanner;
/**
 * 유기농 배추 - Silver II
 */
public class Main {
    static int[][] arr; //배추를 심을 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        StringBuilder sb = new StringBuilder();

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt(); //배추밭 세로 길이
            int m = sc.nextInt(); //배추밭 가로 길이
            int k = sc.nextInt(); //배추가 심어져 있는 위치의 개수

            arr = new int[n][m];

            for (int j = 0; j < k; j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                arr[x][y] = 1;
            }

            int eartWarm = 0; //구역별 필요한 지렁이의 수

            for (int s = 0; s < arr.length; s++) {
                for (int j = 0; j < arr[s].length; j++) {
                    if (arr[s][j] == 1) {
                        eartWarm += 1;
                        dfs(s, j);
                    }
                }
            }
            sb.append(eartWarm).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int y, int x) {
        arr[y][x] = 0; // 배추가 심어져 있는 땅을 방문함을 표시 -> dfs 종료 조건

        //현재 좌표에서 이동할 수 있는 경우의 수(동, 서, 남, 북)
        int[][] xy = new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

        for (int[] ints : xy) {
            int distance_x = ints[0];
            int distance_y = ints[1];

            // 이어진 배추밭 부분까지 dfs 실행
            if (distance_x >= 0 && distance_x <= arr[0].length - 1 &&
                    distance_y >= 0 && distance_y <= arr.length - 1) {
                if (arr[distance_y][distance_x] == 1) {
                    dfs(distance_y, distance_x);
                }
            }
        }
    }
}
