package gameGraphic;

import javax.swing.JFrame;

public class FTireur extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public FTireur() {
		this.setUndecorated(true);
		this.getContentPane().add(new PTireur());
	}
}
