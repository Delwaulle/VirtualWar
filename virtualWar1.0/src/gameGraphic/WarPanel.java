package gameGraphic;

import gameWar.Plateau;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class WarPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static CardLayout cl;
	public static JPanel pan;
	public static JPanel p;
	public static BoardDisplayer bd;
	public static JTextArea t;
	public static JTextArea t2;
	public static String info="Soldats, faites vos choix!";

	public WarPanel(CardLayout cl1, JPanel pan1){
		this.cl=cl1;
		this.pan=pan1;
		this.setLayout(new GridLayout(1,2,20,20));
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p = new JPanel();
		p.setLayout(new GridLayout(2,1));
		int tours=0;
		bd = new BoardDisplayer(cl, pan, gameWar.Game.p = new Plateau(0));
		p.add(new ActionPanel(1));
		t=new JTextArea(info);
		t2=new JTextArea("");


		t.setBounds(5,20,350,60);
		t2.setBounds(5,130,350,70);
		p2.add(t);
		p2.add(t2);
		p.add(p2);
		tours++;
		this.add(bd);
		this.add(p);


	}

}
