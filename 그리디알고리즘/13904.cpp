#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    vector<pair<int, int>> hw(N); // 마감일, 점수
    for (int i = 0; i < N; i++)
        cin >> hw[i].first >> hw[i].second;

    sort(hw.begin(), hw.end());                        // 일단 임박한 것부터 건드려보기
    priority_queue<int, vector<int>, greater<int>> pq; // 덜 중요한 건 포기하기

    for (int i = 0; i <= N; i++)
    {
        int score = hw[i].second;
        int deadline = hw[i].first;

        if (pq.size() < deadline)
            pq.push(score);
        else if (!pq.empty() && pq.top() < score)
        {
            pq.pop();
            pq.push(score);
        }
    }

    int sum = 0;
    while (!pq.empty())
    {
        sum += pq.top();
        pq.pop();
    }

    cout << sum << "\n";

    return 0;
}