#include <iostream>
#include <vector>
#include <algorithm>
#include <map>
#include <set>

using namespace std;

int N;
int K;
vector<string> numbers;
map<char, long long> gain;

void Cal_Gain()
{
    for (auto &num : numbers)
    {
        long long base = 1; // 36^0 부터 시작
        for (int i = num.size() - 1; i >= 0; --i)
        {
            char digit = num[i];
            // Z로 바꾸면 생기는 이득 == (35 - value[digit]) * base
            int digit_val = (isdigit(digit) ? digit - '0' : 10 + digit - 'A');
            gain[digit] += (35 - digit_val) * base;
            base *= 36;
        }
    }
}

long long Sum()
{
    // 이득이 큰 순서로 정렬
    vector<pair<char, long long>> digits_gain(gain.begin(), gain.end());
    sort(digits_gain.begin(), digits_gain.end(), [](const pair<char, long long> &a, const pair<char, long long> &b)
         { return a.second > b.second; });

    // 최대 K개 선택
    set<char> chosen;
    for (int i = 0; i < min(K, (int)digits_gain.size()); i++)
        chosen.insert(digits_gain[i].first);

    // 모든 수에 대해 계산
    long long total_sum = 0;
    for (auto &num : numbers)
    {
        long long num_value = 0;
        long long base = 1;
        for (int i = num.size() - 1; i >= 0; i--)
        {
            char digit = num[i];
            int value = (isdigit(digit) ? digit - '0' : 10 + digit - 'A');
            if (chosen.find(digit) != chosen.end())
                value = 35;

            num_value += value * base;
            base *= 36;
        }
        total_sum += num_value;
    }
    return total_sum;
}

string Ten_to_36(long long value)
{
    if (value == 0)
        return "0";
    string result;
    while (value > 0)
    {
        int digit = value % 36;
        if (digit < 10)
            result += '0' + digit;
        else
            result += 'A' + (digit - 10);
        value /= 36;
    }
    reverse(result.begin(), result.end());
    return result;
}

/***********************************************************************
 **********************************************************************/

void Input()
{
    cin >> N;
    numbers.resize(N);

    for (int i = 0; i < N; ++i)
        cin >> numbers[i];

    cin >> K;
}

void Solve()
{
    Cal_Gain();
    long long total = Sum();
    cout << Ten_to_36(total) << "\n";
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // freopen("Input.txt", "r", stdin);

    Input();
    Solve();

    return 0;
}