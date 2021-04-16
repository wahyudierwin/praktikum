/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erwinekowahyudi
 */
public class Heap {
    private Node[] heapArray;
    private int maxSize;
    private int currentSize;
    
    public Heap(int mx){
        maxSize = mx;
        currentSize = 0;
        heapArray = new Node[maxSize + 1];
    }
    
    public boolean isEmpty(){
        return currentSize == 0;
    }
    
    public boolean isFull(){
        return currentSize == maxSize;
    }
    
    public boolean insert(int key){
        if (isFull()){
            return false;
        }
        
        Node newNode = new Node(key);
        currentSize++;
        heapArray[currentSize] = newNode;
        trickleUp(currentSize);
        return true;
    }
    
    public void trickleUp(int index){
        int parent = index/2;
        Node bottom = heapArray[index];
        
        while (index>1 && heapArray[parent].getKey() < bottom.getKey()){
            heapArray[index] = heapArray[parent];
            index = parent;
            parent = index/2;
        }
        
        heapArray[index] = bottom;
    }
    
    public Node remove(){
        Node root = heapArray[1];
        heapArray[1] = heapArray[currentSize];
        currentSize--;
        trickleDown(1);
        return root;
    }
    
    public void trickleDown(int index){
        int largerChild;
        Node top = heapArray[index];
        
        while (2*index <= currentSize){ // has at least left child
            int leftChild = 2*index;
            int rightChild = leftChild + 1;
            
            if (rightChild < currentSize && heapArray[rightChild].getKey() > heapArray[leftChild].getKey()){
                largerChild = rightChild;
            }
            else{
                largerChild = leftChild;
            }
            
            if (top.getKey() >= heapArray[largerChild].getKey()){ // stop looping
                break;
            }
            
            heapArray[index] = heapArray[largerChild];
            index = largerChild;
        }
        heapArray[index] = top;
    }
    
    public void displayHeap(){
        System.out.print("heapArray : ");
        
        for (int i=1 ; i<=currentSize ; i++){
            System.out.print(heapArray[i].getKey() + " ");
        }
        
        System.out.println("");
    }
}
