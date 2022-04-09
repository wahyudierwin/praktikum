import java.util.Arrays;

public class Geometry {
    public static double cross(Point O, Point A, Point B) {
        return (A.x - O.x) * (B.y - O.y) - (A.y - O.y) * (B.x - O.x);
    }

    // returns true if pqr turns left (counter clockwise)
    public static boolean ccw(Point p, Point q, Point r){
        return cross(p, q, r) > 0;
    }

    public static Point[] convex_hull(Point[] P) {
        if (P.length > 2) {
            int n = P.length, k = 0;
            Point[] H = new Point[2 * n];

            Arrays.sort(P);

            // Build lower hull
            for (int i = 0; i < n; i++) {
                while (k >= 2 && !ccw(H[k - 2], H[k - 1], P[i])){ // turn right or collinear
                    k--;
                }
                H[k] = P[i];
                k++;
            }

            // Build upper hull
            for (int i = n - 2, t = k + 1; i >= 0; i--) {
                while (k >= t && !ccw(H[k - 2], H[k - 1], P[i])){
                    k--;
                }
                H[k] = P[i];
                k++;
            }
            if (k > 1) {
                H = Arrays.copyOfRange(H, 0, k - 1); // remove non-hull vertices after k; remove k - 1 which is a duplicate
            }
            return H;
        } else if (P.length <= 2) {
            return P.clone();
        } else {
            return null;
        }
    }

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
        
        Point[] hull = convex_hull(points);
        
        for (int i = 0; i < hull.length; i++) {
            if (hull[i] != null)
                System.out.println(hull[i]);
        }
    }

}