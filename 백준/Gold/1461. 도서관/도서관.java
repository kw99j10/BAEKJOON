import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

// 1461 도서관
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        ArrayDeque<Integer> pq = new ArrayDeque<>(); // 양수 위치
        ArrayDeque<Integer> nq = new ArrayDeque<>(); // 음수 위치
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 0) {
                break;
            }
            pq.add(arr[i]);
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                break;
            }
            nq.add(arr[i]);
        }

        // 돌아오지 않을 최대 거리 + 들 수 있는 m개의 책
        int step = 0;
        if (!pq.isEmpty() && !nq.isEmpty()) {
            int max1 = pq.peek();
            int max2 = Math.abs(nq.peek());
            if (max1 > max2) {
                for (int i = 0; i < m; i++) {
                    pq.poll();
                }
                step += max1;
            } else {
                for (int i = 0; i < m; i++) {
                    nq.poll();
                }
                step += max2;
            }
        } else if (pq.isEmpty()) {
            int max = Math.abs(nq.peek());
            for (int i = 0; i < m; i++) {
                nq.poll();
            }
            step += max;
        } else {
            int max = pq.peek();
            for (int i = 0; i < m; i++) {
                pq.poll();
            }
            step += max;
        }

        int book = 1;
        while (!pq.isEmpty()) {
            Integer current = pq.poll();
            if (book == 1) {
                step += current * 2;
            }
            if (book == m) {
                book = 1;
            } else {
                book++;
            }
        }

        book = 1;
        while (!nq.isEmpty()) {
            Integer current = nq.poll();
            if (book == 1) {
                step += Math.abs(current) * 2;
            }
            if (book == m) {
                book = 1;
            } else {
                book++;
            }
        }
        System.out.println(step);
    }
}