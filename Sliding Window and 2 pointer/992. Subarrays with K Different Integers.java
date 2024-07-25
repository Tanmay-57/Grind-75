class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return fun(nums, k) - fun(nums, k-1);
    }

    int fun(int[] nums, int k){
        int l = 0, r = 0, count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while(r< nums.length){
            // Add the current element to the map and update its count
            map.put(nums[r], map.getOrDefault(nums[r],0)+1);
            // If the map size exceeds k, adjust the left pointer to decrease the size
            while(map.size()>k){
                map.put(nums[l], map.get(nums[l])-1);

                if(map.get(nums[l])==0){
                    map.remove(nums[l]);
                }
                l++;
            }
            count = count + (r-l+1);
            r++;
        }

        return count;
    }
}
