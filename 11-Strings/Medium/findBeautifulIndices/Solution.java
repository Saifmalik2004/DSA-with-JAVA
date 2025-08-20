
import java.util.ArrayList;
import java.util.List;

class Solution {
    public void computeLPS(String pat,int[] lps){
        int m=pat.length();
        int len=0;
        lps[0]=0;
        int i =1;
        while(i<m){
            if(pat.charAt(i)==pat.charAt(len)){
                len++;
                lps[i]=len;
                i++;
            }else{
                if(len!=0){
                    len=lps[len-1];

                }else{
                    lps[i]=0;
                    i++;
                    
                }
            }
        }
    }

    public List<Integer> KMP(String pat, String text){
        int n=text.length();
        int m=pat.length();

        List<Integer> res=new ArrayList<>();   
        int lps[]=new int[m];

        computeLPS(pat,lps);
        int j=0;
        int i=0;

        while(i<n){
            if(pat.charAt(j)==text.charAt(i)){
                i++;
                j++;
                if(j==m){
                    res.add(i-j);
                    j=lps[j-1];
                }
            }else if( i<n && pat.charAt(j) != text.charAt(i)){
                    if(j!=0){
                        j=lps[j-1];
                    }else{
                        i++;
                    }

            }
        }

        return res;
    }

    private int lowerBound(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1, result = list.size();

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (list.get(mid) >= target) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        int n=s.length();
        List<Integer> iIdx=KMP(a,s);
        List<Integer> jIdx=KMP(b,s);

        List<Integer> res=new ArrayList<>();

        for(int i:iIdx){

            int leftLim=Math.max(0,i-k);
            int rightLim=Math.min(n-1,i+k);
            int lowerIdx=lowerBound(jIdx,leftLim);
            if(lowerIdx<jIdx.size() && jIdx.get(lowerIdx)<=rightLim){
                res.add(i);
            }


        }
        return res;
    }
}