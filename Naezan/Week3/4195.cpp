#include <bits/stdc++.h>

using namespace std;

int T;

unordered_map<string, string> parent;
unordered_map<string, int> nodes;

string GetParent(const string& id)
{
	if (parent[id] == id)
	{
		return id;
	}

	return parent[id] = GetParent(parent[id]);
}

void SetParent(const string& id1, const string& id2)
{
	string i1 = GetParent(id1);
	string i2 = GetParent(id2);

	if (i1 != i2)
	{
		parent[i1] = i2;
		nodes[i2] += nodes[i1];
	}
}

void Init(const string& id)
{
	if (parent.count(id) == 0)
	{
		parent[id] = id;
		nodes[id] = 1;
	}
}

int main()
{
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	std::cout.tie(nullptr);

	cin >> T;

	for (int i = 0; i < T; ++i)
	{
		int F;
		cin >> F;

		for (int j = 0; j < F; ++j)
		{
			string s1, s2;
			cin >> s1 >> s2;

			Init(s1);
			Init(s2);

			//�θ� ����
			SetParent(s1, s2);

			//���谡 ������ �׳� �ϳ��� ���
			string p1 = GetParent(s1);
			string p2 = GetParent(s2);
			if (p1 == p2)
			{
				cout << nodes[p1] << '\n';
			}
			//���谡 ������ ���� ���ؼ� ���
			else
			{
				cout << nodes[p1] + nodes[p2] << '\n';
			}
		}

		parent.clear();
		nodes.clear();
	}

	return 0;
}