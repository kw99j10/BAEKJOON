import java.util.*;
class Solution {
    static int [][] map;
    static int n, m, count;
    static int []dx = {1, -1, 0, 0};
    static int []dy = {0, 0, 1, -1};
    public int[] solution(String[] maps) {
        ArrayList<Integer> lists = new ArrayList<>();
        n = maps.length;
        m = maps[0].length();
        map = new int [n][m];
        for(int i = 0; i < n;i++) {
            String s = maps[i];
            for(int j = 0; j < m; j++) {
                char c = s.charAt(j);
                if(c == 'X'){
                    map[i][j] = -1;
                } else {
                    map[i][j] = c - '0';
                }
            }
        }
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] != -1) {
                    count = 0;
                    dfs(i, j);
                    lists.add(count);
                }
            }
        }
        
        if(lists.isEmpty()) {
            return new int[]{-1};
        }
        
        Collections.sort(lists);
        int [] answer = new int[lists.size()];
        for(int i = 0; i < lists.size(); i++) {
            answer[i] = lists.get(i);
        }
        return answer;
    }
    static void dfs(int x, int y) {
        count += map[x][y];
        map[x][y] = -1;
        for(int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];
            
            if(nx < 0 || nx >= n || ny < 0 || ny >= m || map[nx][ny] < 0){
                continue;
            }
            dfs(nx, ny);
        }
    }
}