import java.util.ArrayList;
import java.util.Arrays;
public class SortLibrary {

    /* ——————————————————————MergeSort———————————————————————*/
   private static int[] copyArray;
   //one copy Array

   private static int number;

   public static void mergeSort(int[] nums) {
      copyArray = new int[nums.length];  
      mergeSort(0, nums.length - 1, nums);
   }

   private static void mergeSort(int low, int high, int[] nums){

      if(low < high) {
         int mid = low + (high - low) / 2;

         mergeSort(low, mid, nums);
         //runs down rabbit hole, only one thing goes on at once
         mergeSort(mid + 1, high, nums);
         //runs down another rabbit hole, gotta wait for it to stop tho before moving on
        //now finally that all that shit is done, we can move on
         merge(low, mid, high, nums);
      }
   }

   private static void merge(int low, int mid, int high, int[] nums) {

      int i = low;
      int j = mid + 1;
      int index = low;
      
      for(int k = low; k <= high; k++) {
         copyArray[k] = nums[k];
      }

     
      while(i <= mid && j <= high) {
         if(copyArray[i] <= copyArray[j]) {
            nums[index] = copyArray[i];
            i++;
         }
         else {
            nums[index] = copyArray[j];
            j++;
         }
         index++;
      }

      while(i <= mid) {
         nums[index] = copyArray[i];
         i++;
         index++;
      }
   }

    /* ——————————————————————QuickSort———————————————————————*/

   public static void quickSort(int[] nums) {
      quickSort(nums, 0, nums.length - 1);
   }

   private static void quickSort(int[] nums, int loIndex, int hiIndex) {
      if(loIndex  == hiIndex) {
         return;
      }

      if(hiIndex > loIndex) {
         int pivotIndex = partitionStep(nums, loIndex, hiIndex);
         quickSort(nums, loIndex, pivotIndex - 1);
         quickSort(nums, pivotIndex + 1, hiIndex);
      }
   }

   private static int partitionStep(int[] nums, int loIndex, int hiIndex) {
      int pivotIndex = (int)(Math.random() * (hiIndex - loIndex + 1) ) + loIndex;
      int pivotNumber = nums[pivotIndex];
      int temp;

      while(loIndex < hiIndex) {

         while(nums[loIndex] < pivotNumber) {
            loIndex++;
         }
         while(nums[hiIndex] > pivotNumber) {
            hiIndex--;
         }

         if(loIndex <= hiIndex) {
            temp = nums[loIndex];
            nums[loIndex] = nums[hiIndex];
            nums[hiIndex] = temp;
         }
      }

      return loIndex;
   }
}
