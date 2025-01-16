package Algorithm.baekjun;
import java.util.*;

/**
 * 문제 링크
 * https://www.acmicpc.net/problem/32935
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int n = input.nextInt();
        ArrayList<Long> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            long k = input.nextInt();
            list.add(k);
        }
        long sum;

        /**
         * 이 문제의 조건에서 다음의 시행은 일어나지 않거나, 1번 일어나는 것이 최대에요.
         *
         * 이때 sum의 자료형을 잘 정해주어야 해요! 여기서 sum은 최대 300,000 * 10 ^9 가 될 수 있기 때문에
         * 정수형 자료형은 저 값을 담을 수 없어요. 저도 이것 땜에 틀렸었습니다.
         */
        boolean done = false;
        while(!done){
            Collections.sort(list); // 주어진 수열 정렬
            sum = list.stream().mapToLong(Long::longValue).sum(); // 수열의 합
            long min = list.get(0); // 수열의 최솟값
            if (-sum <= min) { // -(합)이 최솟값보다 작거나 같을 때, 결과 출력
                System.out.println(sum);
                done = true; // 반복 종료
            }
            list.set(0, -sum); // -(합)이 최솟갑보다 클 때, 수열의 최솟값을 -(합)으로 변경
        }
    }
}