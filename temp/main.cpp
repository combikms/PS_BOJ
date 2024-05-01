#include <iostream>
#include <vector>

using namespace std;

int N;
vector<vector<char>> graph;
vector<vector<bool>> visited;

void DFS(int x, int y, char color)
{
    int dx[4] = {0, 0, -1, 1};
    int dy[4] = {1, -1, 0, 0}; // 상하좌우

    visited[x][y] = true;
    for (int dir = 0; dir < 4; dir++)
    {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny] && graph[nx][ny] == color)
            DFS(nx, ny, color);
    }
}

int countAreas(bool blind)
{
    visited.assign(N, vector<bool>(N, false));
    int areas = 0;

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            if (!visited[i][j])
            {
                char cur_col = graph[i][j];
                if (blind && (cur_col == 'R' || cur_col == 'G'))
                    cur_col = 'R'; // R==G 로 취급함

                DFS(i, j, cur_col);
                areas++;
            }

    return areas;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    graph.resize(N, vector<char>(N));

    for (int i = 0; i < N; i++)
        for (int j = 0; j < N; j++)
            cin >> graph[i][j];

    cout << countAreas(false) << " " << countAreas(true) << "\n";

    return 0;
}