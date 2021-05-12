package test;

import java.util.Timer;
import java.util.TimerTask;

public class MyTask extends TimerTask{

	static int interval = 25;
	int minutePo = 25;
	int secondsPo = 00;
	static Timer timer;
	@Override
	public void run() throws NullPointerException {
		
		System.out.println(setInterval());
		System.out.println(java.time.LocalTime.now());
	}
	
	private static final int setInterval() {
	    if (interval == 0)
	        timer.cancel();
	    return --interval;
	}
	
}
