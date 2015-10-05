package drawing;

import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.*;

import java.awt.Color;

public class S3 {
	private V3 origo = new V3(0,0,0); //neutral system
	private M3 F = new M3(1,0,0, 0,1,0, 0,0,1); //Flip
	private M3 S = new M3(1,0,0, 0,1,0, 0,0,1); // Scale
	
	private M3 Rx = new M3(1,0,0, 0,1,0, 0,0,1); // Rotation x
	private M3 Ry = new M3(1,0,0, 0,1,0, 0,0,1); // Rotation y
	private M3 Rz = new M3(1,0,0, 0,1,0, 0,0,1); // Rotation z
	private M3 Ra = new M3(1,0,0, 0,1,0, 0,0,1); //Rotation around arbitrary axis
	
	private M3 Sh = new M3(1,0,0, 0,1,0, 0,0,1); //Shear
	
	private M3 Ref = new M3(1,0,0, 0,1,0, 0,0,1); //Reflection
	private M3 transformation = new M3(1,0,0, 0,1,0, 0,0,1);

	private LinkedList<Line3> lines;
	
	//Transformation Matrices
//	public void flipY(){
//		F = F.mult(new M2(1,0,0,-1));
//		updateTransformation();
//	}

	public void scale(V3 scale){
		S = new M3(scale.x	, 0			, 0,
					0		, scale.y	, 0,
					0		, 0			, scale.z); 
		updateTransformation();
	}
	
//	public void shear(V2 shear){
//		Sh = new M2(1, shear.x, shear.y, 1);
//		updateTransformation();
//	}
//	
//	public void reflect(boolean x, boolean y){
//		Ref = new M2(y?-1:1, 0, 0, x?-1:1);
//		updateTransformation();
//	}
//	
	public void setRotationXY(double rotRad){
		Rz = new M3(cos(rotRad)	, -sin(rotRad)	,0,
					sin(rotRad)	, cos(rotRad)	,0,
					0			, 0				,1);
		updateTransformation();
	}
	public void setRotationXZ(double rotRad){
		Ry = new M3(cos(rotRad)		, 0				, sin(rotRad),
					0				, 1				,			0,
					-sin(rotRad)	, 0				, cos(rotRad));
		updateTransformation();
	}
	public void setRotationYZ(double rotRad){
		Rx = new M3(1				, 0				, 0			 ,
					0				, cos(rotRad)	,-sin(rotRad),
					0				, sin(rotRad)	, cos(rotRad));
		updateTransformation();
	}
	
	/** Calculates rotation around arbitrary axis
	 * @param axisVector
	 * @param rotRad
	 */
	public void setRotationArb(V3 axisVector, double rotRad){
		//R = I + sin(rho)*S + (1-cos(rho))*S^2 
		//S = ([0,-u.z,u.y], [u.z,0,-u.x], [-u.y,u.x,0]) , u = axisVector.unit
		V3 u = axisVector.unitVector();
		M3 S = new M3(0,-u.z,u.y, u.z,0,-u.x, -u.y,u.x,0);
		M3 I = new M3(1,0,0, 0,1,0, 0,0,1);
		M3 rot1= S.mult(sin(rotRad));
		M3 rot2 = S.mult(S).mult(1-cos(rotRad));
		Ra = I.add(rot1).add(rot2);
		updateTransformation();
				
	}
	
	private void updateTransformation() {
		transformation = F.mult(S).mult(Rx).mult(Ry).mult(Rz).mult(Ra).mult(Sh).mult(Ref);		
	}
	//transformation Matrices
	public V3 transform(V3 vector){
		vector = transformation.mult(vector);
		V3 v3 = vector.add(origo);
		return v3;
	}
	
	public V3 getOrigo() {
		return origo;
	}

	public void setOrigo(V3 origo) {
		this.origo = origo;
	}

	public void setLines(LinkedList<Line3> lines) {
		this.lines = lines;
	}
	
	public LinkedList<Line3> getTransformedLines(){
		LinkedList<Line3> transLines = new LinkedList<>();
		for (Line3 line3 : lines) {
			V3 start = transform(line3.startpoint);
			V3 end = transform(line3.endpoint);
			transLines.add(new Line3(start, end, line3.color));			
		}
		return transLines;
	}

	public  LinkedList<Line3> getlines() {
		// TODO Auto-generated method stub
		return lines;
	}
	
	public static void main(String[] args){
		S3 system = new S3();
		LinkedList<Line3> lines = new LinkedList<>();
		lines.add(new Line3(new V3(0, 0, 0), new V3(2, 1, 3), Color.CYAN));
		system.setLines(lines);
		system.setRotationArb(new V3(3-1, -3-(-1), 3-1), PI/3);
		lines = system.getTransformedLines();
		for (Line3 line3 : lines) {
			System.out.println(line3);
		}
		
	}

}
