package gameGraphic;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Jouer extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JButton retour;
	private final JButton joueurVsJoueur;
	private final JButton jVsIa;
	private final JButton iaVsIa;
	JPanel pan;
	CardLayout l;
	Image img;
	public Jouer(CardLayout l,JPanel pan) {
		JPanel main = new JPanel();
		this.pan=pan;
		this.l=l;
		this.setLayout(new FlowLayout(0,250,130));
		main.setLayout(new GridLayout(4,1,50,50));
		retour=new Bouton("Retour",pan,l,"menu");
		joueurVsJoueur=new Bouton("Joueur vs Joueur",pan,l,"jvj");
		jVsIa=new Bouton("Joueur vs IA",pan,l,"jvi");
		iaVsIa=new Bouton("IA vs IA",pan,l,"ivi");
		main.add(joueurVsJoueur);
		main.add(jVsIa);
		main.add(iaVsIa);
		main.add(retour);
		main.setOpaque(false);
		this.add(main);
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
