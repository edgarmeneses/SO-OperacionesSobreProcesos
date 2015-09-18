package com.sw1.gui;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

public class ProgressBar extends JDialog implements Runnable{
	private	JProgressBar progress;
	private	JLabel label1;
	private	JPanel topPanel;


	public ProgressBar() {
		setSize( 310, 130 );
		// para eliminar las margenes o bordes del frame
		this.setUndecorated(true);
		setLocationRelativeTo(null);

		topPanel = new JPanel();
		topPanel.setPreferredSize( new Dimension( 310, 130 ) );
		getContentPane().add( topPanel );

		// Create a label and progress bar
		label1 = new JLabel( "calculando porfavor espere...." );
		label1.setPreferredSize( new Dimension( 280, 24 ) );
		add( label1 );

		progress = new JProgressBar();
		progress.setPreferredSize( new Dimension( 300, 20 ) );
		progress.setMinimum(0);
		progress.setMaximum(50);
		progress.setValue( 0 );
		progress.setBounds(20,35,260,20);
		add( progress );
		start();
		
	}
	
	public void startProgressBar(int iCtr){
			// Do some sort of simulated task
			//DoBogusTask( iCtr );

			// Update the progress indicator and label
			label1.setText(  + iCtr +"%"+ " de 100%" );
			Rectangle labelRect = label1.getBounds();
			labelRect.x = 0;
			labelRect.y = 0;
			label1.paintImmediately( labelRect );

			progress.setValue( iCtr );
			Rectangle progressRect = progress.getBounds();
			progressRect.x = 0;
			progressRect.y = 0;
			progress.paintImmediately( progressRect );
		
	}

//	public void DoBogusTask( int iCtr )
//	{
//		Random random = new Random( iCtr );
//
//		// Waste some time
//		for( int iValue = 0; iValue < random.nextFloat() * 10000; iValue++ )
//		{
//			System.out.println( "iValue=" + iValue );
//		}
//	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int iCtr=1;
		while(iCtr<=50){
			startProgressBar(iCtr);
			iCtr++;
			
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		setVisible(false);
	}
	
	public void start(){
		Thread thread = new Thread(this);
		thread.start();
	}

}