package drawing;

public class V2 {
	double x,y;
//Static convenience methods
	public static V2 add (V2 vector1, V2 vector2){
		return new V2(vector1.x+vector2.x, vector1.y+vector2.y);
	}
	
	public V2(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}
	
	public void add(V2 v2){
		this.x +=v2.x;
		this.y +=v2.y;
	}
	
	public void sub(V2 v2){
		this.x-=v2.x;
		this.y-=v2.y;
	}
	public void multiply(double scalar){
		this.x*=scalar;
		this.y*=scalar;
	}
	public void divide(double scalar){
		if (scalar ==0) throw new ArithmeticException("Trying to divide vector by 0 scalar! :" + V2.class);
		this.x/=scalar;
		this.x/=scalar;
	}
	public double dot (V2 v2){
		return this.x*v2.x + this.y*v2.y;
	}
	
	public double length(){
		return Math.sqrt(x*x+y*y);
	}
	

}
