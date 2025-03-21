import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 1039 교환
public class Main {
    static int n, k, max;
    static String s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        s = String.valueOf(n);

        if (s.length() == 1 || (s.charAt(s.length() - 1) == '0' && s.length() == 2)) {
            System.out.println(-1);  // 연산 불가능한 경우
            return;
        }
        bfs();
        System.out.println(max);
    }

    static void bfs() {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[1000001][k + 1];
        queue.add(new int[]{n, 0});
        visit[n][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int num = current[0];
            int cnt = current[1];

            if (k == cnt) {
                max = Math.max(max, num);
                continue; // k 번 수행함
            }

            for (int i = 0; i < s.length(); i++) {
                for (int j = i + 1; j < s.length(); j++) {
                    int tmp = swap(i, j, String.valueOf(num));
                    if (tmp == -1 || visit[tmp][cnt + 1]) {
                        continue; // i번 위치와 j번 숫자 위치를 바꿈. 단, 바꾼 수가 0으로 시작하면 x
                    }
                    queue.add(new int[]{tmp, cnt + 1});
                    visit[tmp][cnt + 1] = true;
                }
            }
        }
    }

    static int swap(int i, int j, String num) {
        if (i == 0 && num.charAt(j) == '0') {
            return -1;
        }
        StringBuilder sb = new StringBuilder(num);
        sb.setCharAt(i, num.charAt(j));
        sb.setCharAt(j, num.charAt(i));
        return Integer.parseInt(sb.toString());
    }
}