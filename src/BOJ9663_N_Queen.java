import java.util.Scanner;

public class BOJ9663_N_Queen {

    public static int N;
    public static int[] col;
    public static int count = 0;

    public static void main(String[] args) {

//        재귀함수 구현
//        1. 서로 공격할 수 있는지 없는지 (같은 값을 가지는지 혹은 +-1의 값을 가지는지 검사) 구현 -> true/false possibility();
//        2. 공격할 수 없고, depth가 N개와 같아지는 경우 카운팅  -> nQueen()

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        col = new int[N];

        nQueen(0);
        System.out.println(count);
    }

    public static void nQueen(int depth) {
//모든 원소를 다 채웠을 때 카운팅

        if (depth == N) {
            count++;
//            이 return은 nQueen메서드의 종료가 아닌 nQueen(depth+1)재귀함수의 종료
            return;
        }

        for (int i = 0; i < N; i++) {
            col[depth] = i;
            if (possibility(depth)) {
                nQueen(depth + 1);
            }
        }
    }

    public static boolean possibility(int depth) {

        for (int i = 0; i < depth; i++) {
            if (col[depth] == col[i]) {
                return false;
            } else if (depth - i == Math.abs(col[depth] - col[i])) {
                return false;
            }
        }
        return true;
    }
}
