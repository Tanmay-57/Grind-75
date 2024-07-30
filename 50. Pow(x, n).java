class Solution {
    public double myPow(double x, int n) {
        double ans= 1.0;
        long temp=n;

        if(n<0) temp= -1* temp;
        while(temp>0){
            if(temp%2 ==1){// n is odd
                ans= ans*x;
                temp= temp-1;
            }
            else{ // n is even
                x= x*x;
                temp= temp/2;
            }
        }

        if(n<0) ans= (double)(1.0)/ (double)(ans);
        return ans;
    }
}
