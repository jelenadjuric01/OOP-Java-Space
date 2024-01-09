package svemir;

import java.awt.Color;

public class Generator extends Thread {
	private Svemir svemir;
	private boolean started = false;
	public Generator(Svemir svemir) {
		this.svemir = svemir;
	}
	
	public static Kometa randomKometa() {
		int x=(int)(Math.random()*200);
		int y=0;
		int r=(int)(Math.random()*20+10);
		return new Kometa(x,y,r);
	}
	@Override
	public void run() {
		try {
			while(!interrupted()) {
				svemir.dodaj(randomKometa());
				sleep(900);
			}
		} catch (InterruptedException e) {}
			
	}

	public synchronized  void zavrsi() {
		if(started)
		this.interrupt();
		
	}

	public synchronized void pokreni() {
		
		this.start();
		started=true;
	}
}
