/*재귀함수를 이용하여 x^n의 결과를 반환하는 함수*/
public class Exponentiation {
	public int Power(int x, int n) { // x와 n을 인자로 받는다.
		if (n == 0) { // 승수가 0이면 1을 리턴한다.
			return 1;
		} else {
			if ((n % 2) == 0) { // 승수가 짝수면 딱 떨어지므로 오차가 생기지 않는다.
				return Power(x, n / 2) * Power(x, n / 2); // 재귀함수로, 인자에 x는 같게 넣어주되, n의 값을 2로나누어 넣어준다.
			} else // 승수가 홀수면 1.5와 같은 값이 되고 n은 integer이기 때문에 오차가 생긴다.
				return x * Power(x, n / 2) * Power(x, n / 2); // 따라서 x를 한번 곱해주고 재귀함수를 실행한다.
		}
	}
}