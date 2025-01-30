class Solution {
    public int getBit(int start, int i){
        return (start & (1 << i)) != 0 ? 1 : 0;
    }

    public int setBit(int start, int i){
        return start | (1<<i) ;
    }

    public int clearBit(int start, int i){
        return start & ~(1<<i) ;
    }

    public int minBitFlips(int start, int goal) {
        int count = 0;
        int i=0;

        while( start != goal){

            int startBit = getBit(start,i);
            int goalBit = getBit(goal,i);

            if(startBit == goalBit){
                i++;
            }else{
                count++;
                if(goalBit == 1){
                    start = setBit(start,i);
                }else{
                    start = clearBit(start,i);
                }
                i++;
            }

        }

        return count;
    }
}