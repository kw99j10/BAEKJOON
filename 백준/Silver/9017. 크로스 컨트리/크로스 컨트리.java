import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

// 9017 크로스 컨트리
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            ArrayList<Integer> tmp = new ArrayList<>(); // 등수를 임시 저장
            st = new StringTokenizer(br.readLine());
            int max = 0;
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(st.nextToken());
                tmp.add(num);
                max = Math.max(max, num);
            }

            int[] rank = new int[max + 1];
            for (Integer score : tmp) {
                rank[score]++;
            }

            ArrayList<Integer> team = new ArrayList<>();
            for (Integer count : tmp) {
                if (rank[count] < 6) {
                    continue; // 한 팀은 6명
                }
                team.add(count);
            }

            ArrayList<Integer> ranks = new ArrayList<>(); // 등수
            for (int i = 0; i < team.size(); i++) {
                ranks.add(i + 1);
            }


            int[] five = new int[max + 1]; // 다섯번째 주자
            int[] sum = new int[max + 1]; // 4명의 점수 합
            int[] count = new int[max + 1]; // 4명 카운트
            Arrays.fill(count, 4);

            // 가장 낮은 점수를 얻는 팀이 우승, 6명이 아니면 계산에서 제외
            for (int i = 0; i < team.size(); i++) {
                int num = team.get(i);

                if (count[num] < 0) {
                    continue;
                }

                if (count[num] == 0) {
                    five[num] = ranks.get(i);
                    count[num]--;
                    continue;
                }
                sum[num] += ranks.get(i);
                count[num]--;
            }

            int min = Integer.MAX_VALUE;
            int minIdx = 0; // 동점의 경우 다섯번째 주자가 빨리 들어온 팀이 우승
            for (int i = 1; i <= max; i++) {

                if (five[i] == 0) {
                    continue;
                }

                if (min > sum[i]) {
                    min = sum[i];
                    minIdx = i;
                } else if (min == sum[i]) {
                    if (five[minIdx] > five[i]) {
                        min = sum[i];
                        minIdx = i;
                    }
                }
            }
            sb.append(minIdx).append("\n");
        }
        System.out.print(sb);
    }
}