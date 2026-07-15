/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum = function(candidates, target) {
    candidates.sort((a, b) => a - b);
    var result = [];
    generateCombinationSum(result,[],0,candidates,target);
    return result;
};

function generateCombinationSum(result,current,i,candidates,target){
    if(i == candidates.length || target == 0){
        if(target == 0){
            result.push([...current]);
        }
        return;
    }

    if(target >= candidates[i]){
        current.push(candidates[i]);
        generateCombinationSum(result,current,i,candidates,target-candidates[i]);
        current.pop();
    }
    generateCombinationSum(result,current,i+1,candidates,target);

}