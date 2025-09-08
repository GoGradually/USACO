
import java.io.*;

public class Exponentiation {
    public static void main(String[] args) throws IOException {
        int t;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-->0){
            sb.append(solve(br)).append('\n');
        }
        pw.println(sb);
        br.close();
        pw.close();
    }

    public static long solve(BufferedReader br) throws IOException {
        String[] s = br.readLine().split(" ");
        long a = Long.parseLong(s[0]);
        long b = Long.parseLong(s[1]);
        long m = 1000000007L;

        long result = 1;
        long now = a;
        while(b > 0){
            if((b & 1) == 1){
                result *= now;
                result %= m;
            }
            now = (now * now) % m;
            b >>= 1;
        }
        return result;
    }
}
