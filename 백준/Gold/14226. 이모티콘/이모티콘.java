import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

// 14226 이모티콘
public class Main {
    static int s;

    static class Emoticon {
        int screen, clip, time;

        public Emoticon(int screen, int clip, int time) {
            this.screen = screen;
            this.clip = clip;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = Integer.parseInt(br.readLine());
        bfs();
    }

    static void bfs() {
        ArrayDeque<Emoticon> queue = new ArrayDeque<>();
        boolean[][] visit = new boolean[s + 1][s + 1];
        queue.add(new Emoticon(1, 0, 0)); // 초기 화면

        while (!queue.isEmpty()) {
            Emoticon current = queue.poll();
            int screen = current.screen;
            int clip = current.clip;
            int time = current.time;

            if (screen == s) {
                System.out.println(time);
                return;
            }

            if (screen > s || visit[screen][clip]) {
                continue;
            }

            visit[screen][clip] = true;

            // 복사
            queue.add(new Emoticon(screen, screen, time + 1));

            // 붙여넣기
            if (clip > 0) {
                queue.add(new Emoticon(screen + clip, clip, time + 1));
            }

            // 삭제
            if (screen > 0) {
                queue.add(new Emoticon(screen - 1, clip, time + 1));
            }
        }
    }
}