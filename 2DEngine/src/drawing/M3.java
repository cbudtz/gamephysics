package drawing;

public class M3 {
	double[][] a = new double[3][3];

	public M3(double a11, double a12, double a13, double a21, double a22, double a23, double a31, double a32, double a33) {
		a[0][0] = a11;	a[0][1] = a12;	a[0][2] = a13;
		a[1][0] = a21;	a[1][1] = a22;	a[1][2] = a23;
		a[2][0] = a31;	a[2][1] = a32;	a[2][2] = a33;
		
		
	}
	
	public M3(){
		this(	0d,0d,0d,
				0d,0d,0d,
				0d,0d,0d);
	}
	
	public M3(double[][] a){
		this.a=a;
	}

	public M3 add(M3 m){
		M3 result = new M3();
		for (int i =0;i<3;i++) {
			for (int j=0;j<3;j++) {
				result.a[i][j] = this.a[i][j]+m.a[i][j];
			}
		}
		return result;
	}

	public M3 sub(M3 m){
		M3 result = new M3();
		for (int i =0;i<3;i++) {
			for (int j=0;j<3;j++) {
				result.a[i][j] = this.a[i][j]-m.a[i][j];
			}
		}
		return result;
		
	}
	
	public M3 mult(double scalar){
		M3 result = new M3();
		for (int i =0;i<3;i++) {
			for (int j=0;j<3;j++) {
				result.a[i][j] = this.a[i][j]*scalar;
			}
		}
		return result;
		
	}
	
	public M3 mult(M3 m3) {
        M3 result=new M3();
        for (int r=0; r<3; r++)
            for (int c=0; c<3; c++)
                result.a[r][c]=row(r).mult(m3.col(c));
        return result;		
		
		
	}
	
	private V3 col(int c) {
		return new V3(a[0][c],a[1][c],a[2][c]);
	}

	private V3 row(int r) {
		return new V3(a[r][0],a[r][1],a[r][2]);
	}

	public V3 mult(V3 v) {
		return new V3(row(0).mult(v),row(1).mult(v),row(2).mult(v));
		
	}
	
	public double det(){
		return 	a[0][0]*a[1][1]*a[2][2]+a[0][1]*a[1][2]*a[2][0]+a[0][2]*a[1][0]*a[2][1]-
				a[2][0]*a[1][1]*a[0][2]-a[2][1]*a[1][2]*a[0][0]-a[2][2]*a[1][0]*a[0][1];
		
	}
	
	public static M3 transpose(M3 m){
		return null;

	}

	
	public M3 inverse(){
		if (this.det()==0) {
			throw new ArithmeticException("No inverse matrix");
		}
		M3 adj = adjugate(this);
		
		return adj.mult((1/this.det()));
	}

	private M3 adjugate(M3 m3) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String toString() {
		String returnString = "";
		for (int i =0;i<3;i++) {
			returnString+="[";
			for (int j=0;j<3;j++) {
				returnString+=a[i][j];
				returnString+=",";
			}
			returnString+="]\r\n";
		} 
		returnString+="";
		return returnString;
	}

	public static void main(String[] args){
		M3 m = new M3(	1,2,3,
						3,2,1,
						2,1,3);
		M3 addm = m.add(m);
		System.out.println(m);
		System.out.println(addm);
		System.out.println(m.sub(m));
		System.out.println(m.det());
		System.out.println(m.mult(m));
		System.out.println(m.mult(new V3(1,2,3)));
		System.out.println(m.mult(2));
		
	}
	

}
