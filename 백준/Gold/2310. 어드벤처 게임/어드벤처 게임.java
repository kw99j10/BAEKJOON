import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    static int n;
    static boolean flag;
    static String[] rooms;
    static int[] money;
    static boolean[] visit;
    static ArrayList<Integer>[] roomsList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        while (true) {
            n = Integer.parseInt(br.readLine());
            if (n == 0) {
                break;
            }

            rooms = new String[n + 1];
            money = new int[n + 1];
            visit = new boolean[n + 1];
            roomsList = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                roomsList[i] = new ArrayList<>();
            }

            for (int i = 1; i <= n; i++) {
                st = new StringTokenizer(br.readLine());
                String r = st.nextToken();
                int m = Integer.parseInt(st.nextToken());

                while (st.hasMoreTokens()) {
                    int next = Integer.parseInt(st.nextToken());
                    if (next == 0) {
                        break;
                    }
                    roomsList[i].add(next); //현재 문에서 다음 문으로 갈 수 있음
                }

                rooms[i] = r;
                money[i] = m;
            }
            flag = false;
            dfs(1, 0);
            String answer = !flag ? "No" : "Yes";
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int current, int change) {
        if (current == n) {
            flag = true;
            return;
        }

        visit[current] = true;
        for (Integer next : roomsList[current]) {
            if (!visit[next]) {
                //다음 방이 트롤이 있는 방일 때, 돈이 있다면 그만큼 소지금을 내고 아니면 이동할 수 없음
                if (rooms[next].equals("T")) {
                    if (change >= money[next]) {
                        change -= money[next];
                    } else {
                        return;
                    }
                }
                //다음 방이 레프리콘 방이라면, 일정량 만큼 금화를 채워줌
                else if (rooms[next].equals("L")) {
                    change = Math.max(change, money[next]);
                }
                dfs(next, change);
            }
        }
        visit[current] = false; //방문 배열 초기화는 현재 인덱스 기준 
    }
}