package drawing;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.LinkedList;

public class DrawTest {

	public static void main(String[] args) {
		CBFrame frame = new CBFrame();
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		
		LinkedList<Ellipse2D> ellipses = new LinkedList<>();
		
		Circle2 circle= new Circle2(new Point2D.Double(100, 100), 100);
		
		ellipses.add(circle.getCircle2D());
		frame.getPanel().setEllipses(ellipses);
		
		LinkedList<Line2D> lines = new LinkedList<>();
		Line2D line = new Line2D.Double(10, 10, 100, 100);
		lines.add(line);
		frame.getPanel().setLines(lines);

	}

}
