package com.learning.dsa.sorting;

/**
 * Bucket Sort
You are the manager at "Dream Wheels," a car showroom with ( n ) cars available. An analysis shows that customers tend to buy expensive rare cars if they come across them after the common cheaper cars. Your task is to arrange the cars in decreasing order of their frequency. If two or more cars have the same frequency, sort them lexicographically.

Input Format:

The first line contains an integer ( n ) (the number of cars).
The second line contains a string of ( n ) characters representing the cars.
Output Format:

Return the arranged string of cars.
Sample Input 1:

8
ssgysyqa
Sample Output 1:

sssyyagq

Explanation: The cars are arranged such that the most frequent cars come first. If two cars have the same frequency, they are sorted lexicographically.

Constraints:

1<= n <= 10^5
All characters are lowercase English alphabets.
 */


class BucketSort {
    String bucketSortCars(String cars) {
      //Write your code here
      int[] arr = new int[26];
      for(int i=0;i<26;i++) {
        arr[i]=0;
      }
      for(char ch:cars.toCharArray()) {
        arr[ch-97]++;
      }
      
      int maxVal = getMax(arr);
      StringBuilder result = new StringBuilder();
      for(int i=maxVal;i>0;i--) {
        for(int j=0;j<arr.length;j++) {
          if(arr[j]==i) {
            String str = Character.toString((char)(j+97));
            result.append(str.repeat(i));
          }
        }
      }
      return result.toString();
   }

  int getMax(int[] arr) {
    int val = Integer.MIN_VALUE;
    for(int i=0;i<26;i++) {
      if(val < arr[i]) {
        val = arr[i];
      }
    }
    return val;
  }
}
