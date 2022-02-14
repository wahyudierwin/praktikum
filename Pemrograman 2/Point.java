class Point implements Comparable<Point> {
	double x, y;

	private double EPS = 1e-9;
	public Point(){
		x = 0.0;
		y = 0.0;
	}

	public Point(double _x, double _y){
		x = _x;
		y = _y;
	}

	public int compareTo(Point other) {
      	if (Math.abs(x - other.x) > EPS){
        	return (int)Math.ceil(x - other.x);
    	}
      	else if (Math.abs(y - other.y) > EPS){
        	return (int)Math.ceil(y - other.y);
    	}
      	else {
        	return 0;  
      	}
    }

	public String toString() {
		return "(" + x + "," + y + ")";
	}
}