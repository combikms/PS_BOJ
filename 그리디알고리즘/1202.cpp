#include <iostream>
#include <vector>
#include <algorithm>
#include <queue>

using namespace std;

struct Jewel
{
    int weight;
    int value;
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    // 개수
    int N, K;
    cin >> N >> K;

    vector<Jewel> jewels(N);
    vector<int> bags(K);

    // 보석(무게, 가치)
    for (int i = 0; i < N; i++)
        cin >> jewels[i].weight >> jewels[i].value;

    // 가방(무게 제한)
    for (int i = 0; i < K; i++)
        cin >> bags[i];

    // 무게 기준 오름차순 정렬
    sort(jewels.begin(), jewels.end(), [](const Jewel &a, const Jewel &b)
         { return a.weight < b.weight; });
    sort(bags.begin(), bags.end());

    // 필요한 자료구조
    priority_queue<int> pq;
    long long sum = 0;
    int idx = 0;

    for (int i = 0; i < K; i++)
    {
        // 넣을 수 있는 보석들 다 추가 (비싼 게 우선순위가 젤 높게 들어감)
        while (idx < N && jewels[idx].weight <= bags[i])
        {
            pq.push(jewels[idx].value);
            idx++;
        }

        // 젤 비싼거 빼다가 가방에 집어넣기
        if (!pq.empty())
        {
            sum += pq.top();
            pq.pop();
        }
    }

    cout << sum << "\n";
    return 0;
}