package drawing;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Circle2 {
	private Point2D center;
	private double radius;
	
	public Circle2(Point2D center, double radius) {
		super();
		this.center = center;
		this.radius = radius;
	}
	
	public Ellipse2D getCircle2D(){
		return new Ellipse2D.Double(center.getX()-radius, center.getY()-radius, radius*2, radius*2);
		
	}
	
}
