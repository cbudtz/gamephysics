package test;

import org.junit.Test;

import drawing.M2;
import drawing.V2;

public class M2Test {

	@Test
	public void testAdd() {
		M2 m = new M2(10, 0, 5, 0);
		M2 m2 = m.add(m);
		assertEquals(m2.a,20,0);
		assertEquals(m2.b,0,0);
		assertEquals(m2.c,10,0);
		assertEquals(m2.d,0,0);
	}

	@Test
	public void testSub() {
		M2 m = new M2(10, 0, 5, 0);
		M2 m2 = m.sub(m);
		assertMatrix(m2, 0, 0, 0, 0);
	}

	@Test
	public void testMultDouble() {
		M2 m = new M2(10, 1, 5, 2);
		M2 m2 = m.mult(2);
		assertMatrix(m2, 20, 2, 10, 4);
	}


	@Test
	public void testMultM2Double() {
		M2 m = new M2(10, 1, 5, 2);
		M2 m2 = m.mult( 2);
		assertMatrix(m2, 20, 2, 10, 4);
		
	}

	@Test
	public void testDotM2M2() {
		M2 m1 = new M2(10, 1, 5, 2);
		M2 m2 = new M2(10, 1, 5, 2);
		M2 m3 = m1.mult( m2);
		assertMatrix(m3, 105, 12, 60, 9);
	}

	@Test
	public void testDotM2V2() {
		M2 m = new M2(10, 1, 5, 2);
		V2 v = new V2(2,1);
		V2 v2 = m.mult( v);
		assertEquals(v2.x,21,0);
		assertEquals(v2.y,12,0);
	}

	@Test
	public void testDet() {
		M2 m = new M2(10, 1, 5, 2);
		double det = m.det();
		assertEquals(15, det,0);
	}

	@Test
	public void testTranspose() {
		M2 m = new M2(10, 1, 5, 2);
		M2 m2 = M2.transpose(m);
		assertMatrix(m2, 10, 5, 1, 2);
	}

	@Test
	public void testInverse() {
		M2 m = new M2(10,1,5,2);
		M2 minv = m.inverse();
		M2 mcheck = m.mult(minv);
		assertMatrix(mcheck, 1, 0, 0, 1);
	}
	
	
	public void assertMatrix(M2 m,double a,double b, double c,double d){
		assertEquals(a,m.a,0.1);
		assertEquals(b,m.b,0.1);
		assertEquals(c,m.c,0.1);
		assertEquals(d,m.d,0.1);
	}

}
