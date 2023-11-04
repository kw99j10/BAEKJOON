import java.util.Scanner;
/**
 * 연결 요소의 개수 - Silver II
 */

public class Main {

    static int[][] arr;
    static boolean[] visit;

    static int count; //연결 요소의 개수: ex) (1,4,6), (2,3,5) -> 2개

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); //정점
        int m = sc.nextInt(); //간선

        arr = new int[n + 1][n + 1]; //연결을 나타낼 배열

        for (int i = 0; i < m; i++) {

            //간선의 양 끝점
            int u = sc.nextInt();
            int v = sc.nextInt();

            arr[u][v] = 1;
            arr[v][u] = 1;
        }

        visit = new boolean[n + 1]; //방문을 확인할 배열
        for (int i = 1; i < arr.length; i++) {
            if (!visit[i]) {
                dfs(i);
                count += 1; // dfs 종료 -> 연결 요소 한 묶음
            }
        }
        System.out.println(count);
    }
    static void dfs(int v){
        visit[v] = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[v][i] == 1) {
                if (!visit[i]) {
                    dfs(i);
                }
            }
        }
    }
}
