class Solution {
    public int findComplement(int num) {
       boolean setBitFound = false;
       for(int bitPos = 30; bitPos > -1; bitPos--){
            int mask = (1 << bitPos);
            if((num & mask) != 0){
                if(!setBitFound)setBitFound = true;
            }
            if(setBitFound){
                num ^= mask;
            }
       }
       return num;
    }
}