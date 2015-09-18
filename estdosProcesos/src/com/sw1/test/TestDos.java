package com.sw1.test;

import com.sw1.logic.Process;
import com.sw1.logic.Transition;

public class TestDos {
	
	public static void main(String[] args) {
		Transition transition = new Transition(5);
		
		transition.getReady().add(new Process("p1", 15 , 1, true, true, true, true, true));
		transition.getReady().add(new Process("p2", 10 , 4, true, true, false, false, false));
		transition.getReady().add(new Process("p3", 5 , 2, true, false, true, false, false));
		transition.getReady().add(new Process("p4", 2 , 8 ,true, false, false, false, false));
		transition.getReady().add(new Process("p5", 9 , 9, false, false, true, false, false));
		
		
		
		transition.runProcess();
		System.out.println("Listos");
		for (Process process : transition.getReady().getHistoricalReady()) {
			System.out.println(process.getName());
		}
		
		System.out.println("Ejecutados");
		for (Process process : transition.getRunning().getRunningHystory()) {
			System.out.println(process.getName());
		}	
		System.out.println("Bloqueados");
		for (Process process : transition.getBlock().getListHistoryLock()) {
			System.out.println(process.getName());
		}	
		System.out.println("Destruidos");
		for (Process process : transition.getDestroyed()) {
			System.out.println(process.getName());
		}	
		System.out.println("Expirados");
		for (Process process : transition.getRunning().getExpirateTime()) {
			System.out.println(process.getName());
		}	
		System.out.println("Comunicados");
		for (Process process : transition.getComunicate()) {
			System.out.println(process.getName());
		}
		System.out.println("Salida ");
		for (Process process : transition.getFinished()) {
			System.out.println(process.getName());
		}
		System.out.println("Restaurados ");
		for (Process process : transition.getRestart()) {
			System.out.println(process.getName());
		}	
	}
}
