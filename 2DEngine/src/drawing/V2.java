package drawing;

public class V2 {
	public double x;
	public double y;
//Static convenience methods
	public static V2 add (V2 vector1, V2 vector2){
		return new V2(vector1.x+vector2.x, vector1.y+vector2.y);
	}
	
	public V2(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	//Silly comment
	
	public V2 add(V2 v2){
		return new V2(this.x +v2.x,
					  this.y +v2.y);
	}
	
	public V2 sub(V2 v2){
		return new V2(this.x-v2.x,
					  this.y-v2.y);
	}
	public V2 multiply(double scalar){
		return new V2(this.x*scalar,
					  this.y*scalar);
	}
	public V2 divide(double scalar){
		if (scalar ==0) throw new ArithmeticException("Trying to divide vector by 0 scalar! :" + V2.class);		
		return new V2(this.x/scalar,
				      this.x/scalar);
	}
	public double dot (V2 v2){
		return this.x*v2.x + this.y*v2.y;
	}
	
	public double length(){
		return Math.sqrt(x*x+y*y);
	}
	public String toString(){
		return x + "," + y;
	}
	

}
