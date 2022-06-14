package AlgorithmMath.combination.blackjack;

public class Blackjack2 {
    public int boringBlackjack(int[] cards) {
        // 결과값을 담을 변수 0으로 초기화
        int result = 0;
        // 3개의 카드를 뽑기 위해 반복문 3번 중첩
        // cards개수만큼 반복
        for(int i = 0; i < cards.length; i++) {
            // i+1 번쨰부터 끝까지 반복
            for(int j = i + 1; j < cards.length; j++) {
                // j+1번째부터 끝까지 반복
                for(int k = j + 1; k < cards.length; k++) {
                    // 소수라면 결과값에 +1
                    if(prime(cards[i] + cards[j] + cards[k])) result++;
                }
            }
        }
        return result;
    }
    // 소수를 구하는 함수
    public boolean prime (int num) {
        if(num == 0 || num == 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i = 3; i <= Math.sqrt(num); i += 2)
            if(num % i == 0) return false;
        return true;
    }
}
