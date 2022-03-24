public class DisjointSetMain {
    public static void main(String[] args) {
        DisjointSet disjointSet = new DisjointSet(5);
        disjointSet.print();
        
        disjointSet.union(3, 4);
        System.out.println("After union 3 and 4:");
        disjointSet.print();
        disjointSet.printRank();

        disjointSet.union(1, 2);
        disjointSet.union(1, 3);
        
        System.out.println("Final result:");
        disjointSet.print();
        disjointSet.printRank();
    }
}
