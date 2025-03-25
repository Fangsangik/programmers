import java.util.LinkedList;
import java.util.Queue;

public class 게임맵최단거리 {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        boolean[][] visited = new boolean[n][m];
        Queue<Node> queue = new LinkedList<>();
        // 시작점 0, 0 시작점 1
        queue.offer(new Node(0, 0, 1));
        // 시작점 방문
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node.x == n - 1 && node.y == m - 1) {
                return node.distance;
            }

            // 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                // 벽이 아니고 방문하지 않았다면
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && maps[nx][ny] == 1 && !visited[nx][ny]) {
                    // 큐에 넣고 방문처리
                    queue.offer(new Node(nx, ny, node.distance + 1));
                    visited[nx][ny] = true;
                }
            }

        }
        return -1;
    }

    //x, y 좌표와 거리를 저장하는 Node 클래스
    static class Node {
        int x;
        int y;
        int distance;

        public Node(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }
}