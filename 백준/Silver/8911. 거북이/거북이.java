import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 8911 거북이
public class Main {
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1}; // 처음에 북->동->남->서

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            String s = br.readLine();
            int maxX = 500, maxY = 500;
            int minX = 500, minY = 500;
            int sx = 500;
            int sy = 500; // (0,0) 에서 시작
            int dir = 0;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                switch (c) {
                    case 'F':
                        sx -= dx[dir];
                        sy -= dy[dir];
                        break;
                    case 'B':
                        sx += dx[dir];
                        sy += dy[dir];
                        break;
                    case 'L':
                        dir = (dir + 3) % 4;
                        break;
                    case 'R':
                        dir = (dir + 1) % 4;
                        break;
                }
                minX = Math.min(minX, sx);
                minY = Math.min(minY, sy);
                maxX = Math.max(maxX, sx);
                maxY = Math.max(maxY, sy);
            }
            sb.append((maxX - minX) * (maxY - minY)).append("\n");
        }
        System.out.print(sb);
    }
}