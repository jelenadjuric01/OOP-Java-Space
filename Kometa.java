package svemir;

import java.awt.Color;
import java.awt.Graphics;

public class Kometa extends NebeskoTelo {
	private static final double inc=2*Math.PI / 5;
	private double angle;
	public Kometa(int x, int y, int r) {
		//super(x, y,new Color((float)Math.random(),(float) Math.random(),(float)Math.random(),0.5f), r);
		super(x, y, Color.GRAY, r);
		angle=Math.random()*2*Math.PI;
	}

	public void paint(Graphics g) {
		Color prev=g.getColor();
		g.setColor(color);
		//double angle=Math.random()*2*Math.PI;
		int endX,endY,i=0;
		int xp[]=new int[5],yp[]=new int[5];
		for(; i<5; angle =(angle+ inc)%(2*Math.PI),i++) {
			endX = (int)(r * Math.cos(angle)+getX());
			endY = (int)(r * Math.sin(angle)+getY());
			xp[i]=endX;
			yp[i]=endY;
			
		}
		g.fillPolygon(xp, yp, 5);
		g.setColor(prev);
	}
	
	
}
