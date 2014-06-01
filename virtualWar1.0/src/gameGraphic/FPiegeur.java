package gameGraphic;

import javax.swing.JFrame;

public class FPiegeur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FPiegeur() {
		this.setUndecorated(true);
		this.getContentPane().add(new PPiegeur());
	}
}
