package drawing;

public class M2 {
	public double a,b,c,d;

	public M2(double a, double b, double c, double d) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
		this.d = d;
	}

	public M2 add(M2 m){
		return new M2(this.a+m.a,this.b+m.b,
					  this.c+m.c,this.d+m.d);
	}

	public M2 sub(M2 m){
		return new M2(this.a-m.a, this.b-m.b,
					  this.c-m.c, this.d-m.d);
	}
	
	public M2 mult(double scalar){
		return new M2(this.a*scalar, this.b*scalar,
					  this.c*scalar, this.d*scalar);
	}
	
	public M2 mult(M2 m2) {
		return new M2(a*m2.a+b*m2.c, a*m2.b+b*m2.d,
					  c*m2.a+d*m2.c, c*m2.b+d*m2.d);
		
	}
	
	public V2 mult(V2 v) {
		return new V2(a*v.x + b*v.y,
					  c*v.x + d*v.y);
	}
	
	public double det(){
		return a*d-b*c;
	}
	
	public static M2 transpose(M2 m){
		return new M2(m.a , m.c,
					  m.b,  m.d);
	}
	
	public M2 adjugate(M2 m){
		return new M2(d, -b,
					  -c, a);
	}
	
	public M2 inverse(){
		if (this.det()==0) {
			throw new ArithmeticException("No inverse matrix");
		}
		M2 adj = adjugate(this);
		
		return adj.mult((1/this.det()));
	}



	
	

}
