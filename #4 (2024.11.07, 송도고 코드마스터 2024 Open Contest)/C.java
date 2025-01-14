import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();

        int [] list = new int [n+1];

        for(int i=1; i<=n; i++){
            list[i] = input.nextInt()*2;
        }

            int result = 180 * (n -1);

            for (int i = 1; i <= n; i++) {
                result -= list[i];
            }

            System.out.println(result );
    }

}
