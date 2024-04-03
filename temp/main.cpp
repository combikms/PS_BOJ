#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<vector<int>> app;
    int T;
    cin >> T;

    for (int i = 0; i < T; i++)
    {
        int N;
        cin >> N;
        app.resize(N);

        for (int i = 0; i < N; i++)
        {
            cin >> app[i][0] >> app[i][1];
        }
    }

    return 0;
}