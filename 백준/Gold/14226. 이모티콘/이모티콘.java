import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

//이모티콘
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());
        bfs(s);
    }

    static void bfs(int s) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0, 0}); //이모티콘 개수, 클립보드 이모티콘 개수, 시간
        boolean[][][] visit = new boolean[2001][2001][3];

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int count = current[0];
            int clipCount = current[1];
            int time = current[2];

            if (count == s) {
                System.out.println(time);
                return;
            }

            if (count > 1000 || clipCount > 2000) {
                continue;
            }

            //화면 이모티콘 복사 -> 클립보드 저장
            if (!visit[count][count][0]) {
                visit[count][count][0] = true;
                queue.add(new int[]{count, count, time + 1});
            }

            //클립보드 모든 이모티콘 화면에 붙여넣기
            if (clipCount > 0 && !visit[count][count + clipCount][1]) {
                visit[count][count + clipCount][1] = true;
                queue.add(new int[]{count + clipCount, clipCount, time + 1});
            }

            //화면 이모티콘 하나 삭제
            if (count > 0 && !visit[count][count - 1][2]) {
                visit[count][count - 1][2] = true;
                queue.add(new int[]{count - 1, clipCount, time + 1});
            }
        }
    }
}