import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class KEM {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());

        String[][] name = new String[n][4]; //이름,국어 점수, 영어 점수, 수학 점수

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            name[i][0] = st.nextToken();
            name[i][1] = st.nextToken();
            name[i][2] = st.nextToken();
            name[i][3] = st.nextToken();
        }

        //Comparator 비교문 작성
        Arrays.sort(name, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                //국어 점수는 감소하는 순서로

                if (o2[1].equals(o1[1])) { //국어 점수가 같으면 영어 점수가 증가하는 순서로

                    if (o2[2].equals(o1[2])) {//국어, 영어 점수가 같으면 수학 점수가 감소하는 순서로

                        if (o2[3].equals(o1[3])) { //점수가 모두 같으면 이름 사전 순으로
                            return o1[0].compareTo(o2[0]);
                        }
                        return Integer.parseInt(o2[3]) - Integer.parseInt(o1[3]);
                    }
                    return Integer.parseInt(o1[2]) - Integer.parseInt(o2[2]);
                }
                return Integer.parseInt(o2[1]) - Integer.parseInt(o1[1]);
            }
        });

        for (String[] strings : name) {
            System.out.println(strings[0]);
        }
    }
}
