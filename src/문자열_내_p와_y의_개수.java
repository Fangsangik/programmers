public class 문자열_내_p와_y의_개수 {
    boolean solution(String s) {
        boolean answer = true;
        int pCnt = 0;
        int yCnt = 0;
        String[] arr = s.split("");
        for (String cnt : arr) {
            if (cnt.equalsIgnoreCase("p")) {
                pCnt++;
                System.out.println("pCnt: " + pCnt);
            } else if (cnt.equalsIgnoreCase("y")) {
                yCnt++;
                System.out.println("yCnt: " + yCnt);
            }

            if (pCnt != yCnt) {
                answer = false;
            }

            if (pCnt == yCnt) {
                answer = true;
            }
        }
        return answer;
    }
}
