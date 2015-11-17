package drawing;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.NetworkChannel;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import static java.lang.Math.*;

import javax.swing.Timer;

public class DrawComet implements ActionListener
{
	private static final long SimSpeedFactor = 10000;
	private CBFrame frame;
	private Ellipse2 earth;
	private Ellipse2 geostationary;
	private Ellipse2 comet;
	private Obj2d cometBody = new Obj2d();
	private Obj2d cometBody2 = new Obj2d();
	private S2 system;
	private LinkedList<Drawable2> drawables;
	private Timer timer = new Timer(1, this);
	private long prevTime;
	private Ellipse2 comet2;

	public static void main(String[] args) {
		new DrawComet().run();




		try {
			Thread.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void run() {
		frame = new CBFrame();
		double cometSpeed = 15000*1000/3600.0; //m/s
		cometBody.center = new V2(6378000*100, 0);
		cometBody.velocity = new V2(cometSpeed*cos(toRadians(175)),cometSpeed*sin(toRadians(175)));
		
		cometBody2.center= new V2(6378000*7, 0);
		cometBody2.velocity = new V2(0, cometSpeed/2);
		
		earth = new Ellipse2(new V2(0, 0), 6378000, 6378000);
		geostationary = new Ellipse2(new V2(0, 0), 6.62*6378000, 6.62*6378000);
		comet = new Ellipse2(cometBody.center, 6378000/10, 6378000/10);
		comet2 = new Ellipse2(cometBody2.center, 6378000/10, 6378000/10);

		system = new S2();
		system.flipY();
		system.scale(new V2(5.0/6378000, 5.0/6378000));
		system.setOrigo(new V2(600, 400));

		drawables = new LinkedList<>();
		drawables.add(earth);
		drawables.add(comet);
		prevTime = System.currentTimeMillis();
		timer.start();
		
				

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		long now = System.currentTimeMillis();
		
		double timeStep = ((now - prevTime)/1000.0)*SimSpeedFactor;
		if (System.currentTimeMillis()%100==0)System.out.println(now-prevTime);
		double cometDist = sqrt(pow(cometBody.center.x,2)+pow(cometBody.center.y,2));
		double cometAcc = (5.97*10000000000000.0*6.6726)/pow(cometDist,2);
		cometBody.acceleration.x =  - (cometBody.center.x/cometDist)*cometAcc;
		cometBody.acceleration.y =  - (cometBody.center.y/cometDist)*cometAcc;
		//Extra Comet
		double cometDist2 = sqrt(pow(cometBody2.center.x,2)+pow(cometBody2.center.y,2));
		double cometAcc2 = (5.97*10000000000000.0*6.6726)/pow(cometDist2,2);
		cometBody2.acceleration.x =  - (cometBody2.center.x/cometDist2)*cometAcc2;
		cometBody2.acceleration.y =  - (cometBody2.center.y/cometDist2)*cometAcc2;
		
		cometBody.updatePos(timeStep);
		cometBody2.updatePos(timeStep);
		
		prevTime=now;
		
		comet.anchorPoint=cometBody.center;
		comet2.anchorPoint=cometBody2.center;
		
		LinkedList<Line2> lines = new LinkedList<>();
		for (Line2 line2 : comet.getLines()) {
			lines.add(line2);
		}
		for (Line2 line2 : comet2.getLines()) {
			lines.add(line2);
		}
		for (Line2 line2 : earth.getLines()){
			lines.add(line2);
		}
		for (Line2 line2 : geostationary.getLines()){
			lines.add(line2);
		}
		system.setLines(lines);
		List<Line2> drawLines = system.getTransformedLines();
		frame.getPanel().setLines(drawLines);

	}

}


