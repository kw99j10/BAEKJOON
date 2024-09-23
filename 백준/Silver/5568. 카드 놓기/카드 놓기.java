import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

//5568 카드 놓기
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int k = Integer.parseInt(br.readLine());
        String[] card = new String[n];
        for (int i = 0; i < n; i++) {
            card[i] = br.readLine();
        }
        HashSet<String> set = new HashSet<>();
        if (k == 2) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        set.add(card[i] + card[j]);
                    }
                }
            }
        } else if (k == 3) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int s = 0; s < n; s++) {
                        if (i != j && j != s && s != i) {
                            set.add(card[i] + card[j] + card[s]);
                        }
                    }
                }
            }
        }
        else{
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int s = 0; s < n; s++) {
                        for (int p = 0; p < n; p++) {
                            if (i != j & j != s && s != p && p != i && i != s && j != p) {
                                set.add(card[i] + card[j] + card[s] + card[p]);
                            }
                        }
                    }
                }
            }
        }
        System.out.println(set.size());
    }
}