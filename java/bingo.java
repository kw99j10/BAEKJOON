import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;

        int[][] arr = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int bingo = 0; //선이 3개면 빙고
        int count = 0; //몇번째 수

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                int tmp = Integer.parseInt(st.nextToken());

                count += 1;
                for (int k = 0; k < 5; k++) {
                    for (int t = 0; t < 5; t++) {
                        if (arr[k][t] == tmp) {
                            arr[k][t] = -1; //빙고판을 지움
                        }
                    }
                }

                bingo = colCount(arr, bingo); //세로 빙고
                bingo = rowCount(arr, bingo); //가로 빙고
                bingo = xyCount(arr, bingo); //대각선 빙고
                bingo = yxCount(arr, bingo);

                if (bingo >= 3) {
                    System.out.println(count);
                    return;
                }
                bingo = 0;
            }
        }
    }
    private static int yxCount(int[][] arr, int bingo) {
        if (arr[0][4] + arr[1][3] + arr[2][2] + arr[3][1] + arr[4][0] == -5) {
            bingo += 1;
        }
        return bingo;
    }

    private static int xyCount(int[][] arr, int bingo) {
        if (arr[0][0] + arr[1][1] + arr[2][2] + arr[3][3] + arr[4][4] == -5) {
            bingo += 1;
        }
        return bingo;
    }

    private static int rowCount(int[][] arr, int bingo) {
        for (int k = 0; k < 5; k++) {
            int w = 0;//행의 합

            for (int t = 0; t < 5; t++) {
                w += arr[k][t];
            }
            if (w == -5) {
                bingo += 1;
            }
        }
        return bingo;
    }

    private static int colCount(int[][] arr, int bingo) {
        for (int k = 0; k < 5; k++) {
            int h = 0;

            for (int t = 0; t < 5; t++) {
                h += arr[t][k];
            }
            if (h == -5) {
                bingo += 1;
            }
        }
        return bingo;
    }
}
