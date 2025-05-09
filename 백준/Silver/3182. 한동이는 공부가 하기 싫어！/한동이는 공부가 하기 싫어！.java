import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 3182 한동이는 공부가 하기 싫어!
public class Main {
    static int n, max, maxIdx, count;
    static int[] people;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        people = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            people[i] = Integer.parseInt(br.readLine());
        }


        for (int i = 1; i <= n; i++) {
            visit = new boolean[n + 1];
            count = 0;
            dfs(i);
            if (count > max) {
                max = count;
                maxIdx = i;
            }
        }
        System.out.println(maxIdx);
    }

    static void dfs(int start) {
        visit[start] = true;
        for (int i = 1; i <= n; i++) {
            if (!visit[i] && people[start] == i) {
                dfs(i);
                count++;
            }
        }
    }
}