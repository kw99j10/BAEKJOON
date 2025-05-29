import java.io.*;
import java.util.*;

// 9575 행운의 수
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            int[] b = new int[m];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                b[i] = Integer.parseInt(st.nextToken());
            }

            int k = Integer.parseInt(br.readLine());
            int[] c = new int[k];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < k; i++) {
                c[i] = Integer.parseInt(st.nextToken());
            }

            HashSet<String> set = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    for (int s = 0; s < k; s++) {
                        String sum = String.valueOf(a[i] + b[j] + c[s]);
                        
                        boolean luck = true;
                        for (int l = 0; l < sum.length(); l++) {
                            if (sum.charAt(l) != '5' && sum.charAt(l) != '8') {
                                luck = false;
                                break;
                            }
                        }
                        if (luck) {
                            set.add(sum);
                        }
                    }
                }
            }
            sb.append(set.size()).append("\n");
        }
        System.out.print(sb);
    }
}