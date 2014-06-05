package gameGraphic;

import gameWar.Plateau;

import java.awt.CardLayout;
import java.awt.GridLayout;

import javax.swing.JPanel;
import javax.swing.JTextArea;
public class InfoCarac extends JPanel{

	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	public static JPanel p;
	public static JTextArea t;
	public static String caracs="blabla";

	public InfoCarac(CardLayout cl, JPanel pan){
		this.cl=cl;
		this.pan=pan;
		this.setLayout(new GridLayout(1,2,20,20));
		JPanel p2 = new JPanel();
		p2.setLayout(null);
		p = new JPanel();
		p.setLayout(new GridLayout(2,1));
		p.add(new ActionPanel(1));
		t=new JTextArea(caracs);
		t.setBounds(5,20,350,60);
		p2.add(t);
		p.add(p2);
		this.add(p);


	}

}
