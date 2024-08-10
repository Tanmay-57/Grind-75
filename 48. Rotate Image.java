class Solution {
    public void rotate(int[][] mat) {
        int n= mat.length;
        //transpose
        // O(N/2 * N/2)
        for(int i=0; i<n-1; i++){ // <n-1 --> will travel till 2nd last row
            for(int j= i+1; j<n; j++){
                int temp= mat[i][j];
                mat[i][j]= mat[j][i];
                mat[j][i]= temp;
            }
        }

        //reverse
        //O(N * N/2)
        for(int i=0; i< n; i++){
            // Initialise start and end index
            int start = 0;
            int end = n - 1;
    
            // Till start < end, swap the element
            // at start and end index
            while (start < end) {  
                // Swap the element
                int temp = mat[i][start];
                mat[i][start] = mat[i][end];
                mat[i][end] = temp;
    
                // Increment start and decrement
                // end for next pair of swapping
                start++;
                end--;
            }
        }
    }
}
