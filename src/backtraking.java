import java.util.Scanner;

public class Main {
    public static boolean[]a;
    public static int []b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n=sc.nextInt();
        int m=sc.nextInt();

        a=new boolean[n];
        b = new int[m];

        dfs(n, m, 0);
    }
    public static void dfs(int n, int m, int depth) {

        if(depth==m) {
            for (int val : b) {
                System.out.print(val + " ");
            }
            System.out.println();
            return;
        }

        for (int i = 0; i < a.length; i++) {
            // 해당 노드를 방문하지 않았을 때
            if (!a[i]) {
                a[i]=true;// 해당 노드 방문상태 변경
                b[depth] = i + 1;// 해당 깊이를 index로 하여 i+1 값 저장
                dfs(n, m, depth + 1);// 다음 자식 노드 방문 위해 depth 1 증가시키며 재귀 호출
                a[i] = false;// 자식노드 방문이 끝나고 돌아오면 방문노드를 방문하지 않은 상태로 변경
            }
        }
    }
}

