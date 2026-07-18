/**
 * @param {string} digits
 * @return {string[]}
 */
var letterCombinations = function(digits) {
    const map = new Map();

    // Map a string key to an array of characters
    map.set("2", ["a","b","c"]);
    map.set("3", ["d","e","f"]);
    map.set("4", ["g","h","i"]);
    map.set("5", ["j","k","l"]);
    map.set("6", ["m","n","o"]);
    map.set("7", ["p","q","r","s"]);
    map.set("8", ["t","u","v"]);
    map.set("9", ["w","x","y","z"]);

    const result = [];
    generateletterCombinations(result,"",0,map,digits);
    return result;
};

function generateletterCombinations(result,current,index,map,digits){

    //Base case 
    if(index == digits.length){
        result.push(current);
        return;
    }

    const letters = map.get(digits[index]);
    for(let i = 0; i < letters.length; i++){
        generateletterCombinations(
            result,
            current + letters[i],
            index+1,
            map,
            digits
        );
    }
}