import java.util.Stack;

/**
 * 하나씩 호출하면서 ( 가 나오면 넣고
 * 그 다음꺼를 호출했을 때 )가 나오면 pop
 *
 * String => Spilt 했을때 시간 초과 발생
 * split은 정규 표현식을 사용하여 문자열을 분할
 * 매칭되는 문자열바다 배열을 생성
 * String[] 객체를 생성하여 반환하기 때문에 불필요한 메모리 할당이 많음.
 *
 * char[]은 문자열의 문자 배열을 직접 반환
 * 불필요한 정규식 분석이 없음
 */

public class 올바른관호 {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false; // 닫는 괄호가 더 많으면 false
                }
                stack.pop();
            }
        }

        return stack.isEmpty(); // 스택이 비어 있으면 올바른 괄호 문자열
    }
}
