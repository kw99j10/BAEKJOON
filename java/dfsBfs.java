import java.util.LinkedList;
import java.util.Scanner;

// dfs와 bfs, silver II
public class Main {

    static boolean[] dfs_visit;
    static boolean[] bfs_visit;
    static int[][] arr;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int v = sc.nextInt();

        arr = new int[n + 1][n + 1];

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
            arr[b][a] = 1;
        }
        dfs_visit = new boolean[n + 1];
        bfs_visit = new boolean[n + 1];

        dfs(v);
        System.out.println();
        bfs(v);
    }
    //DFS는 재귀로 구
    static void dfs(int v) {
        dfs_visit[v]=true;
        System.out.print(v + " ");
        for (int i = 1; i < arr.length; i++) {
            if (arr[v][i] == 1 && !dfs_visit[i]) {
                dfs(i);
            }
        }
    }
    //BFS는 큐로 구현
    static void bfs(int v) {
        bfs_visit[v] = true;
        var q = new LinkedList<Integer>();
        q.add(v);
        System.out.print(v + " ");
        while (!q.isEmpty()) {

            int tmp = q.poll();
            for (int i = 1; i < arr.length; i++) {
                if (arr[tmp][i] == 1 && !bfs_visit[i]) {
                    q.add(i);
                    bfs_visit[i] = true;
                    System.out.print(i + " ");
                }
            }
        }
    }
}
