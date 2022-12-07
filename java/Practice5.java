import java.util.Scanner;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Practice5 {

    public static int maxArray(int A[], int n){
        int maxMul=A[0];

        int Min=A[0]; //최소곱
        int Max=A[0]; //최대곱

        int Min_Array,Max_Array;

        for (int i = 0; i < A.length; i++) {
            Min_Array=min(min(A[i],Min*A[i]),Max*A[i]);
            Max_Array=max(max(A[i],Min*A[i]),Max*A[i]);

            Min=Min_Array;
            Max=Max_Array;

            maxMul=max(maxMul,Max);
        }
        return maxMul;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        int A[]=new int[] {-6,12,-7,0,14,-7,5};

        System.out.println(maxArray(A,n));
    }
}
