import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21608 상어 초등학교
public class Main {
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] seat = new int[n][n];
        int[][] like = new int[n * n + 1][4]; // 학생별 좋아하는 학생 번호

        StringTokenizer st;
        for (int i = 1; i <= n * n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = 0; j < 4; j++) {
                like[num][j] = Integer.parseInt(st.nextToken());
            }

            int max = Integer.MIN_VALUE;
            int free = Integer.MIN_VALUE;

            int x = 0;
            int y = 0;  //배정할 좌표

            //학생별 좌표 배정하기
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (seat[j][k] != 0) {
                        continue; // 이미 자리가 있음
                    }
                    int count = 0; //학생이 인접한 칸의 수
                    int blank = 0; //인접한 칸 중에서 비어있는 칸의 수

                    for (int d = 0; d < 4; d++) {
                        int nx = j + dx[d];
                        int ny = k + dy[d];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                            continue;
                        }

                        for (int s = 0; s < 4; s++) {
                            if (seat[nx][ny] == like[num][s]) {
                                count++;
                            }
                        }

                        if (seat[nx][ny] == 0) {
                            blank++;
                        }
                    }

                    // 조건 1: 좋아하는 학생 인접한 칸 가장 많은 칸 배정
                    if (count > max) {
                        max = count;
                        free = blank;
                        x = j;
                        y = k;
                    }

                    // 조건 2: 인접한 칸 중 비어있는 칸이 가장 많은 칸 배정
                    else if (count == max) {
                        if (blank > free) {
                            free = blank;
                            x = j;
                            y = k;
                        }

                        //조건 3: 행 번호 가장 작은 칸
                        else if (blank == free) {

                            if (x > j) {
                                x = j;
                                y = k;
                            }
                            //조건 4: 열 번호 가장 작은 칸
                            else if (x == j && y > k) {
                                y = k;
                            }
                        }
                    }
                }
            }
            seat[x][y] = num;
        }

        int sum = 0; //만족도 총합 검사
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int num = seat[i][j];
                int count = 0;

                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                        continue;
                    }

                    for (int k = 0; k < 4; k++) {
                        if (seat[nx][ny] == like[num][k]) {
                            count++;
                        }
                    }
                }

                if (count == 1) {
                    sum += 1;
                } else if (count == 2) {
                    sum += 10;
                } else if (count == 3) {
                    sum += 100;
                } else if (count == 4) {
                    sum += 1000;
                }
            }
        }
        System.out.println(sum);
    }
}