class Solution {
    public int totalFruit(int[] fruits) {
        int l =0, r=0, maxLen=0;

        HashMap<Integer, Integer> map = new HashMap<>();

        while(r< fruits.length){
            // for counting freq, defalut value 0;
            map.put(fruits[r], map.getOrDefault(fruits[r], 0)+1);

            // If there are more than 2 types of fruits in the window
            if(map.size()>2){
                // Decrement the count of the fruit at the left pointer
                map.put(fruits[l], map.get(fruits[l])-1);

                // If the count becomes 0, remove the fruit from the map
                if(map.get(fruits[l])==0){
                    map.remove(fruits[l]);
                }
                l++;
            }

            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        return maxLen;
    }
}
