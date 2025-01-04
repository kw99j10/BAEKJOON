import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1063 킹
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String k = st.nextToken(); // 킹의 위치
        String r = st.nextToken(); // 돌의 위치
        int count = Integer.parseInt(st.nextToken()); // 움직이는 횟수

        // 킹, 돌의 위치 좌표화
        int kx = Integer.parseInt(String.valueOf(k.charAt(1))) - 1;
        int ky = (int) k.charAt(0) - 'A';

        int rx = Integer.parseInt(String.valueOf(r.charAt(1))) - 1;
        int ry = (int) r.charAt(0) - 'A';

        // 돌과 같은 곳으로 이동할 때, 돌을 킹이 움직인 방향과 같은 방향으로 한 칸 이동
        for (int i = 0; i < count; i++) {
            String move = br.readLine();

            int nx = kx;
            int ny = ky;

            int px = rx;
            int py = ry;

            if (move.equals("R")) {
                ny += 1;
                if (nx == px && ny == py) {
                    py += 1;
                }
            } else if (move.equals("L")) {
                ny -= 1;
                if (nx == px && ny == py) {
                    py -= 1;
                }
            } else if (move.equals("B")) {
                nx -= 1;
                if (nx == px && ny == py) {
                    px -= 1;
                }
            } else if (move.equals("T")) {
                nx += 1;
                if (nx == px && ny == py) {
                    px += 1;
                }
            } else if (move.equals("RT")) {
                nx += 1;
                ny += 1;
                if (nx == px && ny == py) {
                    px += 1;
                    py += 1;
                }
            } else if (move.equals("LT")) {
                nx += 1;
                ny -= 1;
                if (nx == px && ny == py) {
                    px += 1;
                    py -= 1;
                }
            } else if (move.equals("RB")) {
                nx -= 1;
                ny += 1;
                if (nx == px && ny == py) {
                    px -= 1;
                    py += 1;
                }
            } else if (move.equals("LB")) {
                nx -= 1;
                ny -= 1;
                if (nx == px && ny == py) {
                    px -= 1;
                    py -= 1;
                }
            }

            if (nx < 0 || nx >= 8 || ny < 0 || ny >= 8 || px < 0 || px >= 8 || py < 0 || py >= 8) {
                continue;
            }

            kx = nx;
            ky = ny;

            rx = px;
            ry = py;
        }
        System.out.println((char) (ky + 'A') + String.valueOf(kx + 1));
        System.out.println((char) (ry + 'A') + String.valueOf(rx + 1));
    }
}
