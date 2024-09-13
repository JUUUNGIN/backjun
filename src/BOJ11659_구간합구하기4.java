import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659_구간합구하기4 {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken()); // 수의 개수
        int quizNo = Integer.parseInt(stringTokenizer.nextToken()); // 구해야하는 횟수
        long[] s = new long[suNo + 1]; //합배열 선언(인덱스 1부터 사용하기 위해 +1 해줌

        stringTokenizer = new StringTokenizer(bufferedReader.readLine()); // 합배열을 만들어야할 수들
        for (int i = 1; i <= suNo; i++) {
            s[i] = s[i-1] + Integer.parseInt(stringTokenizer.nextToken()); //합배열 만들기
        }
        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());

            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(s[j] - s[i-1]);
        }

    }
}
