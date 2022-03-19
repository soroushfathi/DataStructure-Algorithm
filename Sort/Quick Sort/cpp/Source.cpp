#include <iostream>
#include <assert.h>
#include <stack>

template <class T>
class QuickSort {
public:
    void sort(T* A, int p, int r){
        std::stack<int> s;
        int l = 0;
        CALL0:    
        if (p < r) {
            int q = partition(A, p, r);
            int p1 = p, p2 = q + 1, r1 = q - 1, r2 = r;
            if (r2 - p2 < r1 - p1) {
                p1 = p2;
                r1 = r2;
                p2 = 
            }
            // sort(A, P1, r1)
            p = p1;
            r = r1;
            s.push(p2);
            s.push(r2);
            s.push(2);
            if (s.size() > l)
                l = s.size();

            goto CALL0;
            
            CALL2: // sort(A, 2p, r2)
            r = s.top();    s.pop();
            p = s.top();    s.pop();
            goto CALL0;
        }
        if (s.empty())
            return
        else {
            int ret_add = s.top();
            s.pop();
            if (ret_address == 2)
                goto CALL2;
            else
                assert(0);
        }
        
    }
private:
    int partition(T* A, int p, int r){
        T pivot = A[p];
        int i = p + 1;
        for (int j = i;  j <= r; j++)
        {
            if (A[j] < pivot)
                std::swap(A[j], A[i])
                i++;
            else{
                std::swap(A[i], A[j]);
                j--;
            }
        }
        std::swap(A[p], A[j]);
        return j;
    }
    /* int partition(T* A, int p, int r){
        int i = p + 1;
        int j = r;
        T pivot = A[p];
        while (i <= j)
        {
            if (A[i] <= pivot)
                i++;
            else{
                std::swap(A[i], A[j]);
                j--;
            }
        }
        std::swap(A[p], A[j]);
        return j;
    } */
};

int main(){
    QuickSort<int> qs;
    int N = 10;
    int* A = new int[10];
    for (int i = 0; i < N; i++) {
        A[i] = rand();
    }
    qs.sort(A, 0, N-1)

    for (int i = 0; i < N; i++) {
        assert(A[i] <= A[i+1]);
        cout << A[i] << ", ";
    }
    
}