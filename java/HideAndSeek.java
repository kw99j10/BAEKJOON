import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] arr; //위치에 따른 시간을 나타내는 그래프
    static int n; //수빈이의 위치
    static int k; //동생의 위치

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();

        arr = new int[100001]; //그래프 초기화

        if (n == k) {
            System.out.println(0); //수빈이와 동생의 위치가 같다면 이동할 필요 X
        }
        else {
            bfs(); //같지 않다면 최소 시간을 구하는 문제이므로 bfs 수행
        }
    }
    static void bfs() {

        Queue<Integer> queue = new LinkedList<>(); //이동할 좌표를 담을 큐
        boolean[] visit = new boolean[100001]; //이동한 좌표를 방문했는 지 확인할 배열

        //수빈이의 처음 위치 세팅
        queue.offer(n);
        visit[n] = true;

        int next; //수빈이가 움직일 다음 좌표

        while (!queue.isEmpty()) {
            int current = queue.poll();

            //이동할 수 있는 경우의 수
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    next = current - 1;
                }
                else if (i == 1) {
                    next = current + 1;
                }
                else{
                    next = current * 2;
                }
                
                //다음 좌표가 동생의 좌표라면 시간을 +1 해주고 bfs 종료
                if (next == k) {
                    System.out.println(arr[current] + 1); 
                    return;
                }

                //좌표 내에 있고 방문하지 않았다면 큐에 다음 위치를 넣음
                //시간 +1 갱신
                if (next >= 0 && next < arr.length && !visit[next]) {
                    arr[next] = arr[current] + 1;
                    visit[next] = true;
                    queue.offer(next);
                }
            }
        }
    }
}
