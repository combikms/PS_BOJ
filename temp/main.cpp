#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N = 0;
int K = 0;
vector<int> road;
queue<int> q;

void BFS(int start)
{
    road[start] = 1;
    q.push(start);

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        if (cur == K)
            break;

        // 순간 이동
        if (cur * 2 < road.size() && road[cur * 2] == 0)
        {
            road[cur * 2] = road[cur];
            q.push(cur * 2);
        }

        // 앞으로
        if (cur + 1 < road.size() && road[cur + 1] == 0)
        {
            road[cur + 1] = road[cur] + 1;
            q.push(cur + 1);
        }

        // 뒤로
        if (cur - 1 >= 0 && road[cur - 1] == 0)
        {
            road[cur - 1] = road[cur] + 1;
            q.push(cur - 1);
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N >> K;
    road.resize(max(N, K) * 2 + 1);

    BFS(N);

    cout << road[K] - 1 << "\n";

    return 0;
}