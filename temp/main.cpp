#include <iostream>
#include <vector>

using namespace std;

class UnionFind
{
private:
    vector<int> parent;
    vector<int> rank;

public:
    UnionFind(int n)
    {
        parent.resize(n);
        rank.resize(n, 0);

        // 초기 상태: 모든 원소는 자신을 루트로 가리킴
        for (int i = 0; i < n; ++i)
        {
            parent[i] = i;
        }
    }

    // 두 원소가 속한 집합을 합침
    void unionSets(int a, int b)
    {
        int rootA = find(a);
        int rootB = find(b);

        // 랭크가 더 낮은 집합이 더 높은 집합을 흡수
        if (rootA != rootB)
        {
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
                parent[rootA] = rootB;
                rank[rootB]++;
            }
        }
        else
        {
            return;
        }
    }

    // 원소 x가 속한 집합의 루트(부모)를 찾음
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

    UnionFind uf(5); // 5개의 원소를 갖는 Union-Find 자료 구조 생성

    // union 연산 수행
    uf.unionSets(0, 1);
    uf.unionSets(2, 3);
    uf.unionSets(0, 4);

    // find 연산 수행
    cout << "Find(1): " << uf.find(1) << "\n"; // 0과 합쳐져 있으므로 0의 루트를 반환
    cout << "Find(2): " << uf.find(2) << "\n"; // 자기 자신이 루트이므로 2의 루트를 반환

    return 0;
}
