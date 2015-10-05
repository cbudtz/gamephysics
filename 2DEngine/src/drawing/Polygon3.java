package drawing;

import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Polygon3 implements Drawable3 {
	protected ArrayList<V3> vertices;
	private LinkedList<Integer[]> connections;
	protected V3 anchorPoint;
	public S3 modelSystem = new S3(); //TODO protection
	public Color color=Color.BLACK;
	
	
	public Polygon3(ArrayList<V3> vertices, LinkedList<Integer[]> lineConnections,V3 anchorPoint) {
		super();
		this.vertices = vertices;
		this.connections = lineConnections;
		this.anchorPoint=anchorPoint;
		updateLines();
	}

	@Override
	public Polygon3 copy()  {
		//TODO implement
		return null;
		
	};
	@Override
	public List<Line3> getTransformedLines() {
		return modelSystem.getTransformedLines();
		
	}

	private void updateLines() {
		//Connect the dots
		LinkedList<Line3> newLines = new LinkedList<>(); 
		for (Integer[] vertexIDs : connections) {
			for (int i = 1; i < vertexIDs.length; i++) {
				newLines.add(new Line3(vertices.get(vertexIDs[i-1]).add(anchorPoint), vertices.get(vertexIDs[i]).add(anchorPoint), color));
			}
		}
		modelSystem.setLines(newLines);
	}


//	@Override
//	public void moveOrigo(V2 displacement) {
//		//modelSystem.setOrigo(modelSystem.getOrigo().add(displacement));
//		ArrayList<V2> newVertices = new ArrayList<>();
//		for (V2 v2 : vertices) {
//			newVertices.add(v2.sub(displacement));
//		}
//		vertices = newVertices;
//		updateLines();
//		
//	}
	
	@Override
	public void stretch(V3 stretch) {
		modelSystem.scale(stretch);
		
	}

//
//	@Override
//	public void reflect(boolean x, boolean y) {
//		modelSystem.reflect(x, y);
//		
//	}
	

	@Override
	public void move(V3 displacement) {
		anchorPoint = anchorPoint.add(displacement);
		
	}

	

	

}
