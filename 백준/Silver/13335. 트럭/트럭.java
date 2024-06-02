import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

// 13335 트럭
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 트럭 수
        int w = Integer.parseInt(st.nextToken()); // 다리 길이
        int l = Integer.parseInt(st.nextToken()); // 다리 하중

        int[] truck = new int[n]; // 다리를 건너려는 트럭들

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            truck[i] = Integer.parseInt(st.nextToken());
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < w; i++) {
            list.offer(0); //다리 길이만큼 리스트에 0을 넣음
        }

        int min = 0; //최단 시간
        int sum = 0; //현재 다리 하중
        int idx = 0; //현재 인덱스
        while (true) {
            if (idx == n) {
                min += w; //마지막 트럭이 건너는 시간
                break;
            }

            min++;
            sum -= list.poll();

            if (l >= truck[idx] + sum) {
                list.offer(truck[idx]);
                sum += truck[idx];
                idx++;
            }else{
                list.offer(0);
            }
        }
        System.out.println(min);
    }
}