/**
 * @param {number[]} nums
 * @return {number[][]}
 */
var subsetsWithDup = function(nums) {
    nums.sort((a, b) => a - b);
    var result = [];
    generateSubsets(nums,0,[],result);
    return result  
};
function generateSubsets(nums,j,current,result){
    result.push([...current]);

    for(let i =j; i<nums.length; i++){
        if(i != j && nums[i] == nums[i-1])  continue;

        current.push(nums[i]);
        generateSubsets(nums,i+1,current,result);
        current.pop();
    }
}