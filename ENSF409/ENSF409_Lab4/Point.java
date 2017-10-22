

class Point implements Cloneable
{
	private Colour colour;
	private Double xCoordinate, yCoordinate;

	
	public Point(Double a, Double b, Colour c){
		colour = (c);
		xCoordinate = a;
		yCoordinate = b;
	}
	public Object clone() throws CloneNotSupportedException{
		Point p = (Point)super.clone();
		p.colour = (Colour)colour.clone();
		return p;
	}
    @Override
	public String toString()   {
		String s;
		s = "X_coordinate: " + xCoordinate +  "\nY-coordinate: " + yCoordinate +
				"\n" + colour + " point" ;
		return s;
	}
	
	public Double  getx()   {
		return xCoordinate;
	}
	
	void  setx(Double newvalue){
		xCoordinate = newvalue;
	}
	
	public Double  gety()   {
		return yCoordinate;
	}
	
	public void  sety(Double newvalue){
		yCoordinate = newvalue;
	}
	
	public Double  distance(Point  other){
		Double dist_x = other.xCoordinate - xCoordinate;
		Double dist_y = other.yCoordinate - yCoordinate;
		
		return (Math.sqrt(Math.pow(dist_x, 2) + Math.pow(dist_y, 2)));
	}
	
	static Double  distance (Point  that, Point  other){
		Double dist_x = other.xCoordinate - that.xCoordinate;
		Double dist_y = other.yCoordinate - that.yCoordinate;
		
		return (Math.sqrt(Math.pow(dist_x, 2) + Math.pow(dist_y, 2)));
	}
}