import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 14225 부분수열의 합
public class Main {
    static int n;
    static int[] arr;
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        comb(0, 0);

        int idx = 1;
        while (true) {
            if (!set.contains(idx)) {
                System.out.println(idx);
                return;
            }
            idx++;
        }
    }

    static void comb(int idx, int sum) {

        if (idx == n) {
            set.add(sum);
            return;
        }

        comb(idx + 1, sum + arr[idx]);
        comb(idx + 1, sum);
    }
}