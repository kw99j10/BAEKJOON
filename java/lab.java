import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[][] arr; //연구소
    static Queue<int[]> queue; //좌표를 담을 큐
    static int n; //세로
    static int m; //가로
    static int count; //벽의 개수
    static int max_safe; //안전 영역의 최대 크기

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        arr = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        dfs(count);
        System.out.println(max_safe);
    }

    private static void dfs(int count) {

        //만약 3개의 벽을 다 세웠다면 해당 경우의 수로 bfs 수행
        //안전 영역의 크기의 최댓값을 구할 수 있는 경우의 수를 모두 탐색함
        if (count == 3) {
            bfs();
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] == 0) {
                    arr[i][j] = 1; //벽으로 바꿈
                    dfs(count + 1);
                    arr[i][j] = 0; //다시 원 상태로
                }
            }
        }
    }

    private static void bfs() {

        queue = new LinkedList<>();

        //안전 영역 최댓값 비교를 위해 탐색할 임시 배열 생성
        int[][] tmp = new int[n][m];

        for (int i = 0; i < n; i++) {

            tmp[i] = Arrays.copyOf(arr[i], m);

            //바이러스가 존재하는 좌표를 저장
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 2) {
                    queue.add(new int[]{j, i});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];

            int[][] xy = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

            for (int[] ints : xy) {
                int distance_x = ints[0];
                int distance_y = ints[1];

                //빈 칸이라면 바이러스가 계속 퍼져나감
                if (distance_x >= 0 && distance_x < m && distance_y >= 0 && distance_y < n) {
                    if (tmp[distance_y][distance_x] == 0) {
                        tmp[distance_y][distance_x] = 2;
                        queue.add(new int[]{distance_x, distance_y});
                    }
                }
            }
        }

        int countSafe = 0; //현재 연구소의 안전 영역의 개수
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tmp[i][j] == 0) {
                    countSafe += 1;
                }
            }
        }
        max_safe = Math.max(max_safe, countSafe);
    }
}
