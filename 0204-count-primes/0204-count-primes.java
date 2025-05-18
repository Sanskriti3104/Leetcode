class Solution {
    public int countPrimes(int n) {
        int[] numbers = new int[n];
        Arrays.fill(numbers,1);

        for(int i=2; i<numbers.length; i++){
            if(numbers[i] == 1){
                for(int j = 2*i; j<numbers.length; j+=i){
                    numbers[j] = 0;
                }
            }
        }

        int count=0;
        for(int i=2; i<numbers.length; i++){
            if(numbers[i] == 1) count++;
        }

        return count;
    }
}