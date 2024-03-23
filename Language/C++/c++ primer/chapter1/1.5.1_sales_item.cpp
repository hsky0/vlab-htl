#include <iostream>
#include "Sales_item.h"

using namespace std;

/*add two Sales_item*/
// int main()
// {

//     Sales_item item1, item2;

//     cin >> item1 >> item2;
//     cout << item1 + item2 << endl;

//     return 0;
// }


/*using member function*/
int main()
{

    Sales_item item, item1, item2;

    cin >> item1 >> item2;
    if(item1.isbn() == item2.isbn()){
        cout << item1 + item2 << endl;
        return 0;
    }
    else{
        cerr << "ISBN is no same" << endl;
        return -1;
    }

    
}