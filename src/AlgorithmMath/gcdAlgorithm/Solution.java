package AlgorithmMath.gcdAlgorithm;

import java.util.*;

public class Solution {
    public ArrayList<Integer[]> divideChocolateStick(int M, int N) {
        // TODO:
        int max = Math.max(M, N);
        ArrayList<Integer[]> list = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            if (M % i == 0 && N % i == 0) {
                Integer[] arr = new Integer[]{i, M/i, N/i};
                list.add(arr);
            }
        }
        return list;
    }
}
