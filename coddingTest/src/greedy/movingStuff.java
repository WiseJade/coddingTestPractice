package greedy;

import java.util.ArrayList;
import java.util.List;

public class movingStuff {
    public int movingStuff(int[] stuff, int limit) {
        int box = 0; // 박스에 넣은 짐 수(최대 2)
        int bstuff = 0; // 박스에 담은 짐 무게
        int result = 1; // 필요한 박수 수
        int max = 0;  // 남은 짐의 최댓값
        int maxIndex = 0; // 짐 최댓값의 인덱스
        List<Boolean> boo = new ArrayList<>();  // 짐을 확인했는지 확인할 배열 (모두 false)
        // 배열을 리스트로 변경
        ArrayList<Integer> slist = new ArrayList<Integer>();
        // 배열을 값을 리스트에 추가
        for (int i = 0; i < stuff.length; i++) {
            slist.add(stuff[i]);
            boo.add(false);
        }
        // 짐 리스트를 모두 포장할 때까지 반복
        while (!slist.isEmpty()) {
            // 한 번 확인한 max는 초기화
            max = 0;
            // 만약 다음 최대값을 가져오는데
            for (int i = 0; i < slist.size(); i++) {
                if (max < slist.get(i) && boo.get(i) == false) {
                    max = slist.get(i);
                    maxIndex = i;
                }
            }
            // 확인한 가장 무거운 짐은 true로 변경
            boo.set(maxIndex, true);
            // 짐 배열에서 가장 큰 값 가져옴
            // 가져온 제일 무거운 짐을 넣었을 때 limit가 넘지 않을 지 확인
            if (bstuff + max <= limit) {
                // 안넘으면 박스에 추가
                bstuff += max;
                box++;
                // 넣은 짐은 리스트에서 제거
                slist.remove(maxIndex);
                boo.remove(maxIndex);
                if(slist.isEmpty()) break;
                // 추가한 후에 박스안의 짐이 2개가 되면
                if (box == 2) {
                    // 박스 변수를 비움
                    box = 0;
                    bstuff = 0;
                    // 아직 담을 짐이 있다면 박스 새로 추가
                    result++;
                    // boo 초기화
                    for (int k = 0; k < boo.size(); k++) {
                        boo.set(k, false);
                    }
                }
            } else if (!boo.contains(false)) {
                // 새로운 박스 가져옴
                box = 0;
                bstuff = 0;
                // 아직 담을 짐이 있다면 박스 새로 추가
                result++;
                // boo 초기화
                for (int k = 0; k < boo.size(); k++) {
                    boo.set(k, false);
                }
            }
        }
        return result;
    }
}
