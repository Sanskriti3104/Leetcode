class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList();
        Arrays.sort(nums);

        for(int a=0; a<nums.length-2; a++){

            if(a>0 && nums[a] == nums[a-1])     continue;
            for(int b =a+1; b<nums.length -1;b++){

                if(b>a+1 && nums[b] == nums[b-1])     continue;

                int c=b+1;
                int d=nums.length -1;

                while(c<d){

                    long sum = (long)nums[a] + nums[b] + nums[c] + nums[d];
                    if(sum < target){
                        c++;
                    }else if(sum > target){
                        d--;
                    }else{
                        result.add(Arrays.asList(nums[a],nums[b],nums[c],nums[d]) );

                        while(c<d && nums[c] == nums[c+1])  c++;
                        while(c<d && nums[d] == nums[d-1])  d--;

                        c++;
                        d--;
                    }

                }
            }
             
        }

        return result;
    }
}
