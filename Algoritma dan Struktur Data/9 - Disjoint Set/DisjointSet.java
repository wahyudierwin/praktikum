import java.util.ArrayList;

public class DisjointSet {
    private int[] parent;
    private int sz;
    
    public DisjointSet(int numItem){
        sz = numItem;
        this.parent = new int[sz + 1];
        for (int i=1 ; i<=this.sz ; i++){
            this.parent[i] = i;
        }
    }
    
    public int findParent(int item){
        int currentParent = this.parent[item];
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
            
            this.parent[secondItem] = smallestParent;
        }
    }
    
    public void print(){
        for (int i=1 ; i<=this.sz ; i++){
            System.out.println("Parent of " + i + " = " + this.parent[i]);
        }
    }
}
