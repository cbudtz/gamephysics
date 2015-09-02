package drawing;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;
import java.util.LinkedList;

public class DrawTest {

	public static void main(String[] args) {
		CBFrame frame = new CBFrame();
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		
		LinkedList<Ellipse2D> ellipses = new LinkedList<>();
		
		Circle2 circle= new Circle2(new Point2D.Double(100, 100), 100);
		Ellipse2 ellipse = new Ellipse2(new Point2D.Double(200, 200), 50, 40);
		
		ellipses.add(ellipse.getEllipse2D());
		ellipses.add(circle.getCircle2D());
		frame.getPanel().setEllipses(ellipses);
		
		LinkedList<Line2D> lines = new LinkedList<>();
		Point2D start = new Point2D.Double(10, 10);
		Point2D end = new Point2D.Double(20,20);
		S2 system = new S2();
		system.flipY();
		system.scale(new V2(20, 10));
		system.setOrigo(new V2(400, 300));
		
		Line2 line = new Line2(new V2(10,10), new V2(20,20));
		line.endpoint= system.transform(line.endpoint);
		line.startpoint = system.transform(line.startpoint);
		Line2D line2d = line.getLine2D();
		lines.add(line2d);
		frame.getPanel().setLines(lines);

	}

}
