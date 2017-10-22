

class Circle extends Shape
{
	private Double radius;

	Circle(Double x_origin, Double y_origin, Double newradius,  String name, Colour colour){
		super(x_origin, y_origin, name, colour);
		radius = newradius;
	}
	public Object clone() throws CloneNotSupportedException{
		Circle c = (Circle)super.clone();
		return c;
	}
	public void shrink(double factor) throws SizeFactorException{
		if(factor < LIMIT) throw new SizeFactorException();
		else this.radius = this.radius/factor;
	}
	public void enlarge(double factor) throws SizeFactorException{
		if(factor < LIMIT) throw new SizeFactorException();
		else this.radius = this.radius*factor;
	}
	public String getName(){
		return this.name.getText();
	}
	public void setName(String newName){
		this.name.setText(newName);
	}
	public void set_radius(Double newradius){
		radius = newradius;
	}
	
	public Double get_radius() {
		return radius;
	}
	
	public Double area() {
		return Math.PI * Math.pow(radius, 2);
	}
	
	public Double perimeter() {
		return 2 * Math.PI * radius;
	}
	
	public Double  volume(){
		return 0.0;
	}
	
	
	public String toString(){
		String s = super.toString()+ "\nRadius: " + radius;
		return s;
	}
         
}