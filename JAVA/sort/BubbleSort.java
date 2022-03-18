package sort;

public class BubbleSort {
    public static void bubbleSort(int[] array){
        int tmp;
        boolean swapped = false;
        for (int i = 0; i < array.length - 1; i++){
            for (int j = 0; j < array.length - i - 1; j++)
                if (array[j]>array[j+1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    swapped = true;
                }
            if (!swapped) // if array is sorted, it will be break at the fist loop
                break;
        }
    }

    public static void main(String[] args) {

    }
}
