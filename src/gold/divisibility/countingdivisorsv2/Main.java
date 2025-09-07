package gold.divisibility.countingdivisorsv2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static List<Integer> primes = new ArrayList<>();
    static int MAX = 1000000;
    static int[] check = new int[MAX + 1];
    public static void main(String[] args) throws Exception {
        for (int i = 2; i <= MAX; i++) {
            if (check[i] == 0) {
                for (int j = i; j <= MAX; j += i) {
                    check[j] = i;
                }
            }
        }


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int T = Integer.parseInt(br.readLine());

        StringBuilder builder = new StringBuilder();

        while(T-->0){
            builder.append(solve(br, pw)).append('\n');
        }
        pw.print(builder);
        br.close();
        pw.close();
    }

    /**
     * x의 약수 개수 구하기
     * 6의 경우
     * 1 2 3 6
     * 2 * 2
     * 8의 경우
     * 2 2 2
     * 4
     * 10의 경우
     * 2 5
     * 9의 경우
     * 3 3
     * 16의 경우
     * 2 2 2 2
     */
    public static int solve(BufferedReader br, PrintWriter pw) throws IOException {
        int x = Integer.parseInt(br.readLine());
        int ans = 1;
        while (x != 1) {
            int count = 1;
            int prime = check[x];
            while (x % prime == 0) {
                count++;
                x /= prime;
            }
            ans *= count;
        }
        return ans;
    }
}
