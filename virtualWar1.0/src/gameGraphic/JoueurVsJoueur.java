package gameGraphic;

import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JoueurVsJoueur extends JPanel {
	CardLayout cl;
	JPanel pan;
	Image img;
	JButton retour;
	public JoueurVsJoueur(CardLayout cl, JPanel pan) {
		this.cl=cl;
		this.pan=pan;
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retour=new Bouton("Retour",pan,cl,"jouer");
		this.add(retour);
		gameController.EntrerIA.rep="jcj";
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
