#include <iostream>
#include <vector>
#include <algorithm>
#include <climits>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, k; // 동전 종류, 목표 가치
    cin >> n >> k;

    vector<int> coins(n);
    for (int i = 0; i < n; i++)
        cin >> coins[i];

    vector<int> dp(k + 1, INT_MAX);
    dp[0] = 0;

    for (int coin : coins)
        for (int i = coin; i <= k; i++)
            if (dp[i - coin] != INT_MAX)
                dp[i] = min(dp[i], dp[i - coin] + 1);

    if (dp[k] == INT_MAX)
        cout << -1 << "\n";
    else
        cout << dp[k] << "\n";

    return 0;
}