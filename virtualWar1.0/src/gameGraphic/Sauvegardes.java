package gameGraphic;

import java.awt.CardLayout;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Sauvegardes extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	Image img;
	JButton retour;
	JPanel p;
	Image img2;
	JLabel lb;
	public Sauvegardes(CardLayout cl, JPanel pan) {
		this.cl=cl;
		this.pan=pan;
		this.setLayout(new FlowLayout());
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		p3.setOpaque(false);
		p2.setOpaque(false);
		p2.setLayout(new GridLayout(2,1));
		p=new JPanel();
		p.setBounds(50,5,400,600);
		lb=new JLabel();
		lb.setOpaque(false);
		lb.setIcon(new ImageIcon("rsc/images/reglement vw2.png"));
		p.add(lb);
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		retour=new Bouton("Retour",pan,cl,"menu");
		p2.add(p);
		p3.add(retour);
		p2.add(p3);
		this.add(p2);
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
