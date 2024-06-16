#include<bits/stdc++.h>
using namespace std;

int main()
{
	ios_base::sync_with_stdio(0);
	cin.tie(0); cout.tie(0);

	int n, x;
	
	priority_queue<int, vector<int>, greater<int>> positive; //���
	priority_queue<int> negative;//����

	vector<int> ans;
	
	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> x;

		if (x > 0)
		{
			positive.push(x);
		}
		else if (x < 0)
		{
			negative.push(x);
		}
		else
		{
			//�Ѵ� ���������
			if (positive.size() == 0 && negative.size() == 0)
			{
				cout << "0\n";
			}
			//����迭�� ����ְ� �����迭�� ������������� 
			else if (positive.size() == 0 && negative.size() != 0)
			{
				cout << negative.top() << "\n";
				negative.pop();
			}
			//����迭�� ��������ʰ� �����迭�� ���������
			else if (positive.size() != 0 && negative.size() == 0)
			{
				cout << positive.top() << "\n";
				positive.pop();
			}
			//�迭 �ΰ��� ������� ������
			else
			{
				if (abs(negative.top()) <= positive.top())
				{
					cout << negative.top() << "\n";
					negative.pop();
				}
				else
				{
					cout << positive.top() << "\n";
					positive.pop();
				}
			}
		}
	}

	return 0;
}
