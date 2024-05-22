#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int R, C;
int ans = 0;

vector<vector<char>> graph;
vector<vector<bool>> visited;
vector<bool> alphabet(26, false);

void DFS(int x, int y, int count)
{
    ans = max(ans, count);
    visited[x][y] = true;
    int dx[4] = {0, 0, -1, 1}; // 좌우
    int dy[4] = {1, -1, 0, 0}; // 상하

    for (int dir = 0; dir < 4; dir++)
    {
        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if (nx >= 0 && nx < R && ny >= 0 && ny < C && !visited[nx][ny])
        {
            int nAlphabet = graph[nx][ny] - 'A';
            if (!alphabet[nAlphabet])
            {
                alphabet[nAlphabet] = true;
                DFS(nx, ny, count + 1);
                alphabet[nAlphabet] = false;
            }
        }
    }
    visited[x][y] = false; // 백트래킹
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> R >> C;
    graph.resize(R, vector<char>(C));
    visited.resize(R, vector<bool>(C, false));
    for (int i = 0; i < R; i++)
    {
        for (int j = 0; j < C; j++)
        {
            cin >> graph[i][j];
        }
    }

    alphabet[graph[0][0] - 'A'] = true; // 시작 지점
    DFS(0, 0, 1);
    cout << ans << "\n";
    return 0;
}
