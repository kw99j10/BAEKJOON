import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;
import java.util.StringTokenizer;

// 17299 오등큰수
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        HashMap<Integer, Integer> count = new HashMap<>(); // 수열에서 수의 등장 횟수

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            count.put(arr[i], count.getOrDefault(arr[i], 0) + 1);
        }

        int[] ngf = new int[n + 1]; // 오등큰수
        Arrays.fill(ngf, -1);

        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i <= n; i++) {
            while (!stack.isEmpty() && count.get(arr[i]) > count.get(arr[stack.peek()])) {
                ngf[stack.pop()] = arr[i];
            }
            stack.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(ngf[i]).append(" ");
        }
        System.out.print(sb);
    }
}