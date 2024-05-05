import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//감시 피하기
public class Main {
    static int n, wall;
    static char[][] info;
    static ArrayList<int[]> teacherList;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        info = new char[n][n];

        teacherList = new ArrayList<>(); //선생님들 좌표

        //'O': 장애물, 'X': 빈칸, 'S': 학생, 'T': 선생님
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                info[i][j] = st.nextToken().charAt(0);
                if (info[i][j] == 'T') {
                    teacherList.add(new int[]{i, j});
                }
            }
        }
        perm(wall);
        System.out.println("NO");
    }

    static void perm(int idx) {
        if (idx == 3) {
            if (check()) {
                System.out.println("YES");
                System.exit(0);
            }
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (info[i][j] == 'X') {
                    info[i][j] = 'O';
                    perm(idx + 1); //장애물을 3개 설치
                    info[i][j] = 'X';
                }
            }
        }
    }

    static boolean check() {
        for (int i = 0; i < teacherList.size(); i++) {
            int tx = teacherList.get(i)[0];
            int ty = teacherList.get(i)[1];

            //선생님 좌표 기준 학생 4방 탐색
            boolean isPossible = search(tx, ty, 0);
            if (!isPossible) {
                return false;
            }
            isPossible = search(tx, ty, 1);
            if (!isPossible) {
                return false;
            }
            isPossible = search(tx, ty, 2);
            if (!isPossible) {
                return false;
            }
            isPossible = search(tx, ty, 3);
            if (!isPossible) {
                return false;
            }
        }
        return true;
    }

    static boolean search(int tx, int ty, int d) {
        while (true) {
            int nx = tx + dx[d];
            int ny = ty + dy[d];

            if (nx < 0 || nx >= n || ny < 0 || ny >= n
                    || info[nx][ny] == 'T' || info[nx][ny] == 'O') {
                break;
            }

            if (info[nx][ny] == 'S') {
                return false;
            }
            tx = nx;
            ty = ny;
        }
        return true;
    }
}
