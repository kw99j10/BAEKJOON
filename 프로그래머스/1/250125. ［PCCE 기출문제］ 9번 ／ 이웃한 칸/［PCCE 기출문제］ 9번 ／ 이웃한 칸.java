class Solution {
    static int [] dh = {0,1,-1,0};
    static int [] dw = {1,0,0,-1};
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        int n = board.length;
        int count = 0;
        
        String color = board[h][w];
        for(int d = 0; d < 4; d++) {
            int nx = h + dh[d];
            int ny = w + dw[d];

            if(nx < 0 || nx >= n || ny < 0 || ny >= n) {
                continue;
            }

            String tmp = board[nx][ny];

            if(color.equals(tmp)) {
                count++;
            }
        }
        
        return count;
    }
}