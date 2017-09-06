package com.situ.servlet.day34;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.swing.plaf.synth.SynthSpinnerUI;

public class My11ServletContextListener implements ServletContextListener{
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("MyServletContextListener.contextInitialized()");
		
		String currentTime = "2017-09-06 10:04:00";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Date firstTime = null;
		try {
			firstTime = simpleDateFormat.parse(currentTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		Timer timer = new Timer();
		
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				System.out.println("银行计息");
			}
		};
		
		// Timer 定时器
		// task 任务
		// fistTime 第一次执行的时间
		// period 间隔过长时间执行
		//timer.scheduleAtFixedRate(timerTask, firstTime, 5000);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("MyServletContextListener.contextDestroyed()");
	}

}
