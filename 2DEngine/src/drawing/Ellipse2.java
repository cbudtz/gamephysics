package drawing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static java.lang.Math.*;

public class Ellipse2 extends Polygon2{
	private static final int STEPFACTOR = 1;
	private V2 center;
	private double width, height;
	public Color color= Color.BLACK;
	
	public Ellipse2(V2 center, double width, double height) {
		super(new ArrayList<V2>(),new V2(center.x,center.y));
		this.center = new V2(0,0);
		this.width = width;
		this.height = height;
	}
		
	@Override
	public List<Line2> getLines() {
		updateLines();
		
		List<Line2> modelLines = modelSystem.getTransformedLines();
		LinkedList<Line2> worldLines = new LinkedList<Line2>();
		for (Line2 line2 : modelLines) {
			worldLines.add(new Line2(line2.startpoint.add(anchorPoint), line2.endpoint.add(anchorPoint), line2.color));
		}
		return worldLines;
	
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
		//modelSystem.setOrigo(modelSystem.getOrigo().add(displacement));
		center = center.sub(displacement);
		
	};

	@Override
	public Polygon2 copy() {
		return new Ellipse2(new V2(center.x, center.y), width, height);
	}

}
