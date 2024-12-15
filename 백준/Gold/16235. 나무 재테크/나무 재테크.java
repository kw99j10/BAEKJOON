import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 16235 나무 재테크
public class Main {
    static class Tree implements Comparable<Tree> {
        int x, y, z;

        public Tree(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }

        @Override
        public int compareTo(Tree o) {
            return this.z - o.z;
        }
    }

    static int n, m, k;
    static PriorityQueue<Tree> tree = new PriorityQueue<>();
    static PriorityQueue<Tree> nextTree = new PriorityQueue<>();
    static int[][] energy;
    static int[][] s2d2;
    static int[][] move = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    static ArrayList<Tree> deadTree = new ArrayList<>(); // 죽은 나무 리스트

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        energy = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                energy[i][j] = 5; // 초기 양분
            }
        }

        s2d2 = new int[n][n]; // 겨울에 추가될 양분
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                s2d2[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            tree.add(new Tree(x, y, z));
        }

        int year = 0;
        while (year != k) {
            treeInvestment(); // 나무 재테크
            year++;
        }
        System.out.println(tree.size());
    }

    static void treeInvestment() {

        spring(); // 나무의 나이가 증가

        summer(); // 죽은 나무가 양분으로 변함

        fall(); // 나무 번식

        winter(); // 양분 추가
    }

    static void spring() {
        while (!tree.isEmpty()) {
            Tree current = tree.poll();
            int x = current.x;
            int y = current.y;
            int old = current.z;

            if (energy[x][y] >= old) {
                nextTree.add(new Tree(x, y, old + 1));
                energy[x][y] -= old;
            } else {
                deadTree.add(new Tree(x, y, old));
            }
        }
    }

    static void summer() {
        // 죽은 나무가 양분으로 변함, 죽은 나무 나이/2 가 양분으로 추가
        for (Tree value : deadTree) {
            energy[value.x][value.y] += value.z / 2;
        }
        deadTree.clear();
    }

    static void fall() {
        while (!nextTree.isEmpty()) {
            Tree current = nextTree.poll();
            int x = current.x;
            int y = current.y;
            int old = current.z;

            tree.add(new Tree(x, y, old));
            if (old % 5 != 0) {
                continue;
            }
            for (int d = 0; d < 8; d++) {
                int nx = x + move[d][0];
                int ny = y + move[d][1];
                if (nx < 0 || nx >= n || ny < 0 || ny >= n) {
                    continue;
                }
                tree.add(new Tree(nx, ny, 1));
            }
        }
    }

    static void winter() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                energy[i][j] += s2d2[i][j];
            }
        }
    }
}
