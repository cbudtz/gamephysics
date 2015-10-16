package drawing;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.*;

public class S2 {
	private V2 origo = new V2(0,0); //neutral system
	private M2 F = new M2(1, 0, 0, 1); //Flip
	private M2 S = new M2(1, 0, 0, 1); // Scale
	private M2 R = new M2(1, 0, 0, 1); // Rotation
	private M2 St = new M2(1, 0, 0, 1); //Stretch
	private M2 Sh = new M2(1,0,0,1); //Shear
	private M2 Ref = new M2(1,0,0,1); //Reflection
	private M2 transformation = new M2(	1, 0, 
										0, 1);

	private List<Line2> lines;
	//Transformation Matrices
	public void flipY(){
		F = F.mult(new M2(1,0,0,-1));
		updateTransformation();
	}

	public void scale(V2 scale){
		S = new M2(scale.x, 0,
				0, scale.y); 
		updateTransformation();
	}
	
	public void stretch(V2 stretch){
		St = new M2(stretch.x, 0, 0, stretch.y);
		updateTransformation();
	}
	public void shear(V2 shear){
		Sh = new M2(1, shear.x, shear.y, 1);
		updateTransformation();
	}
	
	public void reflect(boolean x, boolean y){
		Ref = new M2(y?-1:1, 0, 0, x?-1:1);
		updateTransformation();
	}
	
	public void setRotation(double rotRad){
		R = new M2(cos(rotRad), -sin(rotRad),
					sin(rotRad), cos(rotRad));
		updateTransformation();
	}
	
	private void updateTransformation() {
		transformation = F.mult(S).mult(R).mult(Sh).mult(St).mult(Ref);		
	}
	//transformation Matrices
	public V2 transform(V2 vector){
		vector = transformation.mult(vector);
		V2 v2 = vector.add(origo);
		return v2;
	}
	
	public V2 getOrigo() {
		return origo;
	}

	public void setOrigo(V2 origo) {
		this.origo = origo;
	}

	public void setLines(List<Line2> lines) {
		this.lines = lines;
	}
	
	public List<Line2> getTransformedLines(){
		LinkedList<Line2> transLines = new LinkedList<>();
		for (Line2 line2 : lines) {
			V2 start = transform(line2.startpoint);
			V2 end = transform(line2.endpoint);
			transLines.add(new Line2(start, end, line2.color));			
		}
		return transLines;
	}

	public  List<Line2> getlines() {
		// TODO Auto-generated method stub
		return lines;
	}

}
