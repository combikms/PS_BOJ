#include <iostream>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T = 0;
    cin >> T;

    int A = 0;
    int B = 0;
    for (int i = 0; i < T; i++)
    {
        cin >> A >> B;
        cout << A + B << "\n";
    }

    return 0;
}