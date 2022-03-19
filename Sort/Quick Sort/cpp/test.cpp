#include "DualPivotQuickSort.h"
#include <stdio.h>

#using namespace std

int main(){
    int arr[] = {11, 7, 3, 6, 9, 2};
    DualPivotQuickSort<int> dpq;
    dpq.DualPivotQuickSort(&arr, 0, 6);
    for (int i = 0; i < 6; i++) {
        cout << arr[i] << " ";
    }
    
    return 0;
}