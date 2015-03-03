package GraphTheory;


public class Point {
	
	/**
	 * Stores internal variables in Cartesian coordinates
	 */
	private double x;
	private double y;

	/**
	 * Default constructor - initializes to null vector
	 */
	public Point() {
		x = 0;
		y = 0;
	}

	/**
	 *  Basic Cartesian constructor (right-handed coordinate system)
	 * @param x - x coordinate
	 * @param y - y coordinate
	 * @param z - z coordinate
	 */
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Vector copy constructor
	 * @param rhs - Vector3 object to copy
	 */
	public Point(Point rhs) {
		x = rhs.x;
		y = rhs.y;
	}


	public double getX() {
		return x;
	}

	/**
	 * @param x - New x coordinate
	 */
	public void setX(double x) {
		this.x = x;
	}

	/**
	 * @return y coordinate
	 */
	public double getY() {
		return y;
	}

	/**
	 * @param y - New y coordinate
	 */
	public void setY(double y) {
		this.y = y;
	}

	
	/**
	 * Adds a vector to this one and returns the result
	 * @param v2 - the other vector
	 * @return the sum of this vector and v2
	 */
	public Point add(Point p) {
		return add(this, p);
	}
	
	/**
	 * Subtracts a vector from this one and returns the result
	 * @param v2 - the other vector
	 * @return the difference of this vector and v2
	 */
	public Point subtract(Point v2) {
		return subtract(this, v2);
	}
	
	/**
	 * @return the magnitude of the vector
	 */
	public double getDistance(Point v1)
	{
		double xvalue= Math.pow(this.getX()-v1.getX(), 2);
		double yvalue= Math.pow(this.getY()-v1.getY(), 2);
		double finddistance= Math.sqrt(xvalue+ yvalue);
		return finddistance;
	}
	
	public double findAngle(Point v1)
	{
		
		double deltaX= this.getX()-v1.getX();
		double deltaY= this.getY()-v1.getY();
		double angleInDegrees = Math.atan2(deltaY, deltaX) * 180 *(1/Math.PI);
		//double angleInDegrees = Math.atan(deltaY/deltaX) * 180 *(1/Math.PI);
		return angleInDegrees;
	}

	/**
	 * Adds two vectors
	 * @param v1 - the first addend
	 * @param v2 - the second addend
	 * @return the sum of the two vectors
	 */
	public static Point add(Point v1, Point v2) {
		return new Point(v1.x + v2.x, v1.y + v2.y);
	}
	
	
	/**
	 * Subtracts one vector from another
	 * @param v1 - the initial vector
	 * @param v2 - the vector to be subtracted
	 * @return v1 - v2
	 */
	public static Point subtract(Point v1, Point v2) {
		return new Point(v1.x - v2.x, v1.y - v2.y);
	}
	
	/**
	 * Multiplies a vector by a scalar
	 * @param v1 - the initial vector
	 * @param scaler - the amount to scale the vector by
	 * @return the scaled vector
	 */
	public static Point scale(Point v1, double scaler) {
		return new Point(v1.x * scaler, v1.y * scaler);
	}
	
	/**
	 * Gives the dot product (Euclidean scalar product) of two vectors
	 * @param v1 - one vector
	 * @param v2 - another vector
	 * @return the dot product of the vectors
	 */
	public static double dot(Point v1, Point v2) {
		return v1.x * v2.x + v1.y * v2.y ;
	}
	
	/**
	 * Gives the cross product of two vectors.  (Technically an axial vector, not a vector,
	 * or even better a rank-2 asymmetrical tensor, but we don't need to worry about that in this class.)
	 * @param v1 - the first vector
	 * @param v2 - the second vector
	 * @return - v1 x v2
	 */
	
	
	/**
	 * @return a null vector
	 */
	public static Point resetPoint() {
		return new Point(0, 0);
	}
	
	
}

