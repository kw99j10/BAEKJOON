import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 17780 새로운 게임
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
    static int[][] chess;
    static ArrayList<Integer>[][] num;
    static Chess[] horse;
    static int[][] move = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        chess = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                chess[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        horse = new Chess[k + 1]; // 체스 말 번호
        num = new ArrayList[n][n]; // 말의 위치
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                num[i][j] = new ArrayList<>();
            }
        }

        for (int i = 1; i <= k; i++) {
            st = new StringTokenizer(br.readLine());
            // 좌표, 이동 방향
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken()) - 1;
            num[x][y].add(i);
            horse[i] = new Chess(x, y, i, dir);
        }

        int turn = 1;
        while (turn <= 1000) {
            if (game()) {
                System.out.println(turn);
                return;
            }
            turn++;
        }
        System.out.println(-1);
    }

    static boolean game() {
        // 말 번호 순서대로 이동
        for (int i = 1; i <= k; i++) {
            int x = horse[i].x;
            int y = horse[i].y;
            int dir = horse[i].dir;

            int idx = num[x][y].indexOf(i); // 현재 말이 가장 아래에 있는 말인지
            if (idx != 0) {
                continue;
            }
            int nx = x + move[dir][0];
            int ny = y + move[dir][1];

            if (isBlue(nx, ny)) { // 파란색으로 이동할 경우
                dir = changeDir(dir);
                horse[i].dir = dir;
                nx = x + move[dir][0];
                ny = y + move[dir][1];

                if (isBlue(nx, ny)) {
                    continue;
                }
            }

            ArrayList<Integer> tmp = new ArrayList<>(); // 움직일 말 번호
            for (int j = idx; j < num[x][y].size(); j++) {
                tmp.add(num[x][y].get(j));
                horse[num[x][y].get(j)].x = nx;
                horse[num[x][y].get(j)].y = ny; // 좌표 이동
            }
            num[x][y].removeAll(tmp); // 기존 좌표 제거

            if (chess[nx][ny] == 1) {
                Collections.reverse(tmp); // 빨간색인 경우
            }
            num[nx][ny].addAll(tmp);

            if (num[nx][ny].size() >= 4) {
                return true; // 종료 조건
            }
        }
        return false;
    }

    static int changeDir(int dir) {
        if (dir == 0) return 1;
        if (dir == 1) return 0;
        if (dir == 2) return 3;
        else return 2;
    }

    static boolean isBlue(int nx, int ny) {
        return nx < 0 || nx >= n || ny < 0 || ny >= n || chess[nx][ny] == 2;
    }
}