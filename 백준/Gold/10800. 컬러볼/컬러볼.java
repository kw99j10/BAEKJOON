import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.util.Comparator.comparingInt;

// 10800 컬러볼
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] ball = new int[n + 1][3]; // 번호별 볼의 정보

        StringTokenizer st;
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            ball[i][0] = i; // 번호
            ball[i][1] = Integer.parseInt(st.nextToken()); //색상
            ball[i][2] = Integer.parseInt(st.nextToken()); //크기
        }

        Arrays.sort(ball, comparingInt(o -> o[2]));

        long[] sum = new long[n + 1];
        long[] color = new long[n + 1]; // 색상 별 누적합

        int cur = 0;
        long total = 0L; // 현재 공보다 작은 공의 사이즈 합
        for (int i = 1; i <= n; i++) {
            while (ball[cur][2] < ball[i][2]) {
                total += ball[cur][2];
                color[ball[cur][1]] += ball[cur][2];
                cur++;
            }
            sum[ball[i][0]] = total - color[ball[i][1]]; // 자신 & 겹치는 색상의 공
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(sum[i]).append("\n");
        }
        System.out.print(sb);
    }
}