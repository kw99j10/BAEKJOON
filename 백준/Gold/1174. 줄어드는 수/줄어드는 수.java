import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

// 1174 줄어드는 수
public class Main {
    static int n;
    static ArrayList<Long> lists;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        if (n <= 10) {
            System.out.println(n - 1);
            return;
        }

        if (n > 1023) {
            System.out.println(-1);
            return;
        }

        lists = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            dfs(i, 1);
        }
        Collections.sort(lists);
        System.out.println(lists.get(n - 1));
    }

    static void dfs(long num,int cnt) {
        if (cnt > 10) {
            return;
        }
        lists.add(num);
        for (int i = 0; i < num % 10; i++) {
            dfs(num * 10 + i, cnt + 1);
        }
    }
}