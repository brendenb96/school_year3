
class Rectangle extends Shape
{
	protected Double width, length;
	
	public Rectangle(Double x_origin, Double y_origin, Double newlength, Double newwidth, String  name, Colour colour){
		super(x_origin, y_origin, name, colour);
		length= newlength;
		width =newwidth;
	}
	public Object clone() throws CloneNotSupportedException{
		Rectangle r = (Rectangle)super.clone();
		return r;
	}
	public void shrink(double factor) throws SizeFactorException{
		if(factor < LIMIT) throw new SizeFactorException();
		else{
			this.width = this.width/factor;
			this.length = this.length/factor;
		}
	}
	public void enlarge(double factor) throws SizeFactorException{
		if(factor < LIMIT) throw new SizeFactorException();
		else{
			this.width = this.width*factor;
			this.length = this.length*factor;
		}
	}
	public String getName(){
		return this.name.getText();
	}
	public void setName(String newName){
		this.name.setText(newName);
	}
	protected void  set_length(Double newlength){
		length = newlength;
	}
	
	protected Double  get_length() {
		return length;
	}
	
	protected Double  area(){
		return  width *length;
	}
	
	protected Double  perimeter(){
		return  width  * 2 + length * 2;
	}
	
	protected Double  volume(){
		return 0.0;
	}
	
	@Override
	public String toString(){
		String s = super.toString()+ "\nWidth: " + width + "\nLength: " + length;
		return s;
	}
        	
}