package com.sw1.test;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class testDestruido {
	
	public static void main(String[] args) {
		Transition transition = new Transition(5);
		//name, time, priority, locked, running, destroyed, comunicate, restart
		transition.getReady().add(new Process("p1", 15 , 1, true, true, false, false, false));
		transition.getReady().add(new Process("p2", 20 , 5, true, true, false, false, false));
		
		transition.runProcess();
		System.out.println("Bloqueado");
		for (Process process : transition.getBlock().getListHistoryLock()) {
			System.out.println(process.getName());
		}
		
		System.out.println("Destruido");
		for (Process process : transition.getDestroyed()) {
			System.out.println(process.getName());
		}
		
		System.out.println("running");
		for (Process process : transition.getRunning().getRunningHystory()) {
			System.out.println(process.getName());
		}
		
	}

}
