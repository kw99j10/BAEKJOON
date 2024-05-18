import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 경쟁적 전염
public class Main {
    static class Node implements Comparable<Node> {
        int x, y, virus, time;

        public Node(int x, int y, int virus, int time) {
            this.x = x;
            this.y = y;
            this.virus = virus;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.virus - o.virus; //바이러스 번호가 낮은 순
        }
    }

    static int n, k;
    static int[][] lab;
    static ArrayList<Node> lists;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        lab = new int[n][n];
        lists = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] > 0) {
                    lists.add(new Node(i, j, lab[i][j], 0));
                }
            }
        }
        Collections.sort(lists); //번호가 낮은 순부터 증식하기 위한 정렬
        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int ex = Integer.parseInt(st.nextToken()) - 1;
        int ey = Integer.parseInt(st.nextToken()) - 1;
        bfs(s);
        System.out.println(lab[ex][ey]);
    }

    static void bfs(int s) {
        ArrayDeque<Node> queue = new ArrayDeque<>(lists);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            int x = current.x;
            int y = current.y;
            int virus = current.virus;
            int time = current.time;

            if (time == s) {
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || nx >= n || ny < 0 || ny >= n || lab[nx][ny] != 0) {
                    continue;
                }
                lab[nx][ny] = virus;
                queue.add(new Node(nx, ny, lab[nx][ny], time + 1));
            }
        }
    }
}