public class 자릿수_더하기 {
    public int solution(int n) {
        String[] answer = Integer.toString(n).split("");
        int sum = 0;
        for (String spilt : answer) {
            sum += Integer.parseInt(spilt);
        }
        return sum;
    }
}
