package AlgorithmMath;
import AlgorithmMath.permutation.chickenRecipe.Solution;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        Rock r = new Rock();
//        ArrayList<String[]> a = r.rockPaperScissors(5);
//        for(int i = 0; i < a.size(); i++) {
//            System.out.println(Arrays.toString(a.get(i)));
//        }
//        Dp d = new Dp();
//        System.out.println(d.ocean(50, new int[]{10, 20, 50}));
        Solution r = new Solution();
        ArrayList<Integer[]> output1 = r.newChickenRecipe(new int[]{1, 10, 1100, 1111}, 2);
        for(Integer[] a : output1) {
            System.out.println(Arrays.toString(a));
        }
    }
}
