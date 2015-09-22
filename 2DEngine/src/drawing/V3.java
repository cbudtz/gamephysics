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
	

	private V3 sub(V3 v) {
		return new V3(x-v.x,y-v.y,z-v.z);
		
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
	public void log(){
		System.out.println(this);
	}

	public void log(String message) {
		System.out.println(message +"->" + this);
		
	}
	
	public static void main(String[] args){
		V3 u = new V3(4, 0, -2);
		V3 v = new V3(3,1,-1);
		V3 w = new V3(2, 1, 6);
		V3 s = new V3(1, 4, 1);
		System.out.println(u.mult(v));
		System.out.println(v.mult(s));
		System.out.println(w.unitVector());
		System.out.println(u.mult(v.mult(s)));
		System.out.println(u.mult(v)*v.mult(s));
		System.out.println(new V3(1, 1, 1).mult(new V3(1,3,-4)));
		
		V3 p = new V3(1, 1, 1);
		V3 q = new V3(0,-1, 2);
		V3 r = new V3(2, 2, 1);
		p.cross(q).log();
		p.cross(r).log();
		r.cross(q).log();
		System.out.println(p.cross(r).mult(q));
		q.mult(r.cross(p));
		p.cross(r).cross(q).log();
		System.out.println("\n");
		V3 A = new V3(1, 1, 1);
		V3 B = new V3(0,-1, 2);
		V3 C = new V3(2, 2, 1);
		
		V3 AB = B.sub(A);
		AB.log();
		V3 AC = C.sub(A);
		AC.log();
		AB.cross(AC).unitVector().log();
		System.out.println(abs(AC.mult(AB)*0.5));
		
		
		
	}
	

}
