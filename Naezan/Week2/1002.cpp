#include <bits/stdc++.h>

using namespace std;

int T;

int main()
{
	cin >> T;

	for (int i = 0; i < T; ++i)
	{
		int x1, y1, r1, x2, y2, r2;

		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

		int dd = pow(x1 - x2, 2) + pow(y1 - y2, 2);
		int rr = pow(r1 + r2, 2);
		int nrr = pow(r1 - r2, 2);

		//��ġ
		if (r1 == r2 && x1 == x2 && y1 == y2)
		{
			cout << "-1\n";
		}
		else
		{
			//������
			if (dd > rr)
			{
				cout << "0\n";
			}
			//����
			else if (dd == rr)
			{
				cout << "1\n";
			}
			else if (dd < rr)
			{
				//����
				if (dd < nrr)
				{
					cout << "0\n";
				}
				//����
				else if (dd == nrr)
				{
					cout << "1\n";
				}
				else
				{
					cout << "2\n";
				}
			}
		}
	}

	return 0;
}