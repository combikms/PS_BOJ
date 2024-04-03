#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int N = 0;
int K = 0;
vector<int> road;
vector<bool> visited;
queue<int> q;

void BFS(int start)
{
    road[start] = 1;
    visited[start] = true;
    q.push(start);

    while (!q.empty())
    {
        int cur = q.front();
        q.pop();

        if (cur < K * 2 - 1)
        {
            if (!visited[cur + 1])
            {
                visited[cur + 1] = true;
                road[cur + 1] = road[cur] + 1;
                q.push(cur + 1);
            }
        }
        if (cur > 0)
        {
            if (!visited[cur - 1])
            {
                visited[cur - 1] = true;
                road[cur - 1] = road[cur] + 1;
                q.push(cur - 1);
            }
        }
        if (cur < K)
        {
            if (!visited[cur * 2])
            {
                visited[cur * 2] = true;
                road[cur * 2] = road[cur];
                q.push(cur * 2);
            }
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
    visited.resize(max(N, K) * 2 + 1);

    BFS(N);

    cout << road[K] - 1 << "\n";

    return 0;
}