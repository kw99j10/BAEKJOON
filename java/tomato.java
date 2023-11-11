import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    //토마토가 있는 좌표와 모두 익을 때 까지의 최소 날짜를 담을 객체
    static class Node {
        int x;
        int y;
        int day;

        public Node(int x, int y, int day) {
            this.x = x;
            this.y = y;
            this.day = day;
        }
    }
    static int[][] tomato; //토마토의 상태를 나타내는 그래프

    static Queue<Node> queue; //Node 객체 정보를 담을 큐
    static int m; //토마토 상자의 가로
    static int n; //토마토 상자의 세로

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        m = sc.nextInt();
        n = sc.nextInt();

        tomato = new int[n][m];
        queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tomato[i][j] = sc.nextInt();

                //익어 있는 토마토 들을 큐에 담음
                if (tomato[i][j] == 1) {
                    queue.offer(new Node(j, i, 0));
                }
            }
        }
        bfs(); //bfs 수행
    }
    static void bfs() {

        int day = 0; //토마토가 모두 익을 때까지의 최소 날짜를 갱신할 변수

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            int x = node.x; //현재 x좌표
            int y = node.y; //현재 y좌표
            day = node.day; //최소 날짜를 갱신

            //이동할 수(익을 수) 있는 경우의 수
            int[][] xy = {{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};
            for (int[] ints : xy) {
                int distance_x = ints[0];
                int distance_y = ints[1];

                //좌표안에 토마토가 존재하고 익지 않은 상태(0)라면 -> 익은 상태로 변경(1)
                if (distance_x >= 0 && distance_x < m &&
                        distance_y >= 0 && distance_y < n &&
                        tomato[distance_y][distance_x] == 0) {
                    tomato[distance_y][distance_x] = 1;
                    queue.offer(new Node(distance_x, distance_y, day + 1)); //날짜 갱신
                }
            }
        }

        //만약 익지 않은 토마토가 존재한다면 -1을 출력하고 반복문(bfs) 종료
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (tomato[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }
        }
        System.out.println(day); //토마토가 모두 익었다면 최소 날짜를 출력
    }
}
