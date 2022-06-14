package AlgorithmMath.permutation.chickenRecipe;
import java.util.*;

public class Solution {
    public ArrayList<Integer[]> newChickenRecipe(int[] stuffArr, int choiceNum) {
        // TODO:
        // 재료 리스트 선언
        ArrayList<Integer> ingred = new ArrayList<>();
        // 상한재료 빼고 재료 리스트에 추가
        for(int i = 0; i < stuffArr.length; i++) {  // 배열의 길이만큼 반복
            int count = 0;  // 한가지 재료에서 0의 개수를 셀 변수 0으로 초기화
            String temp = Integer.toString(stuffArr[i]);  // 인덱스의 재료를 String형으로 변환
            for(int j = 0; j < temp.length(); j++) {  // String의 길이만큼 반복
                if(temp.charAt(j) == '0') // 0인지 확인
                    count++;  // 0이면 count+1
            }
            if(count < 3) // count가 3보다 작으면
                ingred.add(stuffArr[i]); // 재료 리스트에 추가
        }
        // 재료를 모두 사용할 수 없거나 뽑을 개수보다 사용할 수 있는 재료 수가 더 적을 경우 null 반환
        if(ingred.size() < choiceNum) {
            return null;
        }
        // 재료를 뽑기전에 순서대로 정렬한다
        Collections.sort(ingred);
        // 재료를 사용했는지 확인할 boolean타입 배열 선언 (크기 : 재료 개수)
        boolean[] used = new boolean[ingred.size()];
        // 결과값 담을 integer배열형 arraylistt 생성
        ArrayList<Integer[]> result = new ArrayList<>();
        // 재귀함수 choice를 호출하여 결과값 list에 반환
        return choice(result, ingred, new Integer[]{}, used, choiceNum, 0);


    }
    // 재귀함수로 원하는 개수만큼 함수 반복해서 리스트에 담는다.
    // 매개변수
    // 결과값 Integer배열형 리스트, 재료 담아져 있는 ingred 리스트, 조합할 재료를 담은 임시 배열 bucket, 재료를 사용했는지 확인할 boolean배열, 뽑을 재료 개수, 뽑은 재료 개수 확인할 depth 변수
    public ArrayList<Integer[]> choice(ArrayList<Integer[]> result, ArrayList<Integer> ingred, Integer[] bucket, boolean[] used, int choiceNum, int depth) {
        // 재료를 원하는 만큼 담으면 결과 리스트에 현재 담아져 있는 재료를 추가하고 리턴한다. (재귀 종료한다)
        if(depth == choiceNum) {
            result.add(bucket);
            return result;
        }
        // 재료 리스트를 모두 확인한다.
        for(int i = 0; i < ingred.size(); i++) {
            // 해당 인덱스의 재료가 아직 사용하지 않았다면
            if(!used[i]) {
                // 사용할 재료는 사용했다고 표시한다
                used[i] = true;
                // 임시 배열을 현재 담아져 있는 재료보다 한칸 늘려서 만든다.
                Integer[] bucketConcat = Arrays.copyOf(bucket, bucket.length + 1);
                // 쓰려는 재료를 임시 배열에 넣는다
                bucketConcat[bucketConcat.length - 1] = ingred.get(i);
                // 현재 담아져있는 임시 재료 배열에 bucketConcat 넣고 깊이+1 을 매개변수로 재귀함수 호출 한다.
                result = choice(result, ingred, bucketConcat, used, choiceNum, depth + 1);
                // 재귀가 끝난 첫 재료는 사용하지 않은 것으로 표시한다
                used[i] = false;
            }
        }
        return result;
    }
}
