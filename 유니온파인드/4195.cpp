#include <iostream>
#include <vector>
#include <map>

using namespace std;

class UnionFind
{
private:
    vector<int> parent;
    vector<int> rank;
    vector<int> num;

public:
    friend int main();
    UnionFind(int n)
    {
        parent.resize(n);
        rank.resize(n, 0);
        num.resize(n, 1); // 추가: 속한 집단의 구성원 수

        // 초기 상태: 자기 자신을 대표로 설정
        for (int i = 0; i < n; ++i)
        {
            parent[i] = i;
        }
    }

    // 유니온 연산
    void unionSets(int a, int b)
    {
        int rootA = find(a);
        int rootB = find(b);

        // 랭크가 높은 집합이 낮은 집합을 흡수
        if (rootA != rootB)
        {
            int new_num = num[rootA] + num[rootB];
            num[rootA] = new_num;
            num[rootB] = new_num;

            if (rank[rootA] < rank[rootB])
            {
                parent[rootA] = rootB;
            }
            else if (rank[rootA] > rank[rootB])
            {
                parent[rootB] = rootA;
            }
            else
            {
                parent[rootA] = rootB; // B가 A를 흡수
                rank[rootB]++;         // B를 승급
            }
        }

        return;
    }

    // x가 속한 집합의 대표 찾기
    int find(int x)
    {
        if (parent[x] != x)
        {
            parent[x] = find(parent[x]); // 경로 압축
        }
        return parent[x];
    }
};

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    for (int i = 0; i < T; i++)
    {
        map<string, int> m;
        int idx = 0;

        int F;
        cin >> F;
        UnionFind uf(2 * F); // 최대 사람 수

        for (int j = 0; j < F; j++)
        {
            string p1, p2;
            cin >> p1 >> p2;

            // 맵에 집어넣어서 숫자화하기
            if (m.find(p1) == m.end())
            {
                m[p1] = idx;
                idx++;
            }
            if (m.find(p2) == m.end())
            {
                m[p2] = idx;
                idx++;
            }

            uf.unionSets(m[p1], m[p2]);
            cout << uf.num[uf.find(m[p1])] << "\n";
        }
    }

    return 0;
}