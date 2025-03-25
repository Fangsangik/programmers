import java.util.Arrays;
import java.util.Stack;

/**
 * 문제: 가장 큰 수
 *
 * 처음 든 생각
 * 배열 숫자를 문자열로 우선 만든 뒤, 하나씩 쪼개서 각 인덱스 별로 비교 하면서
 * 가장 큰 수를 만들면 되지 않을까?
 *
 * 두번 째로 든 생각
 * Stack 사용
 */

public class 가장큰수 {
    /**
     * 시간 초과 발생
     * O(n²) -> 입력수가 많아질 수록 성능이 나빠짐 -> 시간 초과
     */
    public String solution(int[] numbers) {
       String[] strNumbers = new String[numbers.length];

        for (int i = 0; i < strNumbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }


        for (int i = 0; i < strNumbers.length - 1; i++) {
            for (int j = 0; j < strNumbers.length -i - 1; j++) {
                String a = strNumbers[j];
                String b = strNumbers[j + 1];

                if ((a + b).compareTo(b + a) < 0) {
                    strNumbers[j] = b;
                    strNumbers[j + 1] = a;
                }
            }
        }

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String strNumber : strNumbers) {
            sb.append(strNumber);
        }

        return sb.toString();
    }

    public String solution2(int[] numbers) {
        Stack<String> stack = new Stack<>();

        for (int number : numbers) {
            String numStr = String.valueOf(number);

            // 올바른 위치를 찾아 삽입하는 느낌
            Stack<String> temp = new Stack<>();
            // 스택의 젤 위에 값 비교, 새로 넣으려는 값 조합
            // 조합한 값이 더 크면 스택에서 빼서 임시 스택에 넣고, 새로운 값 넣기
            while (!stack.isEmpty() && (stack.peek() + numStr).compareTo(numStr + stack.peek()) < 0) {
                temp.push(stack.pop());
            }
            stack.push(numStr);
            while (!temp.isEmpty()) {
                stack.push(temp.pop());
            }
        }

        // 스택에서 문자열 조합
        StringBuilder result = new StringBuilder();
        for (String s : stack) {
            result.append(s);
        }

        return result.toString().startsWith("0") ? "0" : result.toString();
    }

    /**
     * Arrays.sort() 사용
     * O(nlogn)
     * (b + a).compareTo(a + b) → 문자열을 조합한 결과 비교
     */
    public String solution3 (int[] numbers) {
        String[] strNumbers = Arrays.stream(numbers)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);

        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));

        if (strNumbers[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String strNumber : strNumbers) {
            sb.append(strNumber);
        }

        return sb.toString();
    }
}
