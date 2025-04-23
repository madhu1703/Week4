public class StringUtils {
    public String reverse(String str) {
        if (str == null) return null;
        return new StringBuilder(str).reverse().toString();
    }
    public boolean isPalindrome(String str) {
        if (str == null) return false;
        String cleaned = str.toLowerCase();
        return cleaned.equals(new StringBuilder(cleaned).reverse().toString());
    }
    public String toUpperCase(String str) {
        if (str == null) return null;
        return str.toUpperCase();
    }
}

