package greedy;

public class BoardGame {
    public Integer boardGame(int[][] board, String operation) {
         // 점수를 담을 Integer변수
        Integer result = 0;
        int ud = 0;
        int rl = 0;
        int n = board.length;

        try {
        for(int i = 0; i < operation.length(); i++) {
            switch(operation.charAt(i)) {
                case 'U':
                    ud--;
                    result += board[ud][rl];
                    break;
                case 'D':
                    ud++;
                    result += board[ud][rl];
                    break;
                case 'L':
                    rl--;
                    result += board[ud][rl];
                    break;
                case 'R':
                    rl++;
                    if (rl > n) {
                        return null;
                    }
                    result += board[ud][rl];
                    break;
                default:
                    break;
            }
        }
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
        return result;
    }
}
