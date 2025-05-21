class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0; i<asteroids.length; i++){
            if(st.isEmpty()){
                st.push(asteroids[i]);
            }else{
                if(st.peek() > 0 && asteroids[i] < 0){
                    while(!st.isEmpty() && st.peek() > 0){
                        if(st.peek() > -1*asteroids[i]){
                            break;
                        }else if(st.peek() == -1*asteroids[i]){
                            st.pop();
                            break;
                        }else{
                            st.pop();
                            if (st.isEmpty() || st.peek() < 0) {
                                st.push(asteroids[i]);
                            }
                        }
                    }
                }else{
                    st.push(asteroids[i]);
                }
            }
        }
        
        int result[] = new int[st.size()];
        for(int i=st.size()-1; i>=0; i--){
            result[i] = st.pop();
        }

        return result;
    }
}