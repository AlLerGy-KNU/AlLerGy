package baekjun;

import java.io.*;
import java.util.*;

/**
 * 길이가 i 인 막대를 만드는 방법의 수는 i인 막대를 그대로 사용하거나,
 * i의 약수인 막대를 k배 늘리는 것입니다.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        // BufferedReader를 사용하여 입력을 빠르게 받음
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 N 입력 받기
        int N = Integer.parseInt(br.readLine());
        // 배열 A 입력 받기 및 변환
        int[] A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // 정수 Q 입력 받기
        int Q = Integer.parseInt(br.readLine());
        // 배열 L 입력 받기 및 변환
        int[] L = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        // A와 L에서 최댓값 찾기
        int MX = Arrays.stream(A).max().getAsInt();
        for (int l : L) {
            MX = Math.max(MX, l);
        }

        // D 배열 초기화 (각 숫자의 등장 횟수 저장)
        int[] D = new int[MX + 1];
        for (int a : A) {
            D[a]++;
        }

        // 약수 개수 누적 계산
        for (int i = 2; i <= MX; i++) {
            for (int j = 1; j * j <= i; j++) {
                if (i % j == 0) {
                    D[i] += D[j]; // 약수 j의 개수 추가
                    if (j * j != i && j != 1) {
                        D[i] += D[i / j]; // 대칭되는 약수(i / j)의 개수 추가
                    }
                }
            }
        }

        // 결과를 StringBuilder에 저장하여 출력 속도 최적화
        StringBuilder sb = new StringBuilder();
        for (int l : L) {
            sb.append(D[l]).append(" ");
        }
        System.out.println(sb.toString().trim()); // 결과 출력
    }
}
