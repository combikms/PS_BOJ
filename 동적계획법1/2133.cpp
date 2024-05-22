#include <iostream>
#include <vector>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N;
    cin >> N;

    if (N % 2 != 0)
    { // N이 홀수면 타일을 못 깐다고 함
        cout << 0 << "\n";
        return 0;
    }

    vector<long long> dp(35);
    dp[0] = 1; // 아무것도 채우지 않는 경우도 1가지 방법으로 간주
    if (N >= 2)
        dp[2] = 3; // 이건 사전에 알고 있어야 함

    for (int i = 4; i <= N; i += 2) // 뇌피셜로 푸니까 하도 틀려가지고 인터넷 찾아봤음..
    {
        dp[i] = dp[i - 2] * dp[2];
        for (int j = i - 4; j >= 0; j = j - 2)
            dp[i] = dp[i] + (dp[j] * 2);
    }

    cout << dp[N] << "\n";
    return 0;
}