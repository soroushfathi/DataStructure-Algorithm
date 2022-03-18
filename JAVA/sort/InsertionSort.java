package sort;

import java.util.Arrays;

public class InsertionSort {
    public static int[] insertionSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && key<array[j]){
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = key;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4, 1, 8, 2, 5};
        System.out.println(Arrays.toString(insertionSort(array)));
    }
}
