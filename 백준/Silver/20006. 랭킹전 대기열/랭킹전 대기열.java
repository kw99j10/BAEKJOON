import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

// 20006 랭킹전 대기열
public class Main {
    static class Room {
        int level;
        TreeMap<String, Integer> map = new TreeMap<>(); //키값으로 정렬된 자료 구조
        public Room(int level, String name) {
            this.level = level;
            map.put(name, level);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Room> lists = new ArrayList<>();
        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            boolean isFull = true;

            for (Room list : lists) {
                if (list.map.size() != m && 10 >= Math.abs(level - list.level)) {
                    list.map.put(name, level);
                    isFull = false;
                    break;
                }
            }

            if (isFull) {
                lists.add(new Room(level, name));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room room : lists) {
            sb.append(room.map.size() == m ? "Started!" : "Waiting!").append("\n");

            for (Map.Entry<String, Integer> entry : room.map.entrySet()) {
                sb.append(entry.getValue()).append(" ").append(entry.getKey()).append("\n");
            }
        }
        System.out.print(sb);
    }
}