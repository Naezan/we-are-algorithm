#include <bits/stdc++.h>

using namespace std;

int N, M, k;
long long ans;

bool check[10'001];
int cost[10'001];
vector<int> relation[10'001];

int main()
{
	std::ios::sync_with_stdio(false);
	std::cin.tie(nullptr);
	std::cout.tie(nullptr);

	cin >> N >> M >> k;

	for (int i = 1; i <= N; ++i)
	{
		cin >> cost[i];
	}

	for (int i = 0; i < M; ++i)
	{
		int v, w;
		cin >> v >> w;
		relation[v].emplace_back(w);
		relation[w].emplace_back(v);
	}

	for (int i = 1; i <= N; ++i)
	{
		if (check[i])
		{
			continue;
		}
		check[i] = true;

		//���谡 ���ٸ� ���� ģ���� ���ϱ�
		if (relation[i].empty())
		{
			ans += cost[i];
			continue;
		}

		queue<int> q;
		int smallcost = cost[i];

		q.push(i);

		//BFS�� ���� �� ��� Ž��
		while (!q.empty())
		{
			int idx = q.front();
			q.pop();

			for (auto iter = relation[idx].begin(); iter != relation[idx].end(); ++iter)
			{
				if (check[*iter])
				{
					continue;
				}

				check[*iter] = true;

				//�ڱ� �ڽ� ����
				if (*iter == idx)
				{
					continue;
				}

				//���� �� ��� ����
				if (cost[*iter] < smallcost)
				{
					smallcost = cost[*iter];
				}

				q.push(*iter);
			}
		}

		//���� �� ��� ������Ʈ
		ans += smallcost;
	}

	if (ans <= k)
	{
		cout << ans;
	}
	else
	{
		cout << "Oh no";
	}

	return 0;
}