package com.checkers.model;

import java.awt.event.*;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;

public class Pawn extends JPanel
{
    Ellipse2D.Double circle;
    private String black_pawn = "img/pawn_black.png";
    private String white_pawn = "img/pawn_white.png";
    private String color_pawn;
    private int pos_x;
    private int pos_y; 

    public Pawn(String color, int column, int line)
    {
    	this.pos_x = column;
    	this.pos_y = line;
    	if (color.equals("black"))
    		this.color_pawn = black_pawn;
    	if(color.equals("white"))
    		this.color_pawn = white_pawn;
        setOpaque(false);
    }

   
    public int getPos_x() {
		return pos_x;
	}


	public void setPos_x(int pos_x) {
		this.pos_x = pos_x;
	}


	public int getPos_y() {
		return pos_y;
	}


	public void setPos_y(int pos_y) {
		this.pos_y = pos_y;
	}


	
	
	public void paintComponent(Graphics g)
    {
		try {
			Image img = ImageIO.read(new File(color_pawn));
			super.paintComponent(g);
	        Graphics2D g2 = (Graphics2D) g;
	        int x = (this.getWidth() -img.getWidth(null)) / 2;
		    int y = (this.getHeight() - img.getHeight(null)) / 2;
	        g2.drawImage(img, x, y, null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
