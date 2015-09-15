package drawing;

import java.awt.Color;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class DrawTest {

	public static void main(String[] args) {
		CBFrame frame = new CBFrame();



		Ellipse2 ellipse = new Ellipse2(new V2(1, 1), 10, 10);
		ArrayList<V2> polyVertices = new ArrayList<>();
		polyVertices.add(new V2(0,0));
		polyVertices.add(new V2(2, 0));
		polyVertices.add(new V2(2, 2));
		polyVertices.add(new V2(0, 2));
		Polygon2 polygon = new Polygon2(polyVertices,new V2(1,1));
		Polygon2 polygon2 = polygon.copy();
		
		S2 system = new S2();
		system.flipY();
		system.scale(new V2(20, 20));
		system.setOrigo(new V2(400, 300));
		
		for (int i = 0; i < 100000; i++) {
			//		Manipulating model
					polygon.moveOrigo(new V2(0.0000001*i, 0));
							polygon.setRotation(i*Math.PI/1000);
			//moving model
			polygon.move(new V2(0.0001, 0.0001));
			polygon.color=Color.RED;
			polygon2.shear(new V2(i*.001, 0));
			polygon2.reflect(false, true);
			polygon2.color = Color.BLUE;
			
			LinkedList<Drawable2> drawables = new LinkedList<>();
			drawables.add(ellipse);
			drawables.add(polygon);
			drawables.add(polygon2);
			LinkedList<Line2> lines = new LinkedList<>();
			for (Drawable2 drawable2 : drawables) {
				for (Line2 line2 : drawable2.getLines()) {
					lines.add(line2);
				}
			}
			lines.add(new Line2(new V2(1, 1), new V2(2, 2), Color.black));
			system.setLines(lines);
			List<Line2> drawLines = system.getTransformedLines();
			frame.getPanel().setLines(drawLines);
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
