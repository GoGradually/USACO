import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedOutputStream(System.out));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            sb.append(solve(br)).append("\n");
        }
        pw.print(sb);
        br.close();
        pw.close();
    }

    public static int solve(BufferedReader br) throws IOException {
        int x = Integer.parseInt(br.readLine());
        int count = 0;
        for (int i = 1; i * i <= x; i++) {
            if (x % i == 0) {
                count++;
                if (x / i != i) count++;
            }
        }
        return count;
    }
}