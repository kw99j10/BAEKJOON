import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 20055 컨베이어 벨트 위의 로봇
public class Main {
    static int n, k;
    static int[] belt;
    static boolean[] robot;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        belt = new int[2 * n]; // 회전하는 벨트 내구도
        robot = new boolean[n]; // 로봇 위치

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int step = 1;
        while (true) {

            // 1. 벨트가 로봇과 함께 회전
            moveBelt();

            // 2. 로봇 이동 & 올림
            moveRobot();

            // 3. 내구도 0인 칸 개수가 k개 이상이면 과정 종료
            if (checkDurability() >= k) {
                break;
            }

            step++;
        }
        System.out.println(step);
    }

    static void moveBelt() {

        // 벨트 이동
        int tmp = belt[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = tmp;

        // 로봇 이동
        for (int i = n - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false; // 올리는 위치
        robot[n - 1] = false; // 내리는 위치
    }


    static void moveRobot() {
        for (int i = n - 2; i >= 0; i--) {
            //이동 칸에 로봇 없음 && 내구도 >= 1
            if (!robot[i + 1] && robot[i] && belt[i + 1] > 0) {
                robot[i + 1] = true;
                robot[i] = false;
                belt[i + 1] -= 1;
            }
        }

        if (belt[0] > 0) {
            robot[0] = true;
            belt[0] -= 1;
        }
    }

    static int checkDurability() {
        int count = 0;
        for (int i = 0; i < 2 * n; i++) {
            if (belt[i] == 0) {
                count++;
            }
        }
        return count;
    }
}
