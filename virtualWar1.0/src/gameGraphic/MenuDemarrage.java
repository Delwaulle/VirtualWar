package gameGraphic;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class MenuDemarrage extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton bouton1;
	JButton bouton2;
	JButton bouton3;
	JPanel p;
	JPanel p2;
	SonMenu son;

	public MenuDemarrage()  {
		bouton1 =  new Bouton("Lancez une partie");
		bouton2 =  new Bouton("Sauvegardes");
		bouton3 = new Bouton("Paramètres");
		p=new JPanel();
		p2=new JPanel();
		p2.setBackground(Color.BLACK);
		p.setBackground(Color.BLACK);
		p2.setLayout(new FlowLayout(200,260,150));
		this.setLayout(new BorderLayout());
		p.setLayout(new GridLayout(3,1,0,60));
		p.add(bouton1);
		p.add(bouton2);
		p.add(bouton3);
		p2.add(p);
		this.add(BorderLayout.CENTER,p2);
		son=new SonMenu();
		son.setDaemon(true);
		son.start();
	}
}
