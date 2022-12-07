import static java.lang.Math.max;

public class Practice4 {
    public static int maxArray(int A[], int n){
        int maxSum=0;
        int currentSum = 0;

        for(int i=0;i<n;i++){
            currentSum=max(0,currentSum)+A[i];
            maxSum=max(currentSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int A[]=new int[] {31,-41,59,26,-53,58,97,-93,-23,84};

        int maxSum=0;
        int currentSum = 0;

        for(int i=0;i<A.length;i++){
            currentSum=max(0,currentSum)+A[i];
            maxSum=max(currentSum,maxSum);
        }
        System.out.println(maxSum);
    }
}
