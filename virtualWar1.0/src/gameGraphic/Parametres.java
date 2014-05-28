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
import javax.swing.JSlider;

public class Parametres extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	Image img;
	JButton retour;
	JPanel p;
	JSlider j1;
	JSlider j2;
	public Parametres(CardLayout cl, JPanel pan) {
		this.cl=cl;
		this.pan=pan;
		this.setLayout(new FlowLayout(0,250,130));
		p=new JPanel();
		p.setLayout(new GridLayout(3,1,50,50));
		j1=new JSlider(JSlider.HORIZONTAL,5, 20, 10);
		j2=new JSlider(JSlider.HORIZONTAL,5, 20, 10);
		j1.setOpaque(false);
		j2.setOpaque(false);
		j1.setPaintLabels(true);
		j2.setPaintLabels(true);
		p.add(j1);
		p.add(j2);
		p.setOpaque(false);
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retour=new Bouton("Retour",pan,cl,"menu");
		p.add(retour);
		this.add(p);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
