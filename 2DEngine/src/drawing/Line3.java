package drawing;

import java.awt.Color;

public class Line3 {
	public V3 startpoint;
	public V3 endpoint;
	public Color color = Color.BLACK;
	public Line3(V3 start, V3 endpoint, Color color) {
		super();
		this.startpoint = start;
		this.endpoint = endpoint;
		this.color=color;
	}
	
	
	
}
