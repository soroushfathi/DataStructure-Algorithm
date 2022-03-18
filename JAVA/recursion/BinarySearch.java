package recursion;

public class BinarySearch {
    public static int search(int[] array, int right, int left,int value){
        if(right>=left){
            int mid = (right+left)/2;
            if (array[mid]==value)
                return mid;
            if (array[mid]>value)
                return search(array, left, mid-1, value);
            return search(array, mid+1, right, value);
        }
        return -1;
    }
}
