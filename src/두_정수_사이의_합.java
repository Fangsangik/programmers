public class 두_정수_사이의_합 {
    public long solution(int a, int b) {
        long answer = 0;
        long min = 0;
        long max = 0;

        min = Math.min(a, b);
        max = Math.max(a, b);

        for (long i = min; i <= max; i++) {
            answer += i;
        }

        return answer;
    }
}
