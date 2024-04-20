import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

//웜홀
public class Main {
    static class Road {
        int start, end, time;

        public Road(int start, int end, int time) {
            this.start = start;
            this.end = end;
            this.time = time;
        }
    }

    static int n, m, w;
    static int[] time;
    static ArrayList<Road>[] lists;
    static final int INF = 9999999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            lists = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                lists[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                lists[s].add(new Road(s, e, w));
                lists[e].add(new Road(e, s, w));
            }

            //웜홀 정보를 기존 경로에 갱신(시간 음수)
            for (int i = 0; i < w; i++) {
                st = new StringTokenizer(br.readLine());
                int w_start = Integer.parseInt(st.nextToken());
                int w_end = Integer.parseInt(st.nextToken());
                int w_Time = Integer.parseInt(st.nextToken());
                lists[w_start].add(new Road(w_start, w_end, -w_Time));
            }

            time = new int[n + 1];

            //모든 지점에서 출발하여 경우 탐색
            boolean isPossible = false;
            for (int i = 1; i <= n; i++) {
                Arrays.fill(time, INF);
                if (timeBack(i)) {
                    isPossible = true;
                    break;
                }
            }
            System.out.println(isPossible ? "YES" : "NO");
        }
    }

    //출발을 하였을 때보다 시간이 되돌아가 있는 경우가 있는지 없는지
    static boolean timeBack(int start) {
        time[start] = 0;
        boolean isPossible = false;
        for (int j = 1; j <= n; j++) {
            isPossible = false;
            for (int i = 1; i <= n; i++) {
                for (Road current : lists[i]) {
                    if (time[i] != INF) {
                        if (time[current.end] > time[i] + current.time) {
                            time[current.end] = time[i] + current.time;
                            isPossible = true;
                        }
                    }
                }
            }
            if (!isPossible) {
                break;
            }
        }

        //음의 가중치 탐색 
        if (isPossible) {
            for (int i = 1; i <= n; i++) {
                for (Road current : lists[i]) {
                    if (time[i] != INF) {
                        if (time[current.end] > time[i] + current.time) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}


//2번째 풀이 

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
public class Main {
    static class Road {
        int node, time;

        public Road(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }
    static int n, m, w;
    static boolean isPossible;
    static int[] time;
    static ArrayList<Road>[] lists;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        for (int t = 0; t < test; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            lists = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                lists[i] = new ArrayList<>();
            }
            for (int i = 0; i < m + w; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int w = Integer.parseInt(st.nextToken());

                if (i >= m) {
                    lists[s].add(new Road(e, -w));
                } else {
                    lists[s].add(new Road(e, w));
                    lists[e].add(new Road(s, w));
                }
            }
            time = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                if (timeBack()) {
                    break;
                }
            }
            System.out.println(timeBack() ? "NO" : "YES");
        }
    }
    private static boolean timeBack() {
        isPossible = false;
        for (int i = 1; i <= n; i++) {
            for (Road current : lists[i]) {
                if (time[current.node] > time[i] + current.time) {
                    time[current.node] = time[i] + current.time;
                    isPossible = true;
                }
            }
        }
        return !isPossible;
    }
}
