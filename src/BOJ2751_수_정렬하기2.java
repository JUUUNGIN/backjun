/** <quick sort, scanner 시간초과>

//import java.util.Random;
//import java.util.Scanner;
//
//public class BOJ2751_수_정렬하기2 {
//    public static void main(String[] args) {
//
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] number = new int[n];
//        for (int i = 0; i < n; i++) {
//            number[i] =sc.nextInt();
//        }
//
//        QuickSort(number,0, n-1);
//        for (int i = 0; i < n; i++) {
//            System.out.println(number[i]);
//        }
//    }
//
//    public static void QuickSort(int[] number, int start, int end) {
//
//        if (start < end) {
//            int pivotIndex = Partition(number, start, end);
//            QuickSort(number, start, pivotIndex - 1);
//            QuickSort(number, pivotIndex + 1, end);
//        }
//    }
//
//    public static int Partition(int[] number, int start, int end) {
//
//        Random rand = new Random();
//        int pivotIndex = start + rand.nextInt(end - start + 1);
//
//        // 피벗을 마지막으로 이동
//        int tmp = number[pivotIndex];
//        number[pivotIndex] = number[end];
//        number[end] = tmp;
//
//        int small = start - 1;
//        int pivot = end;
//
//        for (int cur = start; cur <end ; cur++) {
//            if (number[cur] < number[pivot]) {
//                small++;
//                tmp = number[cur];
//                number[cur] = number[small];
//                number[small] = tmp;
//            }
//        }
//
//        tmp = number[pivot];
//        number[pivot] = number[small + 1];
//        number[small + 1] = tmp;
//
//        return small + 1;
//    }
//}
 **/

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ2751_수_정렬하기2 {
    public static void main(String[] args) throws Exception {
        // 표준 입력을 읽기 위한 BufferedReader 초기화
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 표준 출력을 쓰기 위한 BufferedWriter 초기화
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 첫 번째 줄에서 배열의 크기를 읽어옴
        int n = Integer.parseInt(br.readLine());
        // 크기가 n인 정수 배열을 생성
        int[] number = new int[n];

        // n개의 정수를 입력받아 배열에 저장
        for (int i = 0; i < n; i++) {
            number[i] = Integer.parseInt(br.readLine());
        }

        // 배열을 Merge Sort로 정렬
        MergeSort(number, 0, n - 1);

        // 정렬된 배열을 한 줄씩 출력
        for (int i = 0; i < n; i++) {
            bw.write(number[i] + "\n"); //개행은 직접 해줘야함
        }

        // BufferedReader와 BufferedWriter를 닫아 리소스를 해제
        br.close();
        bw.flush(); //남아있는 데이터 모두 출력
        bw.close();
    }

    // 배열의 start부터 end까지를 Merge Sort로 정렬하는 메서드
    public static void MergeSort(int[] number, int start, int end) {
        if (start < end) {
            // 중간 인덱스를 계산
            int mid = (start + end) / 2;
            // 왼쪽 절반을 정렬
            MergeSort(number, start, mid);
            // 오른쪽 절반을 정렬
            MergeSort(number, mid + 1, end);
            // 정렬된 왼쪽과 오른쪽 부분 배열을 병합
            merge(number, start, mid, end);
        }
    }

    // 두 정렬된 부분 배열을 병합하는 메서드
    public static void merge(int[] number, int start, int mid, int end) {
        // 왼쪽과 오른쪽 배열의 크기를 계산
        int leftSize = mid - start + 1;
        int rightSize = end - mid;

        // 왼쪽과 오른쪽 배열을 생성
        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        // 원본 배열의 왼쪽 부분을 왼쪽 배열로 복사
        System.arraycopy(number, start, left, 0, leftSize);
        // 원본 배열의 오른쪽 부분을 오른쪽 배열로 복사
        System.arraycopy(number, mid + 1, right, 0, rightSize);

        // 왼쪽과 오른쪽 배열의 인덱스와 원본 배열의 인덱스를 초기화
        int i = 0, j = 0, k = start;

        // 두 배열을 비교하면서 원본 배열에 병합
        while (i < leftSize && j < rightSize) {
            if (left[i] <= right[j]) {
                number[k] = left[i];
                i++;
            } else {
                number[k] = right[j];
                j++;
            }
            k++;
        }

        // 왼쪽 배열의 남은 요소를 원본 배열에 복사
        while (i < leftSize) {
            number[k] = left[i];
            i++;
            k++;
        }

        // 오른쪽 배열의 남은 요소를 원본 배열에 복사
        while (j < rightSize) {
            number[k] = right[j];
            j++;
            k++;
        }
    }
}