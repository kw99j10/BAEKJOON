import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 1347 미로 만들기
public class Main {
    static char[][] map;
    static int x = 50, y = 50, nowDir, minX = 50, minY = 50, maxX = 50, maxY = 50;
    static int[] dx = {1, 0, -1, 0}; // 남 -> 동 -> 북 -> 서
    static int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        map = new char[101][101];
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                map[i][j] = '#';
            }
        }

        map[x][y] = '.'; //현재 위치
        for (int i = 0; i < n; i++) {
            switch (s.charAt(i)) {
                case 'F':
                    go();
                    break;
                case 'L':
                    nowDir = (nowDir + 3) % 4;
                    break;
                case 'R':
                    nowDir = (nowDir + 1) % 4;
                    break;
            }
        }

        for (int i = minX; i < maxX + 1; i++) {
            for (int j = minY; j < maxY + 1; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void go() {
        x += dx[nowDir];
        y += dy[nowDir];
        map[x][y] = '.';

        minX = Math.min(minX, x);
        minY = Math.min(minY, y);
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
    }
}