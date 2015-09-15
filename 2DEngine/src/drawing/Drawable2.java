package drawing;

import java.util.List;

public interface Drawable2 {

	List<Line2> getLines();
	//Manipulate Model
	void setRotation(double rotRad);
	void moveOrigo(V2 displacement);
	Drawable2 copy();
	void stretch(V2 stretch);
	void shear(V2 shear);
	void reflect(boolean x, boolean y);
	//Manipulate virtual coordinates
	void move(V2 displacement);
	
}
