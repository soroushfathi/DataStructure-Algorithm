package recursion;

import java.util.Arrays;

public class Maxxer {
    public static int max(int[] arr){
        if(arr.length==1) return arr[0];
        int middle = arr.length/2;
        int rightMax = max(Arrays.copyOfRange(arr, middle, arr.length));
        int leftMax = max(Arrays.copyOf(arr, middle));
        return Math.max(rightMax, leftMax);
    }
}
