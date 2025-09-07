package gold.divisibility;

import java.io.*;
import java.util.StringTokenizer;

public class CommonDivisor {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));

        int n = Integer.parseInt(br.readLine());


        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count = new int[1000001];
        for (int i = 0; i < n; i++) {
            count[Integer.parseInt(st.nextToken())]++;
        }

        for (int i = 1000000; i >= 1; i--) {

            int div = 0;
            for (int j = i; j <= 1000000; j += i) {
                div += count[j];
            }
            if (div >= 2) {
                pw.println(i);
                break;
            }
        }
        br.close();
        pw.close();
    }

}

/**
 * a * b / gcd(a, b) = lcm(a, b)
 * 두 수 간의 관계
 * a 와 b 사이의 최대공약수는 b 와 c 사이의 최대공약수와 연결지을 수 있나?
 * a와 b 사이의 무관계 선언이 b와 c사이의 관계를 지울 수 있음
 * 하고 싶은 것: 한번의 스위핑으로 가장 좋은 관계를 찾아내는 법
 * 뭐가 더 크고 작은지를 어떻게 구분하는거지?
 * 9 13 18
 * 불가능하다면, 다른 방법은 없는가?
 * 내가 직접 조절할 수 있는 독립변수 역할이 있나?
 * 두 수 간에 최대공약수는 곱셈으로 둘 다 도달할 수 있음
 * 주어진 수를 하나의 축 안에 몰아넣고, 존재하는 수 카운트 방식으로 답을 구하기
 */
