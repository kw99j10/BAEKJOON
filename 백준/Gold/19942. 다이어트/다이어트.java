import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 19942 다이어트
public class Main {
    static int[] tmp = new int[5];
    static ArrayList<Integer> tmpResults = new ArrayList<>();
    static int[] level = new int[4]; // 영양분 기준
    static ArrayList<int[]> lists = new ArrayList<>(); // 영양분
    static ArrayList<Integer> currentResults; // 식재료 번호
    static int n, min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[5];
            for (int j = 0; j < 5; j++) {
                arr[j] = Integer.parseInt(st.nextToken());
            }
            lists.add(arr);
        }
        comb(0);

        if (min == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(min);
            StringBuilder sb = new StringBuilder();
            for (Integer i : currentResults) {
                sb.append(i).append(" ");
            }
            System.out.print(sb);
        }
    }

    static void comb(int idx) {
        if (idx == n) {
            if (missLevel()) return;

            if (min > tmp[4]) {
                min = tmp[4];
                currentResults = new ArrayList<>(tmpResults);
            } else if (min == tmp[4]) {
                // 현재 결과와 이전 결과의 사전 순서 고려
                if (check(currentResults, tmpResults)) {
                    currentResults = new ArrayList<>(tmpResults);
                }
            }
            return;
        }

        comb(idx + 1);
        tmpResults.add(idx + 1);
        for (int i = 0; i < 5; i++) {
            tmp[i] += lists.get(idx)[i];
        }

        comb(idx + 1);
        tmpResults.remove(tmpResults.size() - 1);
        for (int i = 0; i < 5; i++) {
            tmp[i] -= lists.get(idx)[i];
        }
    }

    static boolean missLevel() {
        for (int i = 0; i < 4; i++) {
            if (level[i] > tmp[i]) {
                return true;
            }
        }
        return false;
    }

    static boolean check(ArrayList<Integer> a, ArrayList<Integer> b) {
        for (int i = 0; i < Math.min(a.size(), b.size()); i++) {
            if (a.get(i) > b.get(i)) {
                return true;
            } else if (b.get(i) > a.get(i)) {
                return false;
            }
        }
        return a.size() > b.size();
    }
}