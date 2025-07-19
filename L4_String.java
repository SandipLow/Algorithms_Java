import java.util.*;

public class L4_String {

    public static List<String> getWords(String str) {
        List<String> ans = new ArrayList<>();
        String word = "";

        for (char ch: str.toCharArray()) {
            if (ch==' ') {
                if (word!="") {
                    ans.add(word);
                    word="";
                }
                continue;
            }
        }

        return ans;
    }

    public static boolean validParanthesis(String str) {
        int cnt = 0;

        for (char ch: str.toCharArray()) {
            if (ch=='(') cnt++;
            else if (ch==')') {
                if (cnt==0) return false;
                cnt--;
            }
        }

        return cnt==0;
    }

    public static String longestPalindromeSubstring(String str) {
        int l, r, n = str.length();
        String ans = "";

        for (int i=0; i<n; i++) {
            // odd length
            l = r = i;
            while (l>=0 && r<n && str.charAt(l)==str.charAt(r)) {
                if (ans.length() < r-l+1) {
                    ans = str.substring(l, r+1);
                }
                l--;
                r++;
            }

            // even length
            l = i; 
            r = i+1;
            while (l>=0 && r<n && str.charAt(l)==str.charAt(r)) {
                if (ans.length() < r-l+1) {
                    ans = str.substring(l, r+1);
                }
                l--;
                r++;
            }

        }

        return ans;
    }

    
    public static void main(String[] args) {
        System.out.println(longestPalindromeSubstring("babad"));
    }
}