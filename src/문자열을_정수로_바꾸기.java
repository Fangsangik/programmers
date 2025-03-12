public class 문자열을_정수로_바꾸기 {
    public int solution(String s) {

        int answer = Integer.parseInt(s);

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            return Integer.parseInt(s.substring(1)) * (s.charAt(0) == '-' ? -1 : 1);
        }

        return answer;
    }
}
