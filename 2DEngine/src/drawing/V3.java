package drawing;
import static java.lang.Math.*;

public class V3 {
	public double x,y,z = 0;
		
	public V3(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public V3 add(V3 v){
		return new V3(x+v.x,y+v.y,z+v.z);
	}

	public double mult(V3 v){
		 return x*v.x+y*v.y+z*v.z;
	}
	
	public V3 mult(double scalar){
		return new V3(x*scalar, y*scalar, z*scalar);
	}
	
	public V3 cross(V3 v){
		return new V3(	y*v.z-z*v.y,
					  	z*v.x-x*v.z,
						x*v.y-y*v.x);
	}
	
	public double length(){
		return sqrt(x*x+y*y+z*z);
		
	}
	public V3 unitVector(){
		double l = length();
		return new V3(x/l,y/l,z/l);
	}
	
	@Override
	public String toString() {
		return "(" + x + "," + y + "," + z + ")";
	}
	public static void main(String[] args){
		V3 u = new V3(4, 0, -2);
		V3 v = new V3(3,1,-1);
		V3 w = new V3(2, 1, 6);
		V3 s = new V3(1, 4, 1);
		System.out.println(u.mult(v));
		//System.out.println(u.cross(u));
		System.out.println(v.mult(s));
		System.out.println(w.unitVector());
		System.out.println(u.mult(v.mult(s)));
		
	}

}
