public class StringMatcher {
    public static void naive(String text, String pattern){
        int textLen = text.length();
        int patternLen = pattern.length();

        boolean found = false;

        for (int i=0 ; i<textLen ; i++){
            boolean current_found = true;
            for (int j=0 ; j<patternLen ; j++){
                if ((i+j >= textLen) || (text.charAt(i+j) != pattern.charAt(j))){
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
        while (textIndex < textLen) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == patternLen) {
                found = true;
                System.out.println("Found pattern at index " + (textIndex - patternIndex) + " using KMP.");
                patternIndex = lps[patternIndex - 1];
            }
            else if (textIndex < textLen && pattern.charAt(patternIndex) != text.charAt(textIndex)) {
                if (patternIndex != 0){
                    patternIndex = lps[patternIndex - 1];
                }
                else{
                    textIndex++;
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
        int patternIndex = 1;

        lps[0] = 0;

        while (patternIndex < patternLen){
            if (pattern.charAt(patternIndex) == pattern.charAt(curLen)){
                curLen++;
                lps[patternIndex] = curLen;
                patternIndex++;
            }
            else{
                if (curLen != 0){
                    curLen = lps[curLen - 1];
                }
                else{
                    lps[patternIndex] = curLen;
                    patternIndex++;
                }
            }
        }

        return lps;
    }
}