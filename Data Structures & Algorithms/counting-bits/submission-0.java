class Solution {
    public int[] countBits(int n) {
        int[] res=new int[n+1];
        for(int i=1; i<=n;i++){
            int current=i;
            int cnt=0;
            while(current!=0){
                if((current&1)==1) cnt++;
                current>>>=1;
            }
            res[i]=cnt;
        }
        return res;
    }
}
