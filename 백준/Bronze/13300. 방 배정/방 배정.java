import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] student = new int[7][2]; //학년, 성별
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int grade = Integer.parseInt(st.nextToken());
            student[grade][gender] += 1;
        }

        int sum = 0;
        for (int i = 1; i <= 6; i++) {
            if (student[i][0] > k) {
                sum += (student[i][0] - 1) / k + 1;
            } else if (student[i][0] != 0 && k >= student[i][0]) {
                sum += 1;
            }

            if (student[i][1] > k) {
                sum += (student[i][1] - 1) / k + 1;
            } else if (student[i][1] != 0 && k >= student[i][1]) {
                sum += 1;
            }
        }
        System.out.println(sum);
    }
}