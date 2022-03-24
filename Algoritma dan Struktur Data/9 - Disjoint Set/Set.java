public class Set{
    private int parent;
    private int rank;

    public Set(int data){
        this.parent = data;
        this.rank = 0;
    }

    public int getParent(){
        return this.parent;
    }

    public void setParent(int parent){
        this.parent = parent;
    }

    public int getRank(){
        return this.rank;
    }

    public void setRank(int rank){
        this.rank = rank;
    }
}