

class Prism extends Rectangle
{
	private Double height;
	
	public Prism(Double x, Double y, Double l, Double w, Double h, String  name, Colour colour)
	{
		super(x, y, l, w, name, colour);
		height = h;
	}	
	public Object clone() throws CloneNotSupportedException{
		Prism p = (Prism)super.clone();
		return p;
	}
	public void shrink(double factor) throws SizeFactorException{
		if(factor < LIMIT) throw new SizeFactorException();
		else{
			this.height = this.height/factor;
			this.width = this.width/factor;
			this.length = this.length/factor;
		}
	}
	public void enlarge(double factor) throws SizeFactorException{
		if(factor < LIMIT) throw new SizeFactorException();
		else{
			this.height = this.height*factor;
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
	public void  set_height(Double h)
	{
		height = h;
	}
	
	public Double  height() 
	{
		return height;
	}
	
	public Double  area()
	{
		return  2 * (length * width) + 2 * (height * length) + 2 * (height * width); 
	}
	
	public Double  perimeter()
	{
		return  width  * 2 + length * 2;
	}
	
	public Double  volume()
	{
		return  width  * length * height;
	}
	
	
	public String toString()
	{
		String s = super.toString()+ "\nheight: " + height;
		return s;
	}
}