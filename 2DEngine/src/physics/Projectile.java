package physics;
import static java.lang.Math.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class Projectile implements ActionListener {
	long tstart;
	private double x;
	private double y;
	private Timer t;

	public static void main(String[] args) {
		new Projectile().run();

	}

	private void run() {
		t = new Timer(50, this);
		tstart = System.currentTimeMillis();
		t.start();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		double elapsed = (System.currentTimeMillis()-tstart)/1000.0;
		x = cos(toRadians(60))*10*elapsed;
		y = sin(toRadians(60))*10*elapsed-(0.5)*9.81*pow(elapsed,2);
		System.out.println("t: " + elapsed + " "+x + ","+y);
		if (y<0){
			t.stop();
			System.exit(1);;
		}
	}
}
