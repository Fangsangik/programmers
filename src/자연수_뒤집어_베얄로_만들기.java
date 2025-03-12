
public class 자연수_뒤집어_베얄로_만들기 {
    public int[] solution(long n) {
        return new StringBuilder(String.valueOf(n)).reverse().chars().map(Character::getNumericValue).toArray();
    }
}
