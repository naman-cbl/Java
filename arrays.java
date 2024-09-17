import java.util.ArrayList;
import java.util.HashSet;

public class arrays {
    public static void main(String[] args) {
        System.out.println("");
        int[] arr = {1, 1, 1, 4, 5};
        //printAllSubArrays(arr);
        //maxSumSubArray(arr);
        //maxSumSubArray3(arr);
        //int result = maxSumCircularSubArray(arr);
        //printArray(arr);
        // ArrayList<String> res = findAllSubsequence(arr, 0, arr.length-1);
        // System.err.println("Subsequences:");
        // for(String s:res){
        //     System.out.println(s);
        // }
        // System.out.println("size:"+res.size() );
        //HashSet<String> set = new HashSet<>();
        //printUniquesubSequence(arr, 0, "-->",set);
        int[][] matrix = new int[6][6];
        System.out.println(lcs("adebc","dcadb",matrix));
        

    }

    public static void printArray(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
    

    public static void printAllSubArrays(int[] arr){
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                for(int k=i;k<=j;k++){
                    System.out.print(arr[k]+ " ");
                }
                System.out.println();
            }
        }
    }

    public static void printAllSubArraysWithSum(int[] arr){
        int n = arr.length;

        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                    System.out.print(arr[k]+ " ");
                }
                System.out.println("   sum:"+sum);
            }
            System.out.println();
        }
    }

    // Time Complexity: O(n3), Space Complexity: O(1)
    public static void maxSumSubArray(int[] arr){
        int n = arr.length;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int sum = 0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                max_sum = Math.max(max_sum, sum);
            }
        }
        System.out.println(max_sum);
    }

    // Commulitive Sum Approach | Time Complexity: O(n2), Space Complexity: O(n)
    public static void maxSumSubArray2(int[] arr){
        int n = arr.length;

        // Commulative sum array
        int[] sums = new int[n+1];
        int sum = 0;
        for(int i=0;i<n;i++){
            sum+=arr[i];
            sums[i+1] = sum;
        }
        
        //find the max difference in the commulative sum
        int max_sum = Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            for(int j=0;j<n+1;j++){
                max_sum = Math.max(max_sum, sums[i]-sums[j]);
            }
        }
        System.out.println(max_sum);
    }

    // Kadane's Algotrithm | Time Complexity: O(n), Space Complexity: O(1)
    public static int maxSumSubArray3(int[] arr){
        int n = arr.length;

        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            curr_sum+=arr[i];
            if(curr_sum<0){
                curr_sum = 0;
            }
            max_sum = Math.max(curr_sum, max_sum);
        }
        return max_sum;
    }

    public static int maxSumCircularSubArray(int[] arr){
        int n = arr.length;
        int nowrap = maxSumSubArray3(arr); // max sum without circular array

        // finding total sum of arr and reversing the sign of numbers to find the max sum of non contributing subarray
        int total_sum = 0;
        for(int i=0;i<n;i++){
            total_sum+=arr[i];
            arr[i] = -arr[i];   
        }

        int wrap = total_sum + maxSumSubArray3(arr); // max sum with circular array

        return Math.max(wrap, nowrap);
    }

    public static int buySellStocks(int[] arr) {

        
        return 0;
    }

    // merge sort using divide and conquer
    public static void mergeSort(int[] arr, int start, int end){
        
        if(start==end){
            return;
        }

        int mid = start + (end-start)/2;

        mergeSort(arr, start, mid);
        mergeSort(arr, mid+1, end);

        int n = end - start + 1;
        int[] merged = new int[n];

        int i=start;int j=mid+1;int k=0;

        while(i<=mid && j<=end){
            if(arr[i]<=arr[j]){
                merged[k] = arr[i];
                i++;k++;
            }else{
                merged[k] = arr[j];
                j++;k++;
            }
        }

        while(i<=mid){
            merged[k] = arr[i];
            i++;k++;
        }
        while(j<=end){
            merged[k] = arr[j];
            j++;k++;
        }

        int x = start;k=0;
        while(x<=end){
            arr[x] = merged[k];
            x++;k++;
        }

    }

    // Advanced binary search
    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        return 0;
    }

    public static ArrayList<String> findAllSubsequence(int[] arr, int start, int end){

        if(start>end){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }

        ArrayList<String> small_output = findAllSubsequence(arr, start+1, end);

        ArrayList<String> output = new ArrayList<>();

        for(String s: small_output){
            output.add(s);
        }

        for(String s: small_output){
            output.add(arr[start]+" "+s);
        }
        return output;
        
    }

    public static void printAllsubSequence(int[] arr, int idx, String result){

        if(idx == arr.length){
            System.out.println(result);
            return;
        }

        printAllsubSequence(arr, idx+1, result+" "+arr[idx]);
        printAllsubSequence(arr, idx+1, result);
    }

    public static void printUniquesubSequence(int[] arr, int idx, String result, HashSet<String> set){

        if(idx == arr.length){
            if(set.contains(result)){
                return;
            }
            set.add(result);
            System.out.println(result);
            return;
        }

        printUniquesubSequence(arr, idx+1, result+" "+arr[idx],set);
        printUniquesubSequence(arr, idx+1, result,set);
    }

    public static int lcs(String s, String t, int[][] matrix){
        if(s.length() == 0 || t.length() == 0){
            return 0;
        }
        if(matrix[s.length()][t.length()] != 0){
            return matrix[s.length()][t.length()];
        }

        int small_output;
        if(s.charAt(s.length()-1) == t.charAt(t.length()-1)){
            small_output = 1 + lcs(s.substring(0, s.length()-1), t.substring(0, t.length()-1), matrix);
        }else{
            int output1 = lcs(s,t.substring(0, t.length()-1), matrix);
            int output2 = lcs(s.substring(0, s.length()-1),t,matrix);
            small_output = Math.max(output1, output2);
        }
        matrix[s.length()][t.length()] = small_output;

        return small_output;
    }
}
