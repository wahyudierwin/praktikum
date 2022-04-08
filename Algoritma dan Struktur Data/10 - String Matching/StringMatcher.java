public class StringMatcher {
    public static void naive(String text, String pattern){
        int textLen = text.length();
        int patternLen = pattern.length();

        boolean found = false;

        for (int i=0 ; i+patternLen <= textLen ; i++){
            boolean current_found = true;
            for (int j=0 ; j<patternLen ; j++){
                if (text.charAt(i+j) != pattern.charAt(j)){
                    current_found = false;
                    break;
                }
            }
            if (current_found){
                found = true;
                System.out.println("Found pattern at index " + i + " using naive.");    
            }
        }
        if (!found){
            System.out.println("Pattern not found using naive.");
        }
    }

    public static void kmp(String text, String pattern){
        int textLen = text.length();
        int patternLen = pattern.length();

        int[] lps = computeLPSArray(pattern, patternLen);

        int textIndex = 0;
        int patternIndex = 0;

        boolean found = false;
        int j=0;

        for (int i=0 ; i<textLen ; i++){
            while ((j > 0) && (text.charAt(i) != pattern.charAt(j))) {
                j = lps[j-1];
            }
            if (text.charAt(i) == pattern.charAt(j)){
                j++;
                if (j == patternLen){
                    found = true;
                    System.out.println("Found pattern at index " + (i - j + 1) + " using KMP.");
                    j = lps[j-1];
                }
            }
        }

        if (!found){
            System.out.println("Pattern not found using KMP.");
        }
    }

    private static int[] computeLPSArray(String pattern, int patternLen){
        int[] lps = new int[patternLen];

        int curLen = 0;

        lps[0] = 0;

        for (int i=1 ; i<patternLen ; i++){
            while ((curLen > 0) && (pattern.charAt(i) != pattern.charAt(curLen))){
                curLen = lps[curLen-1];
            }
            if (pattern.charAt(i) == pattern.charAt(curLen)){
                curLen++;
                lps[i] = curLen;
            }
        }

        return lps;
    }
}
