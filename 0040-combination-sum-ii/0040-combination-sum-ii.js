/**
 * @param {number[]} candidates
 * @param {number} target
 * @return {number[][]}
 */
var combinationSum2 = function(candidates, target) {
    candidates.sort((a, b) => a - b);
    var result = [];
    generateCombinationSum(result,[],0,candidates,target);
    return result;
};

function generateCombinationSum(result,current,j,candidates,target){
    if(j == candidates.length || target == 0){
        if(target == 0){
            result.push([...current]);
        }
        return;
    }

    for(let i =j; i<candidates.length; i++){
        if(i != j && candidates[i] == candidates[i-1])  continue;
        if( candidates[i] > target) continue;

        current.push(candidates[i]);
        generateCombinationSum(result,current,i+1,candidates,target-candidates[i]);
        current.pop();
    }
}