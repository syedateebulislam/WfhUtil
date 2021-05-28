package com.example.WfhUtil;

import java.awt.AWTException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {

	RunningThread t1 = new RunningThread();
	private static Timer timer = new Timer();
	public static boolean startFlag = true;


	@RequestMapping("/")
	public ModelAndView homepage() {

		return new ModelAndView("homepage");
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/startCursor")
	public ModelAndView startCursor() throws AWTException{		
		
		System.setProperty("java.awt.headless", "false");
		
		timer.startTimer();
		
		if(startFlag) {
			startFlag = false;
			t1.start();
		}else {
			t1.resume();
		}

		return new ModelAndView("homepage");
	}

	@SuppressWarnings("deprecation")
	@RequestMapping("/stopCursor")
	public ModelAndView stopCursor(Model model) throws AWTException{		

		t1.suspend();
		double elapsedTime=timer.stopTimer();
		int ss = (int)elapsedTime%60;		
		int mm = (int)elapsedTime/60;
		int hh = (int)elapsedTime/3600;
		String  time = String.valueOf(hh)+" Hr : "+String.valueOf(mm)+" Min : "+String.valueOf(ss)+" Sec";
		model.addAttribute("time", time);
		return new ModelAndView("homepage","time",time);
	}

}