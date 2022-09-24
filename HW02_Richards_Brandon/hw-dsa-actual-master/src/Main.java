import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get("hw-dsa-actual-master/src/insertiontext.txt");
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
      //System.out.println(integers);
      //System.out.println("1");
      Main ob = new Main();
      //ob.Insort(integers);
      //System.out.println(integers);
        ob.MergeSortA(integers,integers.size());
        System.out.println(integers);
    }
  
  // Insertion sort algorithm helped from InterviewBit
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

  // Mergesort from with help from Baeldung.com
  void MergeSortA(List<Integer> integers, int n){
    if(n<2){
      return;
    }
    int mid = n/2;
    //System.out.println(mid);
    List<Integer> l = new ArrayList<Integer>(mid);
    List<Integer> r = new ArrayList<Integer>(n-mid);
    
    if(l.size() == 0 && r.size() == 0)
    {
    for(int i = 0; i<=mid;i++){
      l.add(i);
    }
    for(int i = 0; i <= n-mid; i++){
      r.add(i);
      }
    }
    
    for (int i = 0; i < mid; i++){
      l.set(i, integers.get(i));
      //try{l.set(i, integers.get(i));}catch(Exception e){}
    }
    for (int i = mid; i < n; i++){
      r.set(i-mid,integers.get(i));
    }

    MergeSortA(l,mid);
    MergeSortA(r,n-mid);

    merge(integers,l,r,mid,n-mid);
    
  }
  
  void merge(List<Integer> integers, List<Integer> l, List<Integer> r, int left, int right) {
    int i =0, j =0, k=0;
    while(i<left && j < right) {
      if(l.get(i)<= r.get(j)) {
        integers.set(k++,l.get(i++));
      }
      else {
        integers.set(k++,r.get(j++));
      }
    }
    while(i < left){
      integers.set(k++,l.get(i++));
    }
    while(j < right){
      integers.set(k++,r.get(j++));
    }
  }
  
  }