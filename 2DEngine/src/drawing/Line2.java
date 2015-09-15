package drawing;

import java.awt.Color;
import java.awt.geom.Line2D;

public class Line2 {
	public V2 startpoint;
	public V2 endpoint;
	public Color color = Color.BLACK;
	public Line2(V2 start, V2 endpoint, Color color) {
		super();
		this.startpoint = start;
		this.endpoint = endpoint;
		this.color=color;
	}
	public Line2D getLine2D(){
		return new Line2D.Double(startpoint.x,startpoint.y,endpoint.x,endpoint.y);
	}
	
	
	
	
}
