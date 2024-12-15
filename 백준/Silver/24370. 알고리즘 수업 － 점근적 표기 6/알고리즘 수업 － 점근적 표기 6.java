import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a2 = sc.nextInt();
        int a1 = sc.nextInt();
        int a0 = sc.nextInt();
        int c1 = sc.nextInt();
        int c2 = sc.nextInt();
        int n0 = sc.nextInt();

        boolean condition1 = false;
        boolean condition2 = false;

        double d1 = Math.pow(a1, 2) - 4 * a0 * (a2 - c1); // 판별식 계산
        double d2 = Math.pow(a1, 2) - 4 * a0 * (a2 - c2); // 판별식 계산

        if (a2 == c1) {
            if (a1 == 0 && a0 == 0) {
                condition1 = true;
            } else {
                if (a1 >= 0) {
                    condition1 = true;
                }
            }
        } else if (a2 == 0) {
            condition1 = f(n0, a2, a1, a0) >= g(n0, c1);
        } else if (d1 < 0) {
            condition1 = f(n0, a2, a1, a0) >= g(n0, c1);
        } else if (d1 == 0) {
            condition1 = f(n0, a2, a1, a0) >= g(n0, c1);
        } else {
            double x1 = (a1 + Math.sqrt(d1)) / (2 * (c1 - a2));
            double x2 = (a1 - Math.sqrt(d1)) / (2 * (c1 - a2));
            double x = Math.max(x1, x2);
            if (a2 > 0) {
                double v = a1 / (2.0 * (c1 - a2));
                if (f((int) v, a2, a1, a0) <= g((int) v, c1)) {
                    condition1 = x <= n0;
                }
            } else {
                condition1 = n0 > x;
            }
        }

        if (a2 == c2) {
            if (a1 == 0 && a0 == 0) {
                condition2 = true;
            } else {
                if (a1 == 0) {
                    condition2 = a0 <= 0;
                } else {
                    condition2 = true;
                }
            }
        } else if (a2 == 0) {
            condition2 = f(n0, a2, a1, a0) <= h(n0, c2);
        } else if (d2 < 0) {
            condition2 = f(n0, a2, a1, a0) <= h(n0, c2);
        } else if (d2 == 0) {
            condition2 = f(n0, a2, a1, a0) <= h(n0, c2);
        } else {
            double x1 = (a1 + Math.sqrt(d2)) / (2 * (c2 - a2));
            double x2 = (a1 - Math.sqrt(d2)) / (2 * (c2 - a2));
            double x = Math.max(x1, x2);
            if (a2 > 0) {
                double v = a1 / (2.0 * (c2 - a2));
                if (f((int) v, a2, a1, a0) >= h((int) v, c2)) {
                    condition2 = x <= n0;
                }
            } else {
                condition2 = x <= n0;
            }
        }
        System.out.println((condition1 && condition2) ? 1 : 0);
    }

    static double g(int x, int c1) {
        return c1 * Math.pow(x, 2);
    }

    static double f(int x, int a2, int a1, int a0) {
        return a2 * Math.pow(x, 2) + a1 * x + a0;
    }

    static double h(int x, int c2) {
        return c2 * Math.pow(x, 2);
    }
}
