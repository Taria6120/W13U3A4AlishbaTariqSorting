// Filename: W13U3A4_Alishba_Tariq_Sorting
// Author: Alishba Tariq 
// Date:  Wednesday, May 22, 2024
// Purpose:  
//This code will auto generate 10 mubers between -1000 and 1000. Then it will sort these numbers using the four mehtods we learned in class: buble sort, selection sort, insertion sort, and merge sort. It will also tell you how long it takes for the sort to complete, as well as how many comparisons it makes.

import java.util.Arrays;
import java.util.Random;


public class Main {
  public static void main(String[] args) {
    

    int [] list = new Random().ints (10,-1000,1001).toArray();
    //the number of intergers on the list has to be 10 from -1000 to 1000. 
    System.out.println("Original unsorted list; " + Arrays.toString(list));
    String[] options = {"selection","bubble", "insertion", "quick"};
    for (String option : options){
      sortAndPrint(option, Arrays.copyOf(list, list.length));
    }
  //this is the code for the sorting options. 
 
    }
  public static void sortAndPrint(String options, int[] list) {
      Counter counter = new Counter();
      long starttime = System.nanoTime();

      switch (options) {
          case "selection":
              selectionSort(list, counter);
              break;
          case "bubble":
              bubbleSort(list, counter);
              break;
          case "insertion":
              insertionSort(list, counter);
              break;
          case "quick":
              quickSort(list, 0, list.length - 1, counter);
              break;
      }

      long endtime = System.nanoTime();
      double elapsedtime = (endtime - starttime) / 1_000_000.0; // Convert nanoseconds to milliseconds

      System.out.println(options + " Sort:");
      System.out.println(String.format("%s sort took %.2f milliseconds", options, elapsedtime));
      System.out.println("Sorted list: " + Arrays.toString(list));
      System.out.println("Loop executions: " + counter.loopCount);
      System.out.println("Comparisons: " + counter.compareCount);
      System.out.println("Movement: " + counter.movementCount);
      System.out.println("Time taken: " + elapsedtime + " ms"); // Adjusted message to show milliseconds
      System.out.println();
  }
  static class Counter{
    int loopCount = 0;
    int compareCount = 0;
    int movementCount = 0;

  }
    public static void selectionSort (int[] list, Counter counter){
      for (int i = 0; i < list.length - 1; i++){
        int minIndex = i;
        counter.loopCount++;

        
    for (int j = i + 1; j < list.length; j++){
        counter.loopCount++;
        counter.compareCount++;
          if (list[j] < list[minIndex]){
            minIndex = j;
          }
            
          }
        if (minIndex != i){
          int temp = list[i];
          list[i] = list[minIndex];
          list[minIndex] = temp;
          counter.movementCount+=3;
   //this is the code for the selection sort.       
          
        }
      }
    }

  

    public static void bubbleSort(int[] list, Counter counter){
      for (int i = 0; i < list.length - 1; i++){
        counter.loopCount++;
        for (int j = 0; j < list.length - i - 1; j++){
          counter.loopCount++;
          counter.compareCount++;
          if (list[j] > list[j + 1]){
            int temp = list[j];
            list[j] = list[j + 1];
            list[j + 1] = temp;
            counter.movementCount+=3;
  //this is the code for the bubble sort.   
          }
        }
      }
    }
  public static void insertionSort(int[] list, Counter counter){
    for (int i = 1; i < list.length; i++){
      counter.loopCount++;
      int key = list[i];
      int j = i - 1;
      while (j >= 0 && list[j] > key){
        counter.loopCount++;
        counter.compareCount++;
        list[j + 1] = list[j];
        j--;
      }
      list[j + 1] = key;
      counter.movementCount++;
    //this is the code for the insertion sort.   
    }
  }

  public static void quickSort(int[] list, int low, int high, Counter counter){
    if (low < high){
      int pivotIndex = partition(list, low, high, counter);
      quickSort(list, low, pivotIndex - 1, counter);
      quickSort(list, pivotIndex + 1, high, counter);
    }
  }
  private static int partition(int[] list, int low, int high, Counter counter){
    int pivot = list[high];
    int i = low - 1;
    for (int j = low; j < high; j++){
      counter.loopCount++;
      counter.compareCount++;
      if (list[j] <= pivot){
        i++;
        int temp = list[i];
        list[i] = list[j];
        list[j] = temp;
        counter.movementCount+=3;
      }
    }
    int temp = list[i + 1];
    list[i + 1] = list[high];
    list[high] = temp;
    counter.movementCount+=3;
    return i + 1;
  }
  //this is the code for the quick sort.   
}
    
    