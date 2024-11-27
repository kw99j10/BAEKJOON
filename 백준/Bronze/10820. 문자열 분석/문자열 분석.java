import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s;

        StringBuilder sb = new StringBuilder();
        while ((s = br.readLine()) != null) {

            int length = s.length();
            String lower = s.replaceAll("[^a-z]", "");
            String upper = s.replaceAll("[^A-Z]", "");
            String number = s.replaceAll("[^0-9]", "");
            sb.append(lower.length()).append(" ").append(upper.length()).append(" ")
                    .append(number.length()).append(" ")
                    .append(length - (lower.length() + upper.length() + number.length()))
                    .append("\n");
        }
        System.out.print(sb);
    }
}