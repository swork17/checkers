package com.checkers.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.event.EventListenerList;

import com.checkers.model.Case;
import com.checkers.model.Pawn;

public class View {
	
	private int size_x;
	private int size_y;
	private JFrame window;
	private JMenuBar bar;
	private JPanel score;
	private JPanel plateform;
	private Case cases[][];
	
	public View(int size_x, int size_y) {
		this.size_x = size_x;
		this.size_y = size_y;
		init_window();
	}
	
	private void init_window() {
		if (this.size_x != 0 
				&& this.size_y != 0) {
			window = new JFrame();
			window.setTitle("Cherckers");
			window.setIconImage(new ImageIcon("img/icone.png").getImage());
			window.setSize(this.size_x, this.size_y);
			window.setResizable(false);
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setLocationRelativeTo(null);
			window.setLayout(new BorderLayout());
			init_menu();
			init_score();
			init_plateform();
			window.setVisible(true);
		}
	}
	
	private void init_menu() {
		bar = new JMenuBar();
		
		JMenu file = new JMenu("Fichier");
		JMenuItem new_game = new JMenuItem("Nouvelle partie" );
		JMenuItem quit = new JMenuItem("Quitter" );
			
		JMenu game = new JMenu("Jeu");
		JMenuItem createServer = new JMenuItem("Organiser");
		JMenuItem join = new JMenuItem("Rejoindre");
		JMenuItem save = new JMenuItem("Sauvegarder");
		JMenuItem load = new JMenuItem("Charger");
		JMenuItem restart = new JMenuItem("Recommencer");
		
		JMenu about = new JMenu("A propos");
		JMenuItem rules = new JMenuItem("Regle du jeu" );
		JMenuItem help = new JMenuItem("?" );
		
		file.add(new_game);
		file.addSeparator();
		file.add(quit);
		game.add(createServer);
		game.add(join);
		game.add(save);
		game.add(load);
		game.add(restart);
		about.add(rules);
		about.add(help);
		
		bar.add(file);
		bar.add(game);
		bar.add(about);
		
		// Option "Nouvelle partie"
		new_game.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		
		// Option "Quitter"
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W, KeyEvent.CTRL_MASK));
		
		quit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		System.exit(0);
	    	}
	    });
		
		// Option "?"
		help.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
    		JOptionPane.showMessageDialog(null, "Createurs : Kevin BOUCHER - Fabien DIDIER\nVersion : 0.1",
						    		            "Information", JOptionPane.NO_OPTION);;
	    	}
	    });

		bar.setVisible(true);
		window.add(bar,BorderLayout.NORTH);
	}
	
	private void init_score() {

		score = new JPanel();
		score.add(new JLabel("Score : 0"));
		window.add(score, BorderLayout.SOUTH);
		score.setBorder(BorderFactory.createLineBorder(Color.black));
	}

	private void init_plateform() {
		plateform = new JPanel();
		plateform.setLayout(new GridLayout(8, 8));
		cases = new Case[8][8];
		for(int i = 0; i < 8; i++) {
			cases[i] = new Case[8];
			for(int j=0; j < 8; j++)
			{
				if(((i+j) % 2)==0)
					cases[i][j] = new Case(i,j,"Black",false);
				else 
					cases[i][j] = new Case(i,j,"White",false);
				
				cases[i][j].setBorder(javax.swing.BorderFactory.createEmptyBorder(2,2,2,2));
				cases[i][j].addActionListener(new ActionListener() { 
				@Override
				public void actionPerformed(ActionEvent e) {
				    Case o = (Case)e.getSource();
					System.out.println("X: " + o.getColumn() + " Y: " + o.getLine());
					
					// Déselection des lignes et sélection de la ligne 
					for (int l = 0; l < cases.length; l++) {
						for(int c=0; c < 8; c++)
						{
							cases[l][c].setBorder(javax.swing.BorderFactory.createEmptyBorder(2,2,2,2));
						}
					}
					o.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue));
				} 
				});
				
				
				plateform.add(cases[i][j]);
			}
		}
		window.add(plateform, BorderLayout.CENTER);
	}
}

