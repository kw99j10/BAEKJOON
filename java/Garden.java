import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//공주님의 정원
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        int[][] calendar = new int[13][32];
        makeDays(calendar); //달력의 일 수 -> 숫자 전환

        int[][] project = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start_month = Integer.parseInt(st.nextToken());
            int start_days = Integer.parseInt(st.nextToken());

            int end_month = Integer.parseInt(st.nextToken());
            int end_days = Integer.parseInt(st.nextToken());

            // 모든 날짜를 숫자로 변환
            project[i][0] = calendar[start_month][start_days];
            project[i][1] = calendar[end_month][end_days];
        }

        //시작일이 빠른 순 -> 같다면 종료일이 빠른 순
        Arrays.sort(project, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        int start = 0; //시작일
        int end = 0; //갱신할 종료일
        int min = 0; //선택한 꽃의 최소 개수
        int days = 60; //3월 1일~ 11월 30일: 60~334
        while (days < 335) {

            boolean isPossible = false; //꽃을 심을 수 없는 경우를 판단
            for (int i = start; i < N; i++) {
                if (project[i][0] > days) {
                    break; //현재 날짜보다 시작일이 큰 꽃은 들어올 수 없음
                }

                if (project[i][1] > end && days >= project[i][0]) {
                    end = project[i][1]; //아니라면 꽃의 종료일을 갱신
                    isPossible = true; //꽃을 심을 수 있음
                    start = i + 1; //시작일 갱신
                }
            }

            if (!isPossible) {
                break;
            }

            days = end; //종료일 갱신
            min++;
        }
        System.out.println(335 > end ? 0 : min);
    }

    private static void makeDays(int[][] calendar) {
        int num = 1;
        for (int i = 1; i <= 12; i++) {
            if (i == 2) {
                for (int j = 1; j <= 28; j++) {
                    calendar[i][j] = num++;
                }
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                for (int j = 1; j <= 30; j++) {
                    calendar[i][j] = num++;
                }
            } else {
                for (int j = 1; j <= 31; j++) {
                    calendar[i][j] = num++;
                }
            }
        }
    }
}
