import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17822 원판 돌리기
public class Main {
    static int[][] circle;
    static int[][] seq;
    static int n, m, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        circle = new int[n + 1][m];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        seq = new int[T][3];
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            seq[t][0] = Integer.parseInt(st.nextToken());
            seq[t][1] = Integer.parseInt(st.nextToken());
            seq[t][2] = Integer.parseInt(st.nextToken());
        }

        for (int t = 0; t < T; t++) {
            spin(t);
        }
        System.out.println(getSum());
    }

    static void spin(int t) {
        int x = seq[t][0];
        int d = seq[t][1];
        int k = seq[t][2];
        for (int i = x; i <= n; i += x) {
            int[] tmp = new int[m];
            for (int j = 0; j < m; j++) {
                if (d == 0) {
                    tmp[(j + k) % m] = circle[i][j];
                } else {
                    tmp[(j - k + m) % m] = circle[i][j];
                }
            }
            circle[i] = tmp;
        }
        check();
    }

    static void check() {
        boolean isTrue = false; // 원판에 수가 남아 있는지
        boolean[][] same = new boolean[n + 1][m];

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle[i][j] != 0) {
                    isTrue = true;

                    //우
                    if (circle[i][j] == circle[i][(j + 1) % m]) {
                        same[i][j] = true;
                        same[i][(j + 1) % m] = true;
                    }

                    //좌
                    if (circle[i][j] == circle[i][(j - 1 + m) % m]) {
                        same[i][j] = true;
                        same[i][(j - 1 + m) % m] = true;
                    }

                    //상
                    if (i > 1 && circle[i][j] == circle[i - 1][j]) {
                        same[i][j] = true;
                        same[i - 1][j] = true;
                    }

                    //하
                    if (i < n && circle[i][j] == circle[i + 1][j]) {
                        same[i][j] = true;
                        same[i + 1][j] = true;
                    }
                }
            }
        }

        boolean isRemoved = false; // 같은 수를 지웠는지
        if (isTrue) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    if (same[i][j]) {
                        circle[i][j] = 0;
                        isRemoved = true;
                    }
                }
            }
        }

        if (!isRemoved) {
            avg();
        }
    }

    static void avg() {
        double sum = 0.0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle[i][j] != 0) {
                    sum += circle[i][j];
                    count++;
                }
            }
        }

        double avg = sum / count;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                if (circle[i][j] != 0) {
                    if (circle[i][j] > avg) {
                        circle[i][j]--;
                    } else if (circle[i][j] < avg) {
                        circle[i][j]++;
                    }
                }
            }
        }
    }

    static int getSum() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                sum += circle[i][j];
            }
        }
        return sum;
    }
}