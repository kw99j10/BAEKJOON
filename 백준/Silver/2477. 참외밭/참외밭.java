import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2477 참외밭
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine()); //참외의 개수
        
        int maxW = 0; int maxH = 0;
        int maxWidx = 0; int maxHidx = 0;
        
        int[][] field = new int[6][2];
        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            //변의 방향, 길이를 담음
            field[i][0] = Integer.parseInt(st.nextToken());
            field[i][1] = Integer.parseInt(st.nextToken());

            //동,서 방향 -> 너비
            if (field[i][0] == 1 || field[i][0] == 2) {
                if (field[i][1] > maxW) {
                    maxW = field[i][1];
                    maxWidx = i;
                }
            }

            //남,북 방향 -> 높이
            else if (field[i][0] == 3 || field[i][0] == 4) {
                if (field[i][1] > maxH) {
                    maxH = field[i][1];
                    maxHidx = i;
                }
            }
        }
        int minW = field[(maxWidx + 3) % 6][1];
        int minH = field[(maxHidx + 3) % 6][1]; //3만큼 차이남
        System.out.println(((maxW * maxH) - (minW * minH)) * k);
    }
}