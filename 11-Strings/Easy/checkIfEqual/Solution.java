
public class Solution {
    
    public static boolean check1(String[] arr1,String[] arr2) {

        
        StringBuilder st1=new StringBuilder();
        for (int i = 0; i < arr1.length; i++) {
            
            st1.append(arr1[i]);
        }

        StringBuilder st2=new StringBuilder();

        for (int j = 0; j < arr2.length; j++) {
            st2.append(arr2[j]);
        }

        return st1.toString().contentEquals(st2.toString());
        
    }
   
    public static boolean check(String[] arr1,String[] arr2) {

        int word1=0;
        int word2=0;
        int i=0;
        int j=0;

        while(word1<arr1.length && word2<arr2.length){
        if(arr1[word1].charAt(i)==arr2[word2].charAt(j)){
            if(i+1==arr1[word1].length()){
                i=0;
                word1++;
            }else{
                i++;
            }

            if(j+1==arr2[word2].length()){
                j=0;
                word2++;
            }else{
                j++;
            }

            }else{
            return false;
        }
        }

        return true;
        
    }
    public static void main(String[] args) {
        String a[]={"aab","k"};
        String b[]={"a","ab","k"};

        System.out.println(check1(a, b));
    }
}
