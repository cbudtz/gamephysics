package drawing;

public class Obj3d {
	public V3 velocity = new V3(0, 0, 0);
	public V3 center = new V3(0, 0, 0);
	
	public void updatePos(double timeStep) {
		center = center.add(velocity.mult(timeStep));
	}
}
