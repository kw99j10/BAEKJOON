import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class DNA {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        
        //Hammaxg Distance란 길이가 같은 두 DNA가 있을 때, 각 위치의 뉴클오티드 문자가 다른 것의 개수
        //여러 개의 문자열이 입력될 시에 세로로 그 값을 비교
        
         /*
        Hamming Distance의 합이 가장 작은 DNA==비교할 문자열당 최빈 문자열이 가장 많은 DNA
         */

        int n = sc.nextInt(); //dna의 개수
        int m = sc.nextInt(); //dna를 이루는 문자열의 글자 수

        String[] s = new String[n]; //dna를 담을 배열(hammaxg 거리 비교 위함)

        for (int i = 0; i < n; i++) {
            s[i] = sc.next();
        }
        StringBuilder smax = new StringBuilder(); // Hammaing Distance의 합이 가장 작은 DNA
        int sum=0; // 그 DNA의 Hamming Distance의 합

        for (int i = 0; i < m; i++) {

            int maxIndex = 0; //가장 많이 나오는 문자의 위치
            int max=0; // 가장 작은 합을 가지는 DNA의 Hammaxg Distance의 합

            int[] dis = new int[4]; //서로 다른 4가지의 뉴클레오티드로 (A,C,G,T)

            //A,C,G,T 순서로 뉴클레오티드 빈도 수 비교(같은 DNA 합을 가지는 경우 사전순이기 때문에)
            for (int j = 0; j < n; j++) {

                if(s[j].charAt(i) == 'A')
                    dis[0]++;

                else if(s[j].charAt(i) == 'C')
                    dis[1]++;

                else if(s[j].charAt(i) == 'G')
                    dis[2]++;

                else
                    dis[3]++;
            }

            //최빈 값이 곧 합이 가장 작은 DNA
            for (int j = 0; j < 4; j++) {
                if (dis[j]>max) {
                    max = dis[j];
                    maxIndex=j;
                }
            }
            //많이 나오는 문자의 값이 최소의 Hamming Distance를 이루므로 문자열에 더함
            if(maxIndex == 0)
                smax.append("A");

            else if(maxIndex == 1)
                smax.append("C");

            else if(maxIndex == 2)
                smax.append("G");

            else
                smax.append('T');

            //최빈 문자가 아닌 열의 문자들의 개수(빈도)를 더함(Hamming Distance의 합)
            for(int j=0; j<4; j++) {
                if(j != maxIndex) {
                    sum += dis[j];
                }
            }

        }
        System.out.println(smax);
        System.out.println(sum);
    }
}
