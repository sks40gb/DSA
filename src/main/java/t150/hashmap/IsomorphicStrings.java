package t150.hashmap;

import java.util.HashMap;

public class IsomorphicStrings {


    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        return isMapped(s,t) && isMapped(t,s);
    }

    public boolean isMapped(String s, String t) {
        int[] arr = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(arr[c] > 0){
                if((char)arr[c] != t.charAt(i)){
                    return false;
                }
            }
            arr[c] = t.charAt(i);
        }
        return true;
    }

    public static void main(String[] args) {

        IsomorphicStrings solution = new IsomorphicStrings();

        System.out.println(solution.isIsomorphic("egg", "add")); // true
        System.out.println(solution.isIsomorphic("foo", "bar")); // false
        System.out.println(solution.isIsomorphic("paper", "title")); // true
    }
}