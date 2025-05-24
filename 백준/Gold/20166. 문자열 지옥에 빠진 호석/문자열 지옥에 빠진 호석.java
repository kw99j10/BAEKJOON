import java.io.*;
import java.util.*;

// 20166 문자열 지옥에 빠진 호석
public class Main {
    static class Word {
        int x, y;
        String s;

        public Word(int x, int y, String s) {
            this.x = x;
            this.y = y;
            this.s = s;
        }
    }

    static int n, m, k;
    static int[] dx = {0, 0, 1, -1, 1, 1, -1, -1};
    static int[] dy = {1, -1, 0, 0, 1, -1, 1, -1};
    static char[][] grid;
    static HashMap<String, Integer> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ArrayDeque<Word> queue = new ArrayDeque<>();
                queue.offer(new Word(i, j, "" + grid[i][j]));
                map.put("" + grid[i][j], map.getOrDefault("" + grid[i][j], 0) + 1);

                while (!queue.isEmpty()) {
                    Word current = queue.poll();
                    int x = current.x;
                    int y = current.y;
                    String s = current.s;

                    if (s.length() == 5) {
                        continue;
                    }

                    for (int d = 0; d < 8; d++) {
                        int nx = (x + dx[d] + n) % n;
                        int ny = (y + dy[d] + m) % m;
                        queue.offer(new Word(nx, ny, s + grid[nx][ny]));
                        map.put(s + grid[nx][ny], map.getOrDefault(s + grid[nx][ny], 0) + 1);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            String str = br.readLine();
            sb.append(map.getOrDefault(str, 0)).append("\n");
        }
        System.out.print(sb);
    }
}