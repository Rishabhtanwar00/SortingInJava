package DataStructure;
import java.io.*;
import java.util.*;

public class Main {

  public static void countSort(int[] arr, int min, int max) {
   //write your code here
   int size=max-min+1;
   int[] fa=new int[size];
   
   //frequency array
   for(int i=0;i<arr.length;i++){
       fa[arr[i]-min]++;
   }
   
   //infix array
   for(int i=1;i<fa.length;i++){
       fa[i]=fa[i]+fa[i-1];
   }
   
   //filling in answer array fron infix and original array
   int[] ans=new int[arr.length];
   for(int i=arr.length-1;i>=0;i--){
       int val=arr[i];
       int pos=fa[val-min]-1;
       ans[pos]=val;
       fa[val-min]--;
   }
   
   //copying ans array to oringinal array
   for(int i=0;i<ans.length;i++){
       arr[i]=ans[i];
   }
   
  }

  public static void print(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int[] arr = new int[n];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int i = 0; i < n; i++) {
      arr[i] = scn.nextInt();
      max = Math.max(max, arr[i]);
      min = Math.min(min, arr[i]);
    }
    countSort(arr,min,max);
    print(arr);
  }

}