import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

// 16928 뱀과 사다리 게임
public class Main {
    static int[] board = new int[101]; // 보드판
    static int[] count = new int[101]; // 주사위 굴리는 횟수
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리 수
        int m = Integer.parseInt(st.nextToken()); // 뱀의 수

        for (int i = 1; i <= 100; i++) {
            board[i] = i;
        }

        // 사다리 + 뱀 정보
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            board[Integer.parseInt(st.nextToken())] = Integer.parseInt(st.nextToken());
        }
        bfs();
        System.out.println(count[100]); // 100번 칸
    }
    static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();
            for (int i = 1; i <= 6; i++) {
                if (current + i > 100) {
                    continue;
                }
                if (count[board[current + i]] == 0) {
                    queue.add(board[current + i]);
                    count[board[current + i]] = count[current] + 1;
                }
            }
        }
    }
}