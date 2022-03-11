import java.util.Scanner;

public class KMPSolverMain {
    public static void main(String args[]){
        KMPSolver kmpSolver = new KMPSolver();

        Scanner sc = new Scanner(System.in);
        String text, pattern;

        System.out.println("Input text: ");
        text = sc.nextLine();

        System.out.println("Input pattern: ");
        pattern = sc.nextLine();        
        
        kmpSolver.search(text, pattern);
    }
}