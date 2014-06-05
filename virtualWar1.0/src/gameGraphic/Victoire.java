package gameGraphic;

import javax.swing.JFrame;

public class Victoire extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	int fin;
	public Victoire(int i) {
		this.fin=i;
		this.setBounds(300,150,200,150);
		this.setUndecorated(true);
		this.getContentPane().add(new Pvictoire(fin,this));
	}
}
