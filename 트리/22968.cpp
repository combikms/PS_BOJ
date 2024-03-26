#include <iostream>
#include <vector>
#include <cmath>
using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> minNodes;
    minNodes.push_back(0);
    minNodes.push_back(1);

    for (int i = 2; i < 50; i++)
    {
        minNodes.push_back(minNodes[i - 1] + minNodes[i - 2] + 1);
    }

    int T;
    cin >> T;

    for (int i = 0; i < T; i++)
    {
        long long int V;
        cin >> V;
        for (int h = 0; h <= 45; h++)
        {
            if (minNodes[h] == V)
            {
                cout << h << "\n";
                break;
            }
            else if (minNodes[h] >= V)
            {
                cout << h - 1 << "\n";
                break;
            }
        }
    }

    return 0;
}

// h:     0 1 2 3 4 5  6  7  8  9
// N(h)   0 1 2 4 7 12 20 33 54 88

// --> N(h)가 V 이상이 되는 가장 작은 h를 찾고, h-1을 출력한다.
// --> 단, V = N(h)면 그냥 h를 출력한다.