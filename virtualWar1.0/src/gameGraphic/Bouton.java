package gameGraphic;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Paint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Bouton extends JButton implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	private final String nom;
	Font f;
	private ClicMenu son;
	JPanel p;
	CardLayout l;
	String id;
	public Bouton(String str, JPanel p,CardLayout l,String id){
		super(str);
		this.id=id;
		this.nom=str;
		this.l=l;
		this.p=p;
		this.setPreferredSize(new Dimension(300,60));
		this.setMinimumSize(new Dimension(300,60));
		f= new Font(Font.DIALOG, Font.BOLD, 20);
		this.setFont(f);
		try {
			img = ImageIO.read(new File("rsc/images/bouton1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(id!="jeu")
			this.setEnabled(true);

	}


	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;

		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		Paint gradientPaint = new GradientPaint(0, this.getHeight(), Color.BLACK,
				0, this.getHeight() + this.getWidth(), Color.WHITE);
		g2d.setPaint(gradientPaint);
		FontMetrics fm = g2d.getFontMetrics();
		int height = fm.getHeight();
		int width = fm.stringWidth(this.nom);
		g2d.drawString(this.nom, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4));
		//bool=false;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		son=new ClicMenu();
		son.setDaemon(true);
		son.start();
		try {
			img = ImageIO.read(new File("rsc/images/b7.png"));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		l.show(p,id);


	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		try {
			img = ImageIO.read(new File("rsc/images/bouton2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		try {
			img = ImageIO.read(new File("rsc/images/bouton1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setEnabled(boolean enabled) {
		super.setEnabled(enabled);
		if (enabled) {
			this.addMouseListener(this);
		}
		else {

		}

	}
}
