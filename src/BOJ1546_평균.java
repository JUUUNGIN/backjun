import java.util.Scanner;

public class BOJ1546_평균 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        long sum = 0;
        long max = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] > max) max = arr[i];
            sum += arr[i];
        }

        System.out.println(sum*100.0/max/n); //100.0을 곱하면 자동으로 double형으로 변경됨
    }
}
