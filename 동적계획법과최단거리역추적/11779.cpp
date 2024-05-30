#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <stack>
#include <algorithm>

using namespace std;

struct Edge
{
    int to;
    int weight;
};

vector<int> dijkstra(const vector<vector<Edge>> &graph, int start, vector<int> &prev)
{
    int n = graph.size();
    vector<int> distance(n, INT_MAX);
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    distance[start] = 0;
    pq.push({0, start});
    prev[start] = start; // 시작 지점은 자기 자신으로 설정

    while (!pq.empty())
    {
        int dist = pq.top().first;
        int node = pq.top().second;
        pq.pop();

        if (dist > distance[node])
            continue;

        for (const Edge &edge : graph[node])
        {
            if (dist + edge.weight < distance[edge.to])
            {
                distance[edge.to] = dist + edge.weight;
                prev[edge.to] = node;
                pq.push({distance[edge.to], edge.to});
            }
        }
    }

    return distance;
}

vector<int> Calc_Path(int start, int end, const vector<int> &prev)
{
    vector<int> path;
    for (int at = end; at != start; at = prev[at])
    {
        if (at == -1)
            return {}; // 경로 없음
        path.push_back(at);
    }
    path.push_back(start); // 시작점 추가
    reverse(path.begin(), path.end());
    return path;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<vector<Edge>> graph(N + 1);
    for (int i = 0; i < M; i++)
    {
        int num, to, weight;
        cin >> num >> to >> weight;
        graph[num].push_back({to, weight});
    }

    int start, end;
    cin >> start >> end;
    vector<int> prev(N + 1, -1);
    vector<int> ans = dijkstra(graph, start, prev);

    cout << ans[end] << "\n";
    vector<int> path = Calc_Path(start, end, prev);

    cout << path.size() << "\n";

    for (int node : path)
        cout << node << " ";

    cout << "\n";
    return 0;
}