package drawing;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;

public class Ellipse2 {
	private Point2D center;
	private double width, height;
	
	public Ellipse2(Point2D center, double width, double height) {
		super();
		this.center = center;
		this.width = width;
		this.height = height;
	}
	
	public Ellipse2D getEllipse2D(){
		return new Ellipse2D.Double(center.getX()-width, center.getY()-height, width*2, height*2);
		
	}
}
