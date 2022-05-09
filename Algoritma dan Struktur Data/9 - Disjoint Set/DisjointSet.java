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
            int firstRank = this.sets[firstItemParent].getRank();
            int secondRank = this.sets[secondItemParent].getRank();

            if (firstRank < secondRank){
                this.sets[firstItemParent].setParent(secondItemParent);
            }
            else if (firstRank > secondRank){
                this.sets[secondItemParent].setParent(firstItemParent);
            }
            else{
                this.sets[secondItemParent].setParent(firstItemParent);
                this.sets[firstItemParent].setRank(firstRank + 1);
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
