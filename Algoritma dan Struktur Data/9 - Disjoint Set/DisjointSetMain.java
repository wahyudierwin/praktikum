public class DisjointSetMain {
	public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(10);
        disjointSet.print();
        
        System.out.println(disjointSet.findParent(1));
        
        disjointSet.union(3, 6);
        
        disjointSet.print();
    }
}
