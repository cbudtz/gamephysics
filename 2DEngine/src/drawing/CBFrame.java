package drawing;

import java.awt.HeadlessException;

import javax.swing.JFrame;

public class CBFrame extends JFrame {
	private static final long serialVersionUID = -1407672061265422374L;
	private CBPanel panel;


	public CBFrame() throws HeadlessException {
		super();
		init();
	}

	public CBFrame(String title) throws HeadlessException {
		super(title);
		init();
	}
	
	private void init() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.panel = new CBPanel();
		add(panel);	
		setVisible(true);
		setSize(800, 600);
	}


	public CBPanel getPanel() {
		return panel;
	}

}
