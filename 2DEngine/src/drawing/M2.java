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

	public void add(M2 m){
		this.a+=m.a;
		this.b+=m.b;
		this.c+=m.c;
		this.d+=m.d;
	}

	public void sub(M2 m){
		this.a-=m.a;
		this.b-=m.b;
		this.c-=m.c;
		this.d-=m.d;
	}
	
	public void mult(double scalar){
		this.a*=scalar;
		this.b*=scalar;
		this.c*=scalar;
		this.d*=scalar;
	}
	
	public static M2 mult(M2 m,double scalar){
		return new M2(m.a*scalar,m.b*scalar,m.c*scalar,m.d*scalar);
		
	}
	public static M2 dot(M2 m1, M2 m2){
		return new M2(m1.a*m2.a+m1.b*m2.c, m1.a*m2.b+m1.b*m2.d,
					  m1.c*m2.a+m1.d*m2.c, m1.c*m2.b+m1.d*m2.d);

	}
	public static V2 dot(M2 m, V2 v){

		return new V2(m.a*v.x + m.b*v.y,
				      m.c*v.x + m.d*v.y);

	}
	public double det(){
		return a*d-b*c;
	}
	
	public static M2 transpose(M2 m){
		return new M2(m.a , m.c,
					  m.b,  m.d);
	}
	
	public static M2 adjugate(M2 m){
		return new M2(m.d, -m.b,
					  -m.c, m.a);
	}
	
	public M2 inverse(){
		if (this.det()==0) {
			throw new ArithmeticException("No inverse matrix");
		}
		return M2.mult(M2.adjugate(this), (1/this.det()));
	}
	

}
