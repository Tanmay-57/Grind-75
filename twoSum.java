// Leetcode-1

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap();

        //Fill HM
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],i);
        }

        //Searching
        for(int i=0;i<nums.length;i++){
            int num= nums[i];
            int rem = target-num;

            if(map.containsKey(rem)){
                int index= map.get(rem);
                if(index==i){ // if target=4 and num =2, it will return same index of 2
                    continue;
                }
                return new int[]{i,index};
            }
        }

        return new int[]{};
    }
}
