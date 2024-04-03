#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void DownHeap(vector<int> &A, int i, int heapSize)
{
    int child = 2 * i;
    int right = 2 * i + 1;

    if (child <= heapSize)
    {
        if (right <= heapSize && A[child] < A[right])
            child = right;
        if (A[i] < A[child])
        {
            swap(A[i], A[child]);
            DownHeap(A, child, heapSize);
        }
    }
}

void BuildHeap(vector<int> &A)
{
    int m = A.size() / 2;
    for (int i = m; i >= 1; i--)
        DownHeap(A, i, A.size() - 1);
}

void HeapSort(vector<int> &A)
{
    BuildHeap(A);
    int heapSize = A.size() - 1;
    for (int i = 1; i <= A.size() - 1; i++)
    {
        swap(A[1], A[heapSize]);
        heapSize--;
        DownHeap(A, 1, heapSize);
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    vector<int> A;
    A.push_back(0);

    int N;
    cin >> N;

    for (int i = 0; i < N; i++)
    {
        int input;
        cin >> input;
        A.push_back(input);
    }

    HeapSort(A);

    for (int i = 1; i <= N; i++)
    {
        cout << A[i] << "\n";
    }

    // vector<vector<int>> app;
    // int T;
    // cin >> T;

    // for (int i = 0; i < T; i++)
    // {
    //     int N;
    //     cin >> N;
    //     app.resize(N);

    //     for (int i = 0; i < N; i++)
    //     {
    //         cin >> app[i][0] >> app[i][1];
    //     }
    // }

    return 0;
}