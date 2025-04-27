import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

// 20366 같이 눈사람 만들래?
public class Main {
    static class SnowMan implements Comparable<SnowMan> {
        int head, body, height;

        public SnowMan(int head, int body, int height) {
            this.head = head;
            this.body = body;
            this.height = height;
        }

        @Override
        public int compareTo(SnowMan o) {
            return this.height - o.height;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        ArrayList<SnowMan> list = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                list.add(new SnowMan(i, j, arr[i] + arr[j]));
                // 머리와 몸의 인덱스를 넣음(중복 사용 x)
            }
        }
        Collections.sort(list);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < list.size(); i++) {
            SnowMan current = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                SnowMan next = list.get(j);
                if (current.head != next.body && current.head != next.head &&
                        current.body != next.body && current.body != next.head) {
                    min = Math.min(min, Math.abs(current.height - next.height));
                    break;
                }
            }
        }
        System.out.println(min);
    }
}