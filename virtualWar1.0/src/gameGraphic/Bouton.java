package gameGraphic;

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

public class Bouton extends JButton implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Image img;
	private final String nom;
	Font f;

	public Bouton(String str){
		super(str);
		this.nom=str;
		this.setPreferredSize(new Dimension(300,60));
		this.setMinimumSize(new Dimension(300,60));
		f= new Font(Font.DIALOG, Font.BOLD, 20);
		this.setFont(f);
		try {
			img = ImageIO.read(new File("images/bouton1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g){
		Graphics2D g2d = (Graphics2D)g;

		g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
		Paint gradientPaint = new GradientPaint(0, this.getHeight(), Color.BLACK,
				0, this.getHeight() + this.getWidth(), Color.WHITE);
		g2d.setPaint(gradientPaint);

		FontMetrics fm = g2d.getFontMetrics();
		//Hauteur de la police d'écriture
		int height = fm.getHeight();
		int width = fm.stringWidth(this.nom);

		//On calcule alors la position du texte, et le tour est joué
		g2d.drawString(this.nom, this.getWidth() / 2 - (width / 2), (this.getHeight() / 2) + (height / 4));
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		try {
			img = ImageIO.read(new File("images/bouton2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		try {
			img = ImageIO.read(new File("images/bouton1.png"));
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

}
