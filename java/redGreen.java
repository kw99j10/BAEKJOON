import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static char[][] arr;
    static boolean[][] visit;
    static Queue<int[]> queue;
    static int n; //크기 N의 그리드

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();

        arr = new char[n][n];
        visit = new boolean[n][n];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                arr[i][j] = s.charAt(j);
            }
        }

        int normal_Count = 0; //적록색약이 아닌 사람이 봤을 때 구역의 수
        int red_Count = 0; //적록색약인 사람이 봤을 때 구역의 수

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    normal_Count += 1;
                }
            }
        }

        visit = new boolean[n][n];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] == 'G' || arr[i][j] == 'R') {
                    arr[i][j] = 'Y';
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visit[i][j]) {
                    bfs(i, j);
                    red_Count += 1;
                }
            }
        }
        System.out.println(normal_Count + " " + red_Count);
    }

    private static void bfs(int i, int j) {

        char c = arr[i][j];
        visit[i][j] = true;
        queue.add(new int[]{j, i});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();

            int x = poll[0];
            int y = poll[1];

            int[][] xy = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

            for (int[] ints : xy) {
                int distance_x = ints[0];
                int distance_y = ints[1];

                //같은 문자일 경우에만 bfs 진행
                if (distance_x >= 0 && distance_x < n &&
                        distance_y >= 0 && distance_y < n) {
                    if (arr[distance_y][distance_x] == c &&
                        !visit[distance_y][distance_x]) {

                        visit[distance_y][distance_x] = true;
                        queue.add(new int[]{distance_x, distance_y});
                    }
                }
            }
        }
    }
}
