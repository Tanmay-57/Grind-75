// fibonacci series -70
class Solution {
    public int climbStairs(int n) {

        if(n==1) return 1;

        int[] arr= new int[n+1];
        arr[1]=1; //1st step can be reached in 1 way
        arr[2]=2; //2nd step can be reached in 2 ways

        for(int i=3;i<=n;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }

        return arr[n];
        
    }
}
