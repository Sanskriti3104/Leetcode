/**
 * @param {number} n
 * @return {string[]}
 */
var generateParenthesis = function(n) {
    var list = [];
    generateValidParenthesis(list,n,n,"");
    return list; 
};

function generateValidParenthesis(list,open,close,str){
    if(open == 0 && close == 0){
        list.push(str);
        return;
    }

    if(open>0){
        generateValidParenthesis(list,open-1,close,str+'(');
    }

    if(close > open){
        generateValidParenthesis(list,open,close-1,str+')');
    }
}