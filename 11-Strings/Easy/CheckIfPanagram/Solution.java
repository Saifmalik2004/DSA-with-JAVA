
class Solution {

    public static boolean  panagram(String sentence) {

       char c='a';
       if(sentence.length()<26)return false;
       for (int i = 0; i < 26; i++) {
           if(!sentence.contains(String.valueOf(c++))) return false;
       }
       

       return true;
    }

    public static void main(String[] args) {
        System.out.println(panagram("abcdefghijklmnopqrstuvwxyy"));
    }
}
