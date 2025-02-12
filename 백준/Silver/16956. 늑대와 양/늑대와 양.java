import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16956 늑대와 양
public class Main {
    static int r, c;
    static char[][] farm;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        farm = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                farm[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                char k = farm[i][j];

                if (k == 'W') {
                    for (int d = 0; d < 4; d++) {
                        int nx = i + dx[d];
                        int ny = j + dy[d];

                        if (nx < 0 || nx >= r || ny < 0 || ny >= c || farm[nx][ny] == 'D' || farm[nx][ny] == 'W') {
                            continue;
                        }

                        if (farm[nx][ny] == 'S') {
                            System.out.println(0);
                            return; //울타리를 칠 수 없음
                        }
                        farm[nx][ny] = 'D';
                    }
                }
            }
        }

        System.out.println(1);
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(farm[i][j]);
            }
            System.out.println();
        }
    }
}
