package gameGraphic;

import java.awt.AlphaComposite;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;



public class FonduBronzeV extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image Bronzev;
	float alpha;
	Timer timer;
	Window w;

	public FonduBronzeV(float alpha,Window w) {
		this.setBackground(Color.BLACK);
		this.alpha=alpha;
		this.w=w;
		this.setLayout(new BorderLayout());
		ImageIcon iBronzev = new ImageIcon("rsc/images/logo2.0.png");
		Bronzev=iBronzev.getImage();
		timer= new Timer(15, this);
		timer.start();
	}


	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
		g2d.drawImage(Bronzev,250,150,300,300,null);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		alpha += -0.01f;
		if (alpha <= 0) {
			alpha = 0;
			timer.stop();
			this.add(new AffichageVirtualWar(0,w));
			this.revalidate();
		}
		repaint();

	}
}
