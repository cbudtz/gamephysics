package drawing;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.Timer;

public class CBPanel extends JPanel implements ActionListener{
	private static final long serialVersionUID = 3135592719381820451L;
	private Timer timer;
	private volatile LinkedList<Line2> lines;

	public CBPanel() {
		super();
		timer = new Timer(25, this);
		timer.start();
	}

	private void doDrawing(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;
		if (lines !=null){
			for (Line2 line2 : lines) {
				g2.setColor(line2.color);
				g2.draw(line2.getLine2D());
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

	public synchronized LinkedList<Line2> getLines() {
		return lines;
	}

	public synchronized void setLines(List<Line2> lines) {
		LinkedList<Line2> drawlines = new LinkedList<>();
		for (Line2 line2 : lines) {
			drawlines.add(line2);
		}
		this.lines = drawlines;
	}
	
}
