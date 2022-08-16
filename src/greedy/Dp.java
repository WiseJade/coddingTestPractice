package greedy;

public class Dp {
    public long ocean(int target, int[] type) {
        // 가짓수를 담을(반환할) 결과값 0으로 초기화
        long result = 0;
        long[][] arr = new long[type.length][target + 1];
        for(int i = 0; i < type.length; i++) {
            arr[i][0] = 1;
        }
        // type(동전)의 최소 단위로 나누어 떨어지면 교환 가능하기 때문에 방법수 1 저장
        for (int i = type[0]; i <= target; i++) {
            if (i % type[0] == 0) arr[0][i] = 1;
        }

        for (int i = 1; i < type.length; i++) {
            for (int j = 0; j <= target; j++) {
                if(type[i] > j) {
                    arr[i][j] = arr[i-1][j];
                }
                else {
                    arr[i][j] = arr[i][j-type[i]] + arr[i-1][j];
                }
            }
        }
        result = arr[type.length - 1][target];
        return result;
    }
}
