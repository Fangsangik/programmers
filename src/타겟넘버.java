import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 타겟넘버 {
    /**
     * target - 나와야 하는 값
     * return - target이 나올 수 있는 경우의 수
     * dfs 활용
     */
    public int solution(int[] numbers, int target) {
        int answer = 0;
        answer = dfs(numbers, target, 0, 0);
        return answer;
    }

    public int dfs(int[] numbers, int target, int index, int sum) {
        if (index == numbers.length) {
            return sum == target ? 1 : 0;
        }
        return dfs(numbers, target, index + 1, sum + numbers[index])
                + dfs(numbers, target, index + 1, sum - numbers[index]);
    }

    public int solution2(int[] numbers, int target) {
        int answer = 0;
        Stack<int[]> stack = new Stack<>();

        stack.push(new int[] {0, 0});

        while (!stack.isEmpty()) {
            int[] cur = stack.pop();
            int sum = cur[0];
            int idx = cur[1];

            if (idx == numbers.length) {
                if (sum == target) {
                    answer++;
                }
                continue;
            }

            stack.push(new int[] {sum + numbers[idx], idx + 1});
            stack.push(new int[] {sum - numbers[idx], idx + 1});
        }

        return answer;
    }

    public int solution3 (int[] numbers, int target) {
        int answer = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {0, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int sum = cur[0];
            int idx = cur[1];

            if (idx == numbers.length) {
                if (sum == target) {
                    answer++;
                }
                continue;
            }

            queue.add(new int[] {sum + numbers[idx], idx + 1});
            queue.add(new int[] {sum - numbers[idx], idx + 1});
        }

        return answer;
    }

}
