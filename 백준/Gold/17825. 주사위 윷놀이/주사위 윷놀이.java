import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 17825 주사위 윷놀이
public class Main {
    static class Node {
        int score, next, blue; // 점수, 다음 칸, 파란색 칸

        public Node(int score, int next, int blue) {
            this.score = score;
            this.next = next;
            this.blue = blue;
        }
    }

    static Node[] grid = new Node[33]; // 윷놀이 판
    static boolean[] visit; // 방문 배열
    static int[] dice = new int[10]; // 주사위 정보
    static int[] scores = new int[10]; // 점수
    static int[] horse; // 말 4개의 정보
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 10개 턴 주사위
        for (int i = 0; i < 10; i++) {
            dice[i] = Integer.parseInt(st.nextToken());
        }

        // 격자판 셋팅
        for (int i = 0; i < 21; i++) {
            grid[i] = new Node(i * 2, i + 1, 0);
        }

        // 파란색 칸
        grid[5].blue = 21;
        grid[10].blue = 25;
        grid[15].blue = 27;

        grid[21] = new Node(13, 22, 0);
        grid[22] = new Node(16, 23, 0);
        grid[23] = new Node(19, 24, 0);
        grid[24] = new Node(25, 30, 0);
        grid[25] = new Node(22, 26, 0);
        grid[26] = new Node(24, 24, 0);
        grid[27] = new Node(28, 28, 0);
        grid[28] = new Node(27, 29, 0);
        grid[29] = new Node(26, 24, 0);
        grid[30] = new Node(30, 31, 0);
        grid[31] = new Node(35, 20, 0);
        grid[32] = new Node(0, 32, 0);
        grid[20].next = 32;

        perm(0);
        System.out.println(max);
    }

    static void perm(int count) {
        if (count == 10) {
            int sum = 0;
            visit = new boolean[33];
            horse = new int[4];
            for (int i = 0; i < 10; i++) {
                int next = move(scores[i], dice[i]);
                if (next == -1) {
                    return; // 말이 겹치는 경우
                }
                horse[scores[i]] = next; // 말의 다음 위치
                sum += grid[next].score;
            }
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            scores[count] = i;
            perm(count + 1); // 말을 뽑음
        }
    }

    // 현재 인덱스에서 숫자만큼 이동
    static int move(int idx, int num) {
        int current = horse[idx];
        for (int i = 0; i < num; i++) {
            // 파란색 화살표로 이동
            if (i == 0 && grid[current].blue > 0) {
                current = grid[current].blue;
            } else {
                current = grid[current].next;
            }
        }

        if (current < 32 && visit[current]) {
            return -1; // 말이 겹친 경우
        }
        visit[horse[idx]] = false;
        visit[current] = true; // 주사위 이동
        return current;
    }
}