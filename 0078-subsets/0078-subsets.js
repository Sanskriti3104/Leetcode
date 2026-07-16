/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsets = function(nums) {
    var result = [];
    generateSubsets(nums,0,[],result);
    return result
};
function generateSubsets(nums,i,current,result){
    if(i == nums.length){
        result.push([...current]);
        return;
    }
    current.push(nums[i]);
    generateSubsets(nums,i+1,current,result);
    current.pop();
    generateSubsets(nums,i+1,current,result);
}