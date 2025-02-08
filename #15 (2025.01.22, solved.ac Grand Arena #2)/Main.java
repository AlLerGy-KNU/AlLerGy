package baekjun;
import java.util.*;

/**
 * 일반적인 큐는 먼저 집어넣은 데이터가 먼저 나오는 구조로 저장하는 선형 자료구조에요
 * 하지만, 우선순위 큐는 들어간 순서에 상관없이 우선 순위가 높은 데이터가 먼저 나오는 것을 말합니다.
 *
 * 우선순위 큐의 속성
 * 1. 모든 항목에는 우선순위가 있습니다.
 * 2. 우선순위가 높은 요소는 우선순위가 낮은 요소보다 먼저 큐에서 제외됩니다.
 * 3. 두 요소의 우선순위가 같으면 큐의 순서에 따라 제공됩니다.
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Queue<Long> pq = new PriorityQueue<>();

        int t = input.nextInt();

        long max = Long.MIN_VALUE; // long 타입 중 가장 작은 값
        for (int i = 0; i < t; i++) {
            long num = input.nextLong();
            pq.add(num);
            max = Math.max(max, num); // 최대값 갱신
        }

        long curmax = max;
        long result = curmax - pq.peek(); // 가장 높은 우선순위의 값 꺼내기

        while (pq.peek() < max) {
            long min = pq.poll(); // 가장 높은 우선순위의 값 꺼내고 그 값 지우기
            result = Math.min(result, curmax - min); // 최솟값 갱신
            curmax = Math.max(curmax, 2 * min);
            pq.add(2L * min);
        }

        System.out.println(Math.min(curmax- pq.peek(), result));
    }
}
