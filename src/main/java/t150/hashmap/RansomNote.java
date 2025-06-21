package t150.hashmap;

public class RansomNote {

    public static void main(String[] args) {
        RansomNote solution = new RansomNote();
        System.out.println(solution.canConstruct("a", "b"));           // false
        System.out.println(solution.canConstruct("aa", "ab"));         // false
        System.out.println(solution.canConstruct("aa", "aab"));        // true
    }

    public boolean canConstruct(String a, String b) {
        int[] matchWith =  new int[26];
        for(char c : b.toCharArray()){
            matchWith[c - 'a']++;
        }

        for(char c : a.toCharArray()){
            if(matchWith[c-'a'] > 0){
                matchWith[c-'a']--;
            }else{
                return false;
            }
        }
        return true;
    }

}
