import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * baekjoon 2210 숫자판 점프
 *
 */
public class numberJump {

    static HashSet<String> list=new HashSet<>();
    static int[] dx = {-1, 1, 0, 0}; //상하배열
    static int[] dy = {0, 0, -1, 1}; //좌우배열
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);

        String[][] arr = new String[5][5];
        for (int i=0;i<5;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for (int j=0;j<5;j++){
                arr[i][j]= st.nextToken();
            }
        }

        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                dfs(arr,i,j,0,arr[i][j]);
            }
        }
        System.out.println(list.size());
    }
    static void dfs(String[][] m, int x, int y, int count, String tmp){

        if (count==5){
            list.add(tmp);
            return;
        }
        for (int i=0;i<4;i++){
            int tx = x+dx[i];
            int ty = y+dy[i];
            if((0<=tx&&tx<5)&&(0<=ty&&ty<5)) {
                dfs(m, tx, ty, count + 1, tmp + m[tx][ty]);
            }
        }
    }
}
