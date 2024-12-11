import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 17837 새로운 게임 2
public class Main {
    static class Chess {
        int x, y, num, dir;

        public Chess(int x, int y, int num, int dir) {
            this.x = x;
            this.y = y;
            this.num = num;
            this.dir = dir;
        }
    }

    static int n, k;
    static int[][] grid;
    static ArrayList<Integer>[][] num;
    static Chess[] chess;
    static int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        grid = new int[n][n]; // 체스판
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        num = new ArrayList[n][n]; // 격자 내 말 들의 위치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = new ArrayList<>();
            }
        }
        chess = new Chess[k + 1]; // 체스 말에 대한 정보

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            chess[i] = new Chess(x, y, i, dir);
            num[x][y].add(i);
        }

        int turn = 1;
        while (turn <= 1000) {
            if (game()) {
                System.out.println(turn); // 게임이 종료되면
                return;
            }
            turn++;
        }
        System.out.println(-1);
    }

    static boolean game() {

        // 1번말부터 움직이면서 게임 시작
        for (int i = 1; i <= k; i++) {
            int x = chess[i].x;
            int y = chess[i].y;
            int dir = chess[i].dir;

            int nx = x + move[dir][0];
            int ny = y + move[dir][1];

            // 움직인 말이 판을 이탈 or 파란색
            if (isMove(nx, ny)) {
                dir = changeDirection(dir);
                chess[i].dir = dir;
                nx = x + move[dir][0];
                ny = y + move[dir][1];

                // 이전과 똑같으면 이동하지 않음
                if (isMove(nx, ny)) {
                    continue;
                }
            }

            ArrayList<Integer> tmp = new ArrayList<>(); // 말을 순서대로 담을 리스트
            boolean isPossible = false;
            for (int j = 0; j < num[x][y].size(); j++) {

                // 현재 말이 바닥 말이면 이동 가능
                if (num[x][y].get(j) == i) {
                    isPossible = true;
                }

                if (isPossible) {
                    chess[num[x][y].get(j)].x = nx;
                    chess[num[x][y].get(j)].y = ny;
                    tmp.add(num[x][y].get(j));
                }
            }

            num[x][y].removeAll(tmp);

            // 빨간색인 경우
            if (grid[nx][ny] == 1) {
                Collections.reverse(tmp);
            }

            num[nx][ny].addAll(tmp);


            // 말이 4개 이샇 쌓이면 종료
            if (num[nx][ny].size() >= 4) {
                return true;
            }
        }
        return false;
    }

    private static int changeDirection(int dir) {
        switch (dir) {
            case 0:
                dir = 1;
                break;
            case 1:
                dir = 0;
                break;
            case 2:
                dir = 3;
                break;
            case 3:
                dir = 2;
                break;
        }
        return dir;
    }

    private static boolean isMove(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny] == 2;
    }
}