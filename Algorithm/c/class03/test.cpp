#include <iostream>

using namespace std;


int test(int &x){

    x = 356;
    cout << "test x = " << x << endl;

    return 0;
}

int main(){


    int x = 123;
    cout << "main x = " << x << endl;
    test(x);
    cout << "called test in main x = " << x << endl;

    return 0;
}