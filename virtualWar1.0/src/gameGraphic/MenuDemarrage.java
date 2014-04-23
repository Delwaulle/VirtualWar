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
	JPanel p3;
	SonMenu son;
	CheckBoxSon cbs;

	public MenuDemarrage()  {
		son=new SonMenu();
		son.setDaemon(true);
		son.start();
		bouton1 =  new Bouton("Lancez une partie");
		bouton2 =  new Bouton("Sauvegardes");
		bouton3 = new Bouton("Paramètres");
		cbs=new CheckBoxSon("Désactiver le son",son);
		p3=new JPanel();
		p3.setBackground(Color.BLACK);
		p3.setLayout(new FlowLayout(0,335,0));
		p3.add(cbs);
		p=new JPanel();
		p2=new JPanel();
		p2.setBackground(Color.BLACK);
		p.setBackground(Color.BLACK);
		p2.setLayout(new FlowLayout(150,252,150));
		this.setLayout(new BorderLayout());
		p.setLayout(new GridLayout(3,1,0,60));
		p.add(bouton1);
		p.add(bouton2);
		p.add(bouton3);
		p2.add(p);
		this.add(BorderLayout.CENTER,p2);
		this.add(BorderLayout.SOUTH,p3);
	}
}
