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

    int V, E;
    cin >> V >> E;

    vector<vector<Edge>> graph(V);

    int start;
    cin >> start;

    for (int i = 0; i < E; i++)
    {
        int u, v, w;
        cin >> u >> v >> w;

        graph[u - 1].push_back({v - 1, w});
    }

    vector<int> ans = dijkstra(graph, start - 1);
    for (int i = 0; i < V; i++)
    {
        if (ans[i] == INT_MAX)
        {
            cout << "INF"
                 << "\n";
        }
        else
        {
            cout << ans[i] << "\n";
        }
    }

    return 0;
}