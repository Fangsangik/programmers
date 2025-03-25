/**
 * 갈색 카펫 10개 노란 카펫 2개
 * -> 10 + 2 = 12 (4, 3)
 * 갈색 카펫 8개 노란 카펫 1개
 * -> 8 + 1 = 9 (3, 3)
 * 갈색 카펫 24개 노란 카펫 24개
 * -> 24 + 24 = 48 (8, 6)
 */
public class 카펫 {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        int width = 0;
        int height = 0;

        //약수 찾기
        for (int i = sum; i > 1; i--) {
            if (sum % i == 0) {
                //세로
                int col = sum / i;
                //i, col 이 brown에 적합한지 확인
                //i * 2는 위 아래 타일 수
                // (col - 2) * 2는 양쪽 세로 테두리를 포함한 타일 수
                // -2는 모서리 타일 중복 계산 X
                if ((i * 2 + (col - 2) * 2) == brown) {
                    width = i;
                    height = col;
                    break;
                }
            }
        }

        return new int[]{width, height};
    }

    /**
     * 2x + 2y - 4 = brown (양쪽 모서리)
     * 2x = brown + 4 - 2y
     * x = (brown + 4 - 2y) / 2
     * <p>
     * (x - 2) * (y - 2) = yellow => x >=3, y >= 3
     * xy - 2x - 2y = yellow
     * xy = yellow + 2x + 2y
     * y = (yellow + 2x + 2y) / x
     */
    public int[] solution2(int brown, int yellow) {
        for (int y = 3; y <= brown + yellow; y++) {
            int x = (brown + 4 - 2 * y) / 2;

            if (x < y) {
                continue;
            }

            if ((x - 2) * (y - 2) == yellow) {
                return new int[]{x, y};
            }
        }

        return new int[]{0, 0};
    }
}
