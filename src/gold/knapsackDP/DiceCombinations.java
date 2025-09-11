
import java.io.*;

public class DiceCombinations {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        long n = Long.parseLong(br.readLine());

        long[] dp = new long[(int) n + 1];
        dp[0] = 1;
        long mod = 1000000007L;
        for (int i = 0; i < n; i++) {
            for (int dice = 1; dice <= 6; dice++) {
                if (i + dice <= n) {
                    dp[i + dice] += dp[i];
                    dp[i + dice] %= mod;
                }
            }
        }
        pw.println(dp[(int) n]);
        br.close();
        pw.close();
    }
}
