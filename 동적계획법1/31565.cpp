#include <iostream>
#include <vector>
#include <chrono>
#include <iomanip>

using namespace std;

// 1: 휴가 +V일
// 2: 군기교육대 +G일
// 3: 전문하사 +M개월

struct soldier
{
    int year;
    int month;
    int day;
};

int JamDifference(soldier A, soldier B)
{
    tm time1 = {0, 0, 0, A.day, A.month - 1, A.year - 1900};
    tm time2 = {0, 0, 0, B.day, B.month - 1, B.year - 1900};
    time_t time1_seconds = mktime(&time1);
    time_t time2_seconds = mktime(&time2);

    const int seconds_per_day = 60 * 60 * 24;
    time_t difference = difftime(time2_seconds, time1_seconds);
    return abs(difference / seconds_per_day);
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 종현(선임)
    soldier jonghyun;
    cin >> jonghyun.year >> jonghyun.month >> jonghyun.day;

    // 영도(후임)
    soldier youngdo;
    cin >> youngdo.year >> youngdo.month >> youngdo.day;

    int goal = JamDifference(youngdo, jonghyun);

    int T, N;
    cin >> T >> N;

    vector<int> cost;
    vector<int> day;

    cost.push_back(0);
    day.push_back(0);

    for (int i = 1; i <= N; i++)
    {
        // 방법, 여유, 일수
        int opt, C, D;
        cin >> opt >> C >> D;
        if (opt == 3)
            D *= 30;

        cost.push_back(C);
        day.push_back(D);
    }

    vector<vector<int>> dp(N + 1, vector<int>(T + 1, 0));
    for (int i = 1; i <= N; i++)
    {
        for (int j = 1; j <= T; j++)
        {
            if (cost[i] > j)
            {
                dp[i][j] = dp[i - 1][j];
            }
            else
            {
                dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - cost[i]] + day[i]);
            }
        }
    }

    cout << abs(goal - dp[N][T]) << "\n";

    return 0;
}