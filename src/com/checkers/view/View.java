package com.checkers.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class View {
	
	private int size_x;
	private int size_y;
	private JFrame window;
	private JMenuBar bar;
	
	public View(int size_x, int size_y) {
		this.size_x = size_x;
		this.size_y = size_y;
		init_window();
	}
	
	private void init_window() {
		if (this.size_x != 0 
				&& this.size_y != 0) {
			window = new JFrame();
			window.setTitle("Cherckers V0.1");
			window.setIconImage(new ImageIcon("img/icone.png").getImage());
			window.setSize(this.size_x, this.size_y);
			window.setResizable(false);
			window.setLayout(new BorderLayout());
			init_menu();
			window.setVisible(true);
		}
	}
	
	private void init_menu() {
		bar = new JMenuBar();
		JMenu fichier = new JMenu("Fichier" );
		JMenuItem new_game = new JMenuItem("Nouvelle partie" );
		JMenuItem about = new JMenuItem("A propos" );
		JMenuItem quit = new JMenuItem("Quitter" );
		
		new_game.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,
                InputEvent.CTRL_MASK));
		
		quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,
                KeyEvent.CTRL_MASK));
		
		quit.addActionListener(new ActionListener(){
	    	public void actionPerformed(ActionEvent e){
	    		System.exit(0);
	    	}
	    });
		
		fichier.add(new_game);
		fichier.add(about);
		fichier.add(quit);
		bar.add(fichier);
		bar.setVisible(true);
		window.add(bar,BorderLayout.NORTH);
	}
}
