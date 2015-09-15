package drawing;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.*;

public class Ellipse2 implements Drawable2{
	private static final int STEPFACTOR = 4;
	private V2 center;
	private double width, height;
	private S2 modelSystem = new S2();
	public Color color= Color.BLACK;
	
	public Ellipse2(V2 center, double width, double height) {
		super();
		this.center = center;
		this.width = width;
		this.height = height;
	}
		
	@Override
	public List<Line2> getLines() {
		updateLines();
		
		return modelSystem.getTransformedLines();
	}

	private void updateLines() {
		LinkedList<Line2>lines = new LinkedList<>();
		V2 start= new V2(center.x+width, center.y);
		V2 prev = start, cur = start;
		for (double rho=0;rho<2*PI;rho+=PI/(sqrt(width+height)*STEPFACTOR)){
			cur = new V2(center.x+cos(rho)*width, center.y+sin(rho)*height);
			lines.add (new Line2(prev, cur,color));
			prev=cur;
		}
		lines.add(new Line2(start, cur, color));
		modelSystem.setLines(lines);
	}

	@Override
	public void setRotation(double rotRad) {
		modelSystem.setRotation(rotRad);
		
	}

	@Override
	public void moveOrigo(V2 displacement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Drawable2 copy() {
		return null;
	}

	@Override
	public void move(V2 displacement) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stretch(V2 stretch) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void shear(V2 shear) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void reflect(boolean x, boolean y) {
		// TODO Auto-generated method stub
		
	}
}
