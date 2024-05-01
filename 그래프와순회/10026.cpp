#include <iostream>
#include <vector>

using namespace std;

int N;
vector<vector<char>> graph;
vector<vector<bool>> visited;

void DFS(int x, int y, char color, bool blind)
{
    int dx[4] = {0, 0, -1, 1};
    int dy[4] = {1, -1, 0, 0}; // 상하좌우

    visited[x][y] = true;
    for (int dir = 0; dir < 4; dir++)
    {
        int nx = x + dx[dir];
        int ny = y + dy[dir];
        if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[nx][ny])
        {
            if (blind) // 색약
            {
                if ((color == 'R' && (graph[nx][ny] == 'R' || graph[nx][ny] == 'G')) || (color == 'B' && graph[nx][ny] == 'B'))
                    DFS(nx, ny, color, blind);
            }
            else // 정상
            {
                if (graph[nx][ny] == color)
                    DFS(nx, ny, color, blind);
            }
        }
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
                    cur_col = 'R'; // R==G로 취급

                DFS(i, j, cur_col, blind);
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