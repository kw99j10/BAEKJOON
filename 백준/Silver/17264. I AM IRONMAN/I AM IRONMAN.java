import java.io.*;
import java.util.*;

// 17264 I AM IRONMAN
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int cut = Integer.parseInt(st.nextToken());

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String toggle = st.nextToken();
            if (toggle.equals("W")) {
                map.put(name, w);
            } else {
                map.put(name, -l);
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            String name = br.readLine();
            if (!map.containsKey(name)) {
                sum = Math.max(0, sum - l);
                continue;
            }

            sum += map.get(name);
            sum = Math.max(0, sum);

            if (sum >= cut) {
                System.out.println("I AM NOT IRONMAN!!");
                return;
            }
        }
        System.out.println("I AM IRONMAN!!");
    }
}