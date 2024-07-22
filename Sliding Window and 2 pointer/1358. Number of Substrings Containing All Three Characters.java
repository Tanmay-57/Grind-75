class Solution {
    public static int numberOfSubstrings(String s) {
        int count = 0;
        int[] lastSeen = {-1,-1,-1};

        for(int i=0; i< s.length();i++){
            // Update the last seen index of the current character
            lastSeen[s.charAt(i)- 'a']= i;

            // If all characters have been seen at least once
            if(lastSeen[0]!= -1 && lastSeen[1]!= -1 && lastSeen[2]!= -1){
                // Calculate the number of valid substrings ending at index i
                count = count + (1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2])));
            }
        }        

        return count;
    }
}
