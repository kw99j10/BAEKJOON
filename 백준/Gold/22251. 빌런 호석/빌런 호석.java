import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 22251 빌런 호석
public class Main {
    // 0~9까지 LED 디스플레이
    static int[][] sign = {
            {1, 1, 1, 0, 1, 1, 1}, //0
            {0, 0, 1, 0, 0, 1, 0}, //1
            {1, 0, 1, 1, 1, 0, 1}, //2
            {1, 0, 1, 1, 0, 1, 1}, //3
            {0, 1, 1, 1, 0, 1, 0}, //4
            {1, 1, 0, 1, 0, 1, 1}, //5
            {1, 1, 0, 1, 1, 1, 1}, //6
            {1, 0, 1, 0, 0, 1, 0}, //7
            {1, 1, 1, 1, 1, 1, 1}, //8
            {1, 1, 1, 1, 0, 1, 1}  //9
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken()); // 보여지는 자릿 수
        int p = Integer.parseInt(st.nextToken()); // 반전 가능한 LED
        int x = Integer.parseInt(st.nextToken()); // 현재 층

        int count = 0;

        StringBuilder tmp = new StringBuilder();
        if (k > String.valueOf(x).length()) {
            tmp.append("0".repeat(k - String.valueOf(x).length()));
        }
        tmp.append(x); //501층, k=4 이면 "0501"로 나타냄

        for (int i = 1; i <= n; i++) {
            if (i == x) {
                continue; //같은 층
            }
            String s = "";
            if (k > String.valueOf(i).length()) {
                s += "0".repeat(k-String.valueOf(i).length());
            }
            s += String.valueOf(i);

            int cnt = 0; //반전시킬 횟수
            for (int j = 0; j < s.length(); j++) {
                int[] arr1 = sign[tmp.charAt(j) - '0'];
                int[] arr2 = sign[s.charAt(j) - '0'];

                for (int t = 0; t < arr1.length; t++) {
                    if (arr1[t] != arr2[t]) {
                        cnt++;
                    }
                }
            }
            if (p >= cnt) {
                count++; // 반전 가능한 led
            }
        }
        System.out.println(count);
    }
}