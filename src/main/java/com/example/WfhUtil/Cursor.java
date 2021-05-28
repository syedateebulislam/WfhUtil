package com.example.WfhUtil;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.util.Random;

public class Cursor {

	public static void move()  throws AWTException  {

		Robot hal = new Robot();
		Random rand = new Random();
		int upperbound = 10;
		int count = 1;
		
		while(count<10) {

			int int_rand_initial = (rand.nextInt(upperbound)+1);
			int int_random = int_rand_initial * 1000;
			hal.delay(int_random);

			int x1 = 800 + (int_rand_initial*4);
			int x2 = 1000 + (int_rand_initial*4);
			int y1 = 480 + (int_rand_initial*4);
			int y2 = 480 + (int_rand_initial*4);

			if(count%2==0) {
				hal.mouseMove(x1, y1);
				hal.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				hal.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
			else {
				hal.mouseMove(x2, y2);
				hal.mousePress(InputEvent.BUTTON1_DOWN_MASK);
				hal.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			}
			count++;
		}		
	}
}
