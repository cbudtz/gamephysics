package drawing;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DrawTest3D {

	public static void main(String[] args) {
		ArrayList<V3> vertices = new ArrayList<>();
		vertices.add(new V3(1,4,1));//Base 1
		vertices.add(new V3(1,4,3));
		vertices.add(new V3(1,6,1));
		vertices.add(new V3(1,6,3));
		
		vertices.add(new V3(3,4,1));//Top 1
		vertices.add(new V3(3,4,3));
		vertices.add(new V3(3,6,1));
		vertices.add(new V3(3,6,3));
		LinkedList<Integer[]> lineConnections = new LinkedList<>();
		lineConnections.add(new Integer[]{0,1,2,3,0,4,5,6,7,4});
		lineConnections.add(new Integer[]{1,5});
		lineConnections.add(new Integer[]{2,6});
		lineConnections.add(new Integer[]{3,7});
			
		Polygon3 cube = new Polygon3(vertices, lineConnections, new V3(0, 0, 0));
		List<Line3> translines = cube.getTransformedLines();
		
		for (Line3 line3 : translines) {
			System.out.println(line3);
		}
	}

}
