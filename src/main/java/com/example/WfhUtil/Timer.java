package com.example.WfhUtil;

import org.springframework.util.StopWatch;

public class Timer {

	StopWatch s1 = new StopWatch();
	
	public void startTimer(){
		
		s1.start();
	}
	
	public double stopTimer(){
		
		s1.stop();
		return s1.getTotalTimeSeconds();
	}
		
}
