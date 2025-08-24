class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n=s.length();
        if(n==1)return false;
        
        for(int i=n/2; i>=1;i--){
            String str=s.substring(0,i);

            if(n%(i)!=0) continue;
            int times=n/(i);
            StringBuilder result = new StringBuilder();
            for(int j=0;j<times;j++){
                result.append(str);
            }
            if(s.equals(result.toString()))return true;
        }
        return false;
    }
}