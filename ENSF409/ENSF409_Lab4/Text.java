
class Text implements Cloneable, Resizable
{
	
	private final Double DEFAULT_SIZE = 10.0;
	
    private Colour colour;
    private Double fontSize;
    
    private String text;


	public Text(String text) {
       this.text = text;
       fontSize = DEFAULT_SIZE;
	}
	public Object clone() throws CloneNotSupportedException{
		Text t = (Text)super.clone();
		return t;
	}
	public void shrink(double factor) throws SizeFactorException{
		if(factor < LIMIT) throw new SizeFactorException();
		else this.fontSize = this.fontSize/factor;
	}
	public void enlarge(double factor) throws SizeFactorException{
		if(factor < LIMIT) throw new SizeFactorException();
		else this.fontSize = this.fontSize*factor;
	}
	public Double getFontSize(){
		return fontSize;
	}
	
	public void setColour(String s){
		colour = new Colour(s);
	}
	
	public void setText(String newText){
		text = newText;
	}
	
	public String getText(){
		return text ;
	}
	
	@Override
	public String toString(){
		return (text);
	}

       
}
