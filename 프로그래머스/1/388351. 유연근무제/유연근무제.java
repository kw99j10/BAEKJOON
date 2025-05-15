class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        int len = schedules.length;
        
        int [] possible = new int [len];
        for(int i = 0; i < len; i++) {
            int hour = schedules[i] / 100;
            int min = schedules[i] % 100 + 10;
            if(min >= 60) {
                hour += 1;
                min = min - 60;
            }
            possible[i] = hour * 100 + min;
        }
        
        for(int i = 0; i < len; i++) {
            int start = startday;
            
            boolean isPossible = true;
            for(int j = 0; j < 7; j++) {
                if((start >= 1 && start <= 5) && possible[i] < timelogs[i][j]) {
                    isPossible = false;
                }
                start = (start % 7) + 1;
            }
            
            if(isPossible) {
                answer++;
            }
        }
        return answer;
    }
}