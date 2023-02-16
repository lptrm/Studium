package Algorithmen;

import java.util.Arrays;

public class Sorting {
    public static void main(String[] args) {
        int[] target = {-3, 5, 3, 7, 9, -12 , 4, -8};
        SelectionSort(target);
        System.out.println(Arrays.toString(target));
    }
    public static void SelectionSort(int[] input){
        for (int i = 0; i < input.length-1; i++){
            int min = i;
            for (int j = i+1; j < input.length; j++){
                if (input[min]>input[j]){
                    min = j;
                }
            }
            swap(input, i, min);
        }
    }
    public static void BubbleSort(int[] input){
        boolean sorted;
        do {
            sorted = false;
            for (int i = 0; i < input.length-1;i++){
                if (input[i]>input[i+1]) {
                    swap(input, i, i+1);
                    sorted = true;
                }

            }
        } while (sorted);
    }
    public static void swap(int[] arr, int i1, int i2){
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }
}
