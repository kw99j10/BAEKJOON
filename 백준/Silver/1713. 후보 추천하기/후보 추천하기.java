import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1713 후보 추천하기
public class Main {
    static class Student implements Comparable<Student> {
        int num, count, old; // 사진틀 번호, 추천 수, 얼마나 오래 됐는지

        public Student(int num, int count, int old) {
            this.num = num;
            this.count = count;
            this.old = old;
        }

        @Override
        public int compareTo(Student o) {
            if (this.count == o.count) {
                return this.old - o.old;
            }
            return this.count - o.count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int chu = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        LinkedList<Student> queue = new LinkedList<>(); // 삽입 삭제 위함

        int order = 1;
        for (int i = 0; i < chu; i++) {
            int num = Integer.parseInt(st.nextToken());

            boolean isFin = false; // 이미 있는 사진틀
            for (Student student : queue) {
                if (student.num == num) {
                    student.count++;
                    isFin = true;
                    break;
                }
            }
//
//            for (Student student : queue) {
//                System.out.print(student.num + " ");
//            }
//            System.out.println();

            if (isFin) {
                Collections.sort(queue);
                continue;
            }

            if (queue.size() >= n) {
                queue.poll(); //사진틀 개수를 넘어간 경우
            }
            queue.add(new Student(num, 1, order++));
            Collections.sort(queue);
        }

        ArrayList<Integer> lists = new ArrayList<>();
        for (Student student : queue) {
            lists.add(student.num);
        }
        Collections.sort(lists);
        for (Integer list : lists) {
            System.out.print(list + " ");
        }
    }
}