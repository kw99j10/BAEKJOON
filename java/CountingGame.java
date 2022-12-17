import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CountingGame {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        String[] s = new String[99]; //1~99까지의 숫자의 문자열을 담는 배열

        for (int i = 0; i < 99; i++) {

            String t = String.valueOf(i + 1);

            if (t.length() == 1) {
                switch (t) {
                    case "1":
                        s[i] = "one";
                        break;
                    case "2":
                        s[i] = "two";
                        break;
                    case "3":
                        s[i] = "three";
                        break;
                    case "4":
                        s[i] = "four";
                        break;
                    case "5":
                        s[i] = "five";
                        break;
                    case "6":
                        s[i] = "six";
                        break;
                    case "7":
                        s[i] = "seven";
                        break;
                    case "8":
                        s[i] = "eight";
                        break;
                    case "9":
                        s[i] = "nine";
                        break;
                }
            }
            else {
                if (t.charAt(0) == '1') {
                    s[i] = "one ";
                }
                else if(t.charAt(0)=='2') {
                    s[i] = "two ";
                }
                else if(t.charAt(0)=='3') {
                    s[i] = "three ";
                }
                else if(t.charAt(0)=='4') {
                    s[i] = "four ";
                }
                else if(t.charAt(0)=='5') {
                    s[i] = "five ";
                }
                else if(t.charAt(0)=='6') {
                    s[i] = "six ";
                }
                else if(t.charAt(0)=='7') {
                    s[i] = "seven ";
                }
                else if(t.charAt(0)=='8') {
                    s[i] = "eight ";
                }
                else if(t.charAt(0)=='9') {
                    s[i] = "nine ";
                }
                switch (t.charAt(1)) {

                    case '0':
                        s[i] += "zero";
                        break;

                    case '1':
                        s[i] += "one";
                        break;
                    case '2':
                        s[i] += "two";
                        break;
                    case '3':
                        s[i] += "three";
                        break;
                    case '4':
                        s[i] += "four";
                        break;
                    case '5':
                        s[i] += "five";
                        break;
                    case '6':
                        s[i] += "six";
                        break;
                    case '7':
                        s[i] += "seven";
                        break;
                    case '8':
                        s[i] += "eight";
                        break;
                    case '9':
                        s[i] += "nine";
                        break;
                }
                }
            }
        int n = sc.nextInt();
        int m = sc.nextInt();


        var h = new HashMap<String, Integer>();
        
        //해당 범위까지의 숫자와 숫자의 문자 값을 hashmap에 저장
        for (int i = n; i <= m; i++) {
            h.put(s[i - 1], i);
        }
      
        //키 값(문자열)을 비교하여 정렬
        List<Map.Entry<String, Integer>> entryList = new LinkedList<>(h.entrySet());
        entryList.sort(Map.Entry.comparingByKey());

        int t = 1; // 10개씩 줄바꿈하여 출력
        for(Map.Entry<String, Integer> entry : entryList){
            System.out.print(entry.getValue()+" ");
            if (t%10==0)
                System.out.println("");
            t += 1;
        }
    }
}
