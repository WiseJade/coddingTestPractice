package greedy;

public class Parttime {
    public int partTimeJob(int k) {
        // 정렬된 6개의 동전을 배열로 선언
        int[] coin = {1, 5, 10, 50, 100, 500};
        // 동전을 고려했는지 담을 boolean 배열 선언(초기값 false)
        boolean[] boo = new boolean[6];
        // 거스름돈으로 낼 동전 개수를 셀 변수 0으로 초기화
        int count = 0;
        int max = 0;
        // 거스름돈 k가 0이 될 때까지 반복
        while (k > 0) {
            max = 0;
            // 확인안한 동전들 중 가장 액수가 큰 동전 찾기
            // 6번 반복, 큰 인덱스 부터 확인
            for (int i = 5; i >= 0; i--) {
                // i번째 boo가 false이면 최댓값에 i번째 인덱스 동전값 저장
                if (boo[i] == false) {
                    max = coin[i];
                    // 확인할 인덱스 boo값 true로 저장
                    boo[i] = true;
                    break;
                }
            }
            // 가장 큰 값을 뺏을 때 남은 거스름돈이 음수가 아닌지 확인
            if(k - max >= 0) {
                // 음수가 아니라면 거스름돈에서 동전만큼 액수빼고
                k -= max;
                // 동전수 +1
                count++;
                if(k == 0) break;
                // 최대 동전 뺐기 때문에 모든 boo값을 확인 안한 상태로 바꾼다
                for(int j = 0; j < 6; j++) {
                    boo[j] = false;
                }
            }
            // 음수라면 위에 과정 반복
        }

        return count;
    }
}