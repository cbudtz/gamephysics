package drawing;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.LinkedList;
import java.util.List;

import javax.swing.Timer;

import static java.lang.Math.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawTest3D implements ActionListener{
	public Timer t = new Timer(1, this);
	private long millitime;
	LinkedList<Polygon3> polys;
	S2 system;
	CBFrame frame = new CBFrame();

	public DrawTest3D(LinkedList<Polygon3> polys) {
		this.polys=polys;
		this.t.start();
		millitime=System.currentTimeMillis();
		this.system= new S2();
		system.flipY();
		system.scale(new V2(20, 20));
		system.setOrigo(new V2(400, 300));
	}

	public static void main(String[] args) {
		ArrayList<V3> vertices = new ArrayList<>();
		vertices.add(new V3(1,4,1));//Base 1
		vertices.add(new V3(1,4,3));
		vertices.add(new V3(1,6,3));
		vertices.add(new V3(1,6,1));

		vertices.add(new V3(3,4,1));//Top 1
		vertices.add(new V3(3,4,3));
		vertices.add(new V3(3,6,3));
		vertices.add(new V3(3,6,1));
		LinkedList<Integer[]> lineConnections = new LinkedList<>();
		lineConnections.add(new Integer[]{0,1,2,3,0,4,5,6,7,4});
		lineConnections.add(new Integer[]{1,5});
		lineConnections.add(new Integer[]{2,6});
		lineConnections.add(new Integer[]{3,7});
		Polygon3 cube = new Polygon3(vertices, lineConnections, new V3(0, 0, 0));
		//Polygons
		LinkedList<Polygon3> polys = new LinkedList<>();
		polys.add(cube);


		DrawTest3D test = new DrawTest3D(polys);
		cube.modelSystem.setRotationXY(PI/10000);



	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double time = (System.currentTimeMillis()-millitime)/1000.0;
		LinkedList<Line2> flatLines = new LinkedList<>();
		for (Polygon3 polygon3 : polys) {
			polygon3.modelSystem.setRotationXY(PI*time);
			polygon3.modelSystem.setRotationXZ(PI*time/2);
			polygon3.modelSystem.setRotationYZ(PI*time/6);
			flatLines.addAll(polygon3.getFlattenedLines());
		}
		
		 
		system.setLines(flatLines);

		List<Line2> drawlines = system.getTransformedLines();
		frame.getPanel().setLines(drawlines);

	}

}
