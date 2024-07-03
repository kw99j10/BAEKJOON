import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

// 1351 무한 수열
public class Main {
    static long n;
    static int p, q;
    static HashMap<Long, Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Long.parseLong(st.nextToken());
        p = Integer.parseInt(st.nextToken());
        q = Integer.parseInt(st.nextToken());

        //범위가 커 map으로 설정
        map = new HashMap<>();
        map.put(0L, 1L); //A0 = 1
        System.out.println(dp(n));
    }
    static long dp(long n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        long x = n / p;
        long y = n / q;
        map.put(n, dp(x) + dp(y)); //Ai = A(i/p)+A(i/q)
        return map.get(n);
    }
}