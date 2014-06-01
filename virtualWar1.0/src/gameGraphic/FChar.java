package gameGraphic;


import javax.swing.JFrame;

public class FChar extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FChar() {
		this.setUndecorated(true);
		this.getContentPane().add(new PChar());
	}

}
