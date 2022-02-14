import java.util.ArrayDeque;

public class Responsi {

	public static void main(String[] args){
		ArrayDeque myDeque = new ArrayDeque<Integer>();

		// Stack
		myDeque.addFirst(1);
		myDeque.addFirst(2);

		System.out.println(myDeque.getFirst());

		System.out.println(myDeque.removeFirst());
		System.out.println(myDeque.getFirst());
	}
}