import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int a = sc.nextInt();
		int b = sc.nextInt();

		int count = 0; // 연산의 최솟값

		while (true) {

			if (a == b) {
				count += 1;
				break;
			}

			if (a > b) {
				count = -1; //연산을 수행할 수는 있으나 B를 A로 만들 수 없는 경우
				break;
			}

			if (b % 10 == 1) {
				b = b / 10;
			}

			else if (b % 2 == 0) {
				b = b / 2;
			}

			else {
				count = -1; //불가능한 연산의 경우
				break;
			}
			count += 1;
		}
		System.out.println(count);
	}
}
