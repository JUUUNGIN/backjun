import java.util.Scanner;

public class BOJ2750_수_정렬하기 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] number = new int[n];
        for (int i = 0; i < n; i++) {
            number[i] =sc.nextInt();
        }

        BubbleSort(number, n);
        for (int i = 0; i < n; i++) {
            System.out.println(number[i]);
        }
    }

    public static void BubbleSort(int[] number, int n) {

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (number[j] > number[j + 1]) {
                    int tmp = number[j];
                    number[j] = number[j + 1];
                    number[j+1] = tmp;
                }
            }
        }
    }
}
