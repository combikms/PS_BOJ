#include <iostream>
#include <vector>
using namespace std;

// 1면: 5 * (n-2) * (n-2) + 4 * (n-2)
// 2면: 8 * (n-2) + 4
// 3면: 4

// 3면: min(CAB, CBF, CFE, CEA, DEA, DEF, DBF, DAB) => 8
// 2면: min(DA, DE, DB, DF, AB, AE, BF, FE, CA, CB, CF, CE) => 12
// 1면: min(A,B,C,D,E)

long long int N;
vector<long> noon;

// A B C D E F
// 0 1 2 3 4 5

long long int three()
{
    long long int combinations[8] = {
        noon[2] + noon[0] + noon[1],
        noon[2] + noon[1] + noon[5],
        noon[2] + noon[5] + noon[4],
        noon[2] + noon[0] + noon[4],
        noon[3] + noon[4] + noon[0],
        noon[3] + noon[4] + noon[5],
        noon[1] + noon[3] + noon[5],
        noon[0] + noon[1] + noon[3]};

    long long int min = combinations[0];
    for (int i = 0; i < 8; i++)
        if (combinations[i] < min)
            min = combinations[i];
    return min;
}

long long int two()
{
    long long int combinations[12] = {
        noon[3] + noon[0],
        noon[3] + noon[1],
        noon[3] + noon[4],
        noon[3] + noon[5],
        noon[0] + noon[1],
        noon[0] + noon[4],
        noon[4] + noon[5],
        noon[1] + noon[5],
        noon[2] + noon[0],
        noon[2] + noon[1],
        noon[2] + noon[4],
        noon[2] + noon[5]};

    long long int min = combinations[0];
    for (int i = 0; i < 12; i++)
        if (combinations[i] < min)
            min = combinations[i];
    return min;
}

long long int one()
{
    long long int min = noon[0];
    for (int i = 0; i < 6; i++)
        if (noon[i] < min)
            min = noon[i];
    return min;
}

long long int max()
{
    long long int max = noon[0];
    for (int i = 0; i < 6; i++)
        if (noon[i] > max)
            max = noon[i];
    return max;
}

long long int result()
{
    return (5 * (N - 2) * (N - 2) + 4 * (N - 2)) * one() + (8 * (N - 2) + 4) * two() + 4 * three();
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> N;
    for (int i = 0; i < 6; i++)
    {
        int input;
        cin >> input;
        noon.push_back(input);
    }

    if (N != 1)
        cout << result() << "\n";
    else
        cout << noon[0] + noon[1] + noon[2] + noon[3] + noon[4] + noon[5] - max() << "\n";

    return 0;
}