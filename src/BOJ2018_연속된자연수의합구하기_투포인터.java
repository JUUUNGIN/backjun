import java.util.Scanner;

public class BOJ2018_연속된자연수의합구하기_투포인터 {
    public static void main(String[] args) {

        // 1~n까지 중 연속된 자연수의 합이 n이 되게 만드는 문제
        // 예를들어 n이 10일 때 연속된 자연수의 합이 되는 경우는 10, 1+2+3+4 총 2개가 있음

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int count = 1;
        int start_index = 1;
        int end_index = 1;
        int sum = 1;
        while (end_index != n) {
            if (sum == n) {
                count++;
                end_index++;
                sum += end_index;
            } else if (sum > n) {
                sum -= start_index;
                start_index++;

            } else {
                end_index++;
                sum += end_index;
            }
        }
        System.out.println(count);
    }
}
