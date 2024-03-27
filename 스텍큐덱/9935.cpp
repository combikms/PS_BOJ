#include <iostream>
#include <vector>
using namespace std;

vector<char> stack;
int sp = -1;

void PUSH(char X)
{
    stack.push_back(X);
    sp++;
}

void POP()
{
    stack.pop_back();
    sp--;
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    string input;
    cin >> input;

    string bomb;
    cin >> bomb;

    for (int i = 0; i < input.length(); i++)
    {
        PUSH(input[i]);
        bool isBOMB = true;
        if (sp >= bomb.length() - 1)
        {
            for (int j = sp, k = bomb.length() - 1; k >= 0; j--, k--)
            {
                if (stack[j] != bomb[k])
                {
                    isBOMB = false;
                    break;
                }
            }
            if (isBOMB)
            {
                for (int i = 0; i < bomb.length(); i++)
                {
                    POP();
                }
            }
        }
    }

    if (sp == -1)
        cout << "FRULA";
    else
        for (int i = 0; i < stack.size(); i++)
            cout << stack[i];

    cout << "\n";

    return 0;
}