import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 20056 마법사 상어와 파이어볼
public class Main {
    static class FireBall {
        int m, s, d;

        public FireBall(int m, int s, int d) {
            this.m = m; //질량
            this.s = s; //방향
            this.d = d; //속력
        }
    }

    static int n, m, k;
    static ArrayList<FireBall>[][] grid;

    //파이어볼의 방향
    static int[][] move = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new ArrayList[n][n];
        init(grid);
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            grid[r][c].add(new FireBall(m, s, d)); //좌표에 대한 파이어볼 정보
        }

        // k번 만큼 파이어볼 이동 (이동 후 파이어볼 개수는 동일)
        for (int i = 0; i < k; i++) {
            move();
        }

        int sum = 0;
        sum = getSum(sum); // 파이어볼 질량의 합
        System.out.println(sum);
    }

    static void move() {
        ArrayList<FireBall>[][] tmp = new ArrayList[n][n]; // 임시 격자
        init(tmp);

        // 1. 파이어볼 이동
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (FireBall ball : grid[i][j]) {
                    int nx = (i + move[ball.d][0] * ball.s) % n;
                    int ny = (j + move[ball.d][1] * ball.s) % n;
                    nx = nx < 0 ? nx + n : nx;
                    ny = ny < 0 ? ny + n : ny;
                    tmp[nx][ny].add(ball);
                }
            }
        }

        // 2. 이동이 끝나면 2개 이상 파이어볼 있는 칸에서 같은 칸 파이어볼이 모두 합쳐짐
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (tmp[i][j].size() >= 2) {
                    int mSum = 0; //질량합
                    int sSum = 0; //속력합
                    int even = 0; //짝수 개수
                    int odd = 0; //홀수 개수
                    for (FireBall fireBall : tmp[i][j]) {
                        mSum += fireBall.m;
                        sSum += fireBall.s;
                        if (fireBall.d % 2 == 0) {
                            even++;
                        } else {
                            odd++;
                        }
                    }

                    mSum /= 5;
                    sSum /= tmp[i][j].size();
                    tmp[i][j].clear();

                    if (mSum <= 0) {
                        continue; //질량이 0인 파이어볼은 소멸
                    }
                    if (even == 0 || odd == 0) {
                        for (int k = 0; k <= 6; k += 2) {
                            tmp[i][j].add(new FireBall(mSum, sSum, k));
                        }
                    } else {
                        for (int k = 1; k <= 7; k += 2) {
                            tmp[i][j].add(new FireBall(mSum, sSum, k));
                        }
                    }
                }
            }
        }
        init(grid);
        grid = tmp; // 기존 격자 초기화 후 덮어 쓰기
    }

    static void init(ArrayList<FireBall>[][] tmp) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp[i][j] = new ArrayList<>();
            }
        }
    }

    static int getSum(int sum) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (FireBall fireBall : grid[i][j]) {
                    sum += fireBall.m;
                }
            }
        }
        return sum;
    }
}