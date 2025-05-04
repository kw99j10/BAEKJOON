import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 14658 하늘에서 별똥별이 빗발친다
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        ArrayList<int[]> lists = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists.add(new int[]{x, y}); // 별똥별이 떨어지는 위치 좌표
        }
        
        int max = 0; // 튕겨내는 별똥별
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                int cnt = 0; // 현재 영역에 포함되는 별똥별

                int cx = lists.get(i)[0];
                int cy = lists.get(j)[1]; // 기준 좌표
                for (int[] list : lists) {
                    int x = list[0];
                    int y = list[1];

                    if ((x >= cx && x <= cx + l) && y >= cy && y <= cy + l) {
                        cnt++;
                    }
                }
                max = Math.max(max, cnt);
            }
        }
        System.out.println(k - max); // 부딪히는 별똥별
    }
}