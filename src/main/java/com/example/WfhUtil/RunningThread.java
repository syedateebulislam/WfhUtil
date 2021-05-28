package com.example.WfhUtil;

import java.awt.AWTException;

public class RunningThread extends Thread{

	private volatile boolean running = true;

	public void run(){
	
		while (running) {

			try {
				Cursor.move();
				Thread.sleep(1000);
				
			} catch (InterruptedException | AWTException e) {
				if(!running){
					break;
				}
			}
		}
	}

	public void stopThread() {
		running = false;
		interrupt();
	}

}