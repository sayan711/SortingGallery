package org.example;


public class Sort {

    /**
     * Should take in an array of two ints and changes it
     * to array with the numbers from smallest to largest.
     *
     * @param nums
     */
    public static void sortTwo(int[] nums) {
        if (nums[0] > nums[1]) {
            int temp = nums[0];
            nums[0] = nums[1];
            nums[1] = temp;
        }
    }

    private static void mergeSort(int[] inputArray) {
        int inputLength = inputArray.length;

        if (inputLength < 2) {
            return;
        }

        int midIndex = inputLength/2;
        int[] leftHalf = new int[midIndex];
        int[] rightHalf = new int[inputLength-midIndex];

        for(int i =0; i<midIndex; i++){
            leftHalf[i] = inputArray[i];
        }
        for(int i = midIndex; i<inputLength; i++){
            rightHalf[i-midIndex] = inputArray[i];
        }

        mergeSort(leftHalf);
        mergeSort(rightHalf);

        merge(inputArray, leftHalf, rightHalf);
    }

        /**
         * This function should take the two arrays and merge them into the inputArray.
         * The result should be in order from smallest to largest, with all the numbers from both arrays included.
         *
         * @param inputArray - The original array that will come back changed.
         * @param array1     - A sorted list of numbers that is the size of half the length of the inputArray
         * @param array2     - A sorted list of numbers that is the size of half the length of the inputArray
         */


        public static void merge(int[] inputArray, int[] array1, int[] array2){
            int array1Size = array1.length;
            int array2size = array2.length;

            int i = 0, j = 0, k = 0;

            while (i < array1Size && j < array2size) {
                if (array1[i] <= array2[j]) {
                    inputArray[k] = array1[i];
                    i++;
                }
                else{
                    inputArray[k] = array2[j];
                    j++;
                }
                k++;
            }
            while(i < array1Size){
                inputArray[k] = array1[i];
                i++; k++;
            }
            if(j < array2size){
                inputArray[k] = array2[j];
                j++; k++;
            }
    }
}