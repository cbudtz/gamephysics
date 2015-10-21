package drawing;

import java.util.LinkedList;

public class Camera {
	//neutral system
	final V3 O = new V3(0,0,0);
	final V3 i = new V3(1, 0, 0);
	final V3 j = new V3(0, 1, 0);
	final V3 k = new V3(0,0,1);
	
	//Projection Plane
	S2 screen; 
	double pDist = 40; //Projection distance

	//Camera system
	V3 E = new V3(0, 0, 40); //Camera Placement
	V3 F = new V3(0, 0, 0); //Focus Point
	M3 RUD = new M3(1, 0, 0,
					0, 1, 0,
					0, 0, 1); //Transformation matrix
	
	//Camera transformations
	M3 Roll = new M3	(1, 0, 0,
					 	 0, 1, 0,
					 	 0, 0, 1);
	M3 Pitch = new M3	(1, 0, 0,
		 	 			 0, 1, 0,
		 	 			 0, 0, 1);
	M3 Yaw = new M3	(1, 0, 0,
		 	 		 0, 1, 0,
		 	 		 0, 0, 1);
			
	
	//Lines for projection
	LinkedList<Line3> cameraLines = new LinkedList<>();

	public Camera(S2 screen) {
		this.screen=screen;
	}
	
	private V2 project(V3 point){
		//transform into camera coordinates
		V3 EP = point.sub(E);
		V3 transPoint = RUD.mult(EP);
		//Projection
		return new V2(transPoint.x*pDist/transPoint.z, transPoint.y*pDist/transPoint.z);
	}

	public void setCameraLines(LinkedList<Line3> cameraLines) {
		this.cameraLines = cameraLines;
	}

	public LinkedList<Line2> getTransformedLines(){
		LinkedList<Line2> transLines = new LinkedList<Line2>();
		for (Line3 line3 : cameraLines) {
			V2 startPoint = project(line3.startpoint);
			V2 endPoint = project(line3.endpoint);
			transLines.add(new Line2(startPoint, endPoint, line3.color));
		}
		return transLines;
	}

	public void setE(V3 e) {
		E = e;
	}

	public void setFocusPoint(V3 f) {
		F = f;
		updateTransformation();
	}

	private void updateTransformation() {
		V3 d = F.sub(E);
		System.out.println(d);
		d = d.unitVector();
		V3 r = d.cross(k);
		r = r.unitVector();
		V3 u = d.cross(r);
		System.out.println(r);
		System.out.println(u);
		System.out.println(d);
		RUD = new M3(r.x, r.y, r.z, u.x, u.y, u.z, d.x, d.y, d.z);
		
	}





}
