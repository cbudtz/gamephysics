package drawing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import javax.swing.JPanel;
import javax.swing.Timer;

public class CBPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 3135592719381820451L;
	private Timer timer;
	private LinkedList<Ellipse2D> ellipses;
	private LinkedList<Line2D> lines;

	public CBPanel() {
		super();
		timer = new Timer(25, this);
		timer.start();
	}

	/**
	 * 
	 */



	private void doDrawing(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		if (ellipses !=null){
			for (Ellipse2D ellipse2d : ellipses) {
				g2.draw(ellipse2d);
			}
		}
		if (lines !=null){
			for (Line2D line2d : lines) {
				g2.draw(line2d);
			}
		}


	}
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		doDrawing(g);
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();

	}

	//Getters and Setters

	public LinkedList<Ellipse2D> getEllipses() {
		return ellipses;
	}
	public void setEllipses(LinkedList<Ellipse2D> ellipses) {
		this.ellipses = ellipses;
	}

	public LinkedList<Line2D> getLines() {
		return lines;
	}

	public void setLines(LinkedList<Line2D> lines) {
		this.lines = lines;
	}
	
}
