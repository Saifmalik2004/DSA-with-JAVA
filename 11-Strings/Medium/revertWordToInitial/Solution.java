class Solution {
    public int minimumTimeToInitialState(String word, int k) {
        int count=1;
        int n=word.length();
        int i=k;
        while(i<n){

            if(checkIfPrefix(word,i)){
             break;
            }else{
                i+=k;
                count++;

            }
        }
        return count;

    }
    public boolean checkIfPrefix(String word,int k){
         
         int i=0;
         int j=k;
         while(j<word.length()){
            if(word.charAt(i) != word.charAt(j)){
                return false;
            }
            i++;
            j++;
         }
         return true;
    }
}