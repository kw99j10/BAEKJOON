import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        //자료 구조의 형태(정보)를 나타낼 배열
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //각각의 자료 구조에는 한 개의 원소가 들어있음 주의!!
        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++){
            int a = Integer.parseInt(st.nextToken());
            if (arr[i] == 0){
                queue.offerFirst(a); //스택일 경우 원소를 넣을 필요 없음
            }
        }


        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        //큐스택 자료 구조에 삽입할 원소를 입력 받음
        for (int i = 0; i < m; i++){
            queue.offerLast(Integer.parseInt(st.nextToken()));
            sb.append(queue.pollFirst()).append(" ");
        }
        System.out.print(sb);
    }
}
