import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 2138 전구와 스위치
public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        char[] current = br.readLine().toCharArray(); // 현재 상태
        char[] goal = br.readLine().toCharArray(); // 목표

        // 이전 상태를 비교하여 i-1 ~ i+1 번째의 전구 상태를 확인하여 전구를 킬지 말지를 정함
        // 이때, 0번째 전구는 확인할 수 없으므로 경우의 수를 나누어 구현
        int case1 = solve(current.clone(), goal, false); // 0번 끔
        int case2 = solve(current.clone(), goal, true); // 0번 킴
        int min = Math.min(case1, case2);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static int solve(char[] arr, char[] goal, boolean isFirst) {
        int count = 0;

        if (isFirst) {
            change(arr, 0);
            count++;
        }

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] != goal[i - 1]) {
                change(arr, i);
                count++;
            }
        }
        return check(arr, goal) ? count : Integer.MAX_VALUE;
    }

    static void change(char[] arr, int i) {
        for (int j = i - 1; j <= i + 1; j++) {
            if (j >= 0 && j < n) {
                arr[j] = (arr[j] == '0') ? '1' : '0';
            }
        }
    }


    static boolean check(char[] a, char[] b) {
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }
        return true;
    }
}