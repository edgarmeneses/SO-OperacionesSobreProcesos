package com.sw1.test;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class testExpirate {
	
	public static void main(String[] args) {
		Transition transition = new Transition(5);
		
		transition.getReady().add(new Process("p1", 15 , 1, false, false, false, false, false));
		transition.getReady().add(new Process("p2", 20 , 5, false, false, false, false, false));
		
		transition.runProcess();
		
		for (Process process : transition.getRunning().getExpirateTime()) {
			System.out.println(process);
		}
		
	}

}
