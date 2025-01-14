import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt(); // 포지션 제로 중심 (x,y) 포지션 제로는 원으로 표현
        int y = input.nextInt(); // 사실상 y는 사용되지 않음
        int r = input.nextInt(); // 반지름

        int count_line = 0; // 직선이 경계에 걸쳤을 때, 값 
        int count_in = 0; // 직선이 원 내부에 있을 때 값,


        int [] t_i = new int[n];
        for(int i=0; i<n; i++) {
            int num = input.nextInt(); // 각 직선 t_i
            t_i[i] = num;
            // 바나나는 n개의 직선 중 하나를 골라 그 위에서만 존재
            // 포지션 내부로 들어갈 수 있는 직선의 개수 a와
            // 경계에만 들어갈 수 있는 b
            if (r*r == (x - t_i[i])*(x - t_i[i])) {
                count_line++;
            }
            else if (r*r > (x - t_i[i])*(x - t_i[i])) {
                count_in++;
            }
        }

        System.out.println(count_in +" "+ count_line);

    }
}
