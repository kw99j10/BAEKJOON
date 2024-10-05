import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

//2531 회전 초밥
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); //접시 수
        int d = Integer.parseInt(st.nextToken()); //초밥 가짓 수
        int k = Integer.parseInt(st.nextToken()); //연속해서 먹는 접시 수
        int c = Integer.parseInt(st.nextToken()); //쿠폰번호

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int max = 0;

        HashSet<Integer> set = new HashSet<>(); // 먹을 수 있는 초밥 가짓 수
        for (int i = 0; i < n; i++) {

            int end = (i + k - 1) % n;
            if (i > end) {
                for (int j = i; j < n; j++) {
                    set.add(arr[j]);
                }
                for (int j = 0; j <= end; j++) {
                    set.add(arr[j]);
                }
            }else{
                for (int j = i; j <= end; j++) {
                    set.add(arr[j]);
                }
            }
            set.add(c); // 쿠폰 초밥
            max = Math.max(max, set.size());
            set.clear();
        }
        System.out.println(max);
    }
}