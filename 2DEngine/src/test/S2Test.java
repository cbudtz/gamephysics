package test;

import static org.junit.Assert.*;

import org.junit.Test;

import drawing.S2;
import drawing.V2;

public class S2Test {

	@Test
	public void testFlipY() {
		S2 system = new S2();
		system.flipY();
		V2 vector = system.transform(new V2(10, 10));
		assertV2(vector, 10,-10);
	}

	@Test
	public void testScale() {
		S2 system = new S2();
		system.scale(new V2(2,5));
		V2 vector = system.transform(new V2(10,10));
		assertV2(vector,20,50);
	}

	@Test
	public void testTransform() {
		
	}
	
	

	private void assertV2(V2 vector, double i, double j) {
		assertEquals(i, vector.x,0.001);
		assertEquals(j, vector.y,0.001);
		
	}

	

}
