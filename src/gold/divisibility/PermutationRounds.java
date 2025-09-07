import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;


public class PermutationRounds {
    public static final int MAX_VAL = 200000;
    static int[] prime = new int[200001];
    public static void main(String[] args) throws IOException {

        setPrime();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).map(a -> a - 1).toArray();

        int[] check = new int[MAX_VAL + 1];
        Arrays.fill(check, -1);

        int[] lcm = new int[MAX_VAL + 1];

        for(int i = 0; i < n; i++){
            if(check[i] != -1) continue;
            long count = 1;
            check[i] = 1;
            int now = arr[i];
            check[now] = 1;
            while (now != i){
                now = arr[now];
                check[now] = 1;
                count++;
            }
            lcm(count, lcm);
        }
        long ans = getPow(lcm);
        System.out.println(ans);
        br.close();
    }

    private static long getPow(int[] lcm) {
        long ans = 1;
        for(int i = 1; i <= MAX_VAL; i++){
            long now = i;
            while(lcm[i] > 0){
                if(lcm[i] % 2 == 1){
                    ans = (ans * now) % 1000000007L;
                }
                now *= now;
                now %= 1000000007L;
                lcm[i] >>= 1;
            }
        }
        return ans;
    }

    private static void setPrime() {
        for(int i = 2; i <= MAX_VAL; i++){
            if(prime[i] == 0){
                for(int j = i; j <= MAX_VAL; j += i){
                    prime[j] = i;
                }
            }
        }
    }

    private static void lcm(long newVal, int[] lcm) {
        while(newVal > 1){
            int nowPrime = prime[(int)newVal];
            int count = 0;
            while(newVal % nowPrime == 0){
                newVal /= nowPrime;
                count++;
            }
            lcm[nowPrime] = Math.max(lcm[nowPrime], count);
        }
    }


    static long modPow(long a, long e, long m) {
        long r = 1 % m;
        a %= m;
        while (e > 0) {
            if ((e & 1) == 1) r = (r * a) % m;
            a = (a * a) % m;
            e >>= 1;
        }
        return r;
    }

    static long invModPrime(long a, long m) {
        return modPow(a, m - 2, m);
    }
}
