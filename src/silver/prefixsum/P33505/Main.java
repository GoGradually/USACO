package silver.prefixsum.P33505;

import java.io.*;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            solve(br, pw);
        }
    }
    public static void solve(BufferedReader br, PrintWriter pw) throws IOException {
        int n, m;
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

    }
}

/**
 * x 골라야 함
 * 연산의 횟수는 최소화
 * x를 잘 골라서
 * m으로 나누어 떨어지게
 * 그리고 그때의 연산 최소 횟수 구하기
 * x를 몇으로 둬야 M으로 나누어 떨어지게 할 수 있을까?
 * M은 이미 정해져 있는 상수이다.
 * 내가 바꿀 수 있는건 x
 * 모두의 m으로 나눈 나머지
 * x의 변화에 따른 비용의 변화는 어떻게 일어나는가를 생각해보면,
 * 변수 각각 별로 0부터 m-1까지의 ^v자 형태의 꺾인 선이 구해진다.
 * 그리고 모든 ^v자 형태의 꺾인선을 합하면? 필요한 비용인 f(x)가 된다.
 * 변화는 모두 1씩만 일어난다는 점에 주의하면, 많은 변수가 좋은 쪽으로 영향받을 수록 유리하다.
 * 그럼 둘 중 가까운 쪽이 훨씬 유리한건가?
 *
 * m으로 나눈 나머지가 m에 가까운가, 0에 가까운가
 * m/2 > arr[i]가 하나라도 많으면 x를 키우는게 좋은 선택이다.
 * 결국 분기점은 하나씩 0으로 만드는 구간이다.
 * 이 갯수는 올라갔다 내려갔다 하기 때문에, 이분탐색으로 구할 수는 없다.
 * 정렬 - O(N)
 * 나머지화 - O(N)
 *
 * 이후, 각 O(N)에 대해,
 * 증가하는 카운트 I와 감소하는 카운트 J 유지해서
 * 아니 그냥 그 원소를 빼
 *
 */
