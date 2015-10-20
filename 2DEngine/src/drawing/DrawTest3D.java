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
	Camera cam;
	CBFrame frame = new CBFrame();

	public DrawTest3D(LinkedList<Polygon3> polys) {
		this.polys=polys;
		this.t.start();
		millitime=System.currentTimeMillis();
		this.system= new S2();
		system.flipY();
		system.scale(new V2(40, 40));
		system.setOrigo(new V2(400, 300));
		cam = new Camera(new S2());
		cam.setFocusPoint(new V3(2, 2, 2)); //Focus on Cube
	}

	public static void main(String[] args) {
		ArrayList<V3> vertices = new ArrayList<>();
		vertices.add(new V3(0,3,0));//Base 1
		vertices.add(new V3(0,3,2));
		vertices.add(new V3(0,5,2));
		vertices.add(new V3(0,5,0));

		vertices.add(new V3(2,3,0));//Top 1
		vertices.add(new V3(2,3,2));
		vertices.add(new V3(2,5,2));
		vertices.add(new V3(2,5,0));
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



	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double time = (System.currentTimeMillis()-millitime)/1000.0;
		LinkedList<Line3> modelLines = new LinkedList<>();
		LinkedList<Line2> flatLines = new LinkedList<>();
		for (Polygon3 polygon3 : polys) {
			polygon3.modelSystem.setRotationXY(PI*time);
			polygon3.modelSystem.setRotationXZ(PI*time/2);
			polygon3.modelSystem.setRotationYZ(PI*time/6);
//			flatLines.addAll(polygon3.getFlattenedLines());
			modelLines.addAll(polygon3.getTransformedLines());
		}
		cam.setCameraLines(modelLines);
		flatLines = cam.getTransformedLines();
		//cam.setE(new V3(cam.E.x, cam.E.y, cam.E.z));
		system.setLines(flatLines);

		List<Line2> drawlines = system.getTransformedLines();
		frame.getPanel().setLines(drawlines);

	}

}
