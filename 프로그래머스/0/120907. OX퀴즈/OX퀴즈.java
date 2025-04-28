import java.util.*;
class Solution {
    public String[] solution(String[] quiz) {
        int length = quiz.length;
        String[] answer = new String [length];
        
        for(int i = 0; i < quiz.length; i++) {
            String []tmp = quiz[i].split(" ");
            
            for(int j=0;j<tmp.length;j++){
                System.out.print(tmp[j]+" ");
            }
            
            int left = 0;
            if(tmp[1].equals("-")) {
                left = Integer.parseInt(tmp[0]) - Integer.parseInt(tmp[2]);
            } else {
                left = Integer.parseInt(tmp[0]) + Integer.parseInt(tmp[2]);
            }
            
            if(left == Integer.parseInt(tmp[4])){
                answer[i]= "O";
            } else {
                answer[i]= "X";
            }
        }
        return answer;
    }
}