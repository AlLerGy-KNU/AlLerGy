import java.util.Scanner;

public class Main {
    public static long dolmen(int a, int b) {
        long sum = 0;
        
        sum = (long) (a+b)*((a+b) * (a + b - 1) / 2);
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(dolmen(a,b));
        }
        

    }

}
