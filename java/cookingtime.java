import java.util.*;
public class Cookingtime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int time=sc.nextInt();
        int min=sc.nextInt();

        int need=sc.nextInt();

        time=time+need/60;
        min=min+need%60;

        if (min >= 60) {
            time+=1; //분이 60분이 넘으므로 시간을 1 더한다.
            min-=60; //분이 60분이 넘으면 분에서 60을 뺀다.
        }
        if (time >= 24) {
            time-=24; //24시가 넘으면 time에서 1을 뺀다.
        }
        System.out.println(time+" "+min);
    }
}
