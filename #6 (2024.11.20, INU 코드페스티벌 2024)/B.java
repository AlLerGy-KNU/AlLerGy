import java.util.Scanner;
/**
 * B번 문제
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int a_i = sc.nextInt();
        int a_j = sc.nextInt();

        int b_i = sc.nextInt();
        int b_j = sc.nextInt();


        if((a_i == 0 && b_i == 0 && a_j > b_j) || (a_j == 0 && b_j == 0 && a_i > b_i)){
            System.out.println(3);
        }
        else if((a_i == 0) || (a_j == 0)){
            System.out.println(1);
        }
        else
            System.out.println(2);
    }
}
