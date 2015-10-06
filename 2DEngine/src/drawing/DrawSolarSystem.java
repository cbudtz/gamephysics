package drawing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import static java.lang.Math.*;

import javax.swing.Timer;

public class DrawSolarSystem implements ActionListener {
	S2 solarSystem = new S2();
	long startTime;
	Timer t = new Timer(1, this);
	CBFrame frame = new CBFrame();
	S2 earthSystem = new S2();
	private static Drawable2 moon;
	private static Ellipse2 earth;
	private static Drawable2 sun;

	
	public DrawSolarSystem(){
		startTime=System.currentTimeMillis();
		t.start();
		solarSystem.flipY();
		solarSystem.scale(new V2(5, 5));
		solarSystem.setOrigo(new V2(400, 300));
	}
	

	public static void main(String[] args) {
		DrawSolarSystem simulation = new DrawSolarSystem();
		sun = new Ellipse2(new V2(-5, 0),10,10);
		earth = new Ellipse2(new V2(0,0),2,2);
		moon = new Ellipse2(new V2(4,0), 1,1);
	}
	
	//Update simulation
	@Override
	public void actionPerformed(ActionEvent e) {
		//Time 1 sek = 1 day
		double timeStep = (System.currentTimeMillis()-startTime)/365000.0;
		timeStep*=60;
		//EarthSystem
		List<Line2> moonLines = moon.getLines();
		List<Line2> earthLines = earth.getLines();
		earthLines.addAll(moonLines);
		earthSystem.setLines(earthLines);
		//Update Rotation and placement for earth
		earthSystem.setRotation(2*PI*timeStep*13);
		earthSystem.setOrigo(new V2(40,0));
		//SolarSystem
		List<Line2> solarLines = sun.getLines();
		solarLines.addAll(earthSystem.getTransformedLines());
		
		solarSystem.setLines(solarLines);
		//Rotate Solar System
		solarSystem.setRotation(2*PI*timeStep);
		//Draw the result
		frame.getPanel().setLines(solarSystem.getTransformedLines());
		
		
		

		
	}

}
