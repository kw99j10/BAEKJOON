import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//경사로
public class Main {
    static int n, l, answer;
    static int[][] map;
    static int[][] tmp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        map = new int[n][n]; //행을 비교
        tmp = new int[n][n]; //열을 비교
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                tmp[j][i] = map[i][j];
            }
        }

        for (int i = 0; i < n; i++) {
            checkRoad(map[i]);
            checkRoad(tmp[i]);
        }
        System.out.println(answer);
    }
    static void checkRoad(int[] map) {
        int idx = 0;
        int length = 1;

        //길에 속한 모든 칸의 높이가 같아야 함 또는 경사로를 만듦 
        while (idx != n - 1) {
            if (map[idx] - map[idx + 1] == 0) {
                length++; //높이가 같다면 계속 길을 만들 수 있음
            } else if (map[idx] - map[idx + 1] == -1 && length >= l) {
                length = 1; //높은 높이의 길이나타나면 길을 다시 만듦
            } else if (map[idx] - map[idx + 1] == 1 && length >= 0) {
                length = 1 - l; //범위를 넘어가는 경우를 고려 
                // ex) 순서 3 2, l이 2일 때 배열 범위를 이탈(이 조건을 만족하지 못하면 경사로를 만들지 못함)
            } else {
                return; //불가능한 겨우
            }
            idx++;
        }
        if (length >= 0) {
            answer++;
        }
    }
}
