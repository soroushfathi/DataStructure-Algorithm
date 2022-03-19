#ifndef TEST_FIVEWAYPARTITION_H
#define TEST_FIVEWAYPARTITION_H

#endif //TEST_FIVEWAYPARTITION_H

template <class T>
class FiveWayPartition{
public:
    void swap(int* a, int* b)
    {
        int temp = *a;
        *a = *b;
        *b = temp;
    }
    int Partition(T *arr, int low, int high, T *lp){
        if (arr[low] > arr[high])
            swap(&arr[low], &arr[high]);
        int j =  low+1;
        int g = high - 1, k = low + 1, p = arr[low], q = arr[high];
        while (k<=g){
            if (arr[k] < p){
                swap(&arr[k], &arr[j]);
                j++;
            } else if(arr[k] >= q){
                while (arr[g] > q && k < g)
                    g--;
                swap(&arr[k], &arr[g]);
                g--;
                if(arr[k] < p){
                    swap(&arr[k], &arr[j]);
                    j++;
                }
            }
            k++;
        }
        j--;
        g++;

        swap(&arr[low], &arr[j]);
        swap(&arr[high], &arr[g]);
        *lp = j;
        return g;
    }
};