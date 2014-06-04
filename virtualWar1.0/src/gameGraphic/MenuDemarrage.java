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

public class MenuDemarrage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton bouton1;
	private JButton bouton2;
	private JButton bouton3;

	public JButton getBouton1() {
		return bouton1;
	}

	public void setBouton1(JButton bouton1) {
		this.bouton1 = bouton1;
	}

	public JButton getBouton2() {
		return bouton2;
	}

	public void setBouton2(JButton bouton2) {
		this.bouton2 = bouton2;
	}

	public JButton getBouton3() {
		return bouton3;
	}

	public void setBouton3(JButton bouton3) {
		this.bouton3 = bouton3;
	}

	JPanel p;
	JPanel p2;
	SonMenu son;
	JLabel jl;
	Image img;
	Jouer j;
	CardLayout cl;
	JPanel pan;
	public MenuDemarrage(CardLayout cl, JPanel pan)  {
		super();
		this.cl=cl;
		this.pan=pan;
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jl=new JLabel(new ImageIcon("rsc/images/son5.png"));
		son=new SonMenu();
		jl.addMouseListener(new MListener(jl,son));
		son.setDaemon(true);
		son.start();
		bouton1 =  new Bouton("Lancez une partie",pan,cl,"jouer");
		bouton2 =  new Bouton("Règlement",pan,cl,"reglement");
		bouton3 = new Bouton("Paramètres",pan,cl,"parametres");
		p=new JPanel();
		p2=new JPanel();
		p2.setLayout(new FlowLayout(0,250,130));
		p.setOpaque(false);
		p.setLayout(new GridLayout(4,1,50,50));
		p.add(bouton1);
		p.add(bouton2);
		p.add(bouton3);
		p.add(jl);
		p2.setOpaque(false);
		p2.add(p);
		this.add(p2);
	}



	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,p2);
	}
}
