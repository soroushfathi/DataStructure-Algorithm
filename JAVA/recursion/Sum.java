package recursion;

import java.util.Arrays;

public class Sum {
    /**
     * T(n)=O(n), S(n)=O(n^2)
     * @param array array of int
     * @return the sum of array integers
     */
    public static int sum(int[] array){
        int n = array.length;
        if(n==1)
            return array[0];
//        return array[n-1] + sum()
        return array[array.length-1] + sum(Arrays.copyOf(array, array.length - 1));
    }

    public static void main(String[] args) {
        System.out.println(sum(new int[]{1, 2, 3, 4, 5}));
    }
}
