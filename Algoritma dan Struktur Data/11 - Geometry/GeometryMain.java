public class GeometryMain{
    public static void main(String[] args) {
        Point[] points = new Point[10];
        points[0] = new Point(10, 1);
        points[1] = new Point(2, 2);
        points[2] = new Point(2, 3);
        points[3] = new Point(3, 4);
        points[4] = new Point(9, 5);
        points[5] = new Point(9, 6);
        points[6] = new Point(6, 7);
        points[7] = new Point(6, 8);
        points[8] = new Point(5, 9);
        points[9] = new Point(8, 10);
        
        Point[] hull = Geometry.convex_hull(points);
        
        for (int i = 0; i < hull.length; i++) {
            if (hull[i] != null)
                System.out.println(hull[i]);
        }
    }
}
