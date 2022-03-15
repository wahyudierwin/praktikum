public class Main {
    public static void main(String[] args){
        int[] keys =  new int[]{78, 3, 9, 10, 23, 77, 34, 86, 90, 100, 20, 66, 94, 63, 97};
        Heap myheap = new Heap(keys.length);
        
        for (int i=0 ; i<keys.length ; i++){
            myheap.insert(keys[i]);
        }
        
        myheap.displayHeap();
        
        myheap.remove();
        myheap.displayHeap();
    }
}
