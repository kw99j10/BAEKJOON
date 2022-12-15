import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FavoriteVote {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc=new Scanner(System.in);

        int t=sc.nextInt();

        for (int i=0;i<t;i++){
            int k=sc.nextInt();

            int max=0; //최다 득표자의 투표 수 저장
            int max_i=0; //최다 득표자의 기호(번호)저장
            int sum=0; //투표 수(과반 수 판단)
            boolean q=true; //동점자 판단

            for (int j=0;j<k;j++){
                int p=sc.nextInt();
                if (p>max) {
                    max = p;
                    max_i = j + 1;
                    q = true;
                }
                else if(max==p) {
                    q = false;
                }
                sum+=p;
            }
            if (!q) //최다 득표자가 모두 동률인 경우
                System.out.println("no winner");

            else if(max>sum/2) //최다 득표자의 수가 투표의 합의 절반을 넘을 때
                System.out.println("majority winner "+max_i);

            else //최다 득표자의 수가 투표의 합의 절반을 넘지못할 때
                System.out.println("minority winner "+max_i);
        }
    }
}






