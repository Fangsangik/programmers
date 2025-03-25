import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 문제: 기능개발
 * 먼저 들어간 기능이 끝나야 하기 때문에 = Queue
 * 기능 개발은 동시에 진행되지만 이전 기능이 배포될때 같이 배포가 가능
 */
public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> answerList = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) {
                queue.add((100 - progresses[i]) / speeds[i]);
            } else {
                // 0이 아니면 다음날 배포
                queue.add(((100 - progresses[i]) / speeds[i]) + 1);
            }
        }

        int day = queue.poll();
        int cnt = 1;

        while (!queue.isEmpty()) {
            // 현재 배포 날짜가 큐의 다음 기능의 배포날짜 보다 크면 추가
            if (day >= queue.peek()) {
                // 같이 배포할 기능 수 증가
                cnt++;
                queue.poll();
            } else {
                // 지금까지의 배포 개수를 저장
                answerList.add(cnt);
                // 초기화
                cnt = 1;
                // 다음 배포 날짜로 변경
                day = queue.poll();
            }
        }
        answerList.add(cnt);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
