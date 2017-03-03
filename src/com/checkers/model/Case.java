package com.checkers.model;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Case extends JButton{

	private int column;
	private int line;
	private String color;
	private boolean available;

	public Case(int line, int column, String color, boolean available) {
		super();
		setColumn(column);
		setLine(line);
		setCouleur(color);
	}

	public String getCouleur() {
		return color;
	}
	public void setCouleur(String couleur) {
		this.color = couleur;
		if(couleur.compareTo("White" ) == 0) {
			setIcon(new ImageIcon("img/blanc.jpg"));
		}
		if(couleur.compareTo("Black" ) == 0) {
			setIcon(new ImageIcon("img/brun.jpg"));
			if (this.line < 3) {
				JPanel jp = new Pawn("black", this.column, this.line);
				this.add(jp);
			}
			else if (this.line > 4) {
				JPanel jp = new Pawn("white", this.column, this.line);
				this.add(jp);
			}
		}
	}
	public int getColumn() {
		return column;
	}
	public void setColumn(int colonne) {
		this.column = colonne;
	}
	public int getLine() {
		return line;
	}
	public void setLine(int ligne) {
		this.line = ligne;
	}
	public boolean isAvailable() {
		return available;
	}

}
