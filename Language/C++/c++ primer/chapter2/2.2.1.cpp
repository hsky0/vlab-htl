#include <iostream>


using namespace std;


/*******variable type*******/
// int main()
// {

//     unsigned char a = -1;
//     signed char b = 256;

//     cout << "a = " << a << endl;
//     cout << "b = " << b << endl;

//     unsigned u = 10;
//     int i = -42;
//     cout << i + i << endl;
//     cout << u + i << endl;
//     cout << "the size of unsigned = " << sizeof(u) << endl;
//     cout << "the size of int = " << sizeof(i) << endl;

//     unsigned maxnum = -32;
//     cout << maxnum << endl;
    
//     return 0;
// }


/*****Initialization 1*****/
// int main()
// {

//     int var1 = 1;
//     int var2 = {2};
//     int var3{3};
//     int var4(4);
//     int var5 = (5);

//     cout << "var1 = " << var1 << endl;
//     cout << "var2 = " << var2 << endl;
//     cout << "var3 = " << var3 << endl;
//     cout << "var4 = " << var4 << endl;
//     cout << "var5 = " << var5 << endl;

//     return 0;
// }

/*****Initialization 2*****/
// int main()
// {

//     long double ld = 3.1415926536;
//     int a{ld}, b = {ld};
//     int c(ld), d = ld;

//     cout << "ld = " << ld << "a = " << a << "b = " << b << "c = " << c << "d = " << d << endl;

//     return 0;
// }


/*****Initialization 3*****/
int main()
{

    string book("0-201-78345-x");

    cout << book << endl;

    return 0;
}