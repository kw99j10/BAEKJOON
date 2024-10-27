import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 16987 계란으로 계란치기
public class Main {
    static int n, max = 0;
    static int[][] eggs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        eggs = new int[n][2];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            eggs[i][0] = Integer.parseInt(st.nextToken()); //내구도
            eggs[i][1] = Integer.parseInt(st.nextToken()); //무게
        }
        perm(0);
        System.out.println(max);
    }

    static void perm(int idx) {
        if (idx == n) {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (eggs[i][0] <= 0) {
                    cnt++; // 깨진 계란 체크
                }
            }
            max = Math.max(max, cnt);
            return;
        }

        boolean isPossible = false; //충돌이 가능한지

        for (int i = 0; i < n; i++) {
            if (idx == i || eggs[i][0] <= 0 || eggs[idx][0] <= 0) {
                continue;
            }
            eggs[i][0] -= eggs[idx][1];
            eggs[idx][0] -= eggs[i][1];
            perm(idx + 1);
            isPossible = true;
            eggs[i][0] += eggs[idx][1];
            eggs[idx][0] += eggs[i][1];
        }

        if (!isPossible) {
            perm(idx + 1); // 계란이 안깨지는 경우
        }
    }
}