package sort;

public class SelectionSort {
    public static void selectionSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) {
            int min_index = i;
            for (int j = i+1; j < array.length; j++)
                if(array[j]<array[min_index])
                    min_index = j;
            int temp = array[min_index];
            array[min_index] = array[i];
            array[i] = temp;
        }
    }
}
