#include <iostream>
#include <vector>
#include <algorithm>
#include <cmath>
#include <climits>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int N, M;
    cin >> N >> M;

    vector<int> positives, negatives;
    int cost = 0;

    for (int i = 0; i < N; i++)
    {
        int input;
        cin >> input;
        if (input > 0)
            positives.push_back(input);
        else if (input < 0)
            negatives.push_back(-input);
    }

    sort(positives.begin(), positives.end(), greater<int>());
    sort(negatives.begin(), negatives.end(), greater<int>());

    // 가장 멀리 있는 곳에 갔다 오는 길에 M권씩 갖다 놓고 옴
    for (int i = 0; i < positives.size(); i += M)
    {
        cost += 2 * positives[i];
    }

    for (int i = 0; i < negatives.size(); i += M)
    {
        cost += 2 * negatives[i];
    }

    // 마지막에 0으로 돌아오는 거리는 빼야 함
    int maxDistance = 0;
    if (!positives.empty())
        maxDistance = positives[0];
    if (!negatives.empty() && negatives[0] > maxDistance)
        maxDistance = negatives[0];
    cost -= maxDistance;

    cout << cost << "\n";

    return 0;
}