class Solution {
    public int hammingWeight(int n) {
        int cnt=0;
        while(n!=0){
            //n&1 controlla bit meno significativo: se e 1 incremento
            if((n&1)==1){
                cnt++;
            }
            //n>>>=1 sposta di uno a destra tutti i bit
            n>>>=1;
        }
        return cnt;
    }
}
