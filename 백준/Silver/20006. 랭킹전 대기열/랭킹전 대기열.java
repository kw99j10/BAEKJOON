import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 20006 랭킹전 대기열
public class Main {
    static class Member {
        int level;
        String name;

        public Member(int level, String name) {
            this.level = level;
            this.name = name;
        }
    }
    static class Room {
        int level;
        List<Member> members; //방 인원
        public Room(int level) {
            this.level = level;
            members = new ArrayList<>();
        }
    }

    static ArrayList<Room> room;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        room = new ArrayList<>();

        for (int i = 0; i < p; i++) {
            st = new StringTokenizer(br.readLine());
            int level = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            boolean isStartPossible = false;

            for (Room current : room) {
                if (10 >= Math.abs(current.level - level) && m > current.members.size()) {
                    current.members.add(new Member(level, name));
                    isStartPossible = true;
                    break;
                }
            }

            // 입장 가능한 방 없어 새로운 방 생성
            if (!isStartPossible) {
                Room next = new Room(level);
                next.members.add(new Member(level, name));
                room.add(next);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Room current : room) {
            if (current.members.size() == m) {
                sb.append("Started!").append("\n");
            } else {
                sb.append("Waiting!").append("\n");
            }

            current.members.sort(Comparator.comparing(member -> member.name));
            for (int j = 0; j < current.members.size(); j++) {
                sb.append(current.members.get(j).level).append(" ")
                        .append(current.members.get(j).name).append("\n");
            }
        }
        System.out.print(sb);
    }
}