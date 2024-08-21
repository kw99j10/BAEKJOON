import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 28702 FizzBuzz
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String a = br.readLine();
        String b = br.readLine();
        String c = br.readLine();

        //FizzBuzz: 15배수
        //Fizz: only 3의 배수
        //Buzz: only 5의 배수
        //i: 그외

        int num = 0;
        if (!a.equals("Fizz") && !a.equals("Buzz") && !a.equals("FizzBuzz")) {
            num = Integer.parseInt(a) + 3;
        }
        else if (!b.equals("Fizz") && !b.equals("Buzz") && !b.equals("FizzBuzz")) {
            num = Integer.parseInt(b) + 2;
        }
        else if (!c.equals("Fizz") && !c.equals("Buzz") && !c.equals("FizzBuzz")) {
            num = Integer.parseInt(c) + 1;
        }

        if (num % 15 == 0) {
            System.out.println("FizzBuzz");
        } else if (num % 5 == 0) {
            System.out.println("Buzz");
        } else if (num % 3 == 0) {
            System.out.println("Fizz");
        }else{
            System.out.println(num);
        }
    }
}