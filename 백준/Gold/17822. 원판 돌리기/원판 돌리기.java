import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 17822 원판 돌리기
public class Main {
    static class Spin {
        int x, d, k;

        public Spin(int x, int d, int k) {
            this.x = x;
            this.d = d;
            this.k = k;
        }
    }

    static ArrayList<Spin> lists;
    static LinkedList<Integer>[] circle;
    static int n, m, T;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); // n번 원판
        m = Integer.parseInt(st.nextToken()); // 적힌 정수 개수
        T = Integer.parseInt(st.nextToken());

        circle = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            circle[i] = new LinkedList<>();
            for (int j = 0; j < m; j++) {
                circle[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        lists = new ArrayList<>();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()); // 배수
            int d = Integer.parseInt(st.nextToken()); // 방향
            int k = Integer.parseInt(st.nextToken()); // k칸 만큼
            lists.add(new Spin(x, d, k));
        }

        for (int t = 0; t < T; t++) {
            spin(t); //t번 회전
        }
        System.out.println(getSum()); // 원판 합
    }

    static void spin(int t) { // 원판 회전
        int x = lists.get(t).x; // 배수 번호
        int d = lists.get(t).d; // 방향
        int k = lists.get(t).k;

        // x 배수에 해당하는 원판을 d 방향으로 k번 만큼 이동
        for (int i = x; i <= n; i += x) {
            for (int j = 0; j < k; j++) {
                if (d == 0) {
                    int tmp = circle[i].getLast();
                    circle[i].removeLast();
                    circle[i].addFirst(tmp);
                } else {
                    int tmp = circle[i].getFirst();
                    circle[i].removeFirst();
                    circle[i].addLast(tmp);
                }
            }
        }

        check();
    }

    static void check() {
        boolean isTrue = false;
        boolean[][] same = new boolean[n + 1][m]; // 같은지 판단

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                Integer tmp = circle[i].get(j);
                if (tmp.equals(0)) {
                    continue;
                }

                // 가로로 인접
                if (tmp.equals(circle[i].get((j + 1) % m))) {
                    same[i][j] = true;
                    same[i][(j + 1) % m] = true;
                    isTrue = true;
                }

                // 같은 원판 내 인접
                if (tmp.equals(circle[i].get((j - 1 < 0 ? j - 1 + m : j - 1)))) {
                    same[i][j] = true;
                    same[i][j - 1 < 0 ? j - 1 + m : j - 1] = true;
                    isTrue = true;
                }

                // 세로로 인접
                if (i > 1) {
                    if (tmp.equals(circle[i - 1].get(j))) {
                        same[i][j] = true;
                        same[i - 1][j] = true;
                        isTrue = true;
                    }
                }
            }
        }

        if (isTrue) {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < m; j++) {
                    if (same[i][j]) {
                        circle[i].set(j, 0); // 수를 지움
                    }
                }
            }
        } else {
            avg(); // 없는 경우
        }
    }

    static void avg() {
        int sum = 0;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                Integer tmp = circle[i].get(j);
                if (tmp.equals(0)) {
                    continue;
                }
                sum += tmp;
                count++;
            }
        }

        double avg = (double) sum / count;

        // 평균보다 큰 수에서는 1을 빼고, 작은 수에는 1을 더함
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                Integer tmp = circle[i].get(j);
                if (tmp.equals(0)) {
                    continue;
                }
                if (avg > tmp) {
                    circle[i].set(j, tmp + 1);
                } else if (tmp > avg) {
                    circle[i].set(j, tmp - 1);
                }
            }
        }
    }

    static int getSum() {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < m; j++) {
                sum += circle[i].get(j);
            }
        }
        return sum;
    }
}