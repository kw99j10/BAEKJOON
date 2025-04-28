import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2303 숫자 게임
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st;

        ArrayList<Integer>[] lists = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            lists[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 5; j++) {
                lists[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        int max = 0;
        int maxIdx = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = j + 1; k < 5; k++) {
                    for (int s = k + 1; s < 5; s++) {
                        int sum = (lists[i].get(j) + lists[i].get(k) + lists[i].get(s)) % 10;
                        if (sum >= max) {
                            if (i > maxIdx) {
                                maxIdx = i;
                            }
                            max = sum;
                        }
                    }
                }
            }
        }
        System.out.println(maxIdx);
    }
}