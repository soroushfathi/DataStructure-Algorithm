#pragma once

template <class T>
class ThreeWayPartition {
public:
	void Partition(T* arr, int n, T pivot, int& p1, int& p2) {
		int j = p1;
		p2 = n - 1;
		while (j<=p2) {
			if (arr[j]==pivot){
                T tmp = arr[j];
                arr[j] = arr[p2];
                arr[p2] = tmp;
				p2--;
			} else if (arr[j] < pivot) {
                T tmp = arr[p1];
                arr[p1] = arr[j];
                arr[j] = tmp;
				p1++;
				j++;
			} else if (arr[j]>pivot)
				j++;
		}
        p2++;
	}
};
