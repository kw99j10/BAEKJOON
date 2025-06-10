import java.util.*;
class Solution {
    static int [] dx = {1, -1, 0, 0};
    static int [] dy = {0, 0, 1, -1};
    static int n, m;
    static int [][] board;
    public int solution(int[][] land) {
        int answer = 0;
        n = land.length;
        m = land[0].length;
        
        board = new int[n][m];
        board = land;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int label = 2;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 1) {
                    int area = bfs(i, j, label);
                    map.put(label++, area); // 라벨링한 구역
                }
            }
        }
    
        int max = 0;
        for(int j = 0; j < m; j++) {
            HashSet<Integer> set = new HashSet<>(); // 라벨링한 석유
            for(int i = 0; i < n; i++) {
                if(board[i][j] > 0) {
                    set.add(board[i][j]);
                }
            }
            
            int count = 0;
            for(Integer size : set) {
                count += map.get(size); // 현재 열에서 시추 가능한 석유
            }
            max = Math.max(max,count);
        }
        return max;
    }
    
    static int bfs(int x,int y, int label) {
        ArrayDeque<int []> queue = new ArrayDeque<>();
        board[x][y] = label;
        queue.add(new int[]{x, y});
        int size = 1;
        while(!queue.isEmpty()) {
            int [] current = queue.poll();
            int cx = current[0];
            int cy = current[1];
            
            for(int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];
                if(nx < 0 || nx >= n || ny < 0 || ny >= m || board[nx][ny] != 1) {
                    continue;
                }
                board[nx][ny] = label;
                size++;
                queue.add(new int[]{nx, ny});
            }
        }
        return size;
    }
}