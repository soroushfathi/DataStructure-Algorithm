#include <stdio.h>
#include "FiveWayPartition.h"
using namespace std;

template <class T>
class DualPivotQuickSort{
public:
    DualPivotQuickSort(){
        
    }
    void DualPivotQuickSort(int* arr, int low, int high){
        if (low < high) {
            int lp, rp;
            FiveWayPartition<int> *fiveWayPartition = new FiveWayPartition<int>();
            rp = FiveWayPartition->partition(arr, low, high, &lp);
            DualPivotQuickSort(arr, low, lp - 1);
            DualPivotQuickSort(arr, lp + 1, rp - 1);
            DualPivotQuickSort(arr, rp + 1, high);
        }
    }
};
