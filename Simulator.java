package svemir;

import java.awt.*;
import java.awt.event.*;

public class Simulator extends Frame {
	private Svemir svemir=new Svemir();
	private Generator gen=new Generator(svemir);
	Button pokreni=new Button("Pokreni!");
	public Simulator(){
		setBounds(700, 200, 200, 400);
		//setTitle("Svemir");
		setResizable(false);
		addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowClosing(WindowEvent e) {
				gen.zavrsi();
				svemir.zavrsi();
				dispose();
				
			}
			
			
		});
			
		
		
		Panel panel= new Panel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel.add(svemir);
		svemir.setBackground(Color.BLACK);
		svemir.setPreferredSize(new Dimension(getWidth(), getHeight()-100));
		add(panel,BorderLayout.CENTER);
		Panel dugme=new Panel();
		dugme.add(pokreni);
		pokreni.addActionListener((ae)->{
			svemir.pokreni();
			gen.pokreni();
			pokreni.setEnabled(false);
		});
		add(dugme,BorderLayout.SOUTH);
		pack();
		setVisible(true);
		
	}

	public static void main(String[] args) {
		new Simulator();
		
		
		//System.out.println(Math.random()*2*Math.PI);

	}

}
