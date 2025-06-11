import java.util.*;
class Solution {
    public String solution(String s) {
        String answer = "";
        int idx = 0;
        
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if(c == ' ') {
                idx = 0;
            } else {
                if(idx % 2 == 0) {
                    c = Character.toUpperCase(c);
                } else {
                    c = Character.toLowerCase(c);
                }
                idx++;
            }
            answer += c;
        }
        return answer;
    }
}