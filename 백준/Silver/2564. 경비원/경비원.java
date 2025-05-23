import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 2564 경비원
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        ArrayList<int[]> lists = new ArrayList<>();
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken()); // 방향
            int dist = Integer.parseInt(st.nextToken());
            if (dir == 1) {
                lists.add(new int[]{0, dist});
            } else if (dir == 2) {
                lists.add(new int[]{h, dist});
            } else if (dir == 3) {
                lists.add(new int[]{dist, 0});
            } else {
                lists.add(new int[]{dist, w});
            }
        }

        int sx = lists.get(n)[0];
        int sy = lists.get(n)[1]; // 동근이 위치
        int sum = 0;
        for (int i = 0; i < lists.size() - 1; i++) {
            int x = lists.get(i)[0];
            int y = lists.get(i)[1];

            // 1. 동근이 북쪽
            if (sx == 0) {
                //북
                if (x == 0) {
                    sum += Math.abs(y - sy);
                }

                //남
                else if (x == h) {
                    sum += h + Math.min((y + sy), Math.abs(w - y) + Math.abs(w - sy));
                }

                //서
                else if (y == 0) {
                    sum += sy + x;
                }

                //동
                else {
                    sum += (w - sy) + x;
                }
            }

            // 2. 동근이 남쪽
            if (sx == h) {
                //북
                if (x == 0) {
                    sum += h + Math.min((y + sy), Math.abs(w - y) + Math.abs(w - sy));
                }

                //남
                else if (x == h) {
                    sum += Math.abs(y - sy);
                }

                //서
                else if (y == 0) {
                    sum += sy + (h - x);
                }

                //동
                else {
                    sum += (w - sy) + (h - x);
                }
            }

            // 3. 동근이 서쪽
            if (sy == 0) {
                //북
                if (x == 0) {
                    sum += y + sx;
                }

                //남
                else if (x == h) {
                    sum += y + (h - sx);
                }

                //서
                else if (y == 0) {
                    sum += Math.abs(x - sx);
                }

                //동
                else {
                    sum += w + Math.min((x + sx), Math.abs(h - x) + Math.abs(h - sx));
                }
            }

            // 4. 동근이 동쪽
            if (sy == w) {

                //북
                if (x == 0) {
                    sum += (w - y) + sx;
                }

                //남
                else if (x == h) {
                    sum += (w - y) + (h - sx);
                }

                //서
                else if (y == 0) {
                    sum += w + Math.min((x + sx), Math.abs(h - x) + Math.abs(h - sx));
                }

                //동
                else {
                    sum += Math.abs(x - sx);
                }
            }
        }
        System.out.println(sum);
    }
}