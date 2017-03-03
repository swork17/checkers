package com.checkers.model;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.event.EventListenerList;

public class Case extends JButton{

	private int column;
	private int line;
	private String color;
	private boolean available;
	private EventListenerList listeners;

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
			this.setEnabled(true);
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