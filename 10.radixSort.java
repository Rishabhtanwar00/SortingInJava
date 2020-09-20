package DataStructure;
import java.io.*;
import java.util.*;

public class Main {

  public static void radixSort(int[] arr) {
    // write code here   
    int max=Integer.MIN_VALUE;
    for(int val:arr){
        if(max<val){
            max=val;
        }
    }
    
    int exp=1;
    while(exp<=max){
        countSort(arr,exp);
        exp=exp*10;
    }
  }

  public static void countSort(int[] arr, int exp) {
    int[] fa=new int[10];
   
   //frequency array
   for(int i=0;i<arr.length;i++){
       fa[arr[i]/ exp % 10]++;
   }
   
   //infix array
   for(int i=1;i<fa.length;i++){
       fa[i]=fa[i]+fa[i-1];
   }
   
   //filling in answer array from infix and original array
   int[] ans=new int[arr.length];
   for(int i=arr.length-1;i>=0;i--){
       int val=arr[i]/ exp % 10;
       int pos=fa[arr[i]/ exp % 10]-1;
       ans[pos]=arr[i];
       fa[arr[i]/ exp % 10]--;
   }
   
   //copying ans array to original array
   for(int i=0;i<ans.length;i++){
       arr[i]=ans[i];
   }
    System.out.print("After sorting on " + exp + " place -> ");
    print(arr);
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.print(arr[i] + " ");
    }
    System.out.println();
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
    }
    radixSort(arr);
    print(arr);
  }

}