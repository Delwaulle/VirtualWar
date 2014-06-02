package gameGraphic;

import gameWar.Plateau;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;

public class WarPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	public WarPanel(CardLayout cl, JPanel pan){
		this.cl=cl;
		this.pan=pan;
		this.setLayout(new GridLayout(1,2));
		JPanel p = new JPanel();
		p.setLayout(new GridLayout(2,1));
		p.add(new ActionPanel());

		this.add(new BoardDisplayer(cl, pan, gameWar.Game.p = new Plateau(0)));
		this.add(p);


	}

}
