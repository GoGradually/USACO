package silver.prefixsum.staticrangesum;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int N, Q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long[] arr = new long[N];
        long[] prefixSum = new long[N+1];
        for (int i = 0; i< N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
            prefixSum[i+1] = prefixSum[i] + arr[i];
        }

        for (int i = 0; i < Q; i++) {
            int l, r;
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            pw.println(prefixSum[r] - prefixSum[l]);
        }
        br.close();
        pw.close();
    }
}



