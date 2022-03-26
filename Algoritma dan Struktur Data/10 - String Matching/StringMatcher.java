public class StringMatcher {
    public void naive(String text, String pattern){
        int textLen = text.length();
        int patternLen = pattern.length();

        int indexFound = -1;

        for (int i=0 ; i<textLen ; i++){
            boolean found = true;
            for (int j=0 ; j<patternLen ; j++){
                if ((i+j >= textLen) || (text.charAt(i+j) != pattern.charAt(j))){
                    found = false;
                }
            }
            if (found){
                indexFound = i;
            }
        }
        if (indexFound != -1){
            System.out.println("Found pattern at index " + indexFound + " using naive.");
        }
        else{
            System.out.println("Pattern not found using naive.");
        }
    }

    public void kmp(String text, String pattern){
        int textLen = text.length();
        int patternLen = pattern.length();

        int[] lps = computeLPSArray(pattern, patternLen);

        int textIndex = 0;
        int patternIndex = 0;

        boolean isFound = false;
        while (textIndex < textLen) {
            if (pattern.charAt(patternIndex) == text.charAt(textIndex)) {
                patternIndex++;
                textIndex++;
            }
            if (patternIndex == patternLen) {
                isFound = true;
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

        if (isFound == false){
            System.out.println("Pattern not found using KMP.");
        }
    }

    private int[] computeLPSArray(String pattern, int patternLen){
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