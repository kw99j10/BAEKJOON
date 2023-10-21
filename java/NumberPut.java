import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 단지 번호 붙이기
public class NumberPut {
    static int[][] map; //단지를 나타내는 배열
    static int count; //각 단지내 집의 수
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < s.length(); j++) {
                map[i][j] = Integer.parseInt(String.valueOf(s.charAt(j)));
            }
        }
        int total = 0; //총 단지 수
        var a = new ArrayList<Integer>(); //연결된 각 단지 수를 담을 list
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 1) {
                    count = 0;
                    total += 1;
                    dfs(i, j);
                    a.add(count); //탐색이 끝나면 리스트에 저장
                }
            }
        }
        System.out.println(total);

        Collections.sort(a); //오름차순 정렬 위함
        for (Integer integer : a) {
            System.out.println(integer);
        }
    }

    static void dfs(int x,int y) {
        //연결되었으면 해당 단지를 0으로 변경 후 count(단지 수) 증가
        map[x][y] = 0;
        count += 1;

        int[][] xy = new int[][]{{x - 1, y}, {x + 1, y}, {x, y - 1}, {x, y + 1}};
        for (int[] ints : xy) {
            int dis_x = ints[0];
            int dis_y = ints[1];

            if (dis_x >= 0 && dis_x <= map[0].length - 1 && dis_y >= 0 && dis_y <= map.length - 1) {
                if (map[dis_x][dis_y] == 1) {
                    dfs(dis_x, dis_y);
                }
            }
        }
    }
}
