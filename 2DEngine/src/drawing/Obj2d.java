package drawing;

public class Obj2d {
	public V2 acceleration = new V2(0,0);
	public V2 velocity = new V2(0, 0);
	public V2 center = new V2(0, 0);
	
	public void updatePos(double timeStep) {
		velocity = velocity.add(acceleration.multiply(timeStep));
		center = center.add(velocity.multiply(timeStep));
	}
}
