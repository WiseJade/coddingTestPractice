package bruteForceAlgorithm;

public class SelectionSort {
    public int[] sort(int[] arr) {
        // 주어진 배열을 sort로 오름차순으로 정렬합니다.
        // 입력: 정렬 가능한 요소의 배열 arr
        // 출력: 오름차순으로 정렬한 배열
        // 배열의 길이-1 번만큼 반복합니다.
        for(int i = 0; i < arr.length - 1; i++) {
            // 더 작은 요소의 인덱스를 담을 변수를 i으로 초기화합니다.
            int index = i;
            // 현재 인덱스의 다음 인덱스부터 배열의 마지막 인덱스까지 반복합니다.
            for(int j = i + 1; j < arr.length; j++) {
                // 현재 인덱스의 값과 비교할 인덱스의 값을 비교합니다.
                if(arr[i] >  arr[j]) {
                    // 더 작은 요소를 현재 인덱스로 둡니다.
                    index = j;
                }
            }
            // 비교한 값 중 제일 작은 요소를 i번째 값과 바꿉니다.
            int temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        // 오름차순으로 정렬된 배열을 반환합니다.
        return arr;
    }
}
