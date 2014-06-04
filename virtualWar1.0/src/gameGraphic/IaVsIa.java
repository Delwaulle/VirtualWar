package gameGraphic;

import gameWar.Plateau;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class IaVsIa extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	CardLayout cl;
	JPanel pan;
	Image img;
	JButton retour;
	JPanel p;
	JButton valider;
	@SuppressWarnings("rawtypes")
	JList jl;
	JScrollPane jp;
	String[] tab;
	Font f;
	JLabel obstacles;
	static double txObstacles;
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public IaVsIa(CardLayout cl1, JPanel pan1) {
		this.cl=cl1;
		this.pan=pan1;
		this.setLayout(new FlowLayout(0,250,50));
		p=new JPanel();
		p.setLayout(new GridLayout(4,1,20,50));
		try {
			img=ImageIO.read(new File("rsc/images/bg1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		valider=new JButton("Valider");
		valider.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				ClicMenu son=new ClicMenu();
				son.setDaemon(true);
				son.start();
				cl.show(pan, "plateauIa");
				gameWar.Game.partieIAcIA();
			}

		});
		retour=new Bouton("Retour",pan,cl,"jouer");
		tab = new String[]{"Aucun","10%","20%","30%","40%","50%","60%"};
		jl=new JList(tab);
		jl.setVisibleRowCount(4);
		jp = new JScrollPane(jl);
		jl.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
		jl.setSelectedIndex(0);
		jl.addListSelectionListener(new ListSelectionListener(){

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				BoardDisplayer.board = new Plateau(jl.getSelectedIndex()*0.1);
				txObstacles=jl.getSelectedIndex()*0.1;
			}

		});
		f=new Font(Font.DIALOG, Font.BOLD, 14);
		obstacles=new JLabel("Choisissez le pourcentage d'obstacles : ");
		obstacles.setOpaque(false);
		obstacles.setFont(f);
		obstacles.setForeground(Color.WHITE);
		p.setOpaque(false);
		p.add(obstacles);
		p.add(jp);
		p.add(valider);
		p.add(retour);
		this.add(p);
		gameController.EntrerIA.rep="iacia";
		//gameWar.Game.partieIAcIA();
	}
	@Override
	public void paintComponent(Graphics g) {
		g.drawImage(img,0,0,this);
	}
}
