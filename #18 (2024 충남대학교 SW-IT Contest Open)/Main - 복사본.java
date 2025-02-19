package baekjun;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.nextLine();

        // 주인공 위치
        int px = 0, py = 0;
        // 카메라 위치 초기값 (0, -1)
        int cx = 0, cy = -1;
        // 카메라 방향 (시계 방향으로 0: 북, 1: 동, 2: 남, 3: 서)
        int direction = 2; // 초기 방향은 남쪽

        // 방향에 따른 이동 변화량 (북, 동, 남, 서 순서)
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        for (int i = 0; i < N; i++) {
            String input = scanner.nextLine();

            if (input.equals("MR")) {
                // 시계 방향 회전
                direction = (direction + 1) % 4;
            } else if (input.equals("ML")) {
                // 반시계 방향 회전
                direction = (direction + 3) % 4;
            } else {
                int moveX = 0, moveY = 0;
                if (input.equals("W")) {
                    moveX = dx[direction];
                    moveY = dy[direction];
                } else if (input.equals("S")) {
                    moveX = -dx[direction];
                    moveY = -dy[direction];
                } else if (input.equals("A")) {
                    moveX = dy[direction] * -1;
                    moveY = dx[direction];
                } else if (input.equals("D")) {
                    moveX = dy[direction];
                    moveY = dx[direction] * -1;
                }

                // 주인공과 카메라 이동
                px += moveX;
                py += moveY;
                cx += moveX;
                cy += moveY;
            }

            // 새로운 카메라 위치 업데이트
            cx = px + dx[direction] * -1;
            cy = py + dy[direction] * -1;

            // 결과 출력
            System.out.println(px*-1 + " " + py*-1 + " " + cx*-1 + " " + cy*-1);
        }

        scanner.close();
    }
}
