package drawing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Polygon2 implements Drawable2 {
	private ArrayList<V2> vertices;
	V2 anchorPoint;
	private S2 modelSystem = new S2();
	public Color color=Color.BLACK;
	
	public Polygon2(ArrayList<V2> vertices, V2 anchorPoint) {
		super();
		this.vertices = vertices;
		this.anchorPoint=anchorPoint;
	}

	@Override
	public Polygon2 copy()  {
		ArrayList<V2> newVertices = new ArrayList<>();
		for (V2 v2 : vertices) {
			newVertices.add(new V2(v2.x, v2.y));		
		}	
		return new Polygon2(newVertices,new V2(anchorPoint.x,anchorPoint.y));
		
	};
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
		LinkedList<Line2> lines = new LinkedList<>();
		V2 start = vertices.get(vertices.size()-1);
		V2 cur = start, prev = start;
		for (V2 v : vertices) {
			cur = v;
			lines.add(new Line2(prev, cur, color));
			prev = cur;
		}
		modelSystem.setLines(lines);
	}

	@Override
	public void setRotation(double rotRad) {
		modelSystem.setRotation(rotRad);
		
	}

	@Override
	public void moveOrigo(V2 displacement) {
		modelSystem.setOrigo(modelSystem.getOrigo().add(displacement));
		ArrayList<V2> newVertices = new ArrayList<>();
		for (V2 v2 : vertices) {
			newVertices.add(v2.sub(displacement));
		}
		vertices = newVertices;
		updateLines();
		
	}
	
	@Override
	public void stretch(V2 stretch) {
		modelSystem.stretch(stretch);
		
	}

	@Override
	public void shear(V2 shear) {
		modelSystem.shear(shear);
	}
	
	@Override
	public void reflect(boolean x, boolean y) {
		modelSystem.reflect(x, y);
		
	}
	

	@Override
	public void move(V2 displacement) {
		anchorPoint = anchorPoint.add(displacement);
		
	}

	

	

}
