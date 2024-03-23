#include <iostream>

using namespace std;

// windows's end of file is ctrl+z, unix, linux, Mac OX is ctrl+d

int main()
{
    int sum = 0, value = 0;

    while(cin >> value){

        sum += value;
    }

    cout << "sum of integer number is:" << sum << endl;

    return 0;
}