import java.util.ArrayList;

public class DisjointSet {
    private ArrayList<Integer> parent;
    private int sz;
    
    public DisjointSet(int numItem){
        sz = numItem;
        this.parent = new ArrayList<Integer>();
        for (int i=0 ; i<=this.sz ; i++){
            this.parent.add(i);
        }
    }
    
    public int findParent(int item){
        int currentParent = this.parent.get(item);
        if (item == currentParent){
            return item;
        }
        else{
            return findParent(currentParent);
        }
    }

    public boolean isSameSet(int firstItem, int secondItem){
        return findParent(firstItem) == findParent(secondItem);
    }
    
    public void union(int firstItem, int secondItem){
        if (!isSameSet(firstItem, secondItem)){
            int firstItemParent = findParent(firstItem);
            int secondItemParent = findParent(secondItem);
            
            int smallestParent;
            
            if (firstItemParent < secondItemParent) smallestParent = firstItemParent;
            else smallestParent = secondItemParent;
            
            this.parent.set(secondItem, smallestParent);
        }
    }
    
    public void print(){
        for (int i=1 ; i<=this.sz ; i++){
            System.out.println("Parent of " + i + " = " + this.parent.get(i));
        }
    }
}
