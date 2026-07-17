/**
 * @param {number} k
 * @param {number} n
 * @return {number[][]}
 */
var combinationSum3 = function(k, n) {
    const result = [];

    backtrack(1, k, n, [], result);

    return result;
};

function backtrack(start, k, target, current, result) {

    // Found a valid combination
    if (target === 0 && current.length === k) {
        result.push([...current]);
        return;
    }

    // Invalid state
    if (target < 0 || current.length > k) {
        return;
    }

    // Try all numbers from 'start' to 9
    for (let i = start; i <= 9; i++) {
        current.push(i);

        // Each number can be used only once
        backtrack(i + 1, k, target - i, current, result);

        // Backtrack
        current.pop();
    }
}