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



public class FonduVirtualWar extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image Virtualwar;
	float alpha;
	Timer timer;
	public FonduVirtualWar(float alpha) {
		this.alpha=alpha;
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		ImageIcon iVirtualwar = new ImageIcon("rsc/images/imageV3.png");
		Virtualwar=iVirtualwar.getImage();
		timer= new Timer(20, this);
		timer.start();
	}


	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,alpha));
		g2d.drawImage(Virtualwar,100,70,600,400,null);
	}

	@Override
	public void actionPerformed(ActionEvent e){
		alpha += -0.01f;
		if (alpha <= 0) {
			alpha = 0;
			timer.stop();
			this.add(new MenuDemarrage());
			this.revalidate();
		}
		repaint();

	}
}
