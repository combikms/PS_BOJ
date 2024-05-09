#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

struct Edge
{
    int to;     // 어디로
    int weight; // 비용
};

vector<int> dijkstra(const vector<vector<Edge>> &graph, int start)
{
    int n = graph.size();             // 정점 개수
    vector<int> distance(n, INT_MAX); // 거기까지의 최단 거리
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

    distance[start] = 0;
    pq.push({0, start});

    while (!pq.empty())
    {
        int dist = pq.top().first;
        int node = pq.top().second;
        pq.pop();

        // 시간 초과 난다길래 이미 방문한 곳은 안 가기로 함
        if (dist > distance[node])
            continue;

        for (const Edge &edge : graph[node])
        {
            if (dist + edge.weight < distance[edge.to])
            {
                distance[edge.to] = dist + edge.weight;
                pq.push({distance[edge.to], edge.to});
            }
        }
    }

    return distance;
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
    vector<int> ans = dijkstra(graph, start);

    cout << ans[end] << "\n";
    return 0;
}