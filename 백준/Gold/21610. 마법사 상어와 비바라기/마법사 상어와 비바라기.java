import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 21610 마법사 상어와 비바라기
public class Main {
    static class Cloud {
        int x, y, water;

        public Cloud(int x, int y, int water) {
            this.x = x;
            this.y = y;
            this.water = water;
        }
    }

    static int[][] move = {{0, -1}, {-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}};
    static int n, m;
    static Cloud[][] grid;
    static ArrayDeque<Cloud> lists; // 구름 위치

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grid = new Cloud[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = new Cloud(i, j, Integer.parseInt(st.nextToken()));
            }
        }

        lists = new ArrayDeque<>();
        lists.add(grid[n - 1][0]);
        lists.add(grid[n - 1][1]);
        lists.add(grid[n - 2][0]);
        lists.add(grid[n - 2][1]); // 초기 구름 위치

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());

            boolean[][] visit = new boolean[n][n]; // 사라진 구름

            //1. 구름 이동
            int size = lists.size();
            for (int j = 0; j < size; j++) {
                Cloud current = lists.poll();
                int x = current.x;
                int y = current.y;

                int nx = (x + move[dir][0] * s) % n;
                int ny = (y + move[dir][1] * s) % n;

                nx = nx < 0 ? nx + n : nx;
                ny = ny < 0 ? ny + n : ny;
                x = nx;
                y = ny;

                grid[x][y].water += 1; //2. 비가 내려 물의 양 1 증가
                visit[x][y] = true; //3. 구름이 사라짐
                lists.add(grid[x][y]);
            }


            //4. 물복사 버그 비바라기
            while (!lists.isEmpty()) {
                Cloud current = lists.poll();
                int x = current.x;
                int y = current.y;
                int count = 0;
                for (int d = 1; d <= 7; d += 2) {
                    int nx = x + move[d][0];
                    int ny = y + move[d][1];
                    if (nx < 0 || nx >= n || ny < 0 || ny >= n || grid[nx][ny].water <= 0) {
                        continue;
                    }
                    count++;
                }
                grid[x][y].water += count;
            }

            // 5. 물의 양 2 이상인 경우 구름 생기고 물 감소
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    // 구름이 사라진 칸 x
                    if (!visit[j][k] && grid[j][k].water >= 2) {
                        grid[j][k].water -= 2;
                        lists.add(grid[j][k]);
                    }
                }
            }


        }

        int total = 0; //물의 양의 합
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                total += grid[i][j].water;
            }
        }
        System.out.println(total);
    }
}