import java.util.Scanner;

public class StringMatcherMain {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String text, pattern;

        System.out.println("Input text: ");
        text = sc.nextLine();

        System.out.println("Input pattern: ");
        do pattern = sc.nextLine();
        while (pattern.equals(""));
        
        StringMatcher.naive(text, pattern);
        StringMatcher.kmp(text, pattern);
    }
}
