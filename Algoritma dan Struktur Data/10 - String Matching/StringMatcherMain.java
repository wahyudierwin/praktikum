import java.util.Scanner;

public class StringMatcherMain {
    public static void main(String args[]){
        StringMatcher matcher = new StringMatcher();

        Scanner sc = new Scanner(System.in);
        String text, pattern;

        System.out.println("Input text: ");
        text = sc.nextLine();

        System.out.println("Input pattern: ");
        pattern = sc.nextLine();        
        
        matcher.naive(text, pattern);
        matcher.kmp(text, pattern);
    }
}