import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.StringTokenizer;

// 1525 퍼즐
public class Main {
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static String answer = "";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for (int i = 0; i < 3; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                answer += st.nextToken();
            }
        }

        if (answer.equals("123456780")){
            System.out.println(0);
            return;
        }

        bfs(); // 기존 문자열 => 초기 문자열로
    }
    static void bfs () {
        ArrayDeque<String> queue = new ArrayDeque<>();
        HashMap<String, Integer> map = new HashMap<>(); //문자열, 이동 횟수
        queue.add(answer);
        map.put(answer, 0);

        while (!queue.isEmpty()) {
            String current = queue.poll();

            int x = current.indexOf("0") / 3;
            int y = current.indexOf("0") % 3;
            for (int d = 0; d < 4; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];

                if (nx < 0 || nx >= 3 || ny < 0 || ny >= 3) {
                    continue;
                }

                String tmp = current;
                char zero = tmp.charAt(tmp.indexOf("0"));
                char num = tmp.charAt(nx * 3 + ny);

                // 문자 퍼즐 스왑
                tmp = tmp.replace(zero, 'k');
                tmp = tmp.replace(num, 'p');
                tmp = tmp.replace('k', num);
                tmp = tmp.replace('p', zero);

                if (!map.containsKey(tmp)) {
                    queue.offer(tmp);
                    map.put(tmp, map.get(current) + 1);

                    if (tmp.equals("123456780")) {
                        System.out.println(map.get(tmp));
                        return;
                    }
                }
            }
        }
        System.out.println(-1);
    }
}