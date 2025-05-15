class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        
        int n = park.length;
        int m = park[0].length;
        
        for(int k = 0; k < mats.length; k++) {
            int r = mats[k]; // rxr 돗자리
            boolean isPossible = false;
            
            for(int i = 0; i <= n - r; i++) {
                for(int j = 0; j <= m - r; j++) {
                    if(!park[i][j].equals("-1")) {
                        continue; // 자리 있음
                    }
                    
                    boolean check = true;
                    for(int a = i; a < i + r; a++) {
                        for(int b = j; b < j + r; b++) {
                            if(!park[a][b].equals("-1")) {
                                check = false;
                                break;
                            }
                        }
                        if(!check) break;
                    }
                    
                    if(check) {
                        isPossible = true;
                        break;
                    }
                }
                if(isPossible) {
                    answer = Math.max(answer, r);
                    break;
                }
            }
        }
        return answer;
    }
}