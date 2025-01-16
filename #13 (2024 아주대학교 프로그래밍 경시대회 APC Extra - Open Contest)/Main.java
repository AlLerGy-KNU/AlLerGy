package Algorithm.baekjun;
import java.util.*;

/**
 * 찐 Even Number
 * 문제 링크
 * https://www.acmicpc.net/problem/32981
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int mod = 1000000007; // 출력 조건

        long [] n = new long[10000001]; // n의 최대 조건, 미리 값들을 모두 저장
        n[1] = 5; // 한자리 숫자 예외
        n[2] = 4*5;
        for(int i=3; i<n.length; i++) {
            n[i] = (n[i-1] * 5) % mod; // 이전 값들의 5를 거듭하여 곱함
        }

        int q = input.nextInt(); // q입력

        for(int i=0; i<q; i++) {
            int a = input.nextInt();
            System.out.println(n[a]); // 해당 인덱스 출력
        }
    }
}