import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// 3153 합이 0
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(num); //학생들의 코딩 실력 정렬

        long cnt = 0; //고를 수 있는 팀의 수
        for (int mid = 0; mid < n; mid++) {

            int start = mid + 1;
            int end = n - 1; //세 수 start, mid, end

            while (start < end) {
                int sum = num[start] + num[mid] + num[end];
                if (sum == 0) {

                    //처음 수와 마지막 수가 같으면 같은 수가 사이에 존재함 => 조합
                    if (num[start] == num[end]) {
                        cnt += (long) (end - start + 1) * (end - start) / 2;
                        break; //중복 방지 반복문 종료
                    }

                    int s = 1;
                    int e = 1;

                    //그외 옆의 숫자가 같은 경우
                    while (num[start] == num[start + 1]) {
                        s++;
                        start++;
                    }

                    while (num[end] == num[end - 1]) {
                        e++;
                        end--;
                    }

                    cnt += (long) s * e;
                    start++;
                    end--;
                }
                else{
                    if (sum > 0) {
                        end--;
                    }else{
                        start++;
                    }
                }
            }
        }
        System.out.println(cnt);
    }
}