import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] crain = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            crain[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(crain);

        int m = Integer.parseInt(br.readLine());
        ArrayList<Integer> box = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        box.sort(Collections.reverseOrder()); //크기 순 역정렬

        //애초에 박스를 배로 옮길 수 없음
        if (box.get(0) > crain[n - 1]) {
            System.out.println(-1);
            return;
        }

        int time = 0;
        //모든 박스를 배로 옮겨야 함 큰 박스 -> 무게가 높은 크레인
        while (!box.isEmpty()) {

            int boxIndex = 0;
            int crainIndex = n - 1;

            while (crainIndex >= 0) {
                if (boxIndex == box.size()) {
                    break;
                } else if (crain[crainIndex] >= box.get(boxIndex)) {
                    box.remove(boxIndex);
                    crainIndex--;
                } else {
                    boxIndex++;
                }
            }
            time++;
        }
        System.out.println(time);
    }
}