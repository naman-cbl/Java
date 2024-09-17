import java.util.*;

class HelloWorld2 {

    public static ArrayList<ArrayList<Integer>> subArrayOfSumK(int[] arr, int i,int k){
        if(arr.length == i){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            return ans;
        }
        if(k==0){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            ans.add(new ArrayList<Integer>());
            return ans;
        }
        if(k<0){
            ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
            return ans;
        }
        
        ArrayList<ArrayList<Integer>> smallAns1 = subArrayOfSumK(arr, i+1,k);
        ArrayList<ArrayList<Integer>> smallAns2 = subArrayOfSumK(arr, i+1,k-arr[i]);
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        
        for(ArrayList<Integer> a: smallAns1){
            ans.add(a);
        }
        
        for(ArrayList<Integer> a: smallAns2){
            a.add(arr[i]);
            ans.add(a);
        }
        return ans;
    }

    public static ArrayList<String> printAllSubOfString(String str,int i){
        if(str.length() == i){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }
        
        ArrayList<String> smallAns = printAllSubOfString(str,i+1);
        ArrayList<String> ans = new ArrayList<>();
        
        for(String s: smallAns){
            ans.add("" + s);
        }
        for(String s: smallAns){
            ans.add(str.charAt(i) + s);
        }
        
        return ans;
    }
    
    public static ArrayList<String> strairsCase(int steps){
        if(steps==0){
            ArrayList<String> ans = new ArrayList<>();
            ans.add("");
            return ans;
        }else if(steps < 0){
            return new ArrayList<>();
        }
        
        ArrayList<String> ans1 = strairsCase(steps-1);
        ArrayList<String> ans2 = strairsCase(steps-2);
        ArrayList<String> ans3 = strairsCase(steps-3);
        
        ArrayList<String> ans = new ArrayList<>();
        for(String s : ans1){
            ans.add("1"+s);
        }
        for(String s : ans2){
            ans.add("2"+s);
        }
        for(String s : ans3){
            ans.add("3"+s);
        }
        
        return ans;
        
        
        
    }
    public static void main(String[] args) {
        System.out.println("Try programiz.pro");
        // ArrayList<String> result = printAllSubOfString("abcd",0);
        // System.out.println(result);
        // System.out.println(result.size());
        
        // ArrayList<String> result = strairsCase(4);
        // System.out.println(result);
        // System.out.println(result.size());

        int[] arr = new int[]{1,2,3,4,5,6};
        ArrayList<ArrayList<Integer>> result = subArrayOfSumK(arr,0,6);
        for(ArrayList<Integer> a: result){
            System.out.println(a);
        }
        System.out.println(result.size());
    }
}