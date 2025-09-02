package module4.dsa1.recursion.day21_RecursionLab;

public class CheckPalindrome {
    static boolean checkPalindrome(String A) {
        return checkP(A,0,A.length()-1);
    }

    static boolean checkP(String A, int start, int end) {
        if(start >= end) return true;
        else {
            if(A.charAt(start) != A.charAt(end))
                return false;
            return checkP(A, start+1, end-1);
        }
    }

    public static void main(String[] args) {
        String A = "madam";
        System.out.println(A+" is palindrome: "+checkPalindrome(A));
        A = "malyalam";
        System.out.println(A+" is palindrome: "+checkPalindrome(A));
        A = "sanam";
        System.out.println(A+" is palindrome: "+checkPalindrome(A));
        A = "adda";
        System.out.println(A+" is palindrome: "+checkPalindrome(A));
    }
}
