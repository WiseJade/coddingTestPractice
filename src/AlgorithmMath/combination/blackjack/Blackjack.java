package AlgorithmMath.combination.blackjack;
import java.util.*;

public class Blackjack {
    public int boringBlackjack(int[] cards) {
        // TODO:
        // 결과값을 담을 변수 0으로 초기화
        int result = 0;
        // 가지고 있는 카드를 정렬한다
        Arrays.sort(cards);
        // 재귀 함수를 호출하여 리턴한다
        result = cardchoice(cards, new int[]{}, result, 0, 0);
        return result;
    }
    // 재귀함수 cardchoice를 이용해서 가능한 모든 조합 찾기
    // 소수이면 결과값에 +1
    // 매개변수 : 가지고 있는 카드 배열, 현재 뽑은 카드 배열, int형 결과값, 마지막으로 뽑은 카드의 다음 인덱스, 뽑은 카드 개수(깊이)
    public int cardchoice (int[] cards, int[] pick, int result, int index, int depth) {
        // 뽑은 카드 개수가 다 차면(3) 소수인지 확인
        if (depth == 3) {
            // 카드의 모든 수 더한다
            int sum = 0;
            for(int i : pick) {
                sum += i;
            }
            // 소수라면 result + 1
            if(prime(sum)) {
                result ++;
            }
            // result 반환해서 재귀를 멈춘다
            return result;
        }
        // index 부터 시작해서 cards의 길이만큼 반복
        for(int i = index; i < cards.length; i++) {
           // 현재까지 뽑은카드의 길이보다 1 늘려서 임시 배열 선언
            int[] pickConcat = Arrays.copyOf(pick, pick.length + 1);
            // 임시 배열의 마지막에 해당 카드 넣어줌
            pickConcat[pickConcat.length - 1] = cards[i];
            // result는 재귀함수 호출해서 대입
            result = cardchoice(cards, pickConcat, result, i + 1, depth + 1);
        }

        return result;
    }
    // 매개변수로 입력받은 수가 소수인지 확인하는 함수
    public boolean prime (int num) {
        if(num == 0 || num == 1) return false;
        if(num == 2) return true;
        if(num % 2 == 0) return false;
        for(int i = 3; i <= Math.sqrt(num); i++)
            if(num % i == 0) return false;
        return true;
    }

}

