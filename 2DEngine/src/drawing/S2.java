package drawing;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.LinkedList;

public class S2 {
	private V2 origo = new V2(0,0); //neutral system
	private M2 transformation = new M2(	1, 0, 
										0, 1);

	private LinkedList<Ellipse2> ellipses;
	private LinkedList<Line2> lines;
	
	public void flipY(){
		transformation = transformation.mult(new M2(1,0,
								   					0,-1));
	}
	
	public void scale(V2 scale){
		transformation = transformation.mult(new M2(scale.x, 0,
													0, scale.y));
	}
	
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

	public void setEllipses(LinkedList<Ellipse2> ellipses) {
		this.ellipses = ellipses;
	}

	public void setLines(LinkedList<Line2> lines) {
		this.lines = lines;
	}
	
	public LinkedList<Line2D> getTransformedLines(){
		LinkedList<Line2D> transLines = new LinkedList<>();
		for (Line2 line2 : lines) {
			line2.startpoint = transform(line2.startpoint);
			line2.endpoint = transform(line2.endpoint);
			transLines.add(line2.getLine2D());			
		}
		return transLines;
	}

}
