package gold.introductiontodp;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Frog1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        int[] dp = new int[n];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            if (i - 1 >= 0) {
                int one = abs(arr[i] - arr[i - 1]);
                dp[i] = Math.min(dp[i], dp[i - 1] + one);
            }
            if (i - 2 >= 0) {
                int two = abs(arr[i] - arr[i - 2]);
                dp[i] = Math.min(dp[i], dp[i - 2] + two);
            }
        }
        pw.println(dp[n - 1]);
        br.close();
        pw.close();
    }
}
