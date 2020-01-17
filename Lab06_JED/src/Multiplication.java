/*재귀함수를 이용하여 큰 정수값 u와 v의 곱을 구하는 함수*/
public class Multiplication {
	public int Prod(int u, int v) { // 인자로 u와 v를 받는다.
		final double THRESHOLD = 1000000; // 계산 가능한 정수값을 정해줌. 이보다 작아지면 곱하여 반환한다.
		int x, y, w, z, r, p, q;
		int n, m;

		n = Math.max(u - 1, v - 1);  // u-1과 v-1중 큰 값을 n에 넣는다.
		if ((u == 0) || (v == 0)) { // 둘중 하나가 0이라면
			return 0; // 0을 반환
		} else {
			if (n <= THRESHOLD) { // n의 값이 THRESHOLD보다 작거나 같다면
				return u * v; // u와 v의 곱을 반환
			} else {
				m = n / 2; // m은 n의 반
				x = u / (10 ^ m); // u의 값을 10의 m승으로 나눈 값
				y = u % (10 ^ m); // u의 값을 10의 m승으로 나눈 나머지의 값
				w = v / (10 ^ m); // v의 값을 10의 m승으로 나눔
				z = v % (10 ^ m); // v의 값을 10의 m승으로 나눈 나머지의 값
				r = Prod(x + y, w + z); // 재귀 함수, x+y, w+z 값이 THRESHOLD보다 작아질 때까지 반복한다. 작아 졌을 때의 값을 서로 곱해서 반환
				p = Prod(x, w); // 재귀 함수, x, w 값이 THRESHOLD보다 작아질 때까지 반복한다. 작아 졌을 때의 값을 서로 곱해서 반환
				q = Prod(y, z); // 재귀 함수, y, z 값이 THRESHOLD보다 작아질 때까지 반복한다. 작아 졌을 때의 값을 서로 곱해서 반환
				return p * (10 ^ (2 * m)) + (r - p - q) * (10 ^ m) + q; // p와 10의 2m승을 곱한 값과, r-p-q와 10의 m승, q값을 더하여 반환한다.
			}
		}
	}
}
