package drawing;

import java.awt.geom.Line2D;

public class Line2 {
	public V2 startpoint;
	public V2 endpoint;
	public Line2(V2 start, V2 endpoint) {
		super();
		this.startpoint = start;
		this.endpoint = endpoint;
	}
	public Line2D getLine2D(){
		return new Line2D.Double(startpoint.x,startpoint.y,endpoint.x,endpoint.y);
	}
	
	
	
	
}
