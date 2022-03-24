import java.util.ArrayList;

public class DisjointSet {
    private Set[] sets;
    private int sz;
    
    public DisjointSet(int numItem){
        this.sz = numItem;
        this.sets = new Set[sz + 1];
        for (int i=1 ; i<=this.sz ; i++){
            this.sets[i] = new Set(i);
        }
    }
    
    public int find(int item){
        int parent = this.sets[item].getParent();
        if (item == parent){
            return item;
        }
        else{
            parent = find(parent);
            this.sets[item].setParent(parent); // path compression
            return parent;
        }
    }

    public boolean isSameSet(int firstItem, int secondItem){
        return find(firstItem) == find(secondItem);
    }
    
    public void union(int firstItem, int secondItem){ // union by rank
        int firstItemParent = find(firstItem);
        int secondItemParent = find(secondItem);

        if (firstItemParent != secondItemParent){
            int firstItemRank = this.sets[firstItem].getRank();
            int secondItemRank = this.sets[secondItem].getRank();

            if (firstItemRank < secondItemRank){
                this.sets[firstItem].setParent(secondItem);
            }
            else if (firstItemRank > secondItemRank){
                this.sets[secondItem].setParent(firstItem);
            }
            else{
                this.sets[secondItem].setParent(firstItem);
                this.sets[firstItem].setRank(firstItemRank + 1);
            }
        }
    }
    
    public void print(){
        for (int i=1 ; i<=this.sz ; i++){
            System.out.println("Parent of " + i + " = " + find(i));
        }
    }

    public void printRank(){
        for (int i=1 ; i<=this.sz ; i++){
            System.out.println("Rank of " + i + " = " + this.sets[i].getRank());
        }
    }
}
