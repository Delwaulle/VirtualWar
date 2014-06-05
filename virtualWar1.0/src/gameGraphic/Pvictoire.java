package gameGraphic;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pvictoire extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Image img;
	JButton ok;
	JFrame fr;
	public Pvictoire(int fin,JFrame f){
		this.fr=f;
		ok=new JButton("Retour au menu");
		ok.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				fr.setVisible(false);;
				WarPanel.cl.show(WarPanel.pan,"menu");

			}

		});
		if (fin==1) {
			try {
				img=ImageIO.read(new File("rsc/images/tireurs/Caracteristiques.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else if (fin==2){
			try {
				img=ImageIO.read(new File("rsc/images/tireurs/Caracteristiques.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		else {
			try {
				img=ImageIO.read(new File("rsc/images/tireurs/Caracteristiques.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.add(ok);
	}

	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}

}
