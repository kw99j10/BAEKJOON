import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

// 2412 암벽 등반
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken()); // 목표 좌표

        ArrayList<Integer>[] lists = new ArrayList[200001];
        for (int i = 0; i <= 200000; i++) {
            lists[i] = new ArrayList<>(); // 홈
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            lists[y].add(x);
        }

        for (int i = 0; i <= 200000; i++) {
            Collections.sort(lists[i]);
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{0, 0});
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                if (y == t) {
                    System.out.println(time);
                    return;
                }

                for (int ny = y - 2; ny <= y + 2; ny++) {
                    if (ny < 0 || ny > 200000) {
                        continue;
                    }

                    for (int j = 0; j < lists[ny].size(); j++) {
                        int nx = lists[ny].get(j);
                        if (nx > x + 2) {
                            break;
                        }

                        if (x - 2 > nx) {
                            continue;
                        }

                        queue.add(new int[]{nx, ny});
                        lists[ny].remove(j);
                        j--; // 사용한 홈 제거
                    }
                }
            }
            time++;
        }
        System.out.println(-1);
    }
}