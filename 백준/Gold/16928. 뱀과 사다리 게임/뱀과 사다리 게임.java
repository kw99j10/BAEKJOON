import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

// 16928 뱀과 사다리 게임
public class Main {
    static int[] board = new int[101];
    static HashMap<Integer, Integer> ladder;
    static HashMap<Integer, Integer> snake;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 사다리 수
        int m = Integer.parseInt(st.nextToken()); // 뱀의 수

        for (int i = 1; i <= 100; i++) {
            board[i] = i - 1;
        }

        ladder = new HashMap<>(); // 사다리 정보
        snake = new HashMap<>(); // 뱀 정보
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            if (i < n) {
                ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }else{
                snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
        }
        bfs();
        System.out.println(board[100]); // 100번 칸
    }
    static void bfs() {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        boolean[] visit = new boolean[101];
        queue.add(1);

        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            if (visit[current]) {
                continue;
            }

            visit[current] = true;
            for (int i = 1; i <= 6; i++) {
                if (current + i > 100) {
                    break; // 100번 칸을 넘어 이동 불가
                }

                if (ladder.containsKey(current + i)) {
                    queue.add(ladder.get(current + i));
                    board[ladder.get(current + i)] = Math.min(board[ladder.get(current + i)], board[current] + 1);
                }
                else if (snake.containsKey(current + i)) {
                    queue.add(snake.get(current + i));
                    board[snake.get(current + i)] = Math.min(board[snake.get(current + i)], board[current] + 1);
                }
                else{
                    queue.add(current + i);
                    board[current + i] = Math.min(board[current + i], board[current] + 1);
                }
            }
        }
    }
}