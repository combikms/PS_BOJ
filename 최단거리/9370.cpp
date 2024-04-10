#include <iostream>
#include <vector>
#include <queue>
#include <climits>

using namespace std;

void DownHeap(vector<int> &A, int i, int heapSize)
{
    int child = 2 * i;
    int right = 2 * i + 1;

    if (child <= heapSize)
    {
        if (right <= heapSize && A[child] < A[right])
            child = right;
        if (A[i] < A[child])
        {
            swap(A[i], A[child]);
            DownHeap(A, child, heapSize);
        }
    }
}

void BuildHeap(vector<int> &A)
{
    int m = A.size() / 2;
    for (int i = m; i >= 1; i--)
        DownHeap(A, i, A.size() - 1);
}

void HeapSort(vector<int> &A)
{
    BuildHeap(A);
    int heapSize = A.size() - 1;
    for (int i = 1; i <= A.size() - 1; i++)
    {
        swap(A[1], A[heapSize]);
        heapSize--;
        DownHeap(A, 1, heapSize);
    }
}

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

    int T;
    cin >> T;

    for (int i = 0; i < T; i++)
    {

        int n, m, t; // 개수: 교차로, 도로, 후보 목적지
        cin >> n >> m >> t;

        vector<vector<Edge>> graph(n + 1);

        int s, g, h; // 출발지, 냄새 감지를 감지한 도로의 시작 및 종착지
        cin >> s >> g >> h;

        int k;
        for (int j = 0; j < m; j++)
        {
            int a, b, d; // a와 b 사이에 양방향 간선(w=d)이 존재
            cin >> a >> b >> d;

            if ((a == g && b == h) || (b == g && a == h))
            {
                k = d;
            }

            graph[a].push_back({b, d});
            graph[b].push_back({a, d});
        }

        vector<int> cand_dist;
        for (int j = 0; j < t; j++)
        {
            int x; // 목적지 후보들
            cin >> x;
            cand_dist.push_back(x);
        }

        vector<int> shortest = dijkstra(graph, s);
        vector<int> shortest_g = dijkstra(graph, g);
        vector<int> shortest_h = dijkstra(graph, h);

        vector<int> ans;
        ans.push_back(0);
        for (int i = 0; i < cand_dist.size(); i++)
        {
            int path1 = (shortest[g] + k) + (shortest_h[cand_dist[i]]); // g-h루트 타기
            int path2 = (shortest[h] + k) + (shortest_g[cand_dist[i]]); // h-g루트 타기
            if (path1 == shortest[cand_dist[i]] || path2 == shortest[cand_dist[i]])
            {
                ans.push_back(cand_dist[i]);
            }
        }

        HeapSort(ans);
        for (int i = 1; i < ans.size(); i++)
        {
            cout << ans[i] << " ";
        }
        cout << "\n";
    }

    return 0;
}

// 6 9 2
// 2 3 1
// 1 2 1
// 1 3 3
// 2 4 4
// 2 5 5
// 3 4 3
// 3 6 2
// 4 5 4
// 4 6 3
// 5 6 7
// 5
// 6