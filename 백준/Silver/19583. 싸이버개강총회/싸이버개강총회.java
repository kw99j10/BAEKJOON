import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 19583 싸이버개강총회
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] s = br.readLine().split(" ");
        String S = s[0]; //개총 시작 시간
        String E = s[1]; //개총 끝낸 시간
        String Q = s[2]; //개총 스트리밍 끝낸 시간

        //출석이 확인된 경우 => 1의 경우 + 2의 경우
        //1. 개총 시작 전에 채팅 기록을 남긴 경우 + 개춍 시작하자마자
        //2. 개총 종료 <= ~ <= 개총 스트리밍 종료

        int start = Integer.parseInt(S.split(":")[0]) * 60 + Integer.parseInt(S.split(":")[1]);
        int end = Integer.parseInt(E.split(":")[0]) * 60 + Integer.parseInt(E.split(":")[1]);
        int streamEnd = Integer.parseInt(Q.split(":")[0]) * 60 + Integer.parseInt(Q.split(":")[1]);

        HashMap<String, Integer> startCheck = new HashMap<>();
        HashMap<String, Integer> endCheck = new HashMap<>();

        String tmp;
        while (true) {

            tmp = br.readLine();
            if (tmp == null || tmp.isEmpty()) {
                break;
            }

            String time = tmp.split(" ")[0];
            String name = tmp.split(" ")[1];

            int total = Integer.parseInt(time.split(":")[0]) * 60 +
                    Integer.parseInt(time.split(":")[1]);

            if (total <= start) {
                startCheck.put(name, total);
            } else if (total >= end && total <= streamEnd) {
                endCheck.put(name, total);
            }
        }

        int count = 0; // 출석이 확인된 학회원
        for (String students : startCheck.keySet()) {
            if (endCheck.containsKey(students)) {
                count++;
            }
        }
        System.out.println(count);
    }
}