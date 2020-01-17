/*����Լ��� �̿��Ͽ� x^n�� ����� ��ȯ�ϴ� �Լ�*/
public class Exponentiation {
	public int Power(int x, int n) { // x�� n�� ���ڷ� �޴´�.
		if (n == 0) { // �¼��� 0�̸� 1�� �����Ѵ�.
			return 1;
		} else {
			if ((n % 2) == 0) { // �¼��� ¦���� �� �������Ƿ� ������ ������ �ʴ´�.
				return Power(x, n / 2) * Power(x, n / 2); // ����Լ���, ���ڿ� x�� ���� �־��ֵ�, n�� ���� 2�γ����� �־��ش�.
			} else // �¼��� Ȧ���� 1.5�� ���� ���� �ǰ� n�� integer�̱� ������ ������ �����.
				return x * Power(x, n / 2) * Power(x, n / 2); // ���� x�� �ѹ� �����ְ� ����Լ��� �����Ѵ�.
		}
	}
}