import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 미로 탐색
public class MazeSearch {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }

        int[][] distance = new int[n][m]; //최소 이동거리를 담는 배열
        boolean[][] visit = new boolean[n][m]; //방문을 확인할 배열
        Queue<int[]> q = new LinkedList<>(); //현재 좌표와 이동 거리를 담는 큐


        //시작점 초기화
        visit[0][0] = true;
        q.add(new int[]{0, 0, 1});

        while (!q.isEmpty()) {
            int[] poll = q.poll();
            int x = poll[0];
            int y = poll[1];
            int dist = poll[2];

            distance[y][x] = dist; //이동 거리를 갱신

            //이동할 수 있는 좌표 경우의 수
            int[][] xy = new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};

            for (int[] ints : xy) {

                int dis_x = ints[0];
                int dis_y = ints[1];

                //이동한 위치가 방문한 적 없고 이동가능한 곳인(map 안 & 값이 1) 경우
                if (dis_x >= 0 && dis_x <= map[0].length - 1 && dis_y >= 0 && dis_y <= map.length - 1) {
                    if (map[dis_y][dis_x] == 1 && !visit[dis_y][dis_x]) {
                        
                        //경우의 수가 2개 이상일 수 있으므로 거리(dist)를 미리 더하지 않음
                        visit[dis_y][dis_x] = true;
                        q.add(new int[]{dis_x, dis_y, dist + 1});
                    }
                }
            }
        }
        for (int i = 0; i < distance.length; i++) {
            for (int j = 0; j < distance[i].length; j++) {
                System.out.print(distance[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(distance[distance.length - 1][distance[0].length - 1]);
    }
}
