
import java.util.HashSet;
import java.util.Set;


class Solution {

    public static boolean  panagram(String sentence) {

       char c='a';
       if(sentence.length()<26)return false;
       for (int i = 0; i < 26; i++) {
           if(!sentence.contains(String.valueOf(c++))) return false;
       }
       

       return true;
    }

    public static boolean panagramOptimize(String sentence) {
    if (sentence.length() < 26) return false;

    Set<Character> set = new HashSet<>();
    for (char c : sentence.toCharArray()) {
        set.add(c);
    }

    return set.size() == 26;
}


    public static void main(String[] args) {
        System.out.println(panagram("abcdefghijklmnopqrstuvwxyy"));//false
        System.out.println(panagram("abcdefghijklmnopqrstuvwxyz"));//true
    }
}
