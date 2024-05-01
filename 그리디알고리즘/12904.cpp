#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string s, t;
    cin >> s >> t;

    // t에서 거꾸로 s로 돌리는 방법으로 바꿈
    while (t.size() > s.size())
    {
        if (t.back() == 'A')
        {
            t.pop_back(); // A를 제거
        }
        else if (t.back() == 'B')
        {
            t.pop_back();                // B 제거
            reverse(t.begin(), t.end()); // 뒤집기
        }
    }

    if (s == t)
    {
        cout << 1 << endl;
    }
    else
    {
        cout << 0 << endl;
    }

    return 0;
}
