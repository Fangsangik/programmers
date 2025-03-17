import java.util.Arrays;
import java.util.Collections;

public class 정수내림차순으로배치 {
    public long solution(long n) {
        String[] answerArr = Long.toString(n).split("");
        Arrays.sort(answerArr);
        StringBuilder sb = new StringBuilder();
        for (String s : answerArr) {
            sb.append(s);
        }
        sb.reverse();
        return Long.parseLong(sb.toString());
    }
}
