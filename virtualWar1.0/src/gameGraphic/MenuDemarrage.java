package gameGraphic;

import java.awt.Color;
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
	JButton bouton1;
	JButton bouton2;
	JButton bouton3;
	JPanel p;
	JPanel p2;
	SonMenu son;
	JLabel jl;
	Image img;

	public MenuDemarrage()  {
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
		bouton1 =  new Bouton("Lancez une partie");
		bouton2 =  new Bouton("Sauvegardes");
		bouton3 = new Bouton("Paramètres");
		p=new JPanel();
		this.setBackground(Color.BLACK);
		this.setLayout(new FlowLayout(0,250,130));
		p.setOpaque(false);
		//p.setBackground(Color.BLACK);
		p.setLayout(new GridLayout(4,1,50,50));
		p.add(bouton1);
		p.add(bouton2);
		p.add(bouton3);
		p.add(jl);
		this.add(p);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
