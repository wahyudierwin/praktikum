public class KMPSolver {
    public void search(String text, String pattern){
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
                System.out.println("Found pattern at index " + (textIndex - patternIndex));
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
            System.out.println("Pattern not found");
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