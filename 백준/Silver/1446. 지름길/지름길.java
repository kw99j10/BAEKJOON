import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 1446 지름길
public class Main {
    static class Road implements Comparable<Road> {
        int x, weight;
        public Road(int x, int weight) {
            this.x = x;
            this.weight = weight;
        }

        @Override
        public int compareTo(Road o) {
            return this.weight - o.weight;
        }
    }
    static int n, d;
    static ArrayList<Road>[]lists;
    static int[] distance = new int[10001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        lists = new ArrayList[10001];
        for (int i = 0; i <= 10000; i++) {
            lists[i] = new ArrayList<>();
            distance[i] = 999999; //경로 초기화
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            if (y > d || weight >= y - x) {
                continue; //목적지보다 먼 도착 위치
            }
            lists[x].add(new Road(y, weight));
        }
        dijkstra();
        System.out.println(distance[d]); // d까지의 최소 거리
    }
    static void dijkstra() {
        PriorityQueue<Road> queue = new PriorityQueue<>();
        queue.add(new Road(0, 0));
        distance[0] = 0;

        while (!queue.isEmpty()) {
            Road current = queue.poll();

            if (current.weight > distance[current.x]) {
                continue;
            }

            for (Road next : lists[current.x]) {
                if (distance[next.x] > distance[current.x] + next.weight) {
                    distance[next.x] = distance[current.x] + next.weight;
                    queue.add(new Road(next.x, distance[next.x]));
                }
            }

            // 지름길이 없는 경우는 y-x 만큼의 거리
            if (d >= current.x + 1 && distance[current.x + 1] > distance[current.x] + 1) {
                distance[current.x + 1] = distance[current.x] + 1;
                queue.add(new Road(current.x + 1, distance[current.x + 1]));
            }
        }
    }
}