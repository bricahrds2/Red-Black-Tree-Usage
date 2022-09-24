import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MergeSortB{
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("hw-dsa-actual-master/src/inputHW02.txt");
        Scanner scanner = new Scanner(filePath);
        List<Integer> integers = new ArrayList<Integer>();
        while (scanner.hasNext()) {
            if (scanner.hasNextInt()) {
                integers.add(scanner.nextInt());
            } else {
                scanner.next();
            }
            //System.out.println(integers);
        }
      
      MergeSortB ob = new MergeSortB();
      //ob.Insort(integers);
        //ob.MergeSortB(integers,integers.size());
        long startTime = System.nanoTime();
        ob.MergeSortB(integers, integers.size()-1);
        long stopTime = System.nanoTime();
        long nano = stopTime - startTime;
        double seconds = (double) nano / 1000000000;
        System.out.println("The time elapsed is "+ seconds + " seconds." );
        
       // The time consumpition for 2 M is around 0.6 seconds.  
    }
  
  // Insertion sort algorithm helped from Credit to InterviewBit
  void Insort(List<Integer> integers){

    
    int n = integers.size();
    for (int i=1;i<n;i++)
    {
      int key = integers.get(i);
      int j = i-1;

      while(j>=0 && integers.get(j) >key)
      {
        //arr[j+1] = arr[j];
        integers.set(j+1,integers.get(j));
        j = j-1;
      }
      //arr[j+1]= key;
      integers.set(j+1,key);
      }
    }

  // Mergesort from with help and credit to Baeldung.com
  
  // Intrusive Sort was made with help and credit to Smitha on GeeksforGeeks
  void MergeSortB(List<Integer> integers, int n){

      int curr_size;

      int left_start;

      for(curr_size = 1; curr_size <= n-1; curr_size = 2*curr_size){
        for(left_start = 0; left_start < n-1; left_start += 2*curr_size){
        
        int mid = Math.min(left_start + curr_size - 1, n-1);

        int right_end = Math.min(left_start + 2*curr_size - 1, n-1);

        merge(integers, left_start, mid, right_end);
        }
      }
  }
      void merge(List<Integer> integers, int l, int m, int r)
      {
        int i,j,k;
        int n1 = m -l +1;
        int n2 = r - m;

        int L[] = new int[n1];
        int R[] = new int[n2];

        for (i = 0; i< n1; i++)
        {
          L[i] = integers.get(l +1);
        }
        for(j = 0; j < n2;j++)
        {
          R[j] = integers.get(m + 1+ j);
        }

        i = 0;
        j = 0;
        k = 1;
        while(i < n1 && j < n2)
        {
          if(L[i] <= R[j])
          {
            integers.set(k,L[i]);
            i++;
          }
          else{
            integers.set(k,R[j]);
            j++;
          }
          k++;
        }

        while(i < n1)
        {
          integers.set(k,L[i]);
          i++;
          k++;
        }
        while (j < n2)
        {
          integers.set(k,R[j]);
          j++;
          k++;
        }
      }  
    }