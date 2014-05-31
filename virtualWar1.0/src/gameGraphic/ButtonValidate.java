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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonValidate extends JButton{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String id;
	String nom;
	CardLayout l;
	JPanel p;
	Font f;
	private Image img;
	boolean b;
	public ButtonValidate(String str, final JPanel p,final CardLayout l,final String id,boolean b){
		super(str);
		this.id=id;
		this.b=b;
		this.nom=str;
		this.l=l;
		this.p=p;
		this.setPreferredSize(new Dimension(300,60));
		this.setMinimumSize(new Dimension(300,60));
		f= new Font(Font.DIALOG, Font.BOLD, 20);
		this.setFont(f);

		this.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				ClicMenu son=new ClicMenu();
				son.setDaemon(true);
				son.start();
				l.show(p, id);
			}

		});
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
	public void setEnabled(boolean enabled) {
		super.setEnabled(b);
		if (b) {
			try {
				img = ImageIO.read(new File("rsc/images/bouton1.png"));
				this.repaint();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			try {
				img = ImageIO.read(new File("rsc/images/boutonDisabled.png"));
				this.repaint();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
}
