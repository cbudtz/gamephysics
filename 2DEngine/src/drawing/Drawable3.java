package drawing;

import java.util.List;

public interface Drawable3 {

	Polygon3 copy();

	List<Line3> getTransformedLines();

	void stretch(V3 stretch);

	void move(V3 displacement);

}
