package svemir;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;


public class Svemir extends Canvas implements Runnable {
	private ArrayList<NebeskoTelo> tela=new ArrayList<>();
	private Thread t=null;
	private boolean work;
	
	public synchronized void dodaj(NebeskoTelo t) {
		tela.add(t);
	}
	@Override
	public synchronized void paint(Graphics g) {
			for(NebeskoTelo telo :tela) {
				telo.paint(g);
				telo.setY(5);
			}	
	}
	public synchronized void pokreni() {
		if(t != null) return;
		work=true;
		t=new Thread(this);
		t.start();
		
	}
	public synchronized void zavrsi() {
		if(t==null)	 return;
		t.interrupt();
		while(t != null) {
			try {
				wait();
			}catch(InterruptedException e) {
				
			}
		}
	}
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				repaint();
				Thread.sleep(100);
			}
		} catch (InterruptedException e) {}
		synchronized (this) {
			t = null;
			notify();
		}
	}
	
	
}
