

class Colour implements Cloneable
{
    private String colour;
    
	public Colour(String s) {
		colour = new String(s);
	}
	public Object clone() throws CloneNotSupportedException{
		Colour c = (Colour)super.clone();
		return c;
	}
    public void setColour(String newColour){
    	colour = newColour;
    }
    
	@Override
	public String toString(){
		return colour;
	}

}
